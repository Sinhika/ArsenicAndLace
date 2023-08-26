package mod.akkamaddi.arsenic.api.content;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.akkamaddi.arsenic.init.ModTags;
import mod.alexndr.simplecorelib.api.helpers.SidedWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class AbstractTaintedFurnaceBlockEntity extends BlockEntity
{
   //protected static final Logger LOGGER = LogManager.getLogger();
    
   public static final int INPUT_SLOT = 0;
   public static final int OUTPUT_SLOT1 = 1;
   public static final int OUTPUT_SLOT2 = 2;
   public static final int FUEL_SLOT = 3;
   
    protected static final String INVENTORY_TAG = "inventory";
    protected static final String SMELT_TIME_LEFT_TAG = "smeltTimeProgress";
    protected static final String MAX_SMELT_TIME_TAG = "maxSmeltTime";
    protected static final String FUEL_BURN_TIME_LEFT_TAG = "fuelBurnTimeLeft";
    protected static final String MAX_FUEL_BURN_TIME_TAG = "maxFuelBurnTime";

    public static final int DATA_FUEL_TIME_LEFT = 0;
    public static final int DATA_FUEL_TIME_MAX = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;

    public static final int BURN_TIME_STANDARD = 200;
    
    protected final RecipeType<? extends AbstractCookingRecipe> recipeType;
    protected final Map<ResourceLocation, Integer> recipe2xp_map = Maps.newHashMap();
    // implement recipe-caching like all the cool kids.
    protected AbstractCookingRecipe cachedRecipe;
    protected ItemStack failedMatch = ItemStack.EMPTY;
    protected static ItemStack defaultSecondaryResult = ItemStack.EMPTY;
    
    protected double fuelMultiplier = 1.0;
    protected boolean hasFuelMultiplier = false;
    
    public int smeltTimeProgress = -1;
    public int maxSmeltTime = -1;
    public int fuelBurnTimeLeft = 0;
    public int maxFuelBurnTime = 0;
    protected boolean lastBurning = false;
    protected Random generator = new Random();
    
    public final ContainerData dataAccess = new ContainerData() 
    {
        @Override
        public int get(int index) {
            switch (index)
            {
            case DATA_FUEL_TIME_LEFT:
                return AbstractTaintedFurnaceBlockEntity.this.fuelBurnTimeLeft;
            case DATA_FUEL_TIME_MAX:
                return AbstractTaintedFurnaceBlockEntity.this.maxFuelBurnTime;
            case DATA_COOKING_PROGRESS:
                return AbstractTaintedFurnaceBlockEntity.this.smeltTimeProgress;
            case DATA_COOKING_TOTAL_TIME:
                return AbstractTaintedFurnaceBlockEntity.this.maxSmeltTime;
            default:
                return 0;
            }
        } // end get()

        @Override
        public void set(int index, int value) {
            switch (index)
            {
            case DATA_FUEL_TIME_LEFT:
                AbstractTaintedFurnaceBlockEntity.this.fuelBurnTimeLeft = value;
                break;
            case DATA_FUEL_TIME_MAX:
                AbstractTaintedFurnaceBlockEntity.this.maxFuelBurnTime = value;
                break;
            case DATA_COOKING_PROGRESS:
                AbstractTaintedFurnaceBlockEntity.this.smeltTimeProgress = value;
                break;
            case DATA_COOKING_TOTAL_TIME:
                AbstractTaintedFurnaceBlockEntity.this.maxSmeltTime = value;
            }
        } // end set()

        @Override
        public int getCount() {
            return NUM_DATA_VALUES;
        }
    }; // end AbstractTaintedFurnace$ContainerData
    
    public final ItemStackHandler inventory = new ItemStackHandler(4) 
    {
            @Override
            protected void onContentsChanged(final int slot) {
                setChanged();
            } // end ()
            
           @Override
            public boolean isItemValid(final int slot, @Nonnull final ItemStack stack) 
            {
                switch (slot) {
                    case FUEL_SLOT:
                        return isFuel(stack);
                    case INPUT_SLOT:
                        return isInput(stack);
                    case OUTPUT_SLOT1:
                        return isOutput(stack);
                    case OUTPUT_SLOT2:
                        return isSecondaryOutput(stack);
                    default:
                        return false;
                }
            } // end ItemStackHander(3).isItemValid()
    }; // end ItemStackHandler(3)

    // CAPABILITY HANDLERS
    public class FurnaceHandler extends SidedWrapper
    {
        public FurnaceHandler(IItemHandlerModifiable inventory, Direction side)
        {
            super(inventory, side);
        }

        @Nonnull
        @Override
        public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) 
        {
            // no, you can't put stuff in the output slots.
            if (slot == OUTPUT_SLOT1 || slot == OUTPUT_SLOT2) 
            {
                return stack;
            }
            // that leaves fuel && input slot, which are covered by isItemValid().
            if (slot == INPUT_SLOT && this.side == Direction.UP) 
            {
                return super.insertItem(slot, stack, simulate);
            }
            if (slot == FUEL_SLOT && isHorizontalSide(this.side)) 
            {
                return super.insertItem(slot, stack, simulate);
            }
            return stack;
          
        } // end insertItem()

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate)
        {
            // you can extract buckets from the fuel slot.
            if (slot == FUEL_SLOT && this.side == Direction.DOWN)
            {
                ItemStack pstack = this.getStackInSlot(FUEL_SLOT);
                if (pstack.is(Items.BUCKET) || pstack.is(Items.WATER_BUCKET))
                {
                    return super.extractItem(slot, amount, simulate);
                }
                else {
                    return ItemStack.EMPTY;
                }
            }
            // you can extract anything from the output slots.
            if ((slot == OUTPUT_SLOT1 || slot == OUTPUT_SLOT2) && this.side == Direction.DOWN) {
                return super.extractItem(slot, amount, simulate);
            }
            
            return ItemStack.EMPTY;
        } // end extractItem()
    } // end FurnaceHandler
    
    // CAPABILITY STUFF
    protected LazyOptional<ItemStackHandler> inventoryCapabilityInternal = LazyOptional.of(() -> this.inventory);
    protected LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalUp = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.UP));
    protected LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalSides = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.EAST));
    protected LazyOptional<IItemHandlerModifiable> inventoryCapabilityExternalDown = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.DOWN));
    
    /**
     * Constructor
     * @param tileEntityTypeIn
     * @param blockpos
     * @param blockstate
     * @param recipeTypeIn
     */
    public AbstractTaintedFurnaceBlockEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate,
            RecipeType<? extends AbstractCookingRecipe> recipeTypeIn)
    {
        super(tileEntityTypeIn, blockpos, blockstate);
        this.fuelMultiplier = 1.0;
        this.hasFuelMultiplier = false;
        this.recipeType = recipeTypeIn;
    }

    // MORE CAPABILITY STUFF
    /**
     * Retrieves the Optional handler for the capability requested on the specific side.
     *
     * @param cap  The capability to check
     * @param side The Direction to check from. CAN BE NULL! Null is defined to represent 'internal' or 'self'
     * @return The requested an optional holding the requested capability.
     */
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side)
    {
        if (cap == ForgeCapabilities.ITEM_HANDLER && side == null)
        {
            return inventoryCapabilityInternal.cast();
        }
        if (cap == ForgeCapabilities.ITEM_HANDLER && side != null) 
        {
            switch (side) {
                case DOWN:
                    return inventoryCapabilityExternalDown.cast();
                case UP:
                    return inventoryCapabilityExternalUp.cast();
                case NORTH:
                case SOUTH:
                case WEST:
                case EAST:
                    return inventoryCapabilityExternalSides.cast();
            }
        }
        return super.getCapability(cap, side);
    } // end getCapability
    
    @Override
    public void invalidateCaps()
    {
        super.invalidateCaps();
        
        // We need to invalidate our capability references so that any cached references (by other mods) don't
        // continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
        
        inventoryCapabilityExternalUp.invalidate();
        inventoryCapabilityExternalDown.invalidate();
        inventoryCapabilityExternalSides.invalidate();
        inventoryCapabilityInternal.invalidate();
    }

    @Override
    public void reviveCaps() 
    {
       super.reviveCaps();
       inventoryCapabilityInternal = LazyOptional.of(() -> this.inventory);
       inventoryCapabilityExternalUp = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.UP));
       inventoryCapabilityExternalSides = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.EAST));
       inventoryCapabilityExternalDown = LazyOptional.of(() -> new FurnaceHandler(this.inventory, Direction.DOWN));
    }
    // END CAPABILITY STUFF
    
    // FUEL STUFF
    protected static final List<Item> validFuels = new ArrayList<Item>();
    protected static Map<Item, Integer> burnTimes = new Hashtable<Item, Integer>();

    public boolean isFuel(ItemStack stack)
    {
        return getValidFuels().contains(stack.getItem()) || stack.is(Items.BUCKET);
    }

    /**
     * Get the list of valid fuels, or create it if it is empty.
     * @return a list of valid fuel items
     */
    public static List<Item> getValidFuels()
    {
        if (validFuels.isEmpty())
        {
            validFuels.add(Items.BONE_MEAL);
            validFuels.add(Items.BONE);
            validFuels.add(Items.BONE_BLOCK);
            validFuels.add(Items.ROTTEN_FLESH);
            validFuels.add(Items.SKELETON_SKULL);
            validFuels.add(Items.WITHER_SKELETON_SKULL);
            validFuels.add(Items.ZOMBIE_HEAD);
            validFuels.add(ModItems.old_lace_chest.get());
            
//            for (Item item : ModTags.getnetherFurnaceFuels().getValues())
//            {
//                validFuels.add(item);
//            }
        }
        return validFuels;
    } // end getValidFuels()

    public static Map<Item, Integer> loadBurnTimes()
    {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addItemBurnTime(map, Items.BONE_MEAL, BURN_TIME_STANDARD);
        addItemBurnTime(map, Items.BONE, BURN_TIME_STANDARD * 8);
        addItemBurnTime(map, Items.ROTTEN_FLESH, BURN_TIME_STANDARD * 8);
        addItemBurnTime(map, Items.SKELETON_SKULL, BURN_TIME_STANDARD *16);
        addItemBurnTime(map, Items.ZOMBIE_HEAD, BURN_TIME_STANDARD *16);
        addItemBurnTime(map, Items.WITHER_SKELETON_SKULL, BURN_TIME_STANDARD *24);
        addItemBurnTime(map, ModItems.old_lace_chest.get(), BURN_TIME_STANDARD * 64);
        addItemBurnTime(map, Items.BONE_BLOCK, BURN_TIME_STANDARD * 80);
        
//        addItemTagBurnTime(map, ModTags.getnetherFurnaceFuels(), fyriteBurnTime / 3);
        return map;
    } // end getBurnTimes()

    protected static void addItemBurnTime(Map<Item, Integer> map,
                                   ItemLike itemProvider, int burnTimeIn)
    {
        map.put(itemProvider.asItem(), burnTimeIn);
    }

    protected static void addItemTagBurnTime(Map<Item, Integer> map, TagKey<Item> iTag, int burnTimeIn)
    {
        ForgeRegistries.ITEMS.tags().getTag(iTag).forEach(item -> map.put(item, burnTimeIn)); 
    } // end ()

    /**
     * For nether furnaces, replaces ForgeHooks.getBurnTime.
     * @param stack - fuel itemstack
     * @param recipeType - ignored
     * @return burn time in ticks.
     */
    public static int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType)
    {
        if (AbstractTaintedFurnaceBlockEntity.burnTimes.isEmpty()) {
            AbstractTaintedFurnaceBlockEntity.burnTimes = AbstractTaintedFurnaceBlockEntity.loadBurnTimes();
        }
        if (stack.isEmpty())
        {
            return 0;
        }
        else {
            Item item = stack.getItem();
            int ret = AbstractTaintedFurnaceBlockEntity.burnTimes.getOrDefault(item, 0);
            return ret;
        }
    } // end getBurnTime()
    
// END FUEL STUFF
    
    /**
     * @return If the stack is not empty and has a smelting recipe associated with it.
     */
    protected boolean isInput(final ItemStack stack)
    {
        if (stack.isEmpty())
            return false;
        return getRecipe(stack).isPresent();
    }

    /**
     * @return If the stack's item is equal to the result of smelting our input
     */
    protected boolean isOutput(final ItemStack stack)
    {
        final Optional<ItemStack> result = getResult(inventory.getStackInSlot(INPUT_SLOT));
        return result.isPresent() && ItemStack.isSameItem(result.get(), stack);
    }

    protected boolean isSecondaryOutput(final ItemStack stack)
    {
        return stack.is(defaultSecondaryResult.getItem());
    }
    
    protected int getBurnDuration(ItemStack fuelstack)
    {
        // getBurnTime() already handles empty stack case.
         int returnval = AbstractTaintedFurnaceBlockEntity.getBurnTime(fuelstack, recipeType);
         // LOGGER.debug("[" + getDisplayName().getString() + "]AbstractNetherFurnaceTileEntity.getBurnDuration: returns " + returnval + " for " + fuelstack.toString());
         return returnval;
    } // end getBurnDuration

    public boolean isBurning()
    {
        return this.fuelBurnTimeLeft > 0;
    }

    
    /**
     * @return The smelting recipe for the inventory; implements recipe caching.
     */
    @SuppressWarnings("unchecked")
    protected Optional<AbstractCookingRecipe> getRecipe(final Container inv)
    {
        if (cachedRecipe != null && cachedRecipe.matches(inv, level))
        {
            return Optional.of(cachedRecipe);
        }
        else
        {
            AbstractCookingRecipe rec 
                = level.getRecipeManager().getRecipeFor((RecipeType<AbstractCookingRecipe>) recipeType, inv, level).orElse(null);
            if (rec == null) {
                failedMatch = inv.getItem(0); // i.e., input.
            }
            else {
                failedMatch = ItemStack.EMPTY;
            }
            cachedRecipe = rec;
            return Optional.ofNullable(rec);
        } // end else
    } // end getRecipe()

    /**
     * @return The smelting recipe for the input stack
     */
    protected Optional<AbstractCookingRecipe> getRecipe(final ItemStack input)
    {
        if (input.isEmpty() || input == failedMatch) {
            return Optional.empty();
        }
        // Due to vanilla's code we need to pass an IInventory into RecipeManager#getRecipe so we make one here.
        return getRecipe(new SimpleContainer(input));
    }

    public void setRecipeUsed(@Nullable Recipe<?> recipe)
    {
        if (recipe != null)
        {
            this.recipe2xp_map.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
                return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
            });
        }
    } // end setRecipeUsed()

    /** 
     * Given an input stack, determine what the output of smelting it would be. Food is always poisoned.
     * @param input
     * @return
     */
    protected Optional<ItemStack> getResult(final ItemStack input)
    {
        // Due to vanilla's code we need to pass an IInventory into
        // RecipeManager#getRecipe and
        // AbstractCookingRecipe#getCraftingResult() so we make one here.
        final SimpleContainer dummyInventory = new SimpleContainer(input);
        Optional<ItemStack> maybe_result = getRecipe(dummyInventory)
        			.map(recipe -> recipe.assemble(dummyInventory, this.getLevel().registryAccess()));
        
        // we do bad things to food here...
        if (maybe_result.isPresent() && maybe_result.get().isEdible()) 
        {
            if (ArsenicConfig.necroticFurnacePoisonsFood 
                    && ModTags.getMeats().contains(maybe_result.get().getItem())) 
            {
                maybe_result = Optional.of(new ItemStack(Items.ROTTEN_FLESH));
            }
            else if (ArsenicConfig.necroticFurnacePoisonsFood 
                    && ModTags.getVegetables().contains(maybe_result.get().getItem())) 
            {
                maybe_result = Optional.of(new ItemStack(Items.POISONOUS_POTATO));
            }
        }
        return Optional.of(maybe_result.orElse(ItemStack.EMPTY));
    }
    
    /**
     * Is it physically possible to put the smelting result in the output slot?
     * @param result - hypothetical smelting product.
     * @return true if result can be added to output slot, false if it cannot.
     */
    protected boolean canSmelt(ItemStack result)
    {
        if (!this.inventory.getStackInSlot(INPUT_SLOT).isEmpty() && !result.isEmpty())
        {
            ItemStack outstack = inventory.getStackInSlot(OUTPUT_SLOT1);
            if (outstack.isEmpty())
            {
                return true;
            }
            else if (! ItemStack.isSameItem(outstack, result))
            {
                return false;
            }
            else
            { // Forge fix: make furnace respect stack sizes in furnace recipes
                return (outstack.getCount() + result.getCount() <= outstack.getMaxStackSize());
            }
 
        } // end-if not output empty and not result empty.
        else
        {
            return false;
        }
    } // end canSmelt()
    
    /** 
     * Is it physically possible to put secondary output in secondary output slot?
     * @param result - secondary output
     * @return true if result can be added to secondary output slot, false if it cannot.
     */
    protected boolean canSmeltSecondary(ItemStack result)
    {
        // result cannot ever be other than specified item (elsewhere).
        
        if (!this.inventory.getStackInSlot(INPUT_SLOT).isEmpty() && !result.isEmpty())
        {
            ItemStack outstack = inventory.getStackInSlot(OUTPUT_SLOT2);
            if (outstack.isEmpty())
            {
                return true;
            }
            else
            { // Forge fix: make furnace respect stack sizes in furnace recipes
                return (outstack.getCount() + result.getCount() <= outstack.getMaxStackSize());
            }
 
        } // end-if not output empty and not result empty.
        else if (result.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    } // end canSmeltSecondary()
    
    /**
     * Mimics the code in {@link AbstractFurnaceTileEntity#getTotalCookTime()}
     *
     * @return The custom smelt time or 200 if there is no recipe for the input
     */
    protected short getSmeltTime(final ItemStack input)
    {
        return getRecipe(input)
                .map(AbstractCookingRecipe::getCookingTime)
                .orElse(BURN_TIME_STANDARD)
                .shortValue();
    }

    /**
     * Actually do the smelting operation. Secondary output generated here.
     * @param result
     */
    protected void smelt(ItemStack result)  // result = itemstack1
    {
        if (result.isEmpty()) { return; }
        
        ItemStack secondaryResult = ItemStack.EMPTY;
        if (generator.nextInt(100) < ArsenicConfig.toxicSootChance)
        {
            secondaryResult = defaultSecondaryResult;
            // System.out.println(ArsenicAndLace.MODID + ": Secondary output (" + secondaryResult.toString() +") created");
        }
        
        if (this.canSmelt(result) && this.canSmeltSecondary(secondaryResult))
        {
            ItemStack inputStack = inventory.getStackInSlot(INPUT_SLOT).copy();  // itemstack
            ItemStack outstack = inventory.getStackInSlot(OUTPUT_SLOT1).copy(); // itemstack2
            ItemStack secondstack = inventory.getStackInSlot(OUTPUT_SLOT2).copy(); // itemstack2
            
            // main output
            if (outstack.isEmpty())
            {
                inventory.setStackInSlot(OUTPUT_SLOT1, result.copy());
            }
            else if (outstack.getItem() == result.getItem())
            {
                outstack.grow(result.getCount());
                inventory.setStackInSlot(OUTPUT_SLOT1, outstack);
            }
            // secondary output
            if (secondstack.isEmpty() && ! secondaryResult.isEmpty()) 
            {
                inventory.setStackInSlot(OUTPUT_SLOT2, secondaryResult.copy());
            }
            else if (! secondaryResult.isEmpty())
            {
                secondstack.grow(secondaryResult.getCount());
                inventory.setStackInSlot(OUTPUT_SLOT2, secondstack);
            }
            
            if (!this.level.isClientSide) 
            {
                this.setRecipeUsed(getRecipe(inputStack).orElse(null));
            }
            final ItemStack fuelStack = inventory.getStackInSlot(FUEL_SLOT).copy();
            if (inputStack.getItem() == Blocks.WET_SPONGE.asItem() && !fuelStack.isEmpty() && fuelStack.getItem() == Items.BUCKET)
            {
                inventory.setStackInSlot(FUEL_SLOT, new ItemStack(Items.WATER_BUCKET));
            }
            inputStack.shrink(1);
            inventory.setStackInSlot(INPUT_SLOT, inputStack);
            // System.out.println(ArsenicAndLace.MODID + ": primary output (" + result.toString() + ") created");
        } // end-if canSmelt result
    } // end smelt()
    
    
    public static void serverTick(Level level, BlockPos blockpos, BlockState blockstate, AbstractTaintedFurnaceBlockEntity tile)
    {
        boolean hasFuel = tile.isBurning();
        boolean flag1 = false;
        
        if (defaultSecondaryResult.isEmpty()) {
            defaultSecondaryResult = new ItemStack(ModItems.arsenic_toxic_soot.get());
//            System.out.println(ArsenicAndLace.MODID + ": defaultSecondaryResult initialized to "
//                               + defaultSecondaryResult.toString());
        }
        if (tile.isBurning())
        {
            --tile.fuelBurnTimeLeft;
        }
        if ( blockstate.getValue(AbstractTaintedFurnaceBlock.LIT) != tile.isBurning() )
        {
            blockstate = blockstate.setValue(AbstractTaintedFurnaceBlock.LIT, Boolean.valueOf(tile.isBurning()));
            level.setBlock(blockpos, blockstate, Block.UPDATE_ALL);
        }
        ItemStack input = tile.inventory.getStackInSlot(INPUT_SLOT).copy();
        ItemStack fuel = tile.inventory.getStackInSlot(FUEL_SLOT).copy();
        final ItemStack result = tile.getResult(input).orElse(ItemStack.EMPTY);
            
        if ((tile.isBurning() || !fuel.isEmpty()) && !input.isEmpty() )
        {
            if (!tile.isBurning() && tile.canSmelt(result))
            {
                tile.fuelBurnTimeLeft = tile.getBurnDuration(fuel);
                tile.maxFuelBurnTime = tile.fuelBurnTimeLeft;
                if (tile.isBurning())
                {
                    flag1 = true;
                    if (fuel.hasCraftingRemainingItem()) 
                    {
                        tile.inventory.setStackInSlot(FUEL_SLOT, fuel.getCraftingRemainingItem());
                    }
                    else if (!fuel.isEmpty()) 
                    {
                        fuel.shrink(1);
                        tile.inventory.setStackInSlot(FUEL_SLOT, fuel); // Update the data
                    }
                } // end-if isBurning
            } // end-if !isBurning but canSmelt
            
            if (tile.isBurning() && tile.canSmelt(result) && tile.canSmeltSecondary(defaultSecondaryResult))
            {
                if (tile.smeltTimeProgress <= 0) // never smelted before
                {
                    tile.maxSmeltTime = tile.getSmeltTime(tile.inventory.getStackInSlot(INPUT_SLOT));
                    tile.smeltTimeProgress = 0;
                }
                ++tile.smeltTimeProgress;
                if (tile.smeltTimeProgress >= tile.maxSmeltTime) 
                {
                    tile.smelt(result);
                    tile.smeltTimeProgress = 0;
                    if (!tile.inventory.getStackInSlot(INPUT_SLOT).isEmpty()) 
                    {
                        tile.maxSmeltTime = tile.getSmeltTime(tile.inventory.getStackInSlot(INPUT_SLOT));
                    }
                    else {
                        tile.maxSmeltTime = 0;
                    }
                    flag1 = true;
                } // end-if progess == maxTime
            } // end-if burning and canBurn
            else {
                tile.smeltTimeProgress = 0;
            }
        } // end-if isBurning & fuel & inputs
        else if (! tile.isBurning() && tile.smeltTimeProgress > 0)
        {
            tile.smeltTimeProgress = (short) Mth.clamp(tile.smeltTimeProgress - 2, 0, tile.maxSmeltTime);
        } // end-else if ! burning & smeltTimeProgress
        if (hasFuel != tile.isBurning())
        {
            flag1 = true;
            blockstate = blockstate.setValue(AbstractTaintedFurnaceBlock.LIT, Boolean.valueOf(tile.isBurning()));
    
            // Flag 2: Send the change to clients
            level.setBlock(blockpos, blockstate, Block.UPDATE_ALL);
        }
        
        if (flag1) {
            setChanged(level, blockpos, blockstate);
         }
    } // end serverTick()

    @Override
    public void onLoad()
    {
        super.onLoad();
        // We set this in onLoad instead of the constructor so that TileEntities
        // constructed from NBT (saved tile entities) have this set to the proper value
        if (level != null && !level.isClientSide)
            lastBurning = isBurning();
    }

    /**
     * Read saved data from disk into the tile.
     */
    @Override
    public void load(final CompoundTag compound)
    {
        super.load(compound);
        this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));
        this.smeltTimeProgress = compound.getInt(SMELT_TIME_LEFT_TAG);
        this.maxSmeltTime = compound.getInt(MAX_SMELT_TIME_TAG);
        this.fuelBurnTimeLeft = compound.getInt(FUEL_BURN_TIME_LEFT_TAG);
        this.maxFuelBurnTime = compound.getInt(MAX_FUEL_BURN_TIME_TAG);

        // We set this in read() instead of the constructor so that TileEntities
        // constructed from NBT (saved tile entities) have this set to the proper value
        if (this.hasLevel() && !this.level.isClientSide) {
            lastBurning = this.isBurning();
        }

        // get recipe2xp map
        int ii = compound.getShort("RecipesUsedSize");
        for(int jj = 0; jj < ii; ++jj) {
           ResourceLocation resourcelocation 
               = new ResourceLocation(compound.getString("RecipeLocation" + jj));
           int kk = compound.getInt("RecipeAmount" + jj);
           this.recipe2xp_map.put(resourcelocation, kk);
        }
        
        // blockstate?
        if (this.hasLevel()) {
            this.level.setBlockAndUpdate(getBlockPos(), this.getBlockState()
                                            .setValue(BlockStateProperties.LIT, 
                                                    Boolean.valueOf(this.isBurning())));
        }
        
    } // end load()

    /**
     * Write data from the tile into a compound tag for saving to disk.
     */
    @Nonnull
    @Override
    public void saveAdditional(final CompoundTag compound)
    {
        super.saveAdditional(compound);
        compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
        compound.putInt(SMELT_TIME_LEFT_TAG, this.smeltTimeProgress);
        compound.putInt(MAX_SMELT_TIME_TAG, this.maxSmeltTime);
        compound.putInt(FUEL_BURN_TIME_LEFT_TAG, this.fuelBurnTimeLeft);
        compound.putInt(MAX_FUEL_BURN_TIME_TAG, this.maxFuelBurnTime);
        
        // write recipe2xp map
        compound.putShort("RecipesUsedSize", (short)this.recipe2xp_map.size());
        int ii = 0;
        for(Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet()) 
        {
           compound.putString("RecipeLocation" + ii, entry.getKey().toString());
           compound.putInt("RecipeAmount" + ii, entry.getValue());
           ++ii;
        }
    } // end saveAdditional()

    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the
     * chunk or when many blocks change at once.
     * This compound comes back to you client-side in {@link #handleUpdateTag}
     * The default implementation ({@link TileEntity#handleUpdateTag}) calls {@link #writeInternal)}
     * which doesn't save any of our extra data so we override it to call {@link #write} instead
     */
    @Override
    @Nonnull
    public CompoundTag getUpdateTag()
    {
        return this.saveWithFullMetadata();
    }

    /**
     * Called when the chunk's TE update tag, gotten from {@link #getUpdateTag()}, is received on the client.
     * Used to handle this tag in a special way. By default this simply calls {@link #readFromNBT(NBTTagCompound)}.
     *
     * @param tag The {@link NBTTagCompound} sent from {@link #getUpdateTag()}
     */
    @Override
    public void handleUpdateTag(CompoundTag tag)
    {
        this.load(tag);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    
    /**
     * Called when you receive a TileEntityData packet for the location this
     * TileEntity is currently in. On the client, the NetworkManager will always
     * be the remote server. On the server, it will be whomever is responsible for
     * sending the packet.
     *
     * @param net The NetworkManager the packet originated from
     * @param pkt The data packet
     */
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt)
    {
        CompoundTag nbtTag = pkt.getTag();
        this.load(nbtTag);
    }

    public void grantExperience(Player player)
    {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Entry<ResourceLocation, Integer> entry : this.recipe2xp_map.entrySet())
        {
            player.level().getRecipeManager().byKey(entry.getKey()).ifPresent((p_213993_3_) -> {
                list.add(p_213993_3_);
                spawnExpOrbs(player, entry.getValue(), ((AbstractCookingRecipe) p_213993_3_).getExperience());
            });
        }
        player.awardRecipes(list);
        this.recipe2xp_map.clear();
    }
    
    protected static void spawnExpOrbs(Player player, int pCount, float experience)
    {
        if (experience == 0.0F) {
            pCount = 0;
        }
        else if (experience < 1.0F)
        {
            int i = Mth.floor((float) pCount * experience);
            if (i < Mth.ceil((float) pCount * experience)
                    && Math.random() < (double) ((float) pCount * experience - (float) i))
            {
                ++i;
            }
            pCount = i;
        }

        while (pCount > 0)
        {
            int j = ExperienceOrb.getExperienceValue(pCount);
            pCount -= j;
            player.level().addFreshEntity(new ExperienceOrb(player.level(), player.getX(), player.getY() + 0.5D,
                    player.getZ() + 0.5D, j));
        }
    } // end spawnExpOrbs()

} // end class
