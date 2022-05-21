package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags
{
    public static class Items
    {
        public static final TagKey<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final TagKey<Item> INGOTS_ARSENIC = forgeTag("ingots/arsenic");
        
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.bind("forge:" + name);
        }
    } // end class Items
    
    private static ResourceLocation tagMeats = new ResourceLocation(ArsenicAndLace.MODID, "meats");
    public static Tag<Item> getMeats() {
        return ItemTags.getAllTags().getTag( tagMeats );
    }
    
    private static ResourceLocation tagVegetables = new ResourceLocation(ArsenicAndLace.MODID, "vegetables");
    public static Tag<Item> getVegetables() {
        return ItemTags.getAllTags().getTag( tagVegetables );
    }
    
} // end class
