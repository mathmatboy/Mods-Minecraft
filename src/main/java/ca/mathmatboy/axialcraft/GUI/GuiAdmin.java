package ca.mathmatboy.axialcraft.GUI;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiAdmin extends GuiScreen 
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
	
	private GuiTextField message;
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		// important !!!
		Keyboard.enableRepeatEvents(true);
		
		// on calcule nos repères
		setReferences();
		
		message = new GuiTextField(fontRendererObj, guiLeft + 110, guiTop + 140, 100, 20);
		initTextField(message, 70 ,true, true, "Message...", 0xffffff00);
		message.setVisible(true);
		
		
		buttonList.add(new GuiButton(0, guiLeft + xSize - 240, guiTop + 40, 100, 20, "Ban/Kick/Kill..."));
		buttonList.add(new GuiButton(1, guiLeft + xSize - 40, guiTop + 40, 100, 20, "Jour/nuit/pluie...."));
		buttonList.add(new GuiButton(2, guiLeft + xSize - 230, guiTop + 140, 40, 20, "Save"));
		buttonList.add(new GuiButton(3, guiLeft + xSize - 180, guiTop + 140, 40, 20, "Stop"));
		buttonList.add(new GuiButton(4, guiLeft + xSize - 130, guiTop + 140, 40, 20, "Restart"));
		buttonList.add(new GuiButton(5, guiLeft + xSize - 40, guiTop + 165, 50, 20, "Envoyer"));
		
		
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
    	this.message.mouseClicked(mouseX, mouseY, button);
	}
	@Override
	protected void keyTyped(char c, int j)
	{
		//permet décrire
    	super.keyTyped(c, j);
    	this.message.textboxKeyTyped(c, j);
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
		message.drawTextBox();
		
		String title = EnumChatFormatting.RED + "Panel Administratif";
		drawString(fontRendererObj, title, guiLeft + xSize / 2 - getStringWidth(title) / 2, guiTop - 15, 0xffffffff);
		
		String ligne = EnumChatFormatting.WHITE + "---------------------------------------------------";
		drawString(fontRendererObj, ligne, guiLeft + xSize / 2 - getStringWidth(ligne) / 2, guiTop - 0, 0xffffffff);
		
		String CommandJoueur = EnumChatFormatting.UNDERLINE + "Commandes Joueurs";
		drawString(fontRendererObj, CommandJoueur, guiLeft + xSize / 2 - getStringWidth(CommandJoueur) / 2 - 100, guiTop + 20, 0xffffffff);
		
		String CommandMonde = EnumChatFormatting.UNDERLINE + "Commandes Monde";
		drawString(fontRendererObj, CommandMonde, guiLeft + xSize / 2 - getStringWidth(CommandMonde) / 2 + 100, guiTop + 20, 0xffffffff);
		
		String ligne2 = EnumChatFormatting.WHITE + "------------------------------------------";
		drawString(fontRendererObj, ligne2, guiLeft + xSize / 2 - getStringWidth(ligne2) / 2, guiTop + 100, 0xffffffff);
		
		String CommandServ = EnumChatFormatting.UNDERLINE + "Commandes Serveurs";
		drawString(fontRendererObj, CommandServ, guiLeft + xSize / 2 - getStringWidth(CommandServ) / 2 - 70, guiTop + 120, 0xffffffff);
		
		String MessageServ = EnumChatFormatting.UNDERLINE + "Message Serveur";
		drawString(fontRendererObj, MessageServ, guiLeft + xSize / 2 - getStringWidth(MessageServ) / 2 + 70, guiTop + 120, 0xffffffff);

		super.drawScreen(mouseX, mouseY, par3);
	}
	@Override
	protected void actionPerformed(GuiButton button)
	{
		super.actionPerformed(button);
		switch (button.id)
		{
		case 0:
           this.mc.displayGuiScreen(new GuiAdminJoueur());
			break;
		case 1:
	       /// this.mc.displayGuiScreen(new GuiAdminMonde(this));
			break;
		case 2:
			this.mc.thePlayer.sendChatMessage("/save");
			break;
		case 3:
			this.mc.thePlayer.sendChatMessage("/stop");
			break;
		case 4:
			this.mc.thePlayer.sendChatMessage("/restart");
			break;
		case 5:
			this.mc.thePlayer.sendChatMessage("./broadcast " + message.getText() );
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
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
