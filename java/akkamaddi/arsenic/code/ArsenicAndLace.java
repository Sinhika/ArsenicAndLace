package akkamaddi.arsenic.code;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import akkamaddi.akkamaddiCore.api.APIcore;
import akkamaddi.akkamaddiCore.api.CommonProxy;
import akkamaddi.akkamaddiCore.api.WerewolfHandler;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LootHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "arsenic", name = "Simple Arsenic and Old Lace", version = "1.7.10-1.4.3", 
	dependencies = "required-after:simpleores ; required-after:fusionplugin ; required-after:akkamaddicore ; after:MoCreatures")

public class ArsenicAndLace
{
    // The instance of your mod that Forge uses.
    @Instance("SimpleArsenic")
    public static ArsenicAndLace instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "akkamaddi.arsenic.code.ClientProxy", 
    		    serverSide = "akkamaddi.akkamaddiCore.api.CommonProxy")
    public static CommonProxy proxy;

    // set simple items class paths
    //public static SimpleOres.core.Items soItems;
    //public static SimpleOres.core.Armor soArmor;

    // set actual item names
    public static Item arsenicIngot;
    public static Item realgarItem;
    public static Item orpimentItem;
    public static Item arsenideSaltItem;
    public static Item smallArsenicChunkItem;
    public static Item mediumArsenicChunkItem;
    public static Item largeArsenicChunkItem;
    public static Item arsenideBronzeIngot;
    public static Item smallArsenideBronzeChunkItem;
    public static Item mediumArsenideBronzeChunkItem;
    public static Item largeArsenideBronzeChunkItem;
    public static Item arsenideGoldIngot;
    public static Item smallArsenideGoldChunkItem;
    public static Item mediumArsenideGoldChunkItem;
    public static Item largeArsenideGoldChunkItem;

    public static Item arsenicSword;
    public static Item arsenicShovel;
    public static Item arsenicAxe;
    public static Item arsenicPickaxe;
    public static Item arsenicHoe;

    public static Item arsenideBronzeSword;
    public static Item arsenideBronzeShovel;
    public static Item arsenideBronzeAxe;
    public static Item arsenideBronzePickaxe;
    public static Item arsenideBronzeHoe;

    public static Item arsenideBronzeHelm;
    public static Item arsenideBronzeChest;
    public static Item arsenideBronzeLegs;
    public static Item arsenideBronzeBoots;

    public static Item arsenideGoldSword;
    public static Item arsenideGoldShovel;
    public static Item arsenideGoldAxe;
    public static Item arsenideGoldPickaxe;
    public static Item arsenideGoldHoe;

    public static Item arsenideGoldHelm;
    public static Item arsenideGoldChest;
    public static Item arsenideGoldLegs;
    public static Item arsenideGoldBoots;

    public static Item oldLaceChest;

    public static Item tenebriumIngot;
    public static Item smallTenebriumChunkItem;
    public static Item mediumTenebriumChunkItem;
    public static Item largeTenebriumChunkItem;

    public static Item tenebriumSword;
    public static Item tenebriumShovel;
    public static Item tenebriumAxe;
    public static Item tenebriumPickaxe;
    public static Item tenebriumHoe;

    public static Item tenebriumHelm;
    public static Item tenebriumChest;
    public static Item tenebriumLegs;
    public static Item tenebriumBoots;

    // set block names
    public static Block blockArsenic;
    public static Block blockArsenideBronze;
    public static Block blockArsenideGold;
    public static Block plateArsenic;
    public static Block blockTenebrium;

    // booleans
    public static boolean werewolfEffectiveness;
    public static boolean enableRecycling;
    public static boolean itemizeMobs;

    // tab
    public static SimpleTab tabAkkamaddiArsenic = new SimpleTab("tabAkkamaddiArsenic");

    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    // public static EnumArmorMaterial armorArsenic = EnumHelper.addArmorMaterial("ARSENIC", 6, new int[] {1, 3, 2, 1}, 10);
	public static ArmorMaterial armorArsenideBronze = EnumHelper
			.addArmorMaterial("ARSENIDEBRONZE", 16, new int[] { 3, 5, 3, 1 }, 9);
	public static ArmorMaterial armorArsenideGold = EnumHelper
			.addArmorMaterial("ARSENIDEGOLD", 12, new int[] { 2, 6, 3, 1 }, 22);
	public static ArmorMaterial armorOldLace = EnumHelper.addArmorMaterial(
			"OLDLACE", 4, new int[] { 1, 1, 1, 1 }, 24);
	public static ArmorMaterial armorTenebrium = EnumHelper.addArmorMaterial(
			"TENEBRIUM", 52, new int[] { 4, 8, 8, 4 }, 17);

    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
    // public static int rendererArsenic;
    public static int rendererArsenideBronze = 0;
    public static int rendererArsenideGold = 0;
    public static int rendererOldLace = 0;
    public static int rendererTenebrium = 0;

    // set tool properties
    // EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	public static ToolMaterial toolArsenic = EnumHelper.addToolMaterial(
			"ARSENIC", 1, 62, 2.0F, 2, 10);
	public static ToolMaterial toolArsenideBronze = EnumHelper.addToolMaterial(
			"ARSENIDEBRONZE", 2, 640, 9.5F, 2, 9);
	public static ToolMaterial toolArsenideGold = EnumHelper.addToolMaterial(
			"ARSENIDEGOLD", 1, 56, 12.0F, 2, 20);
	public static ToolMaterial toolTenebrium = EnumHelper.addToolMaterial(
			"TENEBRIUM", 4, 3820, 9.0F, 3, 17);

    // Tab
    public void setTabIcons()
    {
        /**
         * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
         */
        tabAkkamaddiArsenic.setIcon(new ItemStack(ArsenicAndLace.blockArsenic));
    }

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "akkamaddi");
	    File configFile = new File(configDir, "arsenic.cfg");
	    Configuration config = new Configuration(configFile);
        config.load();
		werewolfEffectiveness = config.get(Configuration.CATEGORY_GENERAL,
				"Works on Mo'Creatures lycanthropes, true or false", true)
				.getBoolean(true);
		enableRecycling = config.get(Configuration.CATEGORY_GENERAL,
				"Enable arsenide recycling recipes, false or true", false)
				.getBoolean(false);
		itemizeMobs = config.get( Configuration.CATEGORY_GENERAL, 
				"Equip mobs with Arsenic gear, false or true",false).getBoolean(false);
	    config.save();
        
        // define items
		arsenicIngot = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicIngot");
		realgarItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("realgarItem");
		orpimentItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("orpimentItem");
		arsenideSaltItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideSaltItem");
		smallArsenicChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenicChunkItem");
		mediumArsenicChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenicChunkItem");
		largeArsenicChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenicChunkItem");
		arsenideBronzeIngot = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeIngot");
		smallArsenideBronzeChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenideBronzeChunkItem");
		mediumArsenideBronzeChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenideBronzeChunkItem");
		largeArsenideBronzeChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenideBronzeChunkItem");
		arsenideGoldIngot = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldIngot");
		smallArsenideGoldChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenideGoldChunkItem");
		mediumArsenideGoldChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenideGoldChunkItem");
		largeArsenideGoldChunkItem = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenideGoldChunkItem");
		
		arsenicSword = new ArsenicSwords(ArsenicAndLace.toolArsenic)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicSword");
		arsenicShovel = new SimpleShovel(ArsenicAndLace.toolArsenic)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicShovel");
		arsenicAxe = new SimpleAxe(ArsenicAndLace.toolArsenic).modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicAxe");
		arsenicPickaxe = new SimplePickaxe(ArsenicAndLace.toolArsenic)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicPickaxe");
		arsenicHoe = new SimpleHoe(ArsenicAndLace.toolArsenic).modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicHoe");
		arsenideBronzeSword = new ArsenicSwords(
				ArsenicAndLace.toolArsenideBronze).modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeSword");
		arsenideBronzeShovel = new SimpleShovel(
				ArsenicAndLace.toolArsenideBronze).modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeShovel");
		arsenideBronzeAxe = new SimpleAxe(ArsenicAndLace.toolArsenideBronze)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeAxe");
		arsenideBronzePickaxe = new SimplePickaxe(
				ArsenicAndLace.toolArsenideBronze).modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzePickaxe");
		arsenideBronzeHoe = new SimpleHoe(ArsenicAndLace.toolArsenideBronze)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeHoe");
		
		arsenideBronzeHelm = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze,
				ArsenicAndLace.rendererArsenideBronze, 0).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeHelm");
		arsenideBronzeChest = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze,
				ArsenicAndLace.rendererArsenideBronze, 1).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeChest");
		arsenideBronzeLegs = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze,
				ArsenicAndLace.rendererArsenideBronze, 2).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeLegs");
		arsenideBronzeBoots = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze,
				ArsenicAndLace.rendererArsenideBronze, 3).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeBoots");

		arsenideGoldSword = new ArsenicSwords(ArsenicAndLace.toolArsenideGold)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldSword");
		arsenideGoldShovel = new SimpleShovel(ArsenicAndLace.toolArsenideGold)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldShovel");
		arsenideGoldAxe = new SimpleAxe(ArsenicAndLace.toolArsenideGold)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldAxe");
		arsenideGoldPickaxe = new SimplePickaxe(ArsenicAndLace.toolArsenideGold)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldPickaxe");
		arsenideGoldHoe = new SimpleHoe(ArsenicAndLace.toolArsenideGold)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldHoe");
		arsenideGoldHelm = new SimpleArmor(ArsenicAndLace.armorArsenideGold,
				ArsenicAndLace.rendererArsenideGold, 0).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldHelm");
		arsenideGoldChest = new SimpleArmor(ArsenicAndLace.armorArsenideGold,
				ArsenicAndLace.rendererArsenideGold, 1).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldChest");
		arsenideGoldLegs = new SimpleArmor(ArsenicAndLace.armorArsenideGold,
				ArsenicAndLace.rendererArsenideGold, 2).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldLegs");
		arsenideGoldBoots = new SimpleArmor(ArsenicAndLace.armorArsenideGold,
				ArsenicAndLace.rendererArsenideGold, 3).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldBoots");
		oldLaceChest = new SimpleArmor(ArsenicAndLace.armorOldLace,
				ArsenicAndLace.rendererOldLace, 1).modId("arsenic")
				.setType("oldLace")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("oldLaceChest");
		
		tenebriumIngot = new SimpleIngot().modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumIngot");
		smallTenebriumChunkItem = new SimpleIngot()
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallTenebriumChunkItem");
		mediumTenebriumChunkItem = new SimpleIngot()
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumTenebriumChunkItem");
		largeTenebriumChunkItem = new SimpleIngot()
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeTenebriumChunkItem");
		
		tenebriumSword = new SimpleSword(ArsenicAndLace.toolTenebrium)
				.modId("arsenic").modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumSword");
		tenebriumShovel = new SimpleShovel(ArsenicAndLace.toolTenebrium)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumShovel");
		tenebriumAxe = new SimpleAxe(ArsenicAndLace.toolTenebrium)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumAxe");
		tenebriumPickaxe = new SimplePickaxe(ArsenicAndLace.toolTenebrium)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumPickaxe");
		tenebriumHoe = new SimpleHoe(ArsenicAndLace.toolTenebrium)
				.modId("arsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumHoe");
		tenebriumHelm = new SimpleArmor(ArsenicAndLace.armorTenebrium,
				ArsenicAndLace.rendererTenebrium, 0).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumHelm");
		tenebriumChest = new SimpleArmor(ArsenicAndLace.armorTenebrium,
				ArsenicAndLace.rendererTenebrium, 1).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumChest");
		tenebriumLegs = new SimpleArmor(ArsenicAndLace.armorTenebrium,
				ArsenicAndLace.rendererTenebrium, 2).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumLegs");
		tenebriumBoots = new SimpleArmor(ArsenicAndLace.armorTenebrium,
				ArsenicAndLace.rendererTenebrium, 3).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumBoots");
        
        // define blocks
        blockArsenic = new SimpleBlock(Material.iron).modId("arsenic")
        .setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal)
        .setBlockName("blockArsenic").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        blockArsenideBronze = new SimpleBlock(Material.iron).modId("arsenic")
        .setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundTypeMetal)
        .setBlockName("blockArsenideBronze").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        blockArsenideGold = new SimpleBlock(Material.iron).modId("arsenic")
        .setHardness(4.0F).setResistance(16.0F).setStepSound(Block.soundTypeMetal)
        .setBlockName("blockArsenideGold").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        blockTenebrium = new SimpleBlock(Material.iron).modId("arsenic")
        .setHardness(12.0F).setResistance(55.0F).setStepSound(Block.soundTypeMetal)
        .setBlockName("blockTenebrium").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        
		plateArsenic = new ArsenicPlate("plateArsenic", Material.wood,
				EnumMobType.everything).setHardness(0.5F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("plateArsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        
        //registration
        GameRegistry.registerBlock(plateArsenic, "plateArsenic");
        
        blockArsenic.setHarvestLevel("pickaxe", 0);
        blockArsenideBronze.setHarvestLevel( "pickaxe", 0);
        blockArsenideGold.setHarvestLevel( "pickaxe", 0);
        plateArsenic.setHarvestLevel( "pickaxe", 0);
        blockTenebrium.setHarvestLevel( "pickaxe", 0);
        
        toolArsenic.customCraftingMaterial = ArsenicAndLace.arsenicIngot;
        toolArsenideBronze.customCraftingMaterial = ArsenicAndLace.arsenideBronzeIngot;
        toolArsenideGold.customCraftingMaterial = ArsenicAndLace.arsenideGoldIngot;
        toolTenebrium.customCraftingMaterial = ArsenicAndLace.tenebriumIngot;
        armorArsenideBronze.customCraftingMaterial = ArsenicAndLace.arsenideBronzeIngot;
        armorArsenideGold.customCraftingMaterial = ArsenicAndLace.arsenideGoldIngot;
        armorOldLace.customCraftingMaterial = Items.string;
        armorTenebrium.customCraftingMaterial = ArsenicAndLace.tenebriumIngot;
        
        //Loot
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenicIngot), 1, 2, 2);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideBronzeIngot), 1, 2, 5);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideGoldIngot), 1, 2, 4);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenicSword), 1, 2, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideBronzeSword), 2, 6, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideGoldSword), 2, 4, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenicPickaxe), 1, 2, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideBronzePickaxe), 2, 6, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideGoldPickaxe), 2, 4, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenicAxe), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideBronzeAxe), 1, 5, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideGoldAxe), 1, 2, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenicShovel), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideBronzeShovel), 1, 2, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(arsenideGoldShovel), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(tenebriumPickaxe), 1, 1, 1);
        LootHelper.addLoot("villageBlacksmith", new ItemStack(tenebriumShovel), 1, 1, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenicIngot), 1, 2, 4);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideBronzeIngot), 1, 2, 5);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideGoldIngot), 1, 2, 4);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenicSword), 3, 5, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideBronzeSword), 2, 6, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideGoldSword), 2, 4, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenicPickaxe), 1, 1, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideBronzePickaxe), 1, 3, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(arsenideGoldPickaxe), 1, 2, 1);
        LootHelper.addLoot("dungeonChest", new ItemStack(oldLaceChest), 4, 8, 4);
        LootHelper.addLoot("strongholdCorridor", new ItemStack(arsenicIngot), 1, 1, 1);
        LootHelper.addLoot("strongholdCorridor", new ItemStack(arsenideBronzeIngot), 1, 1, 2);
        LootHelper.addLoot("strongholdCorridor", new ItemStack(arsenideGoldIngot), 1, 1, 2);
        LootHelper.addLoot("strongholdCrossing", new ItemStack(arsenicIngot), 1, 1, 4);
        LootHelper.addLoot("strongholdCrossing", new ItemStack(arsenideBronzeIngot), 1, 1, 6);
        LootHelper.addLoot("strongholdCrossing", new ItemStack(arsenideGoldIngot), 1, 1, 5);
        LootHelper.addLoot("strongholdLibrary", new ItemStack(oldLaceChest), 1, 1, 2);
        LootHelper.addLoot("strongholdLibrary", new ItemStack(tenebriumHelm), 1, 1, 1);
        LootHelper.addLoot("strongholdLibrary", new ItemStack(tenebriumChest), 1, 1, 1);
        LootHelper.addLoot("strongholdLibrary", new ItemStack(tenebriumLegs), 1, 1, 1);
        LootHelper.addLoot("strongholdLibrary", new ItemStack(tenebriumBoots), 1, 1, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(oldLaceChest), 1, 2, 2);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideBronzeSword), 1, 1, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideGoldSword), 1, 3, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenicPickaxe), 1, 1, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideBronzePickaxe), 1, 3, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideGoldPickaxe), 1, 2, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenicShovel), 1, 1, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideBronzeShovel), 1, 3, 1);
        LootHelper.addLoot("mineshaftCorridor", new ItemStack(arsenideGoldShovel), 1, 2, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(oldLaceChest), 3, 9, 3);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenicShovel), 1, 2, 2);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(tenebriumSword), 1, 2, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(tenebriumShovel), 1, 1, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenideGoldHelm), 1, 3, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenideGoldChest), 1, 3, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenideGoldLegs), 1, 3, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenideGoldBoots), 1, 3, 1);
        LootHelper.addLoot("pyramidDesertyChest", new ItemStack(arsenideGoldSword), 2, 4, 1);
        LootHelper.addLoot("pyramidJungleChest", new ItemStack(arsenideSaltItem), 2, 4, 6);
        LootHelper.addLoot("pyramidJungleChest", new ItemStack(oldLaceChest), 1, 1, 2);
        LootHelper.addLoot("pyramidJungleChest", new ItemStack(tenebriumSword), 1, 2, 1);
        LootHelper.addLoot("pyramidJungleChest", new ItemStack(arsenicSword), 3, 5, 2);

        if (ArsenicAndLace.werewolfEffectiveness)
        {
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldHoe, 6.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldShovel, 7.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldPickaxe, 8.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldAxe, 9.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldSword, 10.0F);
        }
        
        // run tab icon call
        setTabIcons();
        // recipes
        ArsenicRecipes.doArsenicRecipes();
        
        if (itemizeMobs) {
        	APIcore.instance.joinWorldModRegistry.add(new JoinWorldHandler());
        }
    } // end preInit()

    /**
     * Do your mod setup. Build whatever data structures you care about. 
     */
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
     }

    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event)
    {
        // Stub Method
    }
} // end class ArsenicAndLace
