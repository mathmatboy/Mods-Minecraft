
package ca.mathmatboy.axialcraft.commodeMini;

import org.lwjgl.opengl.GL11;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityCommodeMiniSpecialRenderer extends TileEntitySpecialRenderer
{
    public static ModelcommodeMini model = new ModelcommodeMini();
    public static ResourceLocation texture = new ResourceLocation(axialcraftMain.MODID, "textures/models/blocks/commode_mini.png");
    
    public TileEntityCommodeMiniSpecialRenderer()
    {
        this.func_147497_a(TileEntityRendererDispatcher.instance);
    }
    
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick)
    {
        this.renderTileEntityTutorielAt((TileEntityBlockCommode)tile, x, y, z, partialRenderTick);
    }

    private void renderTileEntityTutorielAt(TileEntityBlockCommode tile, double x, double y, double z, float partialRenderTick)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef((90F * tile.getDirection()) + 180F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}