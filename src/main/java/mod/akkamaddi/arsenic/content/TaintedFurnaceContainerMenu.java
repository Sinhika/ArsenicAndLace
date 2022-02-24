package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.api.content.AbstractTaintedFurnaceContainer;
import mod.akkamaddi.arsenic.init.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

public class TaintedFurnaceContainerMenu extends AbstractTaintedFurnaceContainer
{

    public TaintedFurnaceContainerMenu(int id, BlockPos pos, Inventory playerInventory, Player player)
    {
        super(ModMenuTypes.tainted_furnace.get(), id, pos, playerInventory, player);
    }

} // end class
