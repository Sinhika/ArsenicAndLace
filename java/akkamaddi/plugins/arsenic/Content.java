package akkamaddi.plugins.arsenic;

import akkamaddi.api.core.EnumMobType;
import akkamaddi.api.core.LootHelper;
import akkamaddi.api.core.WerewolfHandler;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Content 
{
	/**
	 * Loads all the Simple Arsenic content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		try {
			doItems();
			LogHelper.verboseInfo(ModInfo.ID,
					"All items were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Items were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doBlocks();
			LogHelper.verboseInfo(ModInfo.ID,
					"All blocks were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Blocks were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doTools();
			LogHelper.verboseInfo(ModInfo.ID,
					"All tools were added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Tools were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doArmor();
			LogHelper.verboseInfo(ModInfo.ID,
					"All armor was added successfully");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Armor was not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		//		try{doAchievements(); LogHelper.verboseInfo(ModInfo.ID, "All achievements were added successfully");}
//			catch(Exception e){LogHelper.severe(ModInfo.ID, "Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	} // end preInitialize()

	public static void doArmor() 
	{
		arsenideBronzeHelm = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze, 0).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeHelm");
		arsenideBronzeChest = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze, 1).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeChest");
		arsenideBronzeLegs = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze, 2).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeLegs");
		arsenideBronzeBoots = new SimpleArmor(
				ArsenicAndLace.armorArsenideBronze, 3).modId("arsenic")
				.setType("arsenideBronze")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeBoots");

		arsenideGoldHelm = new SimpleArmor(ArsenicAndLace.armorArsenideGold, 0).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldHelm");
		arsenideGoldChest = new SimpleArmor(ArsenicAndLace.armorArsenideGold, 1).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldChest");
		arsenideGoldLegs = new SimpleArmor(ArsenicAndLace.armorArsenideGold, 2).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldLegs");
		arsenideGoldBoots = new SimpleArmor(ArsenicAndLace.armorArsenideGold, 3).modId("arsenic")
				.setType("arsenideGold")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldBoots");
		
		oldLaceChest = new SimpleArmor(ArsenicAndLace.armorOldLace, 1).modId("arsenic")
				.setType("oldLace")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("oldLaceChest");

		tenebriumHelm = new SimpleArmor(ArsenicAndLace.armorTenebrium, 0).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumHelm");
		tenebriumChest = new SimpleArmor(ArsenicAndLace.armorTenebrium, 1).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumChest");
		tenebriumLegs = new SimpleArmor(ArsenicAndLace.armorTenebrium, 2).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumLegs");
		tenebriumBoots = new SimpleArmor(ArsenicAndLace.armorTenebrium, 3).modId("arsenic")
				.setType("tenebrium")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumBoots");
        
	} // end doArmor()
	
	public static void doTools() 
	{
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
		
        if (Settings.werewolfEffectiveness)
        {
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldHoe, 
        			ArsenicAndLace.toolArsenideGold.getDamageVsEntity() + 4.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldShovel, 
        			ArsenicAndLace.toolArsenideGold.getDamageVsEntity() + 5.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldPickaxe, 
        			ArsenicAndLace.toolArsenideGold.getDamageVsEntity() + 6.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldAxe, 
        			ArsenicAndLace.toolArsenideGold.getDamageVsEntity() + 7.0F);
        	WerewolfHandler.Damage2Wolf.put(arsenideGoldSword, 
        			ArsenicAndLace.toolArsenideGold.getDamageVsEntity() + 8.0F);
        }
		
	} // end doTools()
	
	public static void doBlocks() 
	{
        // define blocks
		blockArsenic = new SimpleBlock(Material.iron).modId("arsenic").setBeaconBase(true)
				.setHardness(Settings.arsenicHardness).setResistance(Settings.arsenicResistance)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockArsenic").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
		blockArsenideBronze = new SimpleBlock(Material.iron).modId("arsenic").setBeaconBase(true)
				.setHardness(Settings.arsenideBronzeHardness)
				.setResistance(Settings.arsenideBronzeResistance)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockArsenideBronze").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
		blockArsenideGold = new SimpleBlock(Material.iron).modId("arsenic").setBeaconBase(true)
				.setHardness(Settings.arsenideGoldHardness)
				.setResistance(Settings.arsenideGoldResistance)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockArsenideGold").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
		blockTenebrium = new SimpleBlock(Material.iron).modId("arsenic").setBeaconBase(true)
				.setHardness(Settings.tenebriumHardness).setResistance(Settings.tenebriumResistance)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("blockTenebrium").setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
		
        blockArsenic.setHarvestLevel("pickaxe", Settings.arsenicHarvestLevel);
        blockArsenideBronze.setHarvestLevel( "pickaxe", Settings.arsenideBronzeHarvestLevel);
        blockArsenideGold.setHarvestLevel( "pickaxe", Settings.arsenideGoldHarvestLevel);
        plateArsenic.setHarvestLevel( "pickaxe", Settings.arsenicHarvestLevel);
        blockTenebrium.setHarvestLevel( "pickaxe", Settings.tenebriumHarvestLevel);
 
		plateArsenic = new ArsenicPlate("plateArsenic", Material.wood,
				EnumMobType.everything).modId("arsenic").setHardness(0.5F)
				.setStepSound(Block.soundTypeMetal)
				.setBlockName("plateArsenic")
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic);
        
	} // end doBlocks()
	
	public static void doItems()
	{
        // define items
		arsenicIngot = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenicIngot");
		realgarItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("realgarItem");
		orpimentItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("orpimentItem");
		arsenideSaltItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideSaltItem");
		smallArsenicChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenicChunkItem");
		mediumArsenicChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenicChunkItem");
		largeArsenicChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenicChunkItem");
		arsenideBronzeIngot = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideBronzeIngot");
		smallArsenideBronzeChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenideBronzeChunkItem");
		mediumArsenideBronzeChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenideBronzeChunkItem");
		largeArsenideBronzeChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenideBronzeChunkItem");
		arsenideGoldIngot = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("arsenideGoldIngot");
		smallArsenideGoldChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallArsenideGoldChunkItem");
		mediumArsenideGoldChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumArsenideGoldChunkItem");
		largeArsenideGoldChunkItem = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeArsenideGoldChunkItem");
		
		tenebriumIngot = new SimpleItem().modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("tenebriumIngot");
		smallTenebriumChunkItem = new SimpleItem()
				.modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("smallTenebriumChunkItem");
		mediumTenebriumChunkItem = new SimpleItem()
				.modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("mediumTenebriumChunkItem");
		largeTenebriumChunkItem = new SimpleItem()
				.modId("arsenic").isIngot()
				.setCreativeTab(ArsenicAndLace.tabAkkamaddiArsenic)
				.setUnlocalizedName("largeTenebriumChunkItem");
		
		
	} // end doItems()
	
	public static void setLoot() 
	{
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

	} // end setLoot()
	
	
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


} // end class Content
