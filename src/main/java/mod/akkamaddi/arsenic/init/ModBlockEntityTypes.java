package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.content.TaintedFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = 
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArsenicAndLace.MODID);
    
    public static RegistryObject<BlockEntityType<TaintedFurnaceBlockEntity>> tainted_furnace
        = BLOCK_ENTITY_TYPES.register("tainted_furnace", 
                () -> BlockEntityType.Builder.of(TaintedFurnaceBlockEntity::new, ModBlocks.tainted_furnace.get())
                .build(null));
    
} // end class
