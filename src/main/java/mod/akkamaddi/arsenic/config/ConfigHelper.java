package mod.akkamaddi.arsenic.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper
{
    public static void bakeClient(final ModConfig config) 
    {
    } // end bakeClient

    public static void bakeServer(final ModConfig config) 
    {
        // not a flag
        ArsenicConfig.enableChestLoot = ConfigHolder.SERVER.serverEnableChestLoot.get();
        
        // ore generation?
        ArsenicConfig.generateArsenicOre = ConfigHolder.SERVER.serverGenerateArsenicOre.get();

        ArsenicConfig.arsenic_cfg = new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverArsenicVeinSize.get(), 
                ConfigHolder.SERVER.serverArsenicVeinCount.get(), true, 
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverArsenicBottomHeight.get()), 
                VerticalAnchor.absolute(ConfigHolder.SERVER.serverArsenicMaxHeight.get()));
        
        // Necrotic furnace chance of generating toxic soot per smelt op.
        ArsenicConfig.toxicSootChance = ConfigHolder.SERVER.serverToxicSootChance.get();
        
        // Does necrotic furnace poison food?
        ArsenicConfig.necroticFurnacePoisonsFood = ConfigHolder.SERVER.serverNecroticFurnacePoisonsFood.get();
        
        // recipe flags.
        ArsenicConfig.INSTANCE.putFlag("recycling_enabled", 
                ConfigHolder.SERVER.serverEnableRecycling.get());
        
        ArsenicConfig.INSTANCE.putFlag("arsenic_making_enabled", 
                ConfigHolder.SERVER.serverEnableArsenicMaking.get());
        ArsenicConfig.INSTANCE.putFlag("arsenic_tools_enabled",
                ConfigHolder.SERVER.serverEnableArsenicTools.get());
        
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
