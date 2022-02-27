package mod.akkamaddi.arsenic.client.gui;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import mod.akkamaddi.arsenic.api.content.client.gui.AbstractTaintedFurnaceScreen;
import mod.akkamaddi.arsenic.content.TaintedFurnaceContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TaintedFurnaceScreen extends AbstractTaintedFurnaceScreen<TaintedFurnaceContainerMenu>
{
    private final static int name_color =  0x0ffffff;

    public TaintedFurnaceScreen(TaintedFurnaceContainerMenu screenMenu, Inventory inv, Component titleIn)
    {
        super(screenMenu, inv, new ResourceLocation(ArsenicAndLace.MODID, "textures/gui/arsenic_furnace_gui"), 
                titleIn, name_color);
    }

} // end class
