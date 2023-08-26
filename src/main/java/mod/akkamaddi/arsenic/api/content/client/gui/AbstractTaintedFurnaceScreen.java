package mod.akkamaddi.arsenic.api.content.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;

import mod.akkamaddi.arsenic.api.content.AbstractTaintedFurnaceContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractTaintedFurnaceScreen<T extends AbstractTaintedFurnaceContainer>
        extends AbstractContainerScreen<T>
{
    protected ResourceLocation BACKGROUND_TEXTURE;
    protected int displayNameColor;

    public AbstractTaintedFurnaceScreen(T screenMenu, Inventory inv, ResourceLocation texture, Component titleIn,
            int nameColor)
    {
        super(screenMenu, inv, titleIn);
        BACKGROUND_TEXTURE = texture;
        displayNameColor = nameColor;
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, final int mouseX, final int mouseY, final float partialTicks)
    {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(pGuiGraphics, mouseX, mouseY); // formerly renderHoveredTooltip
    }

    /**
     * Probably corresponds to ContainerScreen.renderLabels() in 1.16.1.
     * Formerly drawGuiContainerForegroundLayer() in 1.15.2.
     * @param matStack
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, final int mouseX, final int mouseY)
    {
        // Copied from AbstractFurnaceScreen#drawGuiContainerForegroundLayer
        String s = this.title.getString();
        pGuiGraphics.drawString(this.font, s, (float) (this.imageWidth / 2 - this.font.width(s) / 2), 6.0F, displayNameColor, false);
        pGuiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), 8.0F, 
                             (float) (this.imageHeight - 96 + 2), displayNameColor, false);
    }

    /**
     * Corresponds to AbstractFurnaceScreen.renderBg() in 1.16.1.
     * Formerly drawGuiContainerBackgroundLayer() in 1.15.2
     * @param matStack
     * @param partialTicks
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, final float partialTicks, final int mouseX, final int mouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.BACKGROUND_TEXTURE);

        int startX = this.leftPos;
        int startY = this.topPos;
    
        // Screen#blit draws a part of the current texture (assumed to be 256x256) to the screen
        // The parameters are (stack, x, y, u, v, width, height)
    
        pGuiGraphics.blit(this.BACKGROUND_TEXTURE, startX, startY, 0, 0, this.imageWidth, this.imageHeight);
    
        if (this.menu.getBurnProgress() > 0) {
            // Draw progress arrow
            int arrowWidth = getSmeltTimeScaled();
            pGuiGraphics.blit(this.BACKGROUND_TEXTURE, startX + 79, startY + 34, 176, 14, arrowWidth, 14);
        }
        if (this.menu.isLit()) {
            // Draw flames
            int flameHeight = getFuelBurnTimeScaled();
            pGuiGraphics.blit(this.BACKGROUND_TEXTURE, startX + 56, startY + 50 - flameHeight, 176, 14 - flameHeight,14, flameHeight);
        }
    }

    private int getSmeltTimeScaled()
    {
        return this.menu.getBurnProgress();
    }

    private int getFuelBurnTimeScaled()
    {
        return this.menu.getLitProgress();    
    }
    
} // end class
