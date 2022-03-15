package mod.akkamaddi.arsenic.config;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ServerConfig
{
    final ForgeConfigSpec.BooleanValue serverEnableChestLoot; // load additional chest loot?
    final ForgeConfigSpec.IntValue serverToxicSootChance;    // 0 to 100 chance of generating toxic soot
    final ForgeConfigSpec.BooleanValue serverGenerateArsenicOre; // world generation
    final ForgeConfigSpec.IntValue serverArsenicVeinSize;
    final ForgeConfigSpec.IntValue serverArsenicVeinCount;
    final ForgeConfigSpec.IntValue serverArsenicBottomHeight;
    final ForgeConfigSpec.IntValue serverArsenicMaxHeight;

    final ForgeConfigSpec.BooleanValue serverNecroticFurnacePoisonsFood;
    final ForgeConfigSpec.BooleanValue serverEnableRecycling; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenicMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenicTools; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideBronzeMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideBronzeTools; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideGoldMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableArsenideGoldTools; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableTenebriumMaking; // recipe flag
    final ForgeConfigSpec.BooleanValue serverEnableTenebriumTools; // recipe flag

    ServerConfig(final ForgeConfigSpec.Builder builder)
    {
        builder.push("General");
        serverEnableChestLoot =
                builder.comment("Enable additional loot from this mod in chests")
                .translation(ArsenicAndLace.MODID + "config.EnableChestLoot")
                .define("EnableChestLoot", true);
                
        serverEnableRecycling = 
                builder.comment("Enable fusion furnace recycling of arsenide and tenebrium items")
                .translation(ArsenicAndLace.MODID + "config.EnableRecycling")
                .define("EnableRecycling", true);
        
        serverToxicSootChance = 
                builder.comment("Chance of generating toxic soot per item cooked in Necrotic furnace")
                .translation(ArsenicAndLace.MODID + "config.ToxicSootChance")
                .defineInRange("ToxicSootChance", 25, 0, 100);
        
        serverNecroticFurnacePoisonsFood = 
                builder.comment("Necrotic Furnace poisons food; e.g. turns meats into rotten meat, "
                        + "vegtables into poisonous potatoes")
                .translation(ArsenicAndLace.MODID + ".config.NecroticFurnacePoisonsFood")
                .define("NecroticFurnacePoisonsFood", true);
        builder.pop();
        
        builder.push("Arsenic");
        serverEnableArsenicMaking = 
                builder.comment("Enable making Arsenic alloy in fusion furnace")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenicMaking")
                .define("EnableArsenicMaking", true);
        serverEnableArsenicTools = builder.comment("Enable making Arsenic tools")
                .translation(ArsenicAndLace.MODID + "config.EnableArsenicTools")
                .define("EnableArsenicTools", true);
        serverGenerateArsenicOre  = builder.comment("Enable Arsenic Ore generation in the world")
                .translation(ArsenicAndLace.MODID + "config.GenerateArsenicOre")
                .define("GenerateArsenicOre", true);
        serverArsenicVeinSize = builder
                .comment("Arsenic ore vein size")
                .translation(ArsenicAndLace.MODID + ".config.serverArsenicVeinSize")
                .defineInRange("ArsenicVeinSize", 3, 1, Integer.MAX_VALUE);
        serverArsenicVeinCount = builder
                .comment("Arsenic ore vein count per chunk")
                .translation(ArsenicAndLace.MODID + ".config.serverArsenicVeinCount")
                .defineInRange("ArsenicVeinCount", 4, 1, Integer.MAX_VALUE);
        serverArsenicBottomHeight = builder
                .comment("Arsenic ore minimum height")
                .translation(ArsenicAndLace.MODID + ".config.serverArsenicBottomHeight")
                .defineInRange("ArsenicBottomHeight", -16, -63, 254);
        serverArsenicMaxHeight = builder
                .comment("Arsenic ore maximum height")
                .translation(ArsenicAndLace.MODID + ".config.serverArsenicMaxHeight")
                .defineInRange("ArsenicMaxHeight", 16, -63, 255);

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
