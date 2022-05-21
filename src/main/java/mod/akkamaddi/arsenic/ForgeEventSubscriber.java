package mod.akkamaddi.arsenic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.loot.ArsenicRequiredInjectionLookup;
import mod.akkamaddi.arsenic.worldgen.OreGeneration;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArsenicAndLace.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(ArsenicAndLace.MODID + " Forge Event Subscriber");
    private static ArsenicRequiredInjectionLookup lootLookupMap = new ArsenicRequiredInjectionLookup();
    
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        // add optional lootstuffs if enabled
        if (ArsenicConfig.enableChestLoot)
        {
            lootLookupMap.AddOptionalTables();
        }
        LootUtils.LootLoadHandler(ArsenicAndLace.MODID, event, lootLookupMap);
    } // end LootLoad()

    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        
        if (evt.getCategory() != Biome.BiomeCategory.THEEND && evt.getCategory() != Biome.BiomeCategory.NETHER)
        {
            OreGeneration.generateOverworldOres(evt);
        }
    } // end onBiomeLoading()

} // end class
