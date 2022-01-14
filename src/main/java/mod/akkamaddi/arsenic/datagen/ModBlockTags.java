package mod.akkamaddi.arsenic.datagen;

import java.util.List;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.alexndr.simplecorelib.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        registerOreTags();
        registerStorageBlockTags();
        registerMiningTags();
        registerBeaconTags();
        registerMiscTags();
    } // end registerTags()
    
    
    private void registerOreTags()
    {
        this.tag(TagUtils.forgeBlockTag( "ores"))
                .addTag(TagUtils.forgeBlockTag( "ores/arsenic"));
        this.tag(TagUtils.forgeBlockTag( "ores/arsenic"))
	        .add(ModBlocks.arsenic_ore_stone.get())
	        .add(ModBlocks.arsenic_ore_deepslate.get());
    } 
    
    private void registerMiscTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "pressure_plates"))
    		.add(ModBlocks.arsenic_plate.get());
    	
    }
    
    private void registerMiningTags()
    {			
    	// (mineable, stone, iron, diamond, netherite)
    	this.registerMineableTags(
    			List.of(ModBlocks.arsenic_block.get(), ModBlocks.arsenide_bronze_block.get(),
    					ModBlocks.arsenide_gold_block.get(), ModBlocks.tenebrium_block.get(),
    					ModBlocks.arsenic_plate.get(), ModBlocks.arsenic_ore_stone.get(),
    					ModBlocks.arsenic_ore_deepslate.get()), // mineable
    			List.of(ModBlocks.arsenic_block.get(), ModBlocks.arsenide_gold_block.get()), // stone
    			List.of(ModBlocks.arsenide_bronze_block.get(),
    					ModBlocks.arsenic_ore_stone.get(), ModBlocks.arsenic_ore_deepslate.get()), // iron
    			List.of(), // diamond
    			List.of(ModBlocks.tenebrium_block.get()) ); // netherite
    }
    
    private void registerBeaconTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "beacon_base_blocks"))
    		.add(ModBlocks.arsenic_block.get())
    		.add(ModBlocks.arsenide_bronze_block.get())
    		.add(ModBlocks.arsenide_gold_block.get())
    		.add(ModBlocks.tenebrium_block.get());
    }
    
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/arsenic"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/arsenide_bronze"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/arsenide_gold"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/tenebrium"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenic"))
            .add(ModBlocks.arsenic_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenide_bronze"))
            .add(ModBlocks.arsenide_bronze_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenide_gold"))
            .add(ModBlocks.arsenide_gold_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/tenebrium"))
            .add(ModBlocks.tenebrium_block.get());
    } // end registerStorageBlockTags()
    
} // end class
