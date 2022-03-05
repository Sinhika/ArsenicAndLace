package mod.akkamaddi.arsenic.api.content;

import java.util.Random;

import javax.annotation.Nullable;

import mod.akkamaddi.arsenic.init.ModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractTaintedFurnaceBlock extends BaseEntityBlock
{
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;


    protected AbstractTaintedFurnaceBlock(Properties builder)
    {
        super(builder);
        // Set the default values for our blockstate properties
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
        );
    }

    @Nullable
    public abstract <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState bstate, BlockEntityType<T> entityType);

    @Nullable
    @Override
    public abstract BlockEntity newBlockEntity(BlockPos bpos, BlockState bstate);
    
    protected abstract void openContainer(Level level, BlockPos bpos, Player player);

    /**
     * Called when a player right clicks our block.
     * We use this method to open our gui.
     *
     * @deprecated Call via {@link BlockState#onBlockActivated(World, PlayerEntity, Hand, BlockRayTraceResult)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    public InteractionResult use(final BlockState state, final Level worldIn, final BlockPos pos, final Player player, final InteractionHand handIn, final BlockHitResult hit)
    {
        if (!worldIn.isClientSide)
        {
            this.openContainer(worldIn, pos, player);
        }
        return InteractionResult.SUCCESS;
    } // end onBlockActivated()

    /**
     * Makes the block face the player when placed
     */
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public boolean hasAnalogOutputSignal(BlockState bstate) {
        return true;
     }

    
    @Override
    public int getAnalogOutputSignal(BlockState p_60487_, Level level, BlockPos bpos)
    {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(bpos));
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate.
     * If inapplicable, returns the passed blockstate.
     *
     * @deprecated call via {@link BlockState#rotate(Rotation)} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate.
     * If inapplicable, returns the passed blockstate.
     *
     * @deprecated call via {@link BlockState#mirror(Mirror)} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    /**
     * Called from inside the constructor {@link Block#Block(Properties)} to add all the properties to our blockstate
     */
    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, LIT);
    }

    @Override
    public RenderShape getRenderShape(BlockState bstate) 
    {
        return RenderShape.MODEL;
    }
    
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level, BlockEntityType<T> entityType, 
                                                                BlockEntityType<? extends AbstractTaintedFurnaceBlockEntity> entityTypeE) 
    {
       return level.isClientSide ? null : createTickerHelper(entityType, entityTypeE, AbstractTaintedFurnaceBlockEntity::serverTick);
    }
    
    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
     * of whether the block can receive random update ticks
     */
     @OnlyIn(Dist.CLIENT)
     @Override
     public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand)
     {
         if (stateIn.getValue(LIT))
         {
             double d0 = (double) pos.getX() + 0.5D;
             double d1 = (double) pos.getY();
             double d2 = (double) pos.getZ() + 0.5D;
             if (rand.nextDouble() < 0.1D)
             {
                 worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F,
                         false);
             }
    
             Direction direction = stateIn.getValue(FACING);
             Direction.Axis direction$axis = direction.getAxis();
             // double d3 = 0.52D;
             double d4 = rand.nextDouble() * 0.6D - 0.3D;
             double d5 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d4;
             double d6 = rand.nextDouble() * 6.0D / 16.0D;
             double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d4;
             worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
             worldIn.addParticle(ModParticleTypes.necrotic_flame.get(), d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
         }
     } // end animateTick()
    
    
} // end class
