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
	public static void armorStatDefaults() 
	{
		oldLaceArmorDurability = 4;
		oldLaceArmorDamageReduction = new int[] { 1, 1, 1, 1 };
		oldLaceArmorEnchantability = 24;
		arsenideBronzeArmorDurability = 16;
		arsenideBronzeArmorDamageReduction = new int[] { 3, 5, 3, 1 };
		arsenideBronzeArmorEnchantability = 9;
		arsenideGoldArmorDurability = 12;
		arsenideGoldArmorDamageReduction = new int[] { 2, 6, 3, 1 };
		arsenideGoldArmorEnchantability = 22;
		tenebriumArmorDurability = 52;
		tenebriumArmorDamageReduction = new int[] { 4, 8, 8, 4 };
		tenebriumArmorEnchantability = 17;
	} // end armorStatDefaults
	
	/**
	 * sets customized armor stats.
	 */
	public static void customizeArmorStats() {}
	
	/**
	 * Sets the default block stats.
	 */
	public static void blockStatDefaults() 
	{
		arsenicHardness = ;
		arsenicResistance = ;
		arsenicHarvestLevel = ;
		arsenideBronzeHardness = ;
		arsenideBronzeResistance = ;
		arsenideBronzeHarvestLevel = ;
		arsenideGoldHardness = ;
		arsenideGoldResistance = ;
		arsenideGoldHarvestLevel = ;
		tenebriumHardness = ;
		tenebriumResistance = ;
		tenebriumHarvestLevel = ;
		
	} // end blockStatDefaults

	/**
	 * sets customized block stats.
	 */
	public static void customizeBlockStats() {}
	
	/**
	 * Sets the default tool stats.
	 */
	public static void toolStatDefaults() 
	{
		arsenicMiningLevel = 1;
		arsenicUsesNum = 62;
		arsenicMiningSpeed = 2.0F;
		arsenicDamageVsEntity = 2;
		arsenicEnchantability = 10;
		arsenideBronzeMiningLevel = 2;
		arsenideBronzeUsesNum = 640;
		arsenideBronzeMiningSpeed = 9.5F;
		arsenideBronzeDamageVsEntity = 2;
		arsenideBronzeEnchantability =  9;
		arsenideGoldMiningLevel = 1;
		arsenideGoldUsesNum = 56;
		arsenideGoldMiningSpeed = 12.0F;
		arsenideGoldDamageVsEntity = 2; 
		arsenideGoldEnchantability = 20;
		tenebriumMiningLevel = 4;
		tenebriumUsesNum = 3820;
		tenebriumMiningSpeed = 9.0F;
		tenebriumDamageVsEntity = 3;
		tenebriumEnchantability = 17;
	} // end toolStatDefaults

	/**
	 * set customized tool stats.
	 */
	public static void customizeToolStats() {}

	// general toggles
	public static boolean werewolfEffectiveness;
	
	// Tool Stats
	public static int arsenicMiningLevel, arsenideBronzeMiningLevel,
			arsenideGoldMiningLevel, tenebriumMiningLevel;
	public static int arsenicUsesNum, arsenideBronzeUsesNum,
			arsenideGoldUsesNum, tenebriumUsesNum;
	public static float arsenicMiningSpeed, arsenideBronzeMiningSpeed,
			arsenideGoldMiningSpeed, tenebriumMiningSpeed;
	public static float arsenicDamageVsEntity, arsenideBronzeDamageVsEntity,
			arsenideGoldDamageVsEntity, tenebriumDamageVsEntity;
	public static int arsenicEnchantability, arsenideBronzeEnchantability,
			arsenideGoldEnchantability, tenebriumEnchantability;

	// Armor Stats
	public static int oldLaceArmorDurability, arsenideBronzeArmorDurability,
			arsenideGoldArmorDurability, tenebriumArmorDurability;
	public static int[] oldLaceArmorDamageReduction,
			arsenideBronzeArmorDamageReduction,
			arsenideGoldArmorDamageReduction, tenebriumArmorDamageReduction;
	public static int oldLaceArmorEnchantability,
			arsenideBronzeArmorEnchantability, arsenideGoldArmorEnchantability,
			tenebriumArmorEnchantability;

	// Block stats
	public static float arsenicHardness, arsenideBronzeHardness,
			arsenideGoldHardness, tenebriumHardness;
	public static float arsenicResistance, arsenideBronzeResistance,
			arsenideGoldResistance, tenebriumResistance;
	public static int arsenicHarvestLevel, arsenideBronzeHarvestLevel,
			arsenideGoldHarvestLevel, tenebriumHarvestLevel;

	
} // end class ASettings
