
package ca.mathmatboy.axialcraft.FireCamps;

import org.lwjgl.opengl.GL11;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityFireCampsSpecialRenderer extends TileEntitySpecialRenderer
{
    public static ModelFireCamp model = new ModelFireCamp();
    public static ResourceLocation texture = new ResourceLocation(axialcraftMain.MODID, "textures/models/blocks/fire_camp.png");
    
    public TileEntityFireCampsSpecialRenderer()
    {
        this.func_147497_a(TileEntityRendererDispatcher.instance);
    }
    
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialRenderTick)
    {
        this.renderTileEntityTutorielAt((TileEntityBlockFireCamps)tile, x, y, z, partialRenderTick);
    }

    private void renderTileEntityTutorielAt(TileEntityBlockFireCamps tile, double x, double y, double z, float partialRenderTick)
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