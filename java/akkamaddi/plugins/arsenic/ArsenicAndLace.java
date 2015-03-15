package akkamaddi.plugins.arsenic;

import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.ContentTypes;
import alexndr.api.core.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
// used in 1.6.2

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
dependencies = "required-after:simplecore; required-after:simpleores ; required-after:fusion ; required-after:akkamaddicore")

public class ArsenicAndLace
{
     // set simple items class paths
    //public static SimpleOres.core.Items soItems;
    //public static SimpleOres.core.Armor soArmor;

    // tab
    public static SimpleTab tabAkkamaddiArsenic;

    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    // public static EnumArmorMaterial armorArsenic = EnumHelper.addArmorMaterial("ARSENIC", 6, new int[] {1, 3, 2, 1}, 10);
	public static ArmorMaterial armorArsenideBronze, armorArsenideGold, armorOldLace, 
		armorTenebrium;

    // set tool properties
    // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	public static ToolMaterial toolArsenic, toolArsenideBronze, toolArsenideGold, toolTenebrium; 

     /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {
		// Tab
		LogHelper.info("Loading Simple Arsenic & Old Lace...");
		tabAkkamaddiArsenic = new SimpleTab("tabAkkamaddiArsenic", ContentTypes.CreativeTab.GENERAL);
		
		//Configuration
		Settings.createOrLoadSettings(event);
		
		//Content
		setToolAndArmorStats();
		Content.preInitialize();
		Recipes.preInitialize();
		Content.setLoot();

     } // end preInit()

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
    @EventHandler 
    public void load(FMLInitializationEvent event)
    {
		// run tab icon call
		setTabIcons();
		setRepairMaterials();
		Recipes.initialize();
     }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		LogHelper.info("Simple Arsenic and Old Lace loaded");
    }
    
	/**
	 * Sets the tool and armor stats from the Settings file.
	 */
	private static void setToolAndArmorStats() 
	{
		/**
		 * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply
		 * by pieces for their max damage), new int[] {helmet defense,
		 * chestplate defense, leggings defense, boots defense}, enchantability)
		 */
	    // public static EnumArmorMaterial armorArsenic = EnumHelper.addArmorMaterial("ARSENIC", 6, new int[] {1, 3, 2, 1}, 10);
		armorOldLace = EnumHelper.addArmorMaterial("OLDLACE",
				Settings.oldLaceArmorDurability,
				Settings.oldLaceArmorDamageReduction,
				Settings.oldLaceArmorEnchantability);
		armorArsenideBronze = EnumHelper.addArmorMaterial("ARSENIDEBRONZE",
				Settings.arsenideBronzeArmorDurability,
				Settings.arsenideBronzeArmorDamageReduction,
				Settings.arsenideBronzeArmorEnchantability);
		armorArsenideGold = EnumHelper.addArmorMaterial("ARSENIDEGOLD",
				Settings.arsenideGoldArmorDurability,
				Settings.arsenideGoldArmorDamageReduction,
				Settings.arsenideGoldArmorEnchantability);
		armorTenebrium = EnumHelper.addArmorMaterial("TENEBRIUM",
				Settings.tenebriumArmorDurability,
				Settings.tenebriumArmorDamageReduction,
				Settings.tenebriumArmorEnchantability);

		// set tool properties
		// EnumToolMaterial. In form ("NAME", mining level, max uses, speed,
		// damage to entity, enchantability)
		toolArsenic = EnumHelper.addToolMaterial("ARSENIC",
				Settings.arsenicMiningLevel, Settings.arsenicUsesNum,
				Settings.arsenicMiningSpeed, Settings.arsenicDamageVsEntity,
				Settings.arsenicEnchantability);
		toolArsenideBronze = EnumHelper.addToolMaterial("ARSENIDEBRONZE",
				Settings.arsenideBronzeMiningLevel,
				Settings.arsenideBronzeUsesNum,
				Settings.arsenideBronzeMiningSpeed,
				Settings.arsenideBronzeDamageVsEntity,
				Settings.arsenideBronzeEnchantability);
		toolArsenideGold = EnumHelper.addToolMaterial("ARSENIDEGOLD",
				Settings.arsenideGoldMiningLevel, Settings.arsenideGoldUsesNum,
				Settings.arsenideGoldMiningSpeed,
				Settings.arsenideGoldDamageVsEntity,
				Settings.arsenideGoldEnchantability);
		toolTenebrium = EnumHelper.addToolMaterial("TENEBRIUM",
				Settings.tenebriumMiningLevel, Settings.tenebriumUsesNum,
				Settings.tenebriumMiningSpeed,
				Settings.tenebriumDamageVsEntity,
				Settings.tenebriumEnchantability);
	 } // end ()
	
	/**
	 * Sets repair materials for the tools/armor of that type. ie. Copper Ingot to repair copper tools and armor.
	 */
	private static void setRepairMaterials()
	{
        toolArsenic.setRepairItem(new ItemStack(Content.arsenicIngot));
        toolArsenideBronze.setRepairItem(new ItemStack(Content.arsenideBronzeIngot));
        toolArsenideGold.setRepairItem(new ItemStack(Content.arsenideGoldIngot));
        toolTenebrium.setRepairItem(new ItemStack(Content.tenebriumIngot));
        armorArsenideBronze.customCraftingMaterial = Content.arsenideBronzeIngot;
        armorArsenideGold.customCraftingMaterial = Content.arsenideGoldIngot;
        armorOldLace.customCraftingMaterial = Items.string;
        armorTenebrium.customCraftingMaterial = Content.tenebriumIngot;
 	} // end ()
	
    /**
     * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
     */
    public void setTabIcons()
    {
        tabAkkamaddiArsenic.setIcon(new ItemStack(Content.blockArsenic));
    }

	
} // end class ArsenicAndLace
