package mod.akkamaddi.arsenic.datagen;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends MiningItemTags
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerDustTags();
        registerNuggetTags();
        registerIngotTags();
        registerMiscTags();
    }

    
    @Override
    protected void registerOreTags()
    {
        this.tag(TagUtils.forgeTag( "ores"))
            .addTag(TagUtils.forgeTag( "ores/arsenic"));
        this.tag(TagUtils.forgeTag( "ores/arsenic"))
            .add(ModBlocks.arsenic_ore_stone.get().asItem())
            .add(ModBlocks.arsenic_ore_deepslate.get().asItem());
        
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
} // end class
