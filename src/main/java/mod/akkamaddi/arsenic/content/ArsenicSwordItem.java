package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.helpers.ArsenicHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

import net.minecraft.item.Item.Properties;

public class ArsenicSwordItem extends SwordItem
{

    public ArsenicSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return  ArsenicHandler.INSTANCE.hitEntity(stack, target, attacker) 
                && super.hurtEnemy(stack, target, attacker);
    }
    
} // end class
