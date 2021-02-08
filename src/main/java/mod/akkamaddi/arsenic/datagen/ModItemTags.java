package mod.akkamaddi.arsenic.datagen;

import mod.akkamaddi.arsenic.ArsenicAndLace;
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
        registerIngotTags();
    }
    
    private void registerIngotTags()
    {
        // TODO Auto-generated method stub
        
    }

    private void registerDustTags()
    {
        // TODO
    }
} // end class
