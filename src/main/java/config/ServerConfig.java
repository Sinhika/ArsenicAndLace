package config;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.haditecoal.HaditeCoal;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideBronzeMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideBronzeTools; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideGoldMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideGoldTools; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableTenebriumMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableTenebriumTools; // recipe flag

    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of arsenide and tenebrium items")
                .translation(ArsenicAndLace.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        builder.pop();
        
        builder.push("Arsenide Bronze");
        serverEnableArsenideBronzeMaking = 
                builder.comment("Enable making Arsenide Bronze alloy in fusion furnace")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenideBronzeMaking")
                .define("EnableArsenideBronzeMaking", true);
        serverEnableArsenideBronzeTools = builder.comment("Enable making Arsenide Bronze tools")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenideBronzeTools")
                .define("EnableArsenideBronzeTools", true);
        builder.pop();

        builder.push("Arsenide Gold");
        serverEnableArsenideGoldMaking = 
                builder.comment("Enable making Arsenide Gold alloy in fusion furnace")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenideGoldMaking")
                .define("EnableArsenideGoldMaking", true);
        serverEnableArsenideGoldTools = builder.comment("Enable making Arsenide Gold tools")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenideGoldTools")
                .define("EnableArsenideGoldTools", true);
        builder.pop();

        builder.push("Tenebrium");
        serverEnableTenebriumMaking = 
                builder.comment("Enable making Tenebrium alloy in fusion furnace")
                .translation(ArsenicAndLace.MODID + "config.EnableTenebriumMaking")
                .define("EnableTenebriumMaking", true);
        serverEnableTenebriumTools = builder.comment("Enable making Tenebrium tools")
                .translation(ArsenicAndLace.MODID + "config.EnableTenebriumTools")
                .define("EnableTenebriumTools", true);
        builder.pop();

    } // end ctor()
    
} // end class
