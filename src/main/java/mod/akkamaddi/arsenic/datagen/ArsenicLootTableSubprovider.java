package mod.akkamaddi.arsenic.datagen;

import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;

public class ArsenicLootTableSubprovider extends SimpleBlockLootSubProvider
{

    @Override
	protected void generate() 
    {
    	dropSelf(ModBlocks.arsenic_block.get());
    	dropSelf(ModBlocks.raw_arsenic_block.get());
    	dropSelf(ModBlocks.arsenide_bronze_block.get());
    	dropSelf(ModBlocks.arsenide_gold_block.get());
    	dropSelf(ModBlocks.tenebrium_block.get());
    	dropSelf(ModBlocks.arsenic_plate.get());
    	dropMultiItemsWithFortune(ModBlocks.arsenic_ore_stone.get(), ModItems.raw_arsenic.get(), 1, 1);
    	dropMultiItemsWithFortune(ModBlocks.arsenic_ore_deepslate.get(), ModItems.raw_arsenic.get(), 1, 1);
    }

} // end class
