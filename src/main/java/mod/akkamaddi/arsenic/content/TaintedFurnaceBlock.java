package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.api.content.AbstractTaintedFurnaceBlock;
import mod.akkamaddi.arsenic.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

public class TaintedFurnaceBlock extends AbstractTaintedFurnaceBlock
{
    private static final String DISPLAY_NAME = "block.arsenic.tainted_furnace";

    public TaintedFurnaceBlock(Properties builder)
    {
        super(builder);
    }

    /**
     * Called on the logical server when a BlockState with a TileEntity is replaced by another BlockState.
     * We use this method to drop all the items from our tile entity's inventory and update comparators near our block.
     *
     * @Deprecated Call via {@link BlockState#onReplaced(World, BlockPos, BlockState, boolean)}
     * Implementing/overriding is fine.
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState oldState, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) 
    {
        if (oldState.getBlock() != newState.getBlock()) 
        {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof TaintedFurnaceBlockEntity) {
                final ItemStackHandler inventory = ((TaintedFurnaceBlockEntity) tileEntity).inventory;
                for (int slot = 0; slot < inventory.getSlots(); ++slot)
                    Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), inventory.getStackInSlot(slot));
            }
        }
        super.onRemove(oldState, worldIn, pos, newState, isMoving);
    } // end onRemove()


    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate,
            BlockEntityType<T> entityType)
    {
        return createFurnaceTicker(level, entityType, ModBlockEntityTypes.tainted_furnace.get());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate)
    {
        return new TaintedFurnaceBlockEntity(bpos, bstate);
    }

    @Override
    protected void openContainer(Level level, BlockPos bpos, Player player)
    {
        BlockEntity be = level.getBlockEntity(bpos);
        if (be instanceof TaintedFurnaceBlockEntity) 
        {
            MenuProvider containerProvider = new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable(DISPLAY_NAME);
                }
                
                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity)
                {
                    return new TaintedFurnaceContainerMenu(windowId, bpos, playerInventory, playerEntity);
                }
            }; // end anonymous-class
            NetworkHooks.openScreen((ServerPlayer) player, containerProvider, be.getBlockPos());
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        } // end-if
        else {
            throw new IllegalStateException("Our named container provider is missing!");
        }
    }

} // end class
