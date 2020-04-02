package ca.mathmatboy.axialcraft.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class GuiBoutonCreatif extends GuiButton
{   
	public GuiBoutonCreatif(int par1, int par2, int par3, int par4, int par5, String str)
	{
	    super(par1, par2, par3, par4, par5, str);
	}
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {
            p_146112_1_.getTextureManager().bindTexture(GuiAdminJoueur.creatif);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = 106;

            if (flag)
            {
                k += this.height;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k, this.width, this.height);
        }
    }

}