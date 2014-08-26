package akkamaddi.arsenic.code;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArsenicPlate extends BlockBasePressurePlate {
	/** The mob type that can trigger this pressure plate. */
	private EnumMobType triggerMobType;

	protected ArsenicPlate(String par2Str, Material par3Material,
			EnumMobType par4EnumMobType) {
		super(par2Str, par3Material);
		this.triggerMobType = par4EnumMobType;
	}

	/**
	 * Argument is weight (0-15). Return the metadata to be set because of it.
	 */
	protected int func_150066_d(int par1)
	// protected int getMetaFromWeight(int par1)
	{
		return par1 > 0 ? 1 : 0;
	}

	/**
	 * Argument is metadata. Returns power level (0-15)
	 */
	protected int func_150060_c(int par1)
	// protected int getPowerSupply(int par1)
	{
		return par1 == 1 ? 15 : 0;
	}

	/**
	 * Returns the current state of the pressure plate. Returns a value between
	 * 0 and 15 based on the number of items on it.
	 */
	@SuppressWarnings("unchecked")
	@Override
	// protected int getPlateState(World par1World, int par2, int par3, int
	// par4)
	protected int func_150065_e(World par1World, int par2, int par3, int par4) {
		List<Entity> list = null;

		if (this.triggerMobType == EnumMobType.everything) {
			list = par1World.getEntitiesWithinAABBExcludingEntity(
					(Entity) null, this.func_150061_a(par2, par3, par4));
		}

		if (this.triggerMobType == EnumMobType.mobs) {
			list = par1World.getEntitiesWithinAABB(EntityLivingBase.class,
					this.func_150061_a(par2, par3, par4));
		}

		if (this.triggerMobType == EnumMobType.players) {
			list = par1World.getEntitiesWithinAABB(EntityPlayer.class,
					this.func_150061_a(par2, par3, par4));
		}

		if (list != null && !list.isEmpty()) {
			Iterator<Entity> iterator = list.iterator();

			while (iterator.hasNext()) {
				Entity entity = (Entity) iterator.next();

				if (!entity.doesEntityNotTriggerPressurePlate()) {
					return 15;
				}
			}
		}

		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("arsenic" + ":"
				+ (this.getUnlocalizedName().substring(5)));
	}
}
