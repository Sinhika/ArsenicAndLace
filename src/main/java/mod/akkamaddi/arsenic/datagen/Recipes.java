package mod.akkamaddi.arsenic.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(ArsenicAndLace.MODID);
    }

    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes() 

    
    private void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // arsenic compounds
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.realgar.get()),
                ModItems.arsenic_nugget.get(), hasItem(ModItems.realgar.get()), 2.0F, 200, "from_realgar");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.orpiment.get()),
                ModItems.arsenic_nugget.get(), hasItem(ModItems.realgar.get()), 2.0F, 200, "from_orpiment");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.arsenide_salt.get()),
                ModItems.medium_arsenic_chunk.get(), hasItem(ModItems.arsenide_salt.get()), 4.0F, 200);
                
        // large chunks
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_arsenic_chunk.get()),
                ModItems.arsenic_ingot.get(), hasItem(ModItems.large_arsenic_chunk.get()), 4.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_arsenide_bronze_chunk.get()),
                ModItems.arsenide_bronze_ingot.get(), hasItem(ModItems.large_arsenide_bronze_chunk.get()), 5.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_arsenide_gold_chunk.get()),
                ModItems.arsenide_gold_ingot.get(), hasItem(ModItems.large_arsenide_gold_chunk.get()), 6.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModItems.large_tenebrium_chunk.get()),
                ModItems.tenebrium_ingot.get(), hasItem(ModItems.large_tenebrium_chunk.get()), 6.0F, 200);
        
        // vanilla recycling
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.arsenic_axe.get(), ModItems.arsenic_hoe.get(), ModItems.arsenic_pickaxe.get(),
                        ModItems.arsenic_shovel.get(), ModItems.arsenic_sword.get(), ModBlocks.arsenic_plate.get()),
                ModItems.arsenic_nugget.get(), hasItem(ModItems.arsenic_axe.get()), 2.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.tenebrium_axe.get(), ModItems.tenebrium_hoe.get(), ModItems.tenebrium_pickaxe.get(),
                        ModItems.tenebrium_shovel.get(), ModItems.tenebrium_sword.get(), ModItems.tenebrium_boots.get(),
                        ModItems.tenebrium_chestplate.get(), ModItems.tenebrium_helmet.get(), ModItems.tenebrium_leggings.get()),
                ModItems.tenebrium_nugget.get(), hasItem(ModItems.tenebrium_axe.get()), 6.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.arsenide_bronze_axe.get(), ModItems.arsenide_bronze_hoe.get(), ModItems.arsenide_bronze_pickaxe.get(),
                        ModItems.arsenide_bronze_shovel.get(), ModItems.arsenide_bronze_sword.get(), ModItems.arsenide_bronze_boots.get(),
                        ModItems.arsenide_bronze_chestplate.get(), ModItems.arsenide_bronze_helmet.get(), ModItems.arsenide_bronze_leggings.get()),
                ModItems.arsenide_bronze_nugget.get(), hasItem(ModItems.arsenide_bronze_axe.get()), 5.0F, 200);

        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.arsenide_gold_axe.get(), ModItems.arsenide_gold_hoe.get(), ModItems.arsenide_gold_pickaxe.get(),
                        ModItems.arsenide_gold_shovel.get(), ModItems.arsenide_gold_sword.get(), ModItems.arsenide_gold_boots.get(),
                        ModItems.arsenide_gold_chestplate.get(), ModItems.arsenide_gold_helmet.get(), ModItems.arsenide_gold_leggings.get()),
                ModItems.arsenide_gold_nugget.get(), hasItem(ModItems.arsenide_gold_axe.get()), 6.0F, 200);
    } // end registerFurnaceRecipes()

    private void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromItems(ModItems.arsenide_bronze_ingot.get()), "arsenide_bronze",
                hasItem(ModItems.arsenide_bronze_ingot.get()), flag("arsenide_bronze_tools_enabled"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromItems(ModItems.arsenide_gold_ingot.get()), "arsenide_gold",
                hasItem(ModItems.arsenide_gold_ingot.get()), flag("arsenide_gold_tools_enabled"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromItems(ModItems.tenebrium_ingot.get()), "tenebrium",
                hasItem(ModItems.tenebrium_ingot.get()), flag("tenebrium_tools_enabled"));
    } // end registerArmorRecipes()

    private void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromItems(ModItems.arsenic_ingot.get()), "arsenic",
                hasItem(ModItems.arsenic_ingot.get()), flag("arsenic_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromItems(ModItems.arsenide_bronze_ingot.get()), "arsenide_bronze",
                hasItem(ModItems.arsenide_bronze_ingot.get()), flag("arsenide_bronze_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromItems(ModItems.arsenide_gold_ingot.get()), "arsenide_gold",
                hasItem(ModItems.arsenide_gold_ingot.get()), flag("arsenide_gold_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromItems(ModItems.tenebrium_ingot.get()), "tenebrium",
                hasItem(ModItems.tenebrium_ingot.get()), flag("tenebrium_tools_enabled"), false);
       
    } // end registerToolRecipes()

    private void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // arsenide_salt
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.arsenide_salt.get())
            .addIngredient(ModItems.realgar.get()).addIngredient(ModItems.orpiment.get())
            .addCriterion("has_item", hasItem(ModItems.realgar.get()))
            .build(consumer);
        
        // realgar
        ShapedRecipeBuilder.shapedRecipe(ModItems.realgar.get())
            .key('Z', Items.ROTTEN_FLESH)
            .key('B', Items.BONE)
            .patternLine("ZZZ")
            .patternLine("ZZZ")
            .patternLine("ZBZ")
            .addCriterion("has_item", hasItem(Items.ROTTEN_FLESH))
            .build(consumer);
        
        // orpiment
        ShapedRecipeBuilder.shapedRecipe(ModItems.orpiment.get())
            .key('Z', Items.ROTTEN_FLESH)
            .key('S', Items.SLIME_BALL)
            .patternLine("ZZZ")
            .patternLine("ZZZ")
            .patternLine("ZSZ")
            .addCriterion("has_item", hasItem(Items.ROTTEN_FLESH))
            .build(consumer);
        
        // arsenic pressure plate
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.arsenic_plate.get())
            .key('A', ModItems.arsenic_ingot.get())
            .patternLine("AA ")
            .addCriterion("has_item", hasItem(ModItems.arsenic_ingot.get()))
            .build(consumer);
        
    } // end registerMiscRecipes()

    private void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenic_ingot.get(), ModBlocks.arsenic_block.get(), 
                ModItems.arsenic_nugget.get(), hasItem(ModItems.arsenic_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenide_bronze_ingot.get(), ModBlocks.arsenide_bronze_block.get(), 
                ModItems.arsenide_bronze_nugget.get(), hasItem(ModItems.arsenide_bronze_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenide_gold_ingot.get(), ModBlocks.arsenide_gold_block.get(), 
                ModItems.arsenide_gold_nugget.get(), hasItem(ModItems.arsenide_gold_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.tenebrium_ingot.get(), ModBlocks.tenebrium_block.get(), 
                ModItems.tenebrium_nugget.get(), hasItem(ModItems.tenebrium_ingot.get()));
    } // end registerStorageRecipes()

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(ArsenicAndLace.MODID, ArsenicConfig.INSTANCE, name);
    }

} // end class
