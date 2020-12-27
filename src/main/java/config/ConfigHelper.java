package config;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        // recipe flags.
        ArsenicConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        
        ArsenicConfig.INSTANCE.putFlag("arsenide_bronze_making_enabled", 
                ConfigHolder.SERVER.serverEnableArsenideBronzeMaking.get());
        ArsenicConfig.INSTANCE.putFlag("arsenide_bronze_tools_enabled",
                ConfigHolder.SERVER.serverEnableArsenideBronzeTools.get());
        
        ArsenicConfig.INSTANCE.putFlag("arsenide_gold_making_enabled", 
                ConfigHolder.SERVER.serverEnableArsenideGoldMaking.get());
        ArsenicConfig.INSTANCE.putFlag("arsenide_gold_tools_enabled",
                ConfigHolder.SERVER.serverEnableArsenideGoldTools.get());
        
        ArsenicConfig.INSTANCE.putFlag("tenebrium_making_enabled", 
                ConfigHolder.SERVER.serverEnableTenebriumMaking.get());
        ArsenicConfig.INSTANCE.putFlag("tenebrium_tools_enabled",
                ConfigHolder.SERVER.serverEnableTenebriumTools.get());
    } // end bakeServer()
} // end class
