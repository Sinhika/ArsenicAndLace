package mod.akkamaddi.arsenic.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.akkamaddi.arsenic.init.ModBlocks;
import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public Recipes(PackOutput pOutput)
    {
        super(pOutput);
        setbuilder = new RecipeSetBuilder(ArsenicAndLace.MODID);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes() 

    
    private void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        // arsenic compounds
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.realgar.get()),
                ModItems.arsenic_nugget.get(), has(ModItems.realgar.get()), 2.0F, 200, "_from_realgar");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.orpiment.get()),
                ModItems.arsenic_nugget.get(), has(ModItems.realgar.get()), 2.0F, 200, "_from_orpiment");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.arsenic_toxic_lump.get()),
                ModItems.arsenic_nugget.get(), has(ModItems.arsenic_toxic_lump.get()), 2.0F, 200, "_from_lump");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.arsenide_salt.get()),
                ModItems.medium_arsenic_chunk.get(), has(ModItems.arsenide_salt.get()), 4.0F, 200);
        
        // arsenic ore & friends
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.arsenic_ore_stone.get().asItem()),
                ModItems.arsenic_ingot.get(), has(ModBlocks.arsenic_ore_stone.get().asItem()), 4.0F, 200,
                "from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.arsenic_ore_deepslate.get().asItem()),
                ModItems.arsenic_ingot.get(), has(ModBlocks.arsenic_ore_deepslate.get().asItem()), 4.0F, 200,
                "from_deepslate_ore");

        // large chunks & raw metal
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_arsenic.get()),
                ModItems.arsenic_ingot.get(), has(ModItems.raw_arsenic.get()), 4.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_arsenic_chunk.get()),
                ModItems.arsenic_ingot.get(), has(ModItems.large_arsenic_chunk.get()), 4.0F, 200,
                "_from_chunk");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_arsenide_bronze_chunk.get()),
                ModItems.arsenide_bronze_ingot.get(), has(ModItems.large_arsenide_bronze_chunk.get()), 5.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_arsenide_gold_chunk.get()),
                ModItems.arsenide_gold_ingot.get(), has(ModItems.large_arsenide_gold_chunk.get()), 6.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.large_tenebrium_chunk.get()),
                ModItems.tenebrium_ingot.get(), has(ModItems.large_tenebrium_chunk.get()), 6.0F, 200);
        
        // vanilla recycling
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenic_axe.get(), ModItems.arsenic_hoe.get(), ModItems.arsenic_pickaxe.get(),
                        ModItems.arsenic_shovel.get(), ModItems.arsenic_sword.get(), ModBlocks.arsenic_plate.get()),
                ModItems.arsenic_nugget.get(), has(ModItems.arsenic_axe.get()), 2.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.tenebrium_axe.get(), ModItems.tenebrium_hoe.get(), ModItems.tenebrium_pickaxe.get(),
                        ModItems.tenebrium_shovel.get(), ModItems.tenebrium_sword.get(), ModItems.tenebrium_boots.get(),
                        ModItems.tenebrium_chestplate.get(), ModItems.tenebrium_helmet.get(), ModItems.tenebrium_leggings.get()),
                ModItems.tenebrium_nugget.get(), has(ModItems.tenebrium_axe.get()), 6.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenide_bronze_axe.get(), ModItems.arsenide_bronze_hoe.get(), ModItems.arsenide_bronze_pickaxe.get(),
                        ModItems.arsenide_bronze_shovel.get(), ModItems.arsenide_bronze_sword.get(), ModItems.arsenide_bronze_boots.get(),
                        ModItems.arsenide_bronze_chestplate.get(), ModItems.arsenide_bronze_helmet.get(), ModItems.arsenide_bronze_leggings.get()),
                ModItems.arsenide_bronze_nugget.get(), has(ModItems.arsenide_bronze_axe.get()), 5.0F, 200);

        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.arsenide_gold_axe.get(), ModItems.arsenide_gold_hoe.get(), ModItems.arsenide_gold_pickaxe.get(),
                        ModItems.arsenide_gold_shovel.get(), ModItems.arsenide_gold_sword.get(), ModItems.arsenide_gold_boots.get(),
                        ModItems.arsenide_gold_chestplate.get(), ModItems.arsenide_gold_helmet.get(), ModItems.arsenide_gold_leggings.get()),
                ModItems.arsenide_gold_nugget.get(), has(ModItems.arsenide_gold_axe.get()), 6.0F, 200);
        
        // dust recipes (for Silents & other tech mods)
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.arsenic_dust.get()),
                ModItems.arsenic_ingot.get(), has(ModItems.arsenic_dust.get()), 4.0F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.arsenide_bronze_dust.get()),
                ModItems.arsenide_bronze_ingot.get(), 
                has(ModItems.arsenide_bronze_dust.get()), 5.0F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.arsenide_gold_dust.get()),
                ModItems.arsenide_gold_ingot.get(), has(ModItems.arsenide_gold_dust.get()), 
                6.0F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.tenebrium_dust.get()),
                ModItems.tenebrium_ingot.get(), has(ModItems.tenebrium_dust.get()), 
                6.0F, 200, "_from_dust");
    } // end registerFurnaceRecipes()

    private void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.arsenide_bronze_ingot.get()), "arsenide_bronze",
                has(ModItems.arsenide_bronze_ingot.get()), flag("arsenide_bronze_tools_enabled"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.arsenide_gold_ingot.get()), "arsenide_gold",
                has(ModItems.arsenide_gold_ingot.get()), flag("arsenide_gold_tools_enabled"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.tenebrium_ingot.get()), "tenebrium",
                has(ModItems.tenebrium_ingot.get()), flag("tenebrium_tools_enabled"));
    } // end registerArmorRecipes()

    private void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.arsenic_ingot.get()), "arsenic",
                has(ModItems.arsenic_ingot.get()), flag("arsenic_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.arsenide_bronze_ingot.get()), "arsenide_bronze",
                has(ModItems.arsenide_bronze_ingot.get()), flag("arsenide_bronze_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.arsenide_gold_ingot.get()), "arsenide_gold",
                has(ModItems.arsenide_gold_ingot.get()), flag("arsenide_gold_tools_enabled"), false);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModItems.tenebrium_ingot.get()), "tenebrium",
                has(ModItems.tenebrium_ingot.get()), flag("tenebrium_tools_enabled"), false);
       
    } // end registerToolRecipes()

    private void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
    {
        // lace breakdown
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 4)
            .requires(ModItems.old_lace_chest.get())
            .unlockedBy("has_item", has(ModItems.old_lace_chest.get()))
            .save(consumer, "arsenic:string_from_lace");
        
        // arsenide_salt
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.arsenide_salt.get())
            .requires(ModItems.realgar.get()).requires(ModItems.orpiment.get())
            .unlockedBy("has_item", has(ModItems.realgar.get()))
            .save(consumer);
        
        // realgar
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.realgar.get())
            .define('Z', Items.ROTTEN_FLESH)
            .define('B', Items.BONE)
            .pattern("ZZZ")
            .pattern("ZZZ")
            .pattern("ZBZ")
            .unlockedBy("has_item", has(Items.ROTTEN_FLESH))
            .save(consumer);
        
        // orpiment
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.orpiment.get())
            .define('Z', Items.ROTTEN_FLESH)
            .define('S', Items.SLIME_BALL)
            .pattern("ZZZ")
            .pattern("ZZZ")
            .pattern("ZSZ")
            .unlockedBy("has_item", has(Items.ROTTEN_FLESH))
            .save(consumer);
        
        // toxic lump
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.arsenic_toxic_lump.get())
            .requires(ModItems.arsenic_toxic_soot.get(), 9)
            .unlockedBy("has_item", has(ModItems.arsenic_toxic_soot.get()))
            .save(consumer);
        
        // convert raw_arsenic to large_arsenic_chunk
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.large_arsenic_chunk.get())
            .requires(ModItems.raw_arsenic.get())
            .unlockedBy("has_item", has(ModItems.raw_arsenic.get()))
            .save(consumer, "arsenic:convert_raw_to_chunk");
        
        // arsenic pressure plate
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.arsenic_plate.get())
            .define('A', ModItems.arsenic_ingot.get())
            .pattern("AA ")
            .unlockedBy("has_item", has(ModItems.arsenic_ingot.get()))
            .save(consumer);
        
        // necrotic/tainted furnace
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.tainted_furnace.get())
            .define('A', ModItems.arsenic_ingot.get())
            .define('S', Items.BONE)
            .define('R', Items.ROTTEN_FLESH)
            .pattern("ASA")
            .pattern("SRS")
            .pattern("ASA")
            .unlockedBy("has_item", has(ModItems.arsenic_ingot.get()))
            .save(consumer);
            
    } // end registerMiscRecipes()

    private void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_arsenic.get(), 
                ModBlocks.raw_arsenic_block.get(), null, has(ModItems.raw_arsenic.get()));

        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenic_ingot.get(), ModBlocks.arsenic_block.get(), 
                ModItems.arsenic_nugget.get(), has(ModItems.arsenic_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenide_bronze_ingot.get(), ModBlocks.arsenide_bronze_block.get(), 
                ModItems.arsenide_bronze_nugget.get(), has(ModItems.arsenide_bronze_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.arsenide_gold_ingot.get(), ModBlocks.arsenide_gold_block.get(), 
                ModItems.arsenide_gold_nugget.get(), has(ModItems.arsenide_gold_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.tenebrium_ingot.get(), ModBlocks.tenebrium_block.get(), 
                ModItems.tenebrium_nugget.get(), has(ModItems.tenebrium_ingot.get()));
        
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.arsenic_nugget.get(),
                ModItems.medium_arsenic_chunk.get(), ModItems.large_arsenic_chunk.get(),
                has(ModItems.arsenic_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.tenebrium_nugget.get(),
                ModItems.medium_tenebrium_chunk.get(), ModItems.large_tenebrium_chunk.get(),
                has(ModItems.tenebrium_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.arsenide_bronze_nugget.get(),
                ModItems.medium_arsenide_bronze_chunk.get(), ModItems.large_arsenide_bronze_chunk.get(),
                has(ModItems.arsenide_bronze_nugget.get()));
        setbuilder.buildChunkConversionRecipes(consumer, ModItems.arsenide_gold_nugget.get(),
                ModItems.medium_arsenide_gold_chunk.get(), ModItems.large_arsenide_gold_chunk.get(),
                has(ModItems.arsenide_gold_nugget.get()));

    } // end registerStorageRecipes()

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(ArsenicAndLace.MODID, ArsenicConfig.INSTANCE, name);
    }

} // end class
