package mod.akkamaddi.arsenic;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.arsenic.config.ConfigHolder;
import mod.akkamaddi.arsenic.init.ModBlockEntityTypes;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.akkamaddi.arsenic.init.ModMenuTypes;
import mod.akkamaddi.arsenic.init.ModParticleTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArsenicAndLace.MODID)
public class ArsenicAndLace
{
    public static final String MODID = "arsenic";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    
    public ArsenicAndLace()
    {
        LOGGER.debug("Hello from akkamaddi's Arsenic and Lace!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModMenuTypes.CONTAINER_TYPES.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModParticleTypes.PARTICLETYPES.register(modEventBus);

        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
    }

    
} // main class
