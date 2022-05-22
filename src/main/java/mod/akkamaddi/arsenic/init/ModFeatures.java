package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ArsenicAndLace.MODID);
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ARSENIC =
            CONFIGURED_FEATURES.register("ore_arsenic", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.arsenic_ore_stone.get(), 
                                                                    ModBlocks.arsenic_ore_deepslate.get()),
                            ArsenicConfig.arsenic_cfg));
    
    /** PlacedFeature registry */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ArsenicAndLace.MODID);
    
    public static RegistryObject<PlacedFeature> ORE_ARSENIC_DEPOSIT = PLACED_FEATURES.register("ore_arsenic_deposit", 
            ()-> OreGenUtils.createPlacedOreFeature(ORE_ARSENIC.getHolder().get(), ArsenicConfig.arsenic_cfg));

} // end class
