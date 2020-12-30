package mod.akkamaddi.arsenic.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.config.ArsenicConfig;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
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
        // TODO Auto-generated method stub
        
    }

    private void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // TODO Auto-generated method stub
        
    }

    private void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // TODO Auto-generated method stub
        
    }

    private void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // TODO Auto-generated method stub
        
    }

    private void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(ArsenicAndLace.MODID, ArsenicConfig.INSTANCE, name);
    }

} // end class
