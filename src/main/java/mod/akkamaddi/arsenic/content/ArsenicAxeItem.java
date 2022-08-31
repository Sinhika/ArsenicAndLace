package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.helpers.ArsenicHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import net.minecraft.world.item.Item.Properties;

public class ArsenicAxeItem extends AxeItem
{

    public ArsenicAxeItem(Tier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return  ArsenicHandler.INSTANCE.hitEntity(stack, target, attacker) 
                && super.hurtEnemy(stack, target, attacker);
    }
    
} // end class
