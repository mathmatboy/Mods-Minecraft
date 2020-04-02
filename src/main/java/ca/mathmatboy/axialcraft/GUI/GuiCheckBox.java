package ca.mathmatboy.axialcraft.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCheckBox extends GuiButton
{
	private static ResourceLocation image = new ResourceLocation("axialcraft:textures/gui/boutique.png");
	public boolean isSelected;

	public GuiCheckBox(int par1, int par2, int par3, int par4, int par5, String par6Str)
	{
		super(par1, par2, par3, par4, par5, par6Str);
	}

	/**
	 * Draws this button to the screen.
	 */
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.visible)
		{
			FontRenderer fontrenderer = mc.fontRenderer;
			mc.getTextureManager().bindTexture(image);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.field_146123_n = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			int k = this.getHoverState(this.field_146123_n);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.drawTexturedModalRect(this.xPosition, this.yPosition, 176, 0, 10, 10);
			if (this.isSelected)
				this.drawTexturedModalRect(this.xPosition, this.yPosition, 176 + 10, 0, 10, 10);
			this.mouseDragged(mc, mouseX, mouseY);
			int l = 0xffffff55;

			if (packedFGColour != 0)
			{
				l = packedFGColour;
			}
			else if (!this.enabled)
			{
				l = 10526880;
			}
			else if (this.field_146123_n)
			{
				l = 16777120;
			}

			this.drawString(fontrenderer, this.displayString, this.xPosition + 12, this.yPosition + 0, l);
		}
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
	 * e).
	 */
	public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_)
	{
		boolean isOnButton = this.enabled && this.visible;
		isOnButton = isOnButton && p_146116_2_ >= this.xPosition && p_146116_2_ < this.xPosition + this.width;
		isOnButton = isOnButton && p_146116_3_ >= this.yPosition && p_146116_3_ < this.yPosition + this.height;
		if (isOnButton)
			this.isSelected = !this.isSelected;
		return isOnButton;
	}
}

