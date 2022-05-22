package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

public class ModTags
{
    public static class Items
    {
        public static final TagKey<Item> INGOTS_COPPER = TagUtils.forgeTag("ingots/copper");
        public static final TagKey<Item> INGOTS_ARSENIC = TagUtils.forgeTag("ingots/arsenic");
        
    } // end class Items
    
    private static TagKey<Item> tagMeats = TagUtils.modTag(ArsenicAndLace.MODID, "meats");
    public static ITag<Item> getMeats() {
        return ForgeRegistries.ITEMS.tags().getTag( tagMeats );
    }
    
    private static TagKey<Item> tagVegetables = TagUtils.modTag(ArsenicAndLace.MODID, "vegetables");
    public static ITag<Item> getVegetables() {
        return ForgeRegistries.ITEMS.tags().getTag( tagVegetables );
    }
    
} // end class
