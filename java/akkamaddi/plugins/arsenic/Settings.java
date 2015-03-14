package akkamaddi.plugins.arsenic;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import alexndr.api.core.LogHelper;
import akkamaddi.api.core.ASettings;


public class Settings extends ASettings 
{
	/** 
	 * umbrella config loading routine. must be instantiated by child classes.
	 * @param event
	 */
	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		config = GetConfig(event, "akkamaddi", "arsenic.cfg");

		try {
			LogHelper.verboseInfo(ModInfo.ID, "Loading Settings...");
			config.load();
			genericSettings(ModInfo.ID, "Simple Arsenic and Old Lace");
			
			// additional general settings
			werewolfEffectiveness = config
					.getBoolean("Works on MoCreatures lycanthropes",
							Configuration.CATEGORY_GENERAL, true,
					 	"Arsenide Gold affects Mo'Creatures lycanthropes like gold, true or false");

			// Adjustable Ore Spawn Rates
			adjustOreSpawnRates();

			// Armor Stat Modification
			armorStatDefaults();
			if (enableArmorStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Armor Stat Modification enabled!");
				customizeArmorStats();
			} // end-if enableArmorStatModification

			// Block Stat Modification
			blockStatDefaults();
			if (enableBlockStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Block Stat Modification enabled!");
				customizeBlockStats();
			}

			toolStatDefaults();
			if (enableToolStatModification) {
				LogHelper.verboseInfo(ModInfo.ID,
						"Tool Stat Modification enabled!");
				customizeToolStats();
			}
		} // end-try
		catch (Exception e) {
			LogHelper
					.severe(ModInfo.ID,
							"Settings failed to load correctly. The plugin may not function correctly");
		}

		finally {
			config.save();
			LogHelper.verboseInfo(ModInfo.ID, "Settings loaded successfully");
		}
	} // end createOrLoadSettings()
	
	/** 
	 * loads/sets the ore generation variables.
	 */
	public static void adjustOreSpawnRates() {}

	/**
	 * Sets the default armor stats.
	 */
	public static void armorStatDefaults() {}
	
	/**
	 * sets customized armor stats.
	 */
	public static void customizeArmorStats() {}
	
	/**
	 * Sets the default block stats.
	 */
	public static void blockStatDefaults() {}

	/**
	 * sets customized block stats.
	 */
	public static void customizeBlockStats() {}
	
	/**
	 * Sets the default tool stats.
	 */
	public static void toolStatDefaults() {}

	/**
	 * set customized tool stats.
	 */
	public static void customizeToolStats() {}

	public static boolean werewolfEffectiveness;
	
} // end class ASettings
