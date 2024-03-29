package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.helpers.ArsenicHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ArsenicSwordItem extends SwordItem
{

    public ArsenicSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
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
