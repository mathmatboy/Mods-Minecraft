package ca.mathmatboy.axialcraft.GUI;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*
 * Ce GUI est compatible avec le plugins "ShowCaseStandalone"
 * Author code : mathmatboy and dermenslof.
 * 
 */
@SideOnly(Side.CLIENT)
public class GuiBoutique extends GuiScreen
{
	private static ResourceLocation image = new ResourceLocation("axialcraft:textures/gui/boutique.png");

	/*
	 * position du bord supp�rieur de notre gui
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
	 * millieu de l'�cran sur l'axe horizontal
	 */
	private int middleScreenX;

	/*
	 * millieu de notre �cran sur l'axe vertical
	 */
	private int middleScreenY;

	private GuiTextField tFPrix;
	private GuiTextField tFQuantity;
	private GuiCheckBox[] checkBoxs = new GuiCheckBox[4];

	private RenderItem itemRenderer = new RenderItem();
	private int currentSlot = -1;
	private List<ItemStack> inv = new ArrayList<ItemStack>();

	private String error = null;
	private long timeError = 0;
	private long periodeError = 5000L; // 5 secondes

	@Override
	public void initGui()
	{
		super.initGui();
		
		// important !!!
		Keyboard.enableRepeatEvents(true);
		
		// on calcule nos rep�res
		setReferences();

		// on d�clare nos GuiTextField
		tFPrix = new GuiTextField(fontRendererObj, guiLeft + 10, guiTop + 40, 50, 10);
		tFQuantity = new GuiTextField(fontRendererObj, guiLeft + 10, guiTop + 65, 50, 10);
		initTextField(tFPrix, 7 ,true, true, "0", 0xff00ff00);
		initTextField(tFQuantity, 7 ,true, true, "0", 0xff00ff00);
		tFPrix.setVisible(true);
		tFQuantity.setVisible(true);

		// on d�clare nos boutons
		buttonList.add(new GuiButton(0, middleScreenX - 12, guiTop + 65, 10, 20, "<"));
		buttonList.add(new GuiButton(1, middleScreenX + 2, guiTop + 65, 10, 20, ">"));
		buttonList.add(new GuiButton(2, guiLeft + xSize - 60, guiTop + 75, 50, 20, "Valider"));

		// on d�clare nos CheckBox
		checkBoxs[0] = new GuiCheckBox(3, guiLeft + xSize - 65, guiTop + 30, 50, 10, "vendre");
		checkBoxs[1] = new GuiCheckBox(4, guiLeft + xSize - 65, guiTop + 40, 50, 10, "acheter");
		checkBoxs[2] = new GuiCheckBox(5, guiLeft + xSize - 65, guiTop + 50, 50, 10, "vitrine");
		checkBoxs[3] = new GuiCheckBox(6, guiLeft + xSize - 65, guiTop + 60, 50, 10, "effacer");
		checkBoxs[0].isSelected = true;
		for (GuiButton b : checkBoxs)
			buttonList.add(b);

		// on r�cup�re ce que le joueur � dans son inventaire
		getInv();
	}

