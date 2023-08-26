package mod.akkamaddi.arsenic.client;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.client.gui.TaintedFurnaceScreen;
import mod.akkamaddi.arsenic.client.particle.NecroticFlameParticle;
import mod.akkamaddi.arsenic.content.TaintedFurnaceContainerMenu;
import mod.akkamaddi.arsenic.init.ModMenuTypes;
import mod.akkamaddi.arsenic.init.ModParticleTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ArsenicAndLace.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber
{
    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) 
    {
        // Register ContainerType Screens
        event.enqueueWork( () -> {
            MenuScreens.register((MenuType<TaintedFurnaceContainerMenu>) ModMenuTypes.tainted_furnace.get(), TaintedFurnaceScreen::new);
        });
    }

    /**
     * Register our particle factory.
     *
     * Since this is using
     * net.minecraft.client.particle.ParticleEngine.SpriteParticleRegistration, this
     * will need a JSON to reference the particle sprites. This will use the
     * registry name of the particle type itself and be located within the
     * 'particles' directory within assets.
     *
     * Textures referenced in the JSON will be in the 'particle' directory within
     * textures.
     * 
     * @param event an event instance used to register particle factories.
     */
    @SubscribeEvent
    public static void onRegisterParticleFactories(final RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ModParticleTypes.necrotic_flame.get(), 
                       NecroticFlameParticle.NecroticFlameParticleProvider::new);
    }
} // end class
