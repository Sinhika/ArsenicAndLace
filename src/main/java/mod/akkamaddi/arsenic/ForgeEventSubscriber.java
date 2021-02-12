package mod.akkamaddi.arsenic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.loot.ChestLootHandler;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArsenicAndLace.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(ArsenicAndLace.MODID + " Forge Event Subscriber");
    
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) 
            {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                
                if (file.startsWith("stronghold_")) 
                {
                    file = "stronghold";
                }
                switch (file) {
                case "stronghold":
                case "underwater_ruin_small":
                case "underwater_ruin_big":
                    LOGGER.debug("Attempting to inject loot pool for " + "stronghold");
                    event.getTable().addPool(ChestLootHandler.getInjectPool(ArsenicAndLace.MODID, file));
                    break;
                case "desert_pyramid":
                case "jungle_temple":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(ArsenicAndLace.MODID, file));
                    break;
                default:
                    // cases deliberately ignored:
                    // dispensers, because you don't shoot ingots/ores/tools at people.
                    // other villagers
                    // the_end, because no end ores or metals.
                    break;
                } // end-switch
        } // end-if config allows
    } // end LootLoad()
    

} // end class
