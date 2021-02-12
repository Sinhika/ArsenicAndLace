package mod.akkamaddi.arsenic.helpers;

import mod.akkamaddi.arsenic.init.ModItems;
import mod.alexndr.simplecorelib.helpers.IWeaponEffectHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ArsenicHandler implements IWeaponEffectHelper
{
    public static ArsenicHandler INSTANCE = new ArsenicHandler();

    public ArsenicHandler() {}

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if (stack.getItem() == ModItems.arsenic_sword.get() || stack.getItem() == ModItems.arsenic_axe.get())
        {
            target.addPotionEffect(new EffectInstance(Effects.POISON, 130));
        }
        else if (stack.getItem() == ModItems.arsenide_bronze_sword.get() 
                || stack.getItem() == ModItems.arsenide_bronze_axe.get())
        {
            target.addPotionEffect(new EffectInstance(Effects.POISON, 55));
        }
        else if (stack.getItem() == ModItems.arsenide_gold_sword.get() 
                || stack.getItem() == ModItems.arsenide_gold_axe.get())
        {
            target.addPotionEffect(new EffectInstance(Effects.POISON, 80));
        }
        return false;
    }

} // end class
