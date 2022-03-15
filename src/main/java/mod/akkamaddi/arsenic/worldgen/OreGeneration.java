package mod.akkamaddi.arsenic.worldgen;

import java.util.List;

import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.alexndr.simplecorelib.world.OreGenUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration
{
    public static final List<OreConfiguration.TargetBlockState> ARSENIC_TARGET_LIST = 
            OreGenUtils.BuildStandardOreTargetList(ModBlocks.arsenic_ore_stone.get(), ModBlocks.arsenic_ore_deepslate.get());
    
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ARSENIC;
    
    public static PlacedFeature ORE_ARSENIC_DEPOSIT;
     
    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    public static void initOverworldFeatures()
    {
        if (ArsenicConfig.generateArsenicOre) {
            ORE_ARSENIC = FeatureUtils.register("ore_arsenic", 
                    OreGenUtils.ConfigureOreFeature(ARSENIC_TARGET_LIST, ArsenicConfig.arsenic_cfg.getVein_size(), 0.5F));
            ORE_ARSENIC_DEPOSIT = PlacementUtils.register("ore_arsenic_deposit", 
                    OreGenUtils.ConfigurePlacedFeature(ArsenicConfig.arsenic_cfg, ORE_ARSENIC));
        }
    } // end initOverworldFeatures()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (ArsenicConfig.generateArsenicOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ORE_ARSENIC_DEPOSIT);
        }        
    }
} // end class
