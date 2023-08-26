package mod.akkamaddi.arsenic.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
        super.addTags(lookupProvider);
        registerDustTags();
        registerNuggetTags();
        registerIngotTags();
        registerStorageBlockTags();
        registerMiscTags();
        registerToolTags(ModItems.ITEMS);
        registerArmorTags(ModItems.ITEMS);
    }

    
    @Override
    protected void registerOreTags()
    {
        this.tag(TagUtils.forgeTag( "ores"))
            .addTag(TagUtils.forgeTag( "ores/arsenic"));
        this.tag(TagUtils.forgeTag( "ores/arsenic"))
            .add(ModBlocks.arsenic_ore_stone.get().asItem())
            .add(ModBlocks.arsenic_ore_deepslate.get().asItem());
        
        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
                List.of(ModBlocks.arsenic_ore_stone.get(), ModBlocks.arsenic_ore_deepslate.get()), // singular 
                List.of()); // dense
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(ModBlocks.arsenic_ore_stone.get()), // stone ores
                List.of(ModBlocks.arsenic_ore_deepslate.get()), // deepslate ores
                List.of());  // netherrack ores
        
    } // end registerOreTags()

    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
            .addTag(TagUtils.forgeTag("nuggets/arsenic"))
            .addTag(TagUtils.forgeTag("nuggets/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("nuggets/arsenide_gold"))
            .addTag(TagUtils.forgeTag("nuggets/tenebrium"))
            .addTag(TagUtils.forgeTag("nuggets/realgar"))
            .addTag(TagUtils.forgeTag("nuggets/orpiment"));
        
        
        this.tag(TagUtils.forgeTag("nuggets/arsenic")).add(ModItems.arsenic_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/arsenide_bronze")).add(ModItems.arsenide_bronze_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/arsenide_gold")).add(ModItems.arsenide_gold_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/tenebrium")).add(ModItems.tenebrium_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/realgar")).add(ModItems.realgar.get());
        this.tag(TagUtils.forgeTag("nuggets/orpiment")).add(ModItems.orpiment.get());
        
    } // end registerNuggetTags()
    
    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
            .addTag(TagUtils.forgeTag("ingots/arsenic"))
            .addTag(TagUtils.forgeTag("ingots/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("ingots/arsenide_gold"))
            .addTag(TagUtils.forgeTag("ingots/tenebrium"));
       
        this.tag(TagUtils.forgeTag("ingots/arsenic")).add(ModItems.arsenic_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/arsenide_bronze")).add(ModItems.arsenide_bronze_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/arsenide_gold")).add(ModItems.arsenide_gold_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/tenebrium")).add(ModItems.tenebrium_ingot.get());
        
    } // end registerIngotTags()

    private void registerDustTags()
    {
        this.tag(TagUtils.forgeTag("dusts"))
            .addTag(TagUtils.forgeTag("dusts/arsenic"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_gold"))
            .addTag(TagUtils.forgeTag("dusts/tenebrium"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_salt"));
        
        this.tag(TagUtils.forgeTag("dusts/arsenic")).add(ModItems.arsenic_dust.get());
        this.tag(TagUtils.forgeTag("dusts/arsenide_bronze")).add(ModItems.arsenide_bronze_dust.get());
        this.tag(TagUtils.forgeTag("dusts/arsenide_gold")).add(ModItems.arsenide_gold_dust.get());
        this.tag(TagUtils.forgeTag("dusts/tenebrium")).add(ModItems.tenebrium_dust.get());
        this.tag(TagUtils.forgeTag("dusts/arsenide_salt")).add(ModItems.arsenide_salt.get());
    } // end registerDustTags()

    private void registerMiscTags()
    {
        this.tag(TagUtils.forgeTag("reagents"))
            .addTag(TagUtils.forgeTag("reagents/old_lace"));
        this.tag(TagUtils.forgeTag("reagents/old_lace")).add(ModItems.old_lace_chest.get());
        
    } // registerMiscTags()
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeTag("storage_blocks"))
            .addTag(TagUtils.forgeTag("storage_blocks/arsenic"))
            .addTag(TagUtils.forgeTag("storage_blocks/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("storage_blocks/arsenide_gold"))
            .addTag(TagUtils.forgeTag("storage_blocks/tenebrium"))
            .addTag(TagUtils.forgeTag("storage_blocks/raw_arsenic"));
        
        this.tag(TagUtils.forgeTag("storage_blocks/arsenic"))
            .add(ModBlocks.arsenic_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/raw_arsenic"))
            .add(ModBlocks.raw_arsenic_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/arsenide_bronze"))
            .add(ModBlocks.arsenide_bronze_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/arsenide_gold"))
            .add(ModBlocks.arsenide_gold_block.get().asItem());
        this.tag(TagUtils.forgeTag("storage_blocks/tenebrium"))
            .add(ModBlocks.tenebrium_block.get().asItem());
    } // end registerStorageBlockTags()
 
} // end class
