package akkamaddi.arsenic.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class WerewolfHandler
{
    private final Class werewolf;
    private Method isHumanForm;

    public WerewolfHandler() throws ClassNotFoundException
    {
        werewolf = Class.forName("drzhark.mocreatures.entity.monster.MoCEntityWerewolf");

        try
        {
            isHumanForm = werewolf.getMethod("getIsHumanForm");
        }
        catch (NoSuchMethodException e)
        {
            throw new RuntimeException(e);
        }
        catch (SecurityException e)
        {
            throw new RuntimeException(e);
        }
    }

    private boolean isWerewolfInWolfForm(EntityLivingBase entityLiving)
    {
        try
        {
            return werewolf.isInstance(entityLiving) && !(Boolean) isHumanForm.invoke(entityLiving);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }

    @ForgeSubscribe public void onLivingHurt(LivingHurtEvent event)
    {
        if (!isWerewolfInWolfForm(event.entityLiving))
        {
            return;
        }

        Entity entity;
        ItemStack stack;

        if (!(event.source instanceof EntityDamageSource && event.source != null
                && (entity = ((EntityDamageSource) event.source).getEntity()) instanceof EntityLivingBase
                && (stack = ((EntityLivingBase) entity).getHeldItem()) != null))
        {
            return;
        }

        Item item = stack.getItem();

        if (item.itemID ==  ArsenicAndLace.arsenideGoldHoe.itemID)
        {
            event.ammount = 6;
        }
        else if (item.itemID ==  ArsenicAndLace.arsenideGoldShovel.itemID)
        {
            event.ammount = 7;
        }
        else if (item.itemID ==  ArsenicAndLace.arsenideGoldPickaxe.itemID)
        {
            event.ammount = 8;
        }
        else if (item.itemID ==  ArsenicAndLace.arsenideGoldAxe.itemID)
        {
            event.ammount = 9;
        }
        else if (item.itemID ==  ArsenicAndLace.arsenideGoldSword.itemID)
        {
            event.ammount = 10;
        }
    }
}
