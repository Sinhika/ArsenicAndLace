package akkamaddi.plugins.arsenic;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.api.core.LogHelper;
import alexndr.plugins.Fusion.FusionFurnaceRecipes;
import alexndr.plugins.Fusion.FusionMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
//	public static alexndr.SimpleOres.api.helpers.CoreHelper soItems;
	
	public static void preInitialize()
	{
		try {
			addOreDictEntries();
			LogHelper.verboseInfo(ModInfo.ID,
					"All OreDictionary entries were added successfully.");
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
			 "OreDictionary entries were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()
	
	public static void initialize()
	{
		try {
			addRecipes();
			LogHelper.verboseInfo(ModInfo.ID,
					"All recipes were added successfully.");
		} catch (Exception e) {
			LogHelper.severe(ModInfo.ID,
							"Recipes were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end initialize()
	
	public static void addOreDictEntries()
	{
		// Forge ore dictionary recipes
		OreDictionary.registerOre("ingotArsenic", new ItemStack(
				Content.arsenicIngot));
		OreDictionary.registerOre("ingotArsenideBronze", new ItemStack(
				Content.arsenideBronzeIngot));
		OreDictionary.registerOre("ingotArsenideGold", new ItemStack(
				Content.arsenideGoldIngot));
		OreDictionary.registerOre("ingotTenebrium", new ItemStack(
				Content.tenebriumIngot));
		
	} // end ()
	
	@SuppressWarnings("unchecked")
	public static void addRecipes() 
	{
		// recipes: Crafting
		// Storage Blocks
		GameRegistry.addRecipe(new ItemStack(Content.blockArsenic, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						Content.arsenicIngot });
		GameRegistry.addRecipe(new ItemStack(
				Content.blockArsenideBronze, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', Content.arsenideBronzeIngot });
		GameRegistry.addRecipe(new ItemStack(Content.blockArsenideGold,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				Content.arsenideGoldIngot });
		GameRegistry.addRecipe(new ItemStack(Content.blockTenebrium, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						Content.tenebriumIngot });
		// Item Recipes
		// Ingot Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.arsenicIngot, 9),
				new Object[] { Content.blockArsenic });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.arsenideBronzeIngot, 9),
				new Object[] { Content.blockArsenideBronze });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.arsenideGoldIngot, 9),
				new Object[] { Content.blockArsenideGold });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.tenebriumIngot, 9),
				new Object[] { Content.blockTenebrium });
		// Arsenic chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenicChunkItem, 1), new Object[] {
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenicChunkItem, 1), new Object[] {
				Content.mediumArsenicChunkItem,
				Content.mediumArsenicChunkItem,
				Content.mediumArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenicChunkItem, 1), new Object[] {
				Content.mediumArsenicChunkItem,
				Content.mediumArsenicChunkItem,
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenicChunkItem, 1), new Object[] {
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem,
				Content.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenicChunkItem, 2),
				new Object[] { Content.largeArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.smallArsenicChunkItem, 2),
				new Object[] { Content.mediumArsenicChunkItem });
		// Red Bronze chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideBronzeChunkItem, 1), new Object[] {
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideBronzeChunkItem, 1), new Object[] {
				Content.mediumArsenideBronzeChunkItem,
				Content.mediumArsenideBronzeChunkItem,
				Content.mediumArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideBronzeChunkItem, 1), new Object[] {
				Content.mediumArsenideBronzeChunkItem,
				Content.mediumArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenideBronzeChunkItem, 1), new Object[] {
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem,
				Content.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenideBronzeChunkItem, 2),
				new Object[] { Content.largeArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.smallArsenideBronzeChunkItem, 2),
				new Object[] { Content.mediumArsenideBronzeChunkItem });
		// Red Gold chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideGoldChunkItem, 1), new Object[] {
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideGoldChunkItem, 1), new Object[] {
				Content.mediumArsenideGoldChunkItem,
				Content.mediumArsenideGoldChunkItem,
				Content.mediumArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeArsenideGoldChunkItem, 1), new Object[] {
				Content.mediumArsenideGoldChunkItem,
				Content.mediumArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenideGoldChunkItem, 1), new Object[] {
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem,
				Content.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumArsenideGoldChunkItem, 2),
				new Object[] { Content.largeArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.smallArsenideGoldChunkItem, 2),
				new Object[] { Content.mediumArsenideGoldChunkItem });
		// Tenebrium chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeTenebriumChunkItem, 1), new Object[] {
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeTenebriumChunkItem, 1), new Object[] {
				Content.mediumTenebriumChunkItem,
				Content.mediumTenebriumChunkItem,
				Content.mediumTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.largeTenebriumChunkItem, 1), new Object[] {
				Content.mediumTenebriumChunkItem,
				Content.mediumTenebriumChunkItem,
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumTenebriumChunkItem, 1), new Object[] {
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem,
				Content.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.mediumTenebriumChunkItem, 2),
				new Object[] { Content.largeTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.smallTenebriumChunkItem, 2),
				new Object[] { Content.mediumTenebriumChunkItem });
		// Arsenic other things
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.arsenideSaltItem, 1), new Object[] {
				Content.realgarItem, Content.orpimentItem });
		GameRegistry.addRecipe(new ItemStack(Content.realgarItem, 1),
				new Object[] { "ZZZ", "ZZZ", "ZBZ", 'Z', Items.rotten_flesh,
						'B', Items.bone });
		GameRegistry.addRecipe(new ItemStack(Content.orpimentItem, 1),
				new Object[] { "ZZZ", "ZZZ", "ZSZ", 'Z', Items.rotten_flesh,
						'S', Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Content.plateArsenic, 1),
				new Object[] { "AA", 'A', Content.arsenicIngot });
		// Tools
		// Arsenic Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenicPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenicAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenicShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotArsenic", 'Y',
								"stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenicSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotArsenic", 'Y',
								"stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenicHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		// Arsenide Bronze Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzePickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeAxe,
						true, new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeHoe,
						true, new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		// Arsenide Bronze Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeHelm,
						true, new Object[] { "XXX", "X X", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeChest,
						true, new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeLegs,
						true, new Object[] { "XXX", "X X", "X X", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideBronzeBoots,
						true, new Object[] { "X X", "X X", 'X',
								"ingotArsenideBronze" }));
		// Arsenide Gold Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		// Arsenice Gold Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldChest,
						true, new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.arsenideGoldBoots,
						true, new Object[] { "X X", "X X", 'X',
								"ingotArsenideGold" }));
		// Tenebrium Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotTenebrium",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotTenebrium",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		// Tenebrium Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(Content.tenebriumBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotTenebrium" }));
		// Lace breakdown
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4),
				new Object[] { Content.oldLaceChest });
		
		// recipes: Smelting
		GameRegistry.addSmelting(Content.realgarItem,
				new ItemStack(Content.smallArsenicChunkItem), 2.0F);
		GameRegistry.addSmelting(Content.orpimentItem,
				new ItemStack(Content.smallArsenicChunkItem), 2.0F);
		GameRegistry.addSmelting(Content.arsenideSaltItem,
				new ItemStack(Content.mediumArsenicChunkItem), 4.0F);
		GameRegistry.addSmelting(Content.largeArsenicChunkItem,
				new ItemStack(Content.arsenicIngot), 4.0F);
		GameRegistry.addSmelting(
				Content.largeArsenideBronzeChunkItem,
				new ItemStack(Content.arsenideBronzeIngot), 5.0F);
		GameRegistry.addSmelting(
				Content.largeArsenideGoldChunkItem,
				new ItemStack(Content.arsenideGoldIngot), 6.0F);
		GameRegistry.addSmelting(Content.largeTenebriumChunkItem,
				new ItemStack(Content.tenebriumIngot), 6.0F);
		
		// recipes: Fusion Furnace
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh), 
				new ItemStack(Items.bone),
				new ItemStack(Content.realgarItem), 2.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball),
				new ItemStack(Content.orpimentItem), 2.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Content.realgarItem),
				new ItemStack(Content.orpimentItem),
				new ItemStack(Items.poisonous_potato),
				new ItemStack(Content.largeArsenicChunkItem), 20.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Content.oldLaceChest),
				new ItemStack(Content.arsenideSaltItem), 10.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Content.realgarItem),
				new ItemStack(Content.orpimentItem),
				new ItemStack(Content.oldLaceChest),
				new ItemStack(Content.largeArsenicChunkItem), 20.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.dye, 1, 1)),
				new ItemStack(Content.smallArsenideBronzeChunkItem),
				4.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.rotten_flesh)),
				new ItemStack(Content.mediumArsenideBronzeChunkItem),
				6.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotCopper"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.redstone)),
				new ItemStack(Content.largeArsenideBronzeChunkItem),
				15.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotGold"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.dye, 1, 1)),
				new ItemStack(Content.smallArsenideGoldChunkItem), 5.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotGold"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.rotten_flesh)), 
				new ItemStack(Content.mediumArsenideGoldChunkItem), 8.0F);
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("ingotGold"),
				FusionMaterial.of("ingotArsenic"),
				FusionMaterial.of(new ItemStack(Items.redstone)), 
				new ItemStack(Content.largeArsenideGoldChunkItem), 20.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(Content.arsenideGoldIngot),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Content.smallTenebriumChunkItem), 10.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(Content.arsenideGoldIngot),
				new ItemStack(Items.gold_nugget),
				new ItemStack(Content.mediumTenebriumChunkItem), 20.0F);
		FusionFurnaceRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(Content.arsenideGoldIngot),
				new ItemStack(Items.quartz),
				new ItemStack(Content.largeTenebriumChunkItem), 30.0F);
		
		FusionFurnaceRecipes.addSmelting(
				FusionMaterial.of("dyeGreen"),
				FusionMaterial.of("treeLeaves"),
				FusionMaterial.of(new ItemStack(Items.rotten_flesh)),
				new ItemStack(Items.slime_ball), 2.0F);
		// recycling

		if (Settings.enableRecycling) 
		{
			// Arsenic tools
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenicSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenicShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenicPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenicAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenicHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			// other Arsenic
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.plateArsenic),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenicChunkItem), 10.0F);
			// Arsenide Bronze
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(Content.largeArsenideBronzeChunkItem,
							2, 0), 20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeLegs, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(Content.largeArsenideBronzeChunkItem,
							2, 0), 20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzePickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideBronzeHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideBronzeChunkItem),
					10.0F);
			// Arsenide Gold
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(Content.largeArsenideGoldChunkItem, 2,
							0), 30.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldLegs, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(Content.largeArsenideGoldChunkItem, 2,
							0), 30.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.arsenideGoldHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeArsenideGoldChunkItem),
					15.0F);
			// Tenebrium
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes
					.addSmelting(new ItemStack(Content.tenebriumChest,
							1, OreDictionary.WILDCARD_VALUE), new ItemStack(
							Items.quartz, 2, 0), new ItemStack(
							Items.rotten_flesh, 2, 0), new ItemStack(
							Content.largeTenebriumChunkItem, 2, 0),
							40.0F);
			FusionFurnaceRecipes
					.addSmelting(new ItemStack(Content.tenebriumLegs, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Items.quartz, 2, 0), new ItemStack(
							Items.rotten_flesh, 2, 0), new ItemStack(
							Content.largeTenebriumChunkItem, 2, 0),
							40.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.tenebriumHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(Content.largeTenebriumChunkItem),
					20.0F);
			// Shrouds
			FusionFurnaceRecipes.addSmelting(
					new ItemStack(Content.oldLaceChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.coal_ore), 15.0F);
		}
	}
} // end class Recipes
