package mod.akkamaddi.arsenic.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.akkamaddi.arsenic.init.ModTags;
import mod.alexndr.fusion.api.datagen.FusionRecipeSetBuilder;
import mod.alexndr.fusion.api.recipe.AbstractFusionRecipeProvider;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class FusionRecipes extends AbstractFusionRecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private FusionRecipeSetBuilder fusionbuilder;

    public FusionRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        fusionbuilder = new FusionRecipeSetBuilder(ArsenicAndLace.MODID);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerArsenicRecipes(consumer);
        registerArsenideBronzeRecipes(consumer);
        registerArsenideGoldRecipes(consumer);
        registerTenebriumRecipes(consumer);
        registerMiscFusionRecipes(consumer);
    }

    /**
     * Arsenic alloying recipes and arsenic recycling recipes.
     * 
     * @param consumer
     */
    protected void registerArsenicRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(ModItems.realgar.get()));
        primary_inputs.add(Ingredient.of(ModItems.orpiment.get()));
        catalysts[2] = Ingredient.of(Items.POISONOUS_POTATO);
        
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                null, null, ModItems.large_arsenic_chunk.get(), 5.0F, 600,
                flag("arsenic_making_enabled"));

        catalysts[2] = Ingredient.of(ModItems.old_lace_chest.get());
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                null, null, ModItems.large_arsenic_chunk.get(), 5.0F, 600,
                flag("arsenic_making_enabled"), "_with_shroud");
        
        // arsenic recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenic_axe.get(), ModItems.arsenic_hoe.get(),
                        ModItems.arsenic_pickaxe.get(), ModItems.arsenic_shovel.get(), 
                        ModItems.arsenic_sword.get(), ModBlocks.arsenic_plate.get().asItem()),
                null, Ingredient.of(Items.GRAVEL), Ingredient.of(Items.ROTTEN_FLESH),
                ModItems.raw_arsenic.get(), 10.0F, 600, flag("recycling_enabled"), "recycle_arsenic_items");
        
    } // end registerArsenicRecipes

    /**
     * Arsenide bronze alloying recipes and arsenide bronze recycling recipes.
     * 
     * @param consumer
     */
    protected void registerArsenideBronzeRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_COPPER));
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_ARSENIC));
        catalysts[0] = Ingredient.of(Items.RED_DYE);
        catalysts[1] = Ingredient.of(Items.ROTTEN_FLESH);
        catalysts[2] = Ingredient.of(Items.REDSTONE);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.arsenide_bronze_nugget.get(), ModItems.medium_arsenide_bronze_chunk.get(), 
                ModItems.large_arsenide_bronze_chunk.get(), 4.0F, 600,
                flag("arsenide_bronze_making_enabled"));

        // arsenide_bronze recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenide_bronze_axe.get(), ModItems.arsenide_bronze_hoe.get(),
                        ModItems.arsenide_bronze_pickaxe.get(), ModItems.arsenide_bronze_shovel.get(), 
                        ModItems.arsenide_bronze_sword.get(), ModItems.arsenide_bronze_boots.get(),
                        ModItems.arsenide_bronze_helmet.get()),
                Ingredient.of(ModItems.arsenide_bronze_leggings.get(), 
                        ModItems.arsenide_bronze_chestplate.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(Items.ROTTEN_FLESH),
                ModItems.large_arsenide_bronze_chunk.get(), 10.0F, 600, flag("recycling_enabled"), 
                "recycle_arsenide_bronze_items");
    } // end registerArsenideBronzeRecipes

    /**
     * Arsenide gold alloying recipes and arsenide gold recycling recipes.
     * 
     * @param consumer
     */
    protected void registerArsenideGoldRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(Items.GOLD_INGOT));
        primary_inputs.add(Ingredient.of(ModTags.Items.INGOTS_ARSENIC));
        catalysts[0] = Ingredient.of(Items.RED_DYE);
        catalysts[1] = Ingredient.of(Items.ROTTEN_FLESH);
        catalysts[2] = Ingredient.of(Items.REDSTONE);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.arsenide_gold_nugget.get(), ModItems.medium_arsenide_gold_chunk.get(), 
                ModItems.large_arsenide_gold_chunk.get(), 5.0F, 600,
                flag("arsenide_gold_making_enabled"));

        // arsenide_gold recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenide_gold_axe.get(), ModItems.arsenide_gold_hoe.get(),
                        ModItems.arsenide_gold_pickaxe.get(), ModItems.arsenide_gold_shovel.get(), 
                        ModItems.arsenide_gold_sword.get(), ModItems.arsenide_gold_boots.get(),
                        ModItems.arsenide_gold_helmet.get()),
                Ingredient.of(ModItems.arsenide_gold_leggings.get(), 
                        ModItems.arsenide_gold_chestplate.get()), 
                Ingredient.of(Items.GRAVEL), Ingredient.of(Items.ROTTEN_FLESH),
                ModItems.large_arsenide_gold_chunk.get(), 15.0F, 600, flag("recycling_enabled"), 
                "recycle_arsenide_gold_items");
        
    } // end registerArsenideGoldRecipes

    /**
     * Tenebrium alloying recipes and tenebrium recycling recipes.
     * 
     * @param consumer
     */
    protected void registerTenebriumRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];
        
        primary_inputs.add(Ingredient.of(Blocks.OBSIDIAN.asItem()));
        primary_inputs.add(Ingredient.of(ModItems.arsenide_gold_ingot.get()));
        catalysts[0] = Ingredient.of(Items.ROTTEN_FLESH);
        catalysts[1] = Ingredient.of(Items.GOLD_NUGGET);
        catalysts[2] = Ingredient.of(Items.QUARTZ);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.tenebrium_nugget.get(), ModItems.medium_tenebrium_chunk.get(), 
                ModItems.large_tenebrium_chunk.get(), 10.0F, 600,
                flag("tenebrium_making_enabled"));

        // tenebrium recycling recipes
        fusionbuilder.buildFusionRecyclingRecipes(consumer,
                Ingredient.of(ModItems.tenebrium_axe.get(), ModItems.tenebrium_hoe.get(),
                        ModItems.tenebrium_pickaxe.get(), ModItems.tenebrium_shovel.get(), 
                        ModItems.tenebrium_sword.get(), ModItems.tenebrium_boots.get(),
                        ModItems.tenebrium_helmet.get()),
                Ingredient.of(ModItems.tenebrium_leggings.get(), 
                        ModItems.tenebrium_chestplate.get()), 
                Ingredient.of(Items.QUARTZ), Ingredient.of(Items.ROTTEN_FLESH),
                ModItems.large_tenebrium_chunk.get(), 20.0F, 600, flag("recycling_enabled"), 
                "recycle_tenebrium_items");
         
    } // end registerTenebriumRecipes

    protected void registerMiscFusionRecipes(Consumer<FinishedRecipe> consumer)
    {
        List<Ingredient> primary_inputs = new ArrayList<Ingredient>(2);
        Ingredient[] catalysts = new Ingredient[3];

        primary_inputs.add(Ingredient.of(Items.ROTTEN_FLESH));
        primary_inputs.add(Ingredient.of(Items.ROTTEN_FLESH));
        catalysts[0] = Ingredient.of(Items.BONE);
        
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.realgar.get(), null, null, 2.0F, 600, null);
        
        catalysts[0] = Ingredient.of(Items.SLIME_BALL);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.orpiment.get(), null, null, 2.0F, 600, null);

        catalysts[0] = Ingredient.of(ModItems.old_lace_chest.get());
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                ModItems.arsenide_salt.get(), null, null, 10.0F, 600, null);
        
        primary_inputs.clear();
        primary_inputs.add(Ingredient.of(Items.GREEN_DYE));
        primary_inputs.add(Ingredient.of(ItemTags.LEAVES));
        catalysts[0] = Ingredient.of(Items.ROTTEN_FLESH);
        fusionbuilder.buildBasicAlloyRecipes(consumer, primary_inputs, catalysts, 
                Items.SLIME_BALL, null, null, 2.0F, 600, null);
    } // end registerMiscFusionRecipes

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(ArsenicAndLace.MODID, ArsenicConfig.INSTANCE, name);
    }

} // end class
