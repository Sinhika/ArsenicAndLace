package mod.akkamaddi.arsenic.content;

import mod.akkamaddi.arsenic.api.content.AbstractTaintedFurnaceBlockEntity;
import mod.akkamaddi.arsenic.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class TaintedFurnaceBlockEntity extends AbstractTaintedFurnaceBlockEntity
{

    public TaintedFurnaceBlockEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModBlockEntityTypes.tainted_furnace.get(), blockpos, blockstate, RecipeType.SMELTING);
    }

}
