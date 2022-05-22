package mod.akkamaddi.arsenic.worldgen;

import mod.akkamaddi.arsenic.config.ArsenicConfig;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import mod.akkamaddi.arsenic.init.ModFeatures;

public class OreGeneration
{
      
     /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (ArsenicConfig.generateArsenicOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_ARSENIC_DEPOSIT.getHolder().get());
        }        
    }
} // end class
