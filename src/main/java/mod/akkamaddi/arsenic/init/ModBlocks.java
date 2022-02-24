package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.content.TaintedFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArsenicAndLace.MODID);

    // ore blocks - hard (requires iron tools to mine), but brittle (low strength & blast resistance)
    public static final RegistryObject<OreBlock> arsenic_ore_stone =  BLOCKS.register("arsenic_ore_stone",
    		() -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 2.0F, 1.0F)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<OreBlock> arsenic_ore_deepslate =  BLOCKS.register("arsenic_ore_deepslate",
    		() -> new OreBlock(Block.Properties.of(Material.STONE)
                    .strength( 2.0F, 1.0F)
                    .requiresCorrectToolForDrops()));
    
    // storage blocks
    public static final RegistryObject<Block> arsenic_block = BLOCKS.register("arsenic_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(3.0F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> raw_arsenic_block = BLOCKS.register("raw_arsenic_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(3.0F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> arsenide_bronze_block = BLOCKS.register("arsenide_bronze_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(5.0F, 20.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> arsenide_gold_block = BLOCKS.register("arsenide_gold_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(4.0F, 16.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> tenebrium_block = BLOCKS.register("tenebrium_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(12.0F, 55.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));    
   
    // pressure plate
    public static final RegistryObject<PressurePlateBlock> arsenic_plate = BLOCKS.register("arsenic_plate",
            () -> new  PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, 
                                          BlockBehaviour.Properties.of(Material.METAL, 
                                                  ModBlocks.arsenic_block.get().defaultMaterialColor())
                                          .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
    // ovens - TEMPORARY
    public static final RegistryObject<TaintedFurnaceBlock> tainted_furnace = BLOCKS.register("tainted_furnace",
            () -> new TaintedFurnaceBlock(Block.Properties.of(Material.METAL).strength(2.0F, 1.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    
} // end class
