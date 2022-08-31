package mod.akkamaddi.arsenic.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;

public class ArsenicConfig extends SimpleConfig
{
    // recipe flags
    public static ArsenicConfig INSTANCE = new ArsenicConfig();
    
    public static boolean enableChestLoot;
    public static boolean generateArsenicOre;
    public static boolean necroticFurnacePoisonsFood;
    public static int toxicSootChance;
    

} // end-class
