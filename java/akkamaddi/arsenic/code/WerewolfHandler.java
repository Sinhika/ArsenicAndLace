package akkamaddi.arsenic.code;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WerewolfHandler
{
    private final Class<?> werewolf;
    private final Method isHumanForm;

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

    @SubscribeEvent public void onLivingHurt(LivingHurtEvent event)
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

        if (item ==  ArsenicAndLace.arsenideGoldHoe)
        {
            event.ammount = 6;
        }
        else if (item ==  ArsenicAndLace.arsenideGoldShovel)
        {
            event.ammount = 7;
        }
        else if (item ==  ArsenicAndLace.arsenideGoldPickaxe)
        {
            event.ammount = 8;
        }
        else if (item ==  ArsenicAndLace.arsenideGoldAxe)
        {
            event.ammount = 9;
        }
        else if (item ==  ArsenicAndLace.arsenideGoldSword)
        {
            event.ammount = 10;
        }
    }
}
