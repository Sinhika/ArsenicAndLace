package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.helpers.ArsenicHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class ArsenicAxeItem extends AxeItem
{

    public ArsenicAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        return  ArsenicHandler.INSTANCE.hitEntity(stack, target, attacker) 
                && super.hurtEnemy(stack, target, attacker);
    }
    
} // end class
