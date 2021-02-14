package mod.akkamaddi.arsenic.datagen;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, new ModBlockTags(dataGenerator, existingFileHelper), ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        registerDustTags();
        registerNuggetTags();
        registerIngotTags();
    }

    private void registerNuggetTags()
    {
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets"))
            .addTag(TagUtils.forgeTag("nuggets/arsenic"))
            .addTag(TagUtils.forgeTag("nuggets/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("nuggets/arsenide_gold"))
            .addTag(TagUtils.forgeTag("nuggets/tenebrium"))
            .addTag(TagUtils.forgeTag("nuggets/realgar"))
            .addTag(TagUtils.forgeTag("nuggets/orpiment"));
        
        
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/arsenic")).add(ModItems.arsenic_nugget.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/arsenide_bronze")).add(ModItems.arsenide_bronze_nugget.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/arsenide_gold")).add(ModItems.arsenide_gold_nugget.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/tenebrium")).add(ModItems.tenebrium_nugget.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/realgar")).add(ModItems.realgar.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("nuggets/orpiment")).add(ModItems.orpiment.get());
        
    } // end registerNuggetTags()
    
    private void registerIngotTags()
    {
        this.getOrCreateBuilder(TagUtils.forgeTag("ingots"))
            .addTag(TagUtils.forgeTag("ingots/arsenic"))
            .addTag(TagUtils.forgeTag("ingots/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("ingots/arsenide_gold"))
            .addTag(TagUtils.forgeTag("ingots/tenebrium"));
       
        this.getOrCreateBuilder(TagUtils.forgeTag("ingots/arsenic")).add(ModItems.arsenic_ingot.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("ingots/arsenide_bronze")).add(ModItems.arsenide_bronze_ingot.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("ingots/arsenide_gold")).add(ModItems.arsenide_gold_ingot.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("ingots/tenebrium")).add(ModItems.tenebrium_ingot.get());
        
    } // end registerIngotTags()

    private void registerDustTags()
    {
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts"))
            .addTag(TagUtils.forgeTag("dusts/arsenic"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_bronze"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_gold"))
            .addTag(TagUtils.forgeTag("dusts/tenebrium"))
            .addTag(TagUtils.forgeTag("dusts/arsenide_salt"));
        
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/arsenic")).add(ModItems.arsenic_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/arsenide_bronze")).add(ModItems.arsenide_bronze_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/arsenide_gold")).add(ModItems.arsenide_gold_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/tenebrium")).add(ModItems.tenebrium_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/arsenide_salt")).add(ModItems.arsenide_salt.get());
    } // end registerDustTags()
    
} // end class
