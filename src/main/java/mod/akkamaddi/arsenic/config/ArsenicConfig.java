package mod.akkamaddi.arsenic.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import mod.alexndr.simplecorelib.config.SimpleConfig;

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
    
    public static ModOreConfig arsenic_cfg;

} // end-class
