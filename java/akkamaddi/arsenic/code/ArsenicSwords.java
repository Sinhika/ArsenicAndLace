package akkamaddi.arsenic.code;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.content.SimpleSword;

public class ArsenicSwords extends SimpleSword
{
    public ArsenicSwords(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        if (itemID == ArsenicAndLace.arsenicSword.itemID)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 130));
        }

        if (itemID == ArsenicAndLace.arsenideBronzeSword.itemID)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 55));
        }

        if (itemID == ArsenicAndLace.arsenideGoldSword.itemID)
        {
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 80));
        }

        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
}
