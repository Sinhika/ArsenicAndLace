package mod.akkamaddi.arsenic.content;

import java.util.function.Supplier;

import mod.akkamaddi.arsenic.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;

public enum ArsenicItemTier implements Tier 
{
    ARSENIC(1, 62, 2.0F, 2.0F, 10, ()->{ return Ingredient.of(ModItems.arsenic_ingot.get()); }),
    ARSENIDE_BRONZE(2, 640, 9.5F, 2.0F, 9, ()->{ return Ingredient.of( ModItems.arsenide_bronze_ingot.get()); }),
    ARSENIDE_GOLD(1, 56, 12.0F, 2.0F, 20, ()->{ return Ingredient.of( ModItems.arsenide_gold_ingot.get()); }),
    TENEBRIUM(4, 3820, 9.0F, 3.0F, 17, ()->{ return Ingredient.of( ModItems.tenebrium_ingot.get()); });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    private ArsenicItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                    Supplier<Ingredient> repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
    }
    
    @Override
    public int getUses() {
       return this.maxUses;
    }

    @Override
    public float getSpeed() {
       return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
       return this.attackDamage;
    }

    @Override
    public int getLevel() {
       return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
       return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
       return this.repairMaterial.get();
    }
} // end class
