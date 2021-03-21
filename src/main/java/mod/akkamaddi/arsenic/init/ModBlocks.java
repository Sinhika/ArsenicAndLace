package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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

    // storage blocks
    public static final RegistryObject<Block> arsenic_block = BLOCKS.register("arsenic_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(3.0F, 10.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> arsenide_bronze_block = BLOCKS.register("arsenide_bronze_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(5.0F, 20.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> arsenide_gold_block = BLOCKS.register("arsenide_gold_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(4.0F, 16.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> tenebrium_block = BLOCKS.register("tenebrium_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(12.0F, 55.0F).sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).requiresCorrectToolForDrops()));    
   
    // pressure plate
    public static final RegistryObject<PressurePlateBlock> arsenic_plate = BLOCKS.register("arsenic_plate",
            () -> new  PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, 
                                          AbstractBlock.Properties.of(Material.METAL, 
                                                  ModBlocks.arsenic_block.get().defaultMaterialColor())
                                          .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
} // end class
