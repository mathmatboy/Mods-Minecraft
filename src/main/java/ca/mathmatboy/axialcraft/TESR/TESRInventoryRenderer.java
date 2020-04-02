package ca.mathmatboy.axialcraft.TESR;

import org.lwjgl.opengl.GL11;

import ca.mathmatboy.axialcraft.BarSign.TileEntityBarSignSpecialRenderer;
import ca.mathmatboy.axialcraft.FireCamps.TileEntityFireCampsSpecialRenderer;
import ca.mathmatboy.axialcraft.commodeMini.TileEntityCommodeMiniSpecialRenderer;
import ca.mathmatboy.axialcraft.common.axialcraftMain;
import ca.mathmatboy.axialcraft.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TESRInventoryRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,RenderBlocks renderer) 
	{
        if(block == axialcraftMain.commode_mini && metadata == 0)
        {
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityCommodeMiniSpecialRenderer.texture);
            TileEntityCommodeMiniSpecialRenderer.model.renderAll();
            GL11.glPopMatrix();
        }
        else if(block == axialcraftMain.bar_sign && metadata == 0)
        {
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -1.0F, 0.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityBarSignSpecialRenderer.texture);
            TileEntityBarSignSpecialRenderer.model.renderAll();
            GL11.glPopMatrix();
        }
        else if(block == axialcraftMain.fire_camp && metadata == 0)
        {
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -1.0F, 0.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(TileEntityFireCampsSpecialRenderer.texture);
            TileEntityFireCampsSpecialRenderer.model.renderAll();
            GL11.glPopMatrix();
        }
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) 
	{
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
    {

		return true;
	}

	@Override
	public int getRenderId() 
	{
		return ClientProxy.tesrRenderId;
	}

}
