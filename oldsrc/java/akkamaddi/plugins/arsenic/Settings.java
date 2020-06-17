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
	public static void customizeArmorStats() 
	{
		oldLaceArmorDurability = config.getInt("Old Lace Shroud Durability",
				"Armor Stat Modification", oldLaceArmorDurability, 0, 255,
				"Controls the durability of Old Lace Armor.");
		oldLaceArmorDamageReduction = config.get("Armor Stat Modification",
				"Old Lace Shroud Damage Reduction Array",
				oldLaceArmorDamageReduction).getIntList();
		oldLaceArmorEnchantability = config.getInt(
				"Old Lace Shroud Enchantability", "Armor Stat Modification", 
				oldLaceArmorEnchantability,
				0, 255, "Controls the enchantability of Old Lace Shroud.");
		
		arsenideBronzeArmorDurability = config.getInt("Arsenide Bronze Armor Durability",
				"Armor Stat Modification", arsenideBronzeArmorDurability, 0, 255,
				"Controls the durability of Arsenide Bronze Armor.");
		arsenideBronzeArmorDamageReduction = config.get("Armor Stat Modification",
				"Arsenide Bronze Armor Damage Reduction Array",
				arsenideBronzeArmorDamageReduction).getIntList();
		arsenideBronzeArmorEnchantability = config.getInt(
				"Arsenide Bronze Armor Enchantability", "Armor Stat Modification", 
				arsenideBronzeArmorEnchantability,
				0, 255, "Controls the enchantability of Arsenide Bronze Armor.");

		arsenideGoldArmorDurability = config.getInt("Arsenide Gold Armor Durability",
				"Armor Stat Modification", arsenideGoldArmorDurability, 0, 255,
				"Controls the durability of Arsenide Gold Armor.");
		arsenideGoldArmorDamageReduction = config.get("Armor Stat Modification",
				"Arsenide Gold Armor Damage Reduction Array",
				arsenideGoldArmorDamageReduction).getIntList();
		arsenideGoldArmorEnchantability = config.getInt(
				"Arsenide Gold Armor Enchantability", "Armor Stat Modification", 
				arsenideGoldArmorEnchantability,
				0, 255, "Controls the enchantability of Arsenide Gold Armor.");

		tenebriumArmorDurability = config.getInt("Tenebrium Armor Durability",
				"Armor Stat Modification", tenebriumArmorDurability, 0, 255,
				"Controls the durability of Tenebrium Armor.");
		tenebriumArmorDamageReduction = config.get("Armor Stat Modification",
				"Tenebrium Armor Damage Reduction Array",
				tenebriumArmorDamageReduction).getIntList();
		tenebriumArmorEnchantability = config.getInt(
				"Tenebrium Armor Enchantability", "Armor Stat Modification", 
				tenebriumArmorEnchantability,
				0, 255, "Controls the enchantability of Tenebrium Armor.");

	} // end customizeArmorStats
	
	/**
	 * Sets the default block stats.
	 */
	public static void blockStatDefaults() 
	{
		arsenicHardness = 3.0F;
		arsenicResistance = 10.0F;
		arsenicHarvestLevel = 0;
		arsenideBronzeHardness = 5.0F;
		arsenideBronzeResistance = 20.0F;
		arsenideBronzeHarvestLevel = 0;
		arsenideGoldHardness = 4.0F;
		arsenideGoldResistance = 16.0F;
		arsenideGoldHarvestLevel = 0;
		tenebriumHardness = 12.0F;
		tenebriumResistance = 55.0F;
		tenebriumHarvestLevel = 0;
		
	} // end blockStatDefaults

	/**
	 * sets customized block stats.
	 */
	public static void customizeBlockStats() 
	{
		arsenicHardness = config.getFloat("Arsenic Hardness",
				"Block Stat Modification", arsenicHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		arsenicResistance = config.getFloat("Arsenic Resistance",
				"Block Stat Modification", arsenicResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		arsenicHarvestLevel = config.getInt("Arsenic Harvest Level",
				"Block Stat Modification", arsenicHarvestLevel, 0, 255,
				"Tool level required to harvest this block");
		
		arsenideBronzeHardness = config.getFloat("Arsenide Bronze Hardness",
				"Block Stat Modification", arsenideBronzeHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		arsenideBronzeResistance = config.getFloat("Arsenide Bronze Resistance",
				"Block Stat Modification", arsenideBronzeResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		arsenideBronzeHarvestLevel = config.getInt("Arsenide Bronze Harvest Level",
				"Block Stat Modification", arsenideBronzeHarvestLevel, 0, 255,
				"Tool level required to harvest this block");

		arsenideGoldHardness = config.getFloat("Arsenide Gold Hardness",
				"Block Stat Modification", arsenideGoldHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		arsenideGoldResistance = config.getFloat("Arsenide Gold Resistance",
				"Block Stat Modification", arsenideGoldResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		arsenideGoldHarvestLevel = config.getInt("Arsenide Gold Harvest Level",
				"Block Stat Modification", arsenideGoldHarvestLevel, 0, 255,
				"Tool level required to harvest this block");

		tenebriumHardness = config.getFloat("Tenebrium Hardness",
				"Block Stat Modification", tenebriumHardness, 0.0F, 32000.0F,
				"How many hits to break a block");
		tenebriumResistance = config.getFloat("Tenebrium Resistance",
				"Block Stat Modification", tenebriumResistance, 0.0F, 32000.0F,
				"Explosion Resistance");
		tenebriumHarvestLevel = config.getInt("Tenebrium Harvest Level",
				"Block Stat Modification", tenebriumHarvestLevel, 0, 255,
				"Tool level required to harvest this block");
} // end customizeBlockStats
	
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
	public static void customizeToolStats() 
	{
		arsenicMiningLevel = config
				.getInt("Arsenic Mining Level",
						"Tool Stat Modification",
						arsenicMiningLevel,
						0,
						255,
						"Controls the mining level of Arsenic Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		arsenicUsesNum = config.getInt("Arsenic Tools Durability",
				"Tool Stat Modification", arsenicUsesNum, 0, 32000,
				"Controls the number of uses Arsenic Tools have.");
		arsenicMiningSpeed = config
				.getFloat("Arsenic Mining Speed", "Tool Stat Modification",
						arsenicMiningSpeed, 0, 32000,
						"Controls the speed at which Arsenic Tools harvest their appropriate blocks.");
		arsenicDamageVsEntity = config
				.getFloat("Arsenic Damage Vs. Entities",
						"Tool Stat Modification", arsenicDamageVsEntity, 0,
						32000,
						"Controls the amount of damage that Arsenic Tools will do to entities.");
		arsenicEnchantability = config.getInt("Arsenic Tools Enchantability",
				"Tool Stat Modification", arsenicEnchantability, 0, 32000,
				"Controls the enchantability of Arsenic Tools.");
		
		arsenideBronzeMiningLevel = config
				.getInt("Arsenide Bronze Mining Level",
						"Tool Stat Modification",
						arsenideBronzeMiningLevel,
						0,
						255,
						"Controls the mining level of Arsenide Bronze Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		arsenideBronzeUsesNum = config.getInt("Arsenide Bronze Tools Durability",
				"Tool Stat Modification", arsenideBronzeUsesNum, 0, 32000,
				"Controls the number of uses Arsenide Bronze Tools have.");
		arsenideBronzeMiningSpeed = config
				.getFloat("Arsenide Bronze Mining Speed", "Tool Stat Modification",
						arsenideBronzeMiningSpeed, 0, 32000,
						"Controls the speed at which Arsenide Bronze Tools harvest their appropriate blocks.");
		arsenideBronzeDamageVsEntity = config
				.getFloat("Arsenide Bronze Damage Vs. Entities",
						"Tool Stat Modification", arsenideBronzeDamageVsEntity, 0, 32000,
						"Controls the amount of damage that Arsenide Bronze Tools will do to entities.");
		arsenideBronzeEnchantability = config.getInt("Arsenide Bronze Tools Enchantability",
				"Tool Stat Modification", arsenideBronzeEnchantability, 0, 32000,
				"Controls the enchantability of Arsenide Bronze Tools.");

		arsenideGoldMiningLevel = config
				.getInt("Arsenide Gold Mining Level",
						"Tool Stat Modification",
						arsenideGoldMiningLevel,
						0,
						255,
						"Controls the mining level of Arsenide Gold Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		arsenideGoldUsesNum = config.getInt("Arsenide Gold Tools Durability",
				"Tool Stat Modification", arsenideGoldUsesNum, 0, 32000,
				"Controls the number of uses Arsenide Gold Tools have.");
		arsenideGoldMiningSpeed = config
				.getFloat("Arsenide Gold Mining Speed", "Tool Stat Modification",
						arsenideGoldMiningSpeed, 0, 32000,
						"Controls the speed at which Arsenide Gold Tools harvest their appropriate blocks.");
		arsenideGoldDamageVsEntity = config
				.getFloat("Arsenide Gold Damage Vs. Entities",
						"Tool Stat Modification", arsenideGoldDamageVsEntity, 0, 32000,
						"Controls the amount of damage that Arsenide Gold Tools will do to entities.");
		arsenideGoldEnchantability = config.getInt("Arsenide Gold Tools Enchantability",
				"Tool Stat Modification", arsenideGoldEnchantability, 0, 32000,
				"Controls the enchantability of Arsenide Gold Tools.");

		tenebriumMiningLevel = config
				.getInt("Tenebrium Mining Level",
						"Tool Stat Modification",
						tenebriumMiningLevel,
						0,
						255,
						"Controls the mining level of Tenebrium Tools. 0 = wood, 1 = stone, 2 = iron, 3 = diamond.");
		tenebriumUsesNum = config.getInt("Tenebrium Tools Durability",
				"Tool Stat Modification", tenebriumUsesNum, 0, 32000,
				"Controls the number of uses Tenebrium Tools have.");
		tenebriumMiningSpeed = config
				.getFloat("Tenebrium Mining Speed", "Tool Stat Modification",
						tenebriumMiningSpeed, 0, 32000,
						"Controls the speed at which Tenebrium Tools harvest their appropriate blocks.");
		tenebriumDamageVsEntity = config
				.getFloat("Tenebrium Damage Vs. Entities",
						"Tool Stat Modification", tenebriumDamageVsEntity, 0, 32000,
						"Controls the amount of damage that Tenebrium Tools will do to entities.");
		tenebriumEnchantability = config.getInt("Tenebrium Tools Enchantability",
				"Tool Stat Modification", tenebriumEnchantability, 0, 32000,
				"Controls the enchantability of Tenebrium Tools.");

	} // end customizeToolStats

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
