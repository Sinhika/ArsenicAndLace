package mod.akkamaddi.arsenic.init;

import net.minecraft.world.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;

public class ModTags
{
    public static class Items
    {
        public static final Tag.Named<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final Tag.Named<Item> INGOTS_ARSENIC = forgeTag("ingots/arsenic");
        
        private static Tag.Named<Item> forgeTag(String name) {
            return ItemTags.bind("forge:" + name);
        }
    } // end class Items

} // end class
