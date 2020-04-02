package ca.mathmatboy.axialcraft.common;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class RenderEventGuiInGame {
	
	private Minecraft mc = FMLClientHandler.instance().getClient();
    ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
    
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderOverlay(RenderGameOverlayEvent.Pre event)
	{
		
	   if(event.type == RenderGameOverlayEvent.ElementType.DEBUG)
	   {
	        event.setCanceled(true); // annule l'affichage normal
	 	   {
	 		   
		        final Minecraft mc;
		        
		        FontRenderer var8 = this.mc.fontRenderer;
		        
		        if (this.mc.gameSettings.showDebugInfo)
		        {
		            this.mc.mcProfiler.startSection("debug");
		            GL11.glPushMatrix();
		            var8.drawStringWithShadow("AxialCraft v1.1 (" + this.mc.debug + ")", 2, 2, 16777215);
		            long var38 = Runtime.getRuntime().maxMemory();
		            long var40 = Runtime.getRuntime().totalMemory();
		            long var39 = Runtime.getRuntime().freeMemory();
		            long var46 = var40 - var39;
		            String var20 = "Used memory: " + var46 * 100L / var38 + "% (" + var46 / 1024L / 1024L + "MB) of " + var38 / 1024L / 1024L + "MB";
		            int var21 = 14737632;
		            this.drawString(var8, var20, event.resolution.getScaledWidth() - var8.getStringWidth(var20) - 2, 2, 14737632);
		            var20 = "Allocated memory: " + var40 * 100L / var38 + "% (" + var40 / 1024L / 1024L + "MB)";
		            this.drawString(var8, var20, event.resolution.getScaledWidth() - var8.getStringWidth(var20) - 2, 12, 14737632);
		            int var22 = MathHelper.floor_double(this.mc.thePlayer.posX);
		            int var23 = MathHelper.floor_double(this.mc.thePlayer.posY);
		            int var24 = MathHelper.floor_double(this.mc.thePlayer.posZ);
		            this.drawString(var8, String.format("Axe X : (%.5f)", new Object[] {Double.valueOf(this.mc.thePlayer.posX), Integer.valueOf(var22), Integer.valueOf(var22 >> 4), Integer.valueOf(var22 & 15)}), 2, 24, 14737632);
		            this.drawString(var8, String.format("Axe Y : (%.3f)", new Object[] {Double.valueOf(this.mc.thePlayer.boundingBox.minY), Double.valueOf(this.mc.thePlayer.posY)}), 2, 32, 14737632);
		            this.drawString(var8, String.format("Axe Z : (%.5f)", new Object[] {Double.valueOf(this.mc.thePlayer.posZ), Integer.valueOf(var24), Integer.valueOf(var24 >> 4), Integer.valueOf(var24 & 15)}), 2, 40, 14737632);
		            int var25 = MathHelper.floor_double((double)(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		            this.drawString(var8, "Direction : " + Direction.directions[var25] + "", 2, 60, 14737632);

		            if (this.mc.theWorld != null && this.mc.theWorld.blockExists(var22, var23, var24))
		            {
		                Chunk var26 = this.mc.theWorld.getChunkFromBlockCoords(var22, var24);
		                this.drawString(var8,"Biome : " + var26.getBiomeGenForWorldCoords(var22 & 15, var24 & 15, this.mc.theWorld.getWorldChunkManager()).biomeName, 2, 72, 14737632);
		            }

		            if (this.mc.entityRenderer != null && this.mc.entityRenderer.isShaderActive())
		            {
		                this.drawString(var8, String.format("shader: %s", new Object[] {this.mc.entityRenderer.getShaderGroup().getShaderGroupName()}), 2, 112, 14737632);
		            }

		            GL11.glPopMatrix();
		            this.mc.mcProfiler.endSection();
		        }
		        else
		        {
		            var8.drawStringWithShadow("(" + this.mc.debug + ")", 2, 2, 16777215);
		        }
		        
		        
		    }
	    }
	}

    public void drawString(FontRenderer p_73731_1_, String p_73731_2_, int p_73731_3_, int p_73731_4_, int p_73731_5_)
    {
        p_73731_1_.drawStringWithShadow(p_73731_2_, p_73731_3_, p_73731_4_, p_73731_5_);
    }

}

