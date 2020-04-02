package ca.mathmatboy.axialcraft.bouton;


import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ca.mathmatboy.axialcraft.GUI.GuiAdmin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;

@SideOnly(Side.CLIENT)
public class boutonAdmin extends GuiButton
{
	public static int width;
    public static int height;
    
    
	public boutonAdmin(int id, int xPosition, int yPosition, int grosseurL, int grosseurl, String displayString)
	{		
		super(id, xPosition, yPosition, grosseurL, grosseurl, displayString);
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY)
	{
		super.mouseReleased(mouseX, mouseY);
		Minecraft.getMinecraft().displayGuiScreen(new GuiAdmin());
	}
}