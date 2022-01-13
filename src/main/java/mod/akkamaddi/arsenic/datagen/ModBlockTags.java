package mod.akkamaddi.arsenic.datagen;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider
{

    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, ArsenicAndLace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        registerStorageBlockTags();
    } // end registerTags()
    
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
    }
    
} // end class
