package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.content.TaintedFurnaceContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMenuTypes
{
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = 
            DeferredRegister.create(ForgeRegistries.CONTAINERS, ArsenicAndLace.MODID);
    
    public static final RegistryObject<MenuType<TaintedFurnaceContainerMenu>> tainted_furnace =
            CONTAINER_TYPES.register("tainted_furnace", 
                    () -> IForgeMenuType.create((windowId, inv, data) 
                            -> new TaintedFurnaceContainerMenu(windowId, data.readBlockPos(), inv, inv.player)));
    
} // end class
