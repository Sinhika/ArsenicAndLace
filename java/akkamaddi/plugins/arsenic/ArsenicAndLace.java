package akkamaddi.plugins.arsenic;

import alexndr.api.content.inventory.SimpleTab;
import alexndr.api.core.ContentTypes;
import alexndr.api.core.LogHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
	     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
	     */
	    // public static EnumArmorMaterial armorArsenic = EnumHelper.addArmorMaterial("ARSENIC", 6, new int[] {1, 3, 2, 1}, 10);
		armorArsenideBronze = EnumHelper.addArmorMaterial(
				"ARSENIDEBRONZE", 16, new int[] { 3, 5, 3, 1 }, 9);
		armorArsenideGold = EnumHelper.addArmorMaterial(
				"ARSENIDEGOLD", 12, new int[] { 2, 6, 3, 1 }, 22);
		armorOldLace = EnumHelper.addArmorMaterial("OLDLACE", 4,
				new int[] { 1, 1, 1, 1 }, 24);
		armorTenebrium = EnumHelper.addArmorMaterial("TENEBRIUM",
				52, new int[] { 4, 8, 8, 4 }, 17);

		// set tool properties
		// EnumToolMaterial. In form ("NAME", mining level, max uses, speed,
		// damage to entity, enchantability)
		toolArsenic = EnumHelper.addToolMaterial("ARSENIC", 1, 62,
				2.0F, 2, 10);
		toolArsenideBronze = EnumHelper.addToolMaterial(
				"ARSENIDEBRONZE", 2, 640, 9.5F, 2, 9);
		toolArsenideGold = EnumHelper.addToolMaterial(
				"ARSENIDEGOLD", 1, 56, 12.0F, 2, 20);
		toolTenebrium = EnumHelper.addToolMaterial("TENEBRIUM", 4,
				3820, 9.0F, 3, 17);

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
