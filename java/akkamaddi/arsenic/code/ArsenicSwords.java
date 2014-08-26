package akkamaddi.arsenic.code;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import alexndr.SimpleOres.api.content.SimpleSword;

public class ArsenicSwords extends SimpleSword
{
    public ArsenicSwords(ToolMaterial enumtoolmaterial)
    {
        super(enumtoolmaterial);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        if (this == ArsenicAndLace.arsenicSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 130));
        }

        if (this == ArsenicAndLace.arsenideBronzeSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 55));
        }

        if (this == ArsenicAndLace.arsenideGoldSword)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 80));
        }

        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
}
