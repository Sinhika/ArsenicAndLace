package mod.akkamaddi.arsenic.config;

import mod.alexndr.simplecorelib.api.config.ModOreConfig;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.common.util.Lazy;

public class ArsenicConfig extends SimpleConfig
{
    // recipe flags
    public static ArsenicConfig INSTANCE = new ArsenicConfig();
    
    public static boolean enableChestLoot;
    public static boolean generateArsenicOre;
    public static boolean necroticFurnacePoisonsFood;
    public static int toxicSootChance;
    
//    public static final int arsenic_vein_size = 3;
//    public static final int arsenic_vein_count = 4;
    
    public static Lazy<ModOreConfig> arsenic_cfg = Lazy.of(
            ()->new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverArsenicVeinSize.get(), 
                    ConfigHolder.SERVER.serverArsenicVeinCount.get(), true, 
                    VerticalAnchor.absolute(ConfigHolder.SERVER.serverArsenicBottomHeight.get()), 
                    VerticalAnchor.absolute(ConfigHolder.SERVER.serverArsenicMaxHeight.get())));
    

} // end-class
