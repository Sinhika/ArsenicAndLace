package mod.akkamaddi.arsenic.content;

import java.util.function.Supplier;

import mod.akkamaddi.arsenic.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArsenicArmorMaterial implements IArmorMaterial
{
    OLD_LACE ("arsenic:old_lace", 4, new int[] { 1, 1, 1, 1 }, 24, 
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 
            ()-> { return Ingredient.fromItems(Items.STRING);}, 0.0F),
    ARSENIDE_BRONZE("arsenic:arsenide_bronze", 16, new int[] { 1, 3, 5, 3 }, 9,
              SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 
              ()-> { return Ingredient.fromItems(ModItems.arsenide_bronze_ingot.get());}, 0.0F),
    
    ARSENIDE_GOLD("arsenic:arsenide_gold", 12, new int[] { 1, 3, 6, 2 }, 22,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 
            ()-> { return Ingredient.fromItems(ModItems.arsenide_gold_ingot.get());}, 0.0F),
 
    TENEBRIUM("arsenic:tenebrium", 52, new int[] { 4, 8, 8, 4 }, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 
            ()-> { return Ingredient.fromItems(ModItems.tenebrium_ingot.get());}, 0.0F);
             
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;
    private final float knockbackResist;

    private ArsenicArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray,
            int enchantabilityIn, SoundEvent soundIn,
            float toughnessIn,
            Supplier<Ingredient> repairMatIn, float knockbackIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        repairMaterial = new LazyValue<>(repairMatIn);
        knockbackResist = knockbackIn;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return this.repairMaterial.getValue();
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return this.knockbackResist;
    }

} // end-class
