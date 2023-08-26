package mod.akkamaddi.arsenic.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends MiningBlockTags
{

    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
        super.addTags(pProvider);
        registerStorageBlockTags();
        registerBeaconTags();
        registerMiscTags();
    } // end registerTags()
    
    
    @Override
    protected void registerOreTags()
    {
        this.tag(TagUtils.forgeBlockTag( "ores"))
                .addTag(TagUtils.forgeBlockTag( "ores/arsenic"));
        this.tag(TagUtils.forgeBlockTag( "ores/arsenic"))
	        .add(ModBlocks.arsenic_ore_stone.get())
	        .add(ModBlocks.arsenic_ore_deepslate.get());
        
        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.arsenic_ore_stone.get(), ModBlocks.arsenic_ore_deepslate.get()), // singular 
                List.of()); // dense
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(ModBlocks.arsenic_ore_stone.get()), // stone ores
                List.of(ModBlocks.arsenic_ore_deepslate.get()), // deepslate ores
                List.of());  // netherrack ores
    } // end registerOreTags()
    
    private void registerMiscTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "pressure_plates"))
    		.add(ModBlocks.arsenic_plate.get());
    	
    }
    
    @Override
    protected void registerMiningTags()
    {			
    	// (mineable, stone, iron, diamond, netherite)
    	this.registerMineableTags(
    			List.of(ModBlocks.arsenic_block.get(), ModBlocks.arsenide_bronze_block.get(),
    					ModBlocks.arsenide_gold_block.get(), ModBlocks.tenebrium_block.get(),
    					ModBlocks.arsenic_plate.get(), ModBlocks.arsenic_ore_stone.get(),
    					ModBlocks.arsenic_ore_deepslate.get(), ModBlocks.raw_arsenic_block.get()), // mineable
    			List.of(ModBlocks.arsenic_block.get(), ModBlocks.arsenide_gold_block.get(), 
    			        ModBlocks.raw_arsenic_block.get()), // stone
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
            .addTag(TagUtils.forgeBlockTag("storage_blocks/tenebrium"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/raw_arsenic"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenic"))
            .add(ModBlocks.arsenic_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_arsenic"))
            .add(ModBlocks.raw_arsenic_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenide_bronze"))
            .add(ModBlocks.arsenide_bronze_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/arsenide_gold"))
            .add(ModBlocks.arsenide_gold_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/tenebrium"))
            .add(ModBlocks.tenebrium_block.get());
    } // end registerStorageBlockTags()
    
} // end class
