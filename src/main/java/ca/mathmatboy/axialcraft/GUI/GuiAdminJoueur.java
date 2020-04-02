package ca.mathmatboy.axialcraft.GUI;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiAdminJoueur extends GuiScreen 
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
	private GuiTextField banTemp;
	
	protected static final ResourceLocation creatif = new ResourceLocation("axialcraft:textures/gui/creatif.png");
	protected static final ResourceLocation survival = new ResourceLocation("axialcraft:textures/gui/survival.png");
	protected static final ResourceLocation anonyme = new ResourceLocation("axialcraft:textures/gui/anonyme.png");
	
	@Override
	public void initGui()
	{
		super.initGui();
		
		// important !!!
		Keyboard.enableRepeatEvents(true);
		
		// on calcule nos repères
		setReferences();
		
		pseudo = new GuiTextField(fontRendererObj, guiLeft - 30, guiTop + 53, 72, 15);
		initTextField(pseudo, 70 ,true, false, "", 0xffffff00);
		pseudo.setVisible(true);
		banTemp = new GuiTextField(fontRendererObj, guiLeft - 30, guiTop + 93, 42, 15);
		initTextField(banTemp, 70 ,true, false, "", 0xffffff00);
		banTemp.setVisible(true);
		
		buttonList.add(new GuiButton(0, guiLeft + xSize - 300, guiTop + 30, 40, 20, "Op"));
		buttonList.add(new GuiButton(1, guiLeft + xSize - 255, guiTop + 30, 40, 20, "Deop"));
		buttonList.add(new GuiButton(2, guiLeft + xSize - 300, guiTop + 50, 40, 20, "kick"));
		buttonList.add(new GuiButton(3, guiLeft + xSize - 255, guiTop + 50, 40, 20, "kill"));
		buttonList.add(new GuiButton(4, guiLeft + xSize - 300, guiTop + 70, 40, 20, "Ban"));
		buttonList.add(new GuiButton(5, guiLeft + xSize - 255, guiTop + 70, 40, 20, "Déban"));
		buttonList.add(new GuiButton(6, guiLeft + xSize - 300, guiTop + 90, 86, 20, "temps Ban"));
		
		buttonList.add(new GuiBoutonCreatif(7, guiLeft + xSize - 205, guiTop + 70, 20, 20, ""));
		buttonList.add(new GuiBoutonSurvival(8, guiLeft + xSize - 180, guiTop + 70, 20, 20, ""));
		buttonList.add(new GuiBoutonAnonyme(9, guiLeft + xSize - 155, guiTop + 70, 20, 20, ""));
		
		buttonList.add(new GuiButton(10, guiLeft + xSize - 90, guiTop + 30, 150, 20, EnumChatFormatting.UNDERLINE + "Commandes de Téléportation"));
		buttonList.add(new GuiButton(11, guiLeft + xSize - 0, guiTop + 55, 60, 20, "Whitelist +"));
		buttonList.add(new GuiButton(12, guiLeft + xSize - 90, guiTop + 55, 60, 20, "Whitelist -"));
		buttonList.add(new GuiButton(13, guiLeft + xSize - 0, guiTop + 75, 60, 20, "Whitelist off"));
		buttonList.add(new GuiButton(14, guiLeft + xSize - 90, guiTop + 75, 60, 20, "Whitelist on"));
		
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
    	this.banTemp.mouseClicked(mouseX, mouseY, button);
	}
	@Override
	protected void keyTyped(char c, int j)
	{
		//permet décrire
    	super.keyTyped(c, j);
    	this.pseudo.textboxKeyTyped(c, j);
    	this.banTemp.textboxKeyTyped(c, j);
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
		banTemp.drawTextBox();
		
		String title = EnumChatFormatting.RED + "Panel Administratif";
		drawString(fontRendererObj, title, guiLeft + xSize / 2 - getStringWidth(title) / 2, guiTop - 15, 0xffffffff);
		
		String ligne = EnumChatFormatting.WHITE + "---------------------------------------------------";
		drawString(fontRendererObj, ligne, guiLeft + xSize / 2 - getStringWidth(ligne) / 2, guiTop - 0, 0xffffffff);
		
		String CommandJoueur = EnumChatFormatting.GREEN + "Commandes Joueurs";
		drawString(fontRendererObj, CommandJoueur, guiLeft + xSize / 2 - getStringWidth(CommandJoueur) / 2, guiTop + 10, 0xffffffff);
		
		String ligne2 = EnumChatFormatting.WHITE + "------------------------------------------";
		drawString(fontRendererObj, ligne2, guiLeft + xSize / 2 - getStringWidth(ligne2) / 2, guiTop + 130, 0xffffffff);
		
		String CommandServ = EnumChatFormatting.WHITE + "Pseudonymes...";
		drawString(fontRendererObj, CommandServ, guiLeft + xSize / 2 - getStringWidth(CommandServ) / 2 - 80, guiTop + 35, 0xffffffff);
		
		String temBan = EnumChatFormatting.WHITE + "=>(Ban Temp)";
		drawString(fontRendererObj, temBan, guiLeft + xSize / 2 - getStringWidth(temBan) / 2 - 40, guiTop + 95, 0xffffffff);
		

		super.drawScreen(mouseX, mouseY, par3);
	}
	@Override
	protected void actionPerformed(GuiButton button)
	{
		super.actionPerformed(button);
		switch (button.id)
		{
		case 0:
			this.mc.thePlayer.sendChatMessage("/op" + pseudo.getText());
			break;
		case 1:
			this.mc.thePlayer.sendChatMessage("/deop" + pseudo.getText());
			break;
		case 2:
			this.mc.thePlayer.sendChatMessage("/kick" + pseudo.getText());
			break;
		case 3:
			this.mc.thePlayer.sendChatMessage("/kill" + pseudo.getText());
			break;
		case 4:
			this.mc.thePlayer.sendChatMessage("/ban" + pseudo.getText());
			break;
		case 5:
			this.mc.thePlayer.sendChatMessage("/unban" + pseudo.getText());
			break;
		case 6:
			this.mc.thePlayer.sendChatMessage("/tempban" + pseudo.getText() + banTemp.getText());
			break;
		case 7:
			this.mc.thePlayer.sendChatMessage("/gamemode 1" + pseudo.getText());
			break;
		case 8:
			this.mc.thePlayer.sendChatMessage("/gamemode 0" + pseudo.getText());
			break;
		case 9:
			this.mc.thePlayer.sendChatMessage("/gamemode 2" + pseudo.getText());
			break;
		case 10:
	           this.mc.displayGuiScreen(new GuiAdminTeleportation());
			break;
		case 11:
			this.mc.thePlayer.sendChatMessage("/whitelist add" + pseudo.getText());
			break;
		case 12:
			this.mc.thePlayer.sendChatMessage("/whitelist remove" + pseudo.getText());
			break;
		case 13:
			this.mc.thePlayer.sendChatMessage("/whitelist off");
			break;
		case 14:
			this.mc.thePlayer.sendChatMessage("/whitelist on");
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
