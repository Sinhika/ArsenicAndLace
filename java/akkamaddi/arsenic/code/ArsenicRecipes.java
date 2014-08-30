package akkamaddi.arsenic.code;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.core.Content;
import alexndr.SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArsenicRecipes {
	public static alexndr.SimpleOres.api.helpers.CoreHelper soItems;

	@SuppressWarnings("unchecked")
	public static void doArsenicRecipes() {
		// Forge ore dictionary recipes
		OreDictionary.registerOre("ingotArsenic", new ItemStack(
				ArsenicAndLace.arsenicIngot));
		OreDictionary.registerOre("ingotArsenideBronze", new ItemStack(
				ArsenicAndLace.arsenideBronzeIngot));
		OreDictionary.registerOre("ingotArsenideGold", new ItemStack(
				ArsenicAndLace.arsenideGoldIngot));
		OreDictionary.registerOre("ingotTenebrium", new ItemStack(
				ArsenicAndLace.tenebriumIngot));
		
		// recipes: Crafting
		// Storage Blocks
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.blockArsenic, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						ArsenicAndLace.arsenicIngot });
		GameRegistry.addRecipe(new ItemStack(
				ArsenicAndLace.blockArsenideBronze, 1), new Object[] { "AAA",
				"AAA", "AAA", 'A', ArsenicAndLace.arsenideBronzeIngot });
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.blockArsenideGold,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
				ArsenicAndLace.arsenideGoldIngot });
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.blockTenebrium, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
						ArsenicAndLace.tenebriumIngot });
		// Item Recipes
		// Ingot Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.arsenicIngot, 9),
				new Object[] { ArsenicAndLace.blockArsenic });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.arsenideBronzeIngot, 9),
				new Object[] { ArsenicAndLace.blockArsenideBronze });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.arsenideGoldIngot, 9),
				new Object[] { ArsenicAndLace.blockArsenideGold });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.tenebriumIngot, 9),
				new Object[] { ArsenicAndLace.blockTenebrium });
		// Arsenic chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenicChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenicChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenicChunkItem,
				ArsenicAndLace.mediumArsenicChunkItem,
				ArsenicAndLace.mediumArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenicChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenicChunkItem,
				ArsenicAndLace.mediumArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenicChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem,
				ArsenicAndLace.smallArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenicChunkItem, 2),
				new Object[] { ArsenicAndLace.largeArsenicChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.smallArsenicChunkItem, 2),
				new Object[] { ArsenicAndLace.mediumArsenicChunkItem });
		// Red Bronze chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideBronzeChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideBronzeChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenideBronzeChunkItem,
				ArsenicAndLace.mediumArsenideBronzeChunkItem,
				ArsenicAndLace.mediumArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideBronzeChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenideBronzeChunkItem,
				ArsenicAndLace.mediumArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenideBronzeChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem,
				ArsenicAndLace.smallArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenideBronzeChunkItem, 2),
				new Object[] { ArsenicAndLace.largeArsenideBronzeChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.smallArsenideBronzeChunkItem, 2),
				new Object[] { ArsenicAndLace.mediumArsenideBronzeChunkItem });
		// Red Gold chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideGoldChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideGoldChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenideGoldChunkItem,
				ArsenicAndLace.mediumArsenideGoldChunkItem,
				ArsenicAndLace.mediumArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeArsenideGoldChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumArsenideGoldChunkItem,
				ArsenicAndLace.mediumArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenideGoldChunkItem, 1), new Object[] {
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem,
				ArsenicAndLace.smallArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumArsenideGoldChunkItem, 2),
				new Object[] { ArsenicAndLace.largeArsenideGoldChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.smallArsenideGoldChunkItem, 2),
				new Object[] { ArsenicAndLace.mediumArsenideGoldChunkItem });
		// Tenebrium chunks
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeTenebriumChunkItem, 1), new Object[] {
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeTenebriumChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumTenebriumChunkItem,
				ArsenicAndLace.mediumTenebriumChunkItem,
				ArsenicAndLace.mediumTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.largeTenebriumChunkItem, 1), new Object[] {
				ArsenicAndLace.mediumTenebriumChunkItem,
				ArsenicAndLace.mediumTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumTenebriumChunkItem, 1), new Object[] {
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem,
				ArsenicAndLace.smallTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.mediumTenebriumChunkItem, 2),
				new Object[] { ArsenicAndLace.largeTenebriumChunkItem });
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.smallTenebriumChunkItem, 2),
				new Object[] { ArsenicAndLace.mediumTenebriumChunkItem });
		// Arsenic other things
		GameRegistry.addShapelessRecipe(new ItemStack(
				ArsenicAndLace.arsenideSaltItem, 1), new Object[] {
				ArsenicAndLace.realgarItem, ArsenicAndLace.orpimentItem });
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.realgarItem, 1),
				new Object[] { "ZZZ", "ZZZ", "ZBZ", 'Z', Items.rotten_flesh,
						'B', Items.bone });
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.orpimentItem, 1),
				new Object[] { "ZZZ", "ZZZ", "ZSZ", 'Z', Items.rotten_flesh,
						'S', Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(ArsenicAndLace.plateArsenic, 1),
				new Object[] { "AA", 'A', ArsenicAndLace.arsenicIngot });
		// Tools
		// Arsenic Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenicPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenicAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenicShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotArsenic", 'Y',
								"stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenicSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotArsenic", 'Y',
								"stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenicHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenic", 'Y', "stickWood" }));
		// Arsenide Bronze Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzePickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeAxe,
						true, new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeHoe,
						true, new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenideBronze", 'Y', "stickWood" }));
		// Arsenide Bronze Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeHelm,
						true, new Object[] { "XXX", "X X", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeChest,
						true, new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeLegs,
						true, new Object[] { "XXX", "X X", "X X", 'X',
								"ingotArsenideBronze" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideBronzeBoots,
						true, new Object[] { "X X", "X X", 'X',
								"ingotArsenideBronze" }));
		// Arsenide Gold Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldPickaxe,
						true, new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldShovel,
						true, new Object[] { "X", "Y", "Y", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldSword,
						true, new Object[] { "X", "X", "Y", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotArsenideGold", 'Y', "stickWood" }));
		// Arsenice Gold Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldChest,
						true, new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotArsenideGold" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.arsenideGoldBoots,
						true, new Object[] { "X X", "X X", 'X',
								"ingotArsenideGold" }));
		// Tenebrium Tool Recipes
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumPickaxe, true,
						new Object[] { "XXX", " Y ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumAxe, true,
						new Object[] { "XX ", "XY ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumShovel, true,
						new Object[] { "X", "Y", "Y", 'X', "ingotTenebrium",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumSword, true,
						new Object[] { "X", "X", "Y", 'X', "ingotTenebrium",
								'Y', "stickWood" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumHoe, true,
						new Object[] { "XX ", " Y ", " Y ", 'X',
								"ingotTenebrium", 'Y', "stickWood" }));
		// Tenebrium Armor
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumHelm, true,
						new Object[] { "XXX", "X X", 'X', "ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumChest, true,
						new Object[] { "X X", "XXX", "XXX", 'X',
								"ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumLegs, true,
						new Object[] { "XXX", "X X", "X X", 'X',
								"ingotTenebrium" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(ArsenicAndLace.tenebriumBoots, true,
						new Object[] { "X X", "X X", 'X', "ingotTenebrium" }));
		// Lace breakdown
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4),
				new Object[] { ArsenicAndLace.oldLaceChest });
		
		// recipes: Smelting
		GameRegistry.addSmelting(ArsenicAndLace.realgarItem,
				new ItemStack(ArsenicAndLace.smallArsenicChunkItem), 2.0F);
		GameRegistry.addSmelting(ArsenicAndLace.orpimentItem,
				new ItemStack(ArsenicAndLace.smallArsenicChunkItem), 2.0F);
		GameRegistry.addSmelting(ArsenicAndLace.arsenideSaltItem,
				new ItemStack(ArsenicAndLace.mediumArsenicChunkItem), 4.0F);
		GameRegistry.addSmelting(ArsenicAndLace.largeArsenicChunkItem,
				new ItemStack(ArsenicAndLace.arsenicIngot), 4.0F);
		GameRegistry.addSmelting(
				ArsenicAndLace.largeArsenideBronzeChunkItem,
				new ItemStack(ArsenicAndLace.arsenideBronzeIngot), 5.0F);
		GameRegistry.addSmelting(
				ArsenicAndLace.largeArsenideGoldChunkItem,
				new ItemStack(ArsenicAndLace.arsenideGoldIngot), 6.0F);
		GameRegistry.addSmelting(ArsenicAndLace.largeTenebriumChunkItem,
				new ItemStack(ArsenicAndLace.tenebriumIngot), 6.0F);
		
		// recipes: Fusion Furnace
		FusionRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh), new ItemStack(Items.bone),
				new ItemStack(ArsenicAndLace.realgarItem), 2.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball),
				new ItemStack(ArsenicAndLace.orpimentItem), 2.0F);
		FusionRecipes.addSmelting(
				new ItemStack(ArsenicAndLace.realgarItem),
				new ItemStack(ArsenicAndLace.orpimentItem),
				new ItemStack(Items.poisonous_potato),
				new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 20.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(ArsenicAndLace.oldLaceChest),
				new ItemStack(ArsenicAndLace.arsenideSaltItem), 10.0F);
		FusionRecipes.addSmelting(
				new ItemStack(ArsenicAndLace.realgarItem),
				new ItemStack(ArsenicAndLace.orpimentItem),
				new ItemStack(ArsenicAndLace.oldLaceChest),
				new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 20.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Content.copper_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot),
				new ItemStack(Items.dye, 1, 1),
				new ItemStack(ArsenicAndLace.smallArsenideBronzeChunkItem),
				4.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Content.copper_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(ArsenicAndLace.mediumArsenideBronzeChunkItem),
				6.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Content.copper_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot),
				new ItemStack(Items.redstone),
				new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
				15.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.gold_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot),
				new ItemStack(Items.dye, 1, 1),
				new ItemStack(ArsenicAndLace.smallArsenideGoldChunkItem), 5.0F);
		FusionRecipes.addSmelting(new ItemStack(Items.gold_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot), new ItemStack(
						Items.rotten_flesh), new ItemStack(
						ArsenicAndLace.mediumArsenideGoldChunkItem), 8.0F);
		FusionRecipes.addSmelting(new ItemStack(Items.gold_ingot),
				new ItemStack(ArsenicAndLace.arsenicIngot), new ItemStack(
						Items.redstone), new ItemStack(
						ArsenicAndLace.largeArsenideGoldChunkItem), 20.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(ArsenicAndLace.arsenideGoldIngot),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(ArsenicAndLace.smallTenebriumChunkItem), 10.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(ArsenicAndLace.arsenideGoldIngot),
				new ItemStack(Items.gold_nugget),
				new ItemStack(ArsenicAndLace.mediumTenebriumChunkItem), 20.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Blocks.obsidian),
				new ItemStack(ArsenicAndLace.arsenideGoldIngot),
				new ItemStack(Items.quartz),
				new ItemStack(ArsenicAndLace.largeTenebriumChunkItem), 30.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(Blocks.leaves, 1, 0),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball), 2.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(Blocks.leaves, 1, 1),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball), 2.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(Blocks.leaves, 1, 2),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball), 2.0F);
		FusionRecipes.addSmelting(
				new ItemStack(Items.dye, 1, 2),
				new ItemStack(Blocks.leaves, 1, 3),
				new ItemStack(Items.rotten_flesh),
				new ItemStack(Items.slime_ball), 2.0F);

		// recycling

		if (ArsenicAndLace.enableRecycling) {
			// Arsenic tools
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenicSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenicShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenicPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenicAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenicHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			// other Arsenic
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.plateArsenic),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenicChunkItem), 10.0F);
			// Arsenide Bronze
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem,
							2, 0), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeLegs, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem,
							2, 0), 20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzePickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideBronzeHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideBronzeChunkItem),
					10.0F);
			// Arsenide Gold
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem, 2,
							0), 30.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldLegs, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel, 2, 0),
					new ItemStack(Items.rotten_flesh, 2, 0),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem, 2,
							0), 30.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.arsenideGoldHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeArsenideGoldChunkItem),
					15.0F);
			// Tenebrium
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumHelm, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes
					.addSmelting(new ItemStack(ArsenicAndLace.tenebriumChest,
							1, OreDictionary.WILDCARD_VALUE), new ItemStack(
							Items.quartz, 2, 0), new ItemStack(
							Items.rotten_flesh, 2, 0), new ItemStack(
							ArsenicAndLace.largeTenebriumChunkItem, 2, 0),
							40.0F);
			FusionRecipes
					.addSmelting(new ItemStack(ArsenicAndLace.tenebriumLegs, 1,
							OreDictionary.WILDCARD_VALUE), new ItemStack(
							Items.quartz, 2, 0), new ItemStack(
							Items.rotten_flesh, 2, 0), new ItemStack(
							ArsenicAndLace.largeTenebriumChunkItem, 2, 0),
							40.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumBoots, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumSword, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumShovel, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumPickaxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumAxe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.tenebriumHoe, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Items.quartz),
					new ItemStack(Items.rotten_flesh),
					new ItemStack(ArsenicAndLace.largeTenebriumChunkItem),
					20.0F);
			// Shrouds
			FusionRecipes.addSmelting(
					new ItemStack(ArsenicAndLace.oldLaceChest, 1,
							OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.gravel),
					new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE),
					new ItemStack(Blocks.coal_ore), 15.0F);
		}
	}
}