	/*
	 * initialise un GuiTextField de mani�re organis�e
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
		
		// on met � jour nos rep�res au cas o� l'�cran a chang� de taille
		setReferences();

		// si il y a une erreur
		if (error != null)
		{
			// si il s'est �coul� periodeError (en milliseconde) on supprime l'erreur 
			if (System.currentTimeMillis() - timeError > periodeError)
				error = null;
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button)
	{
		boolean pFocus = tFPrix.isFocused();
		boolean qFocus = tFQuantity.isFocused();

		super.mouseClicked(mouseX, mouseY, button);
		
		// on redirije le click vers nos GuiTextField
		tFPrix.mouseClicked(mouseX, mouseY, button);
		tFQuantity.mouseClicked(mouseX, mouseY, button);
		
		// si on a cliqu� sur prix et que la valeur est "0" on efface le texte 
		if (!pFocus && tFPrix.isFocused() && tFPrix.getText().equals("0"))
			tFPrix.setText("");
		// si on a cliqu� sur quantit� et que la valeur est "0" on efface le texte
		if (!qFocus && tFQuantity.isFocused() && tFQuantity.getText().equals("0"))
			tFQuantity.setText("");
		// siprix n'a plus le focus et que le texte est vide on met "0"
		if (!tFPrix.isFocused() && tFPrix.getText().equals(""))
			tFPrix.setText("0");
		// si quantit� n'a plus le focus et que le texte est vide on met "0"
		if (!tFQuantity.isFocused() && tFQuantity.getText().equals(""))
			tFQuantity.setText("0");
	}

	@Override
	protected void keyTyped(char c, int val)
	{
		// si aucun de nos GuiTextFiels ne sont focus on appel que le super.keyTyped()
		if (!tFPrix.isFocused() && !tFQuantity.isFocused())
			super.keyTyped(c, val);
		else
		{
			// on envoie les touches au GuiTextField que si c'est num�rique, un point ou un backspace
			if ((c >= '0' && c <= '9') || c == '.'|| val == 14)
			{
				tFPrix.textboxKeyTyped(c, val);
				tFQuantity.textboxKeyTyped(c, val);
			}
		}
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
			drawCenteredString(fontRendererObj, error, middleScreenX, guiTop - 15, 0xffff0000);

		// on charge la texture du gui
		mc.renderEngine.bindTexture(image);
		// on affiche le gui
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		// on dessine nos GuiTextField
		tFPrix.drawTextBox();
		tFQuantity.drawTextBox();
		// on affiche no textes
		String title = EnumChatFormatting.RED + "Boutique";
		drawString(fontRendererObj, title, guiLeft + xSize / 2 - getStringWidth(title) / 2, guiTop + 8, 0xffffffff);
		fontRendererObj.drawStringWithShadow("Prix :", guiLeft + 10, guiTop + 30, 0xffffffff);
		fontRendererObj.drawStringWithShadow("Quantit� :", guiLeft + 10, guiTop + 55, 0xffffffff);

		// si un item est s�l�ctionn� et que l 'inventaire n'est pas vide, on affiche l'item dans le slot
		if (currentSlot >= 0 && inv.size() > 0)
			itemRenderer.renderItemIntoGUI(fontRendererObj, mc.renderEngine, inv.get(currentSlot), middleScreenX - 8, guiTop + 38, false);

		// on affiche une s�paration horizontale pour le reste (peut-�tre � venir)
		drawHorizontalLine(guiLeft + 5, guiLeft + xSize - 5, middleScreenY + 15, 0xff989898);

		super.drawScreen(mouseX, mouseY, par3);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		super.actionPerformed(button);
		switch (button.id)
		{
		// bouton pr�c�dent
		case 0:
			if (currentSlot > -1)
				--currentSlot;
			break;
		//bouton suivant
		case 1:
			if (currentSlot < inv.size() - 1)
				++currentSlot;
			break;
		//bouton valider
		case 2:
			// sera l'id de la checkBoxk s�l�ctionn�e
			int i = 0;
			// on recherche la checkBox s�l�ctionn�e
			for (int j = i; i < 4; ++j)
			{
				i = j;
				if (checkBoxs[j].isSelected)
					break;
			}
			// on r�cup�re le pris dans le GuiTextField
			int prix = getInt(tFPrix);
			// on r�cup�re la quantit� dans le GuiTextField
			int quantity = getInt(tFQuantity);
			// on r�cup�re l'item s�l�ctionn�
			ItemStack is = currentSlot < 0 || inv.size() < 1 ? null : inv.get(currentSlot);

			// on v�rifie si il n'y a pas d'erreur dans les diff�rentes entr�es
			if (!checkEntry(i, quantity, is))
				return;
			
			// on agit en cons�quence
			switch (i)
			{
			// vendre
			case 0:
				System.out.println("cr�ation de la boutique: vente prix: " + prix + " quantit�: " + quantity + " item: " + is.getDisplayName());
				break;
			// acheter
			case 1:
				System.out.println("cr�ation de la boutique: achat prix: " + prix + " quantit�: " + quantity + " item: " + is.getDisplayName());
				break;
			// vitrine
			case 2:
				System.out.println("cr�ation de la boutique: vitrine item: " + is.getDisplayName());
				break;
			// effacer
			case 3:
				System.out.println("suppression de la boutique");
				break;
			}
			break;
		// checkbox vendre
		case 3:
		// checkbox acheter
		case 4:
		// checkbox vitrine
		case 5:
		// checkbox effacer 
		case 6:
			// ici c'est un fix pour �viter que 2 CheckBox ne soient coch�es en m�me temps ou que aucunes ne soient coch�e
			
			// count repr�sentera le nombre de de CheckBox coch�e(s)
			int count = 0;
			// on parcour notre liste de CheckBox
			for (GuiCheckBox cb : checkBoxs)
			{
				// la CheckBox cb est diff�rente de celle sur laquelle on a cliqu�, on la d�coche
				if (cb.id != button.id)
					cb.isSelected = false;
				// si la CheckBox cb est coch�e, on incr�mente count
				if (cb.isSelected)
					count++;
			}
			// si aucune des CheckBox ne sont coch�es, on coche la premi�re (vendre)
			if (count == 0)
				checkBoxs[0].isSelected = true;
			break;
		}
	}

	/*
	 * valide les entr�es de la boutique
	 * 
	 * renvoie true si tout est bon
	 * sinon renvoie false et set un message d'erreur
	 */
	private boolean checkEntry(int type, int quantity, ItemStack is)
	{
		// on enregistre (au cas o�) le temps de l'erreur pour le timer qui affichera l'erreur
		timeError = System.currentTimeMillis();
		// si c'est une vente, un achat ou une vitrine
		if (type < 3)
		{
			// si c'est une vente, on v�rifie qu'il y ait au moins un 1 dans quantity
			if (type == 0 && quantity < 1)
			{
				error = "la quantit� ne peut pas �tre 0";
				return false;
			}
			if (is == null)
			{
				error = "il faut s�l�ctionner un item";
				return false;
			}
		}
		// si c'est une vente on v�rifie que la quantit� demand� est disponnible sur le joueur
		if (type == 0)
		{
			// count sera ne nombre d'item disponnible du m�me type que celui demand�
			int count = 0;
			// on parcour l'inventaire
			for (ItemStack i : inv)
			{
				// si l'item � le m�me nom que celui demand� on incr�mente count
				if (is.getDisplayName().equals(i.getDisplayName()))
					count += i.stackSize;
			}
			// si le nombre d'item disponnible est inf�rieur � celui demand�, on envoie une erreur
			if (count < quantity)
			{
				error = "tu as moins de " + is.getDisplayName() + " sur toi que la quantit� demand�e";
				return false;
			}
		}
		return true;
	}

	/*
	 * renvoie la longeur d'une chaine de caract�re en pixel
	 */
	private int getStringWidth(String str)
	{
		return fontRendererObj.getStringWidth(str);
	}

	/*
	 * met � jour l'inventaire du joueur
	 */
	private void getInv()
	{
		inv.clear();
		for (ItemStack is : mc.thePlayer.inventory.mainInventory)
		{
			if (is != null)
				inv.add(is);
		}
		if (currentSlot >= inv.size())
			currentSlot = inv.size() - 1;
	}

	/*
	 * renvoie le texte d'un GuiTextField de mani�re s�curis�e
	 * 
	 * renvoie 0 en cas d'erreur
	 */
	private int getInt(GuiTextField tf)
	{
		int value = 0;

		try
		{
			value = Integer.parseInt(tf.getText());
		}
		catch (NumberFormatException ex)
		{
			ex.printStackTrace();
		}
		return value;
	}
	
	/*
	 * initialise les rep�res du gui
	 */
	private void setReferences()
	{
		guiTop = (height - ySize) / 2;
		guiLeft = (width - xSize) / 2;
		middleScreenX = width / 2;
		middleScreenY = height / 2;
	}
}
