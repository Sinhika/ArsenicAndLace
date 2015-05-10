package akkamaddi.plugins.arsenic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import alexndr.api.content.items.SimpleSword;

public class ArsenicSwords extends SimpleSword
{
    public ArsenicSwords(ToolMaterial enumtoolmaterial)
    {
        super(enumtoolmaterial);
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        if (this == Content.arsenicSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 130));
        }

        if (this == Content.arsenideBronzeSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 55));
        }

        if (this == Content.arsenideGoldSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 80));
        }

        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
}
