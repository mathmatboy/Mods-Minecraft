package ca.mathmatboy.axialcraft.GUI;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiAdminTeleportation extends GuiScreen 
{

	/*
	 * position du bord suppérieur de notre gui
	 */
	private int guiTop;

	/*
	 * position du bord gauche de notre gui
	 */
	private int guiLeft;

	/*
	 *  largeur de notre gui
	 */
	private int xSize = 176;

	/*
	 * hauteur de notre gui
	 */
	private int ySize = 166;

	/*
	 * millieu de l'écran sur l'axe horizontal
	 */
	private int middleScreenX;

	/*
	 * millieu de notre écran sur l'axe vertical
	 */
	private int middleScreenY;
	
	private String error = null;
	private long timeError = 0;
	private long periodeError = 5000L; // 5 secondes
	
	private GuiTextField pseudo;
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		// important !!!
		Keyboard.enableRepeatEvents(true);
		
		// on calcule nos repères
		setReferences();
		
		pseudo = new GuiTextField(fontRendererObj, guiLeft + 50, guiTop + 40, 72, 15);
		initTextField(pseudo, 70 ,true, false, "", 0xffffff00);
		pseudo.setVisible(true);
		
		buttonList.add(new GuiButton(0, guiLeft + xSize - 200, guiTop + 30, 45, 20, "tp"));
		buttonList.add(new GuiButton(1, guiLeft + xSize - 20, guiTop + 30, 45, 20, "tpa"));
		buttonList.add(new GuiButton(2, guiLeft + xSize - 200, guiTop + 50, 45, 20, "tphere"));
		buttonList.add(new GuiButton(3, guiLeft + xSize - 20, guiTop + 50, 45, 20, "tpahere"));
		buttonList.add(new GuiButton(4, guiLeft + xSize - 113, guiTop + 70, 45, 20, "tpall"));
		
	}
	/*
	 * initialise un GuiTextField de manière organisée
	 */
	private void initTextField(GuiTextField obj, int size, boolean bg, boolean focus, String text, int color)
	{
		// limite du texte
		obj.setMaxStringLength(size);
		// active le font noir et les bordure
		obj.setEnableBackgroundDrawing(bg);
		// peut perdre le focus ?
		obj.setCanLoseFocus(true);
		// couleur du texte
		obj.setTextColor(color);
		// text par defaut
		obj.setText(text);
	}
	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
		
		// important !!!
		Keyboard.enableRepeatEvents(false);
	}
	@Override
	public void updateScreen()
	{
		super.updateScreen();
		
		// on met à jour nos repères au cas où l'écran a changé de taille
		setReferences();
		
		// si il y a une erreur
		if (error != null)
		{
			// si il s'est écoulé periodeError (en milliseconde) on supprime l'erreur 
			if (System.currentTimeMillis() - timeError > periodeError)
				error = null;
		}
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button)
	{
    	super.mouseClicked(mouseX, mouseY, button);
    	this.pseudo.mouseClicked(mouseX, mouseY, button);

	}
	@Override
	protected void keyTyped(char c, int j)
	{
		//permet décrire
    	super.keyTyped(c, j);
    	this.pseudo.textboxKeyTyped(c, j);

	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float par3)
	{
	
		// on affiche un voile noir sur tout l'ecran
		drawDefaultBackground();
		
		// on set la couleur d'eclairage blanc opaque
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		// si il y a une erreur, on l'affiche
		if (error != null)
			drawCenteredString(fontRendererObj, error, middleScreenX, guiTop - 25, 0xffff0000);
		
		// on dessine nos GuiTextField
		pseudo.drawTextBox();
		
		String title = EnumChatFormatting.RED + "Panel Administratif";
		drawString(fontRendererObj, title, guiLeft + xSize / 2 - getStringWidth(title) / 2, guiTop - 15, 0xffffffff);
		
		String ligne = EnumChatFormatting.WHITE + "---------------------------------------------------";
		drawString(fontRendererObj, ligne, guiLeft + xSize / 2 - getStringWidth(ligne) / 2, guiTop - 0, 0xffffffff);
		
		String CommandJoueur = EnumChatFormatting.GREEN + "Commande de Téléportation";
		drawString(fontRendererObj, CommandJoueur, guiLeft + xSize / 2 - getStringWidth(CommandJoueur) / 2, guiTop + 10, 0xffffffff);
		
		String CommandServ = EnumChatFormatting.WHITE + "Pseudonymes...";
		drawString(fontRendererObj, CommandServ, guiLeft + xSize / 2 - getStringWidth(CommandServ) / 2 , guiTop + 25, 0xffffffff);
		
		String ligne2 = EnumChatFormatting.WHITE + "------------------------------------------";
		drawString(fontRendererObj, ligne2, guiLeft + xSize / 2 - getStringWidth(ligne2) / 2, guiTop + 130, 0xffffffff);
		
		
		super.drawScreen(mouseX, mouseY, par3);
	}
	@Override
	protected void actionPerformed(GuiButton button)
	{
		super.actionPerformed(button);
		switch (button.id)
		{
		case 0:
			this.mc.thePlayer.sendChatMessage("/tp" + pseudo.getText());
			break;
		case 1:
			this.mc.thePlayer.sendChatMessage("/tpa" + pseudo.getText());
			break;
		case 2:
			this.mc.thePlayer.sendChatMessage("/tphere" + pseudo.getText());
			break;
		case 3:
			this.mc.thePlayer.sendChatMessage("/tpahere" + pseudo.getText());
			break;
		case 4:
			this.mc.thePlayer.sendChatMessage("/tpall" + pseudo.getText());
			break;
		}
		
	}
	
	
	/*
	 * renvoie la longeur d'une chaine de caractère en pixel
	 */
	private int getStringWidth(String str)
	{
		return fontRendererObj.getStringWidth(str);
	}
	
	/*
	 * initialise les repères du gui
	 */
	private void setReferences()
	{
		guiTop = (height - ySize) / 2;
		guiLeft = (width - xSize) / 2;
		middleScreenX = width / 2;
		middleScreenY = height / 2;
	}
}
