package ca.mathmatboy.axialcraft.handler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ca.mathmatboy.axialcraft.bouton.boutonAdmin;
import ca.mathmatboy.axialcraft.bouton.boutonBoutique;
import ca.mathmatboy.axialcraft.bouton.boutonhome;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;

/*
 * Author code : mathmatboy, dermenslof, Blackout
 */
public class InventoryInitHandler
{
    @SubscribeEvent
public void onGuiInit(InitGuiEvent event)
{
        Minecraft mc = FMLClientHandler.instance().getClient();
        int xOffset = 0;
        if (event.gui instanceof InventoryEffectRenderer)
            xOffset = !mc.thePlayer.getActivePotionEffects().isEmpty() ? 60 : 0;
        int x = (event.gui.width + 176) / 2 + xOffset;
        int y = (event.gui.height - 166) / 2;

    if(event.gui instanceof GuiInventory)
	{
		event.buttonList.add(new boutonBoutique(2, x, y, 70, 20, "Boutique"));
		event.buttonList.add(new boutonAdmin(4, x, y + 20, 70, 20, "Panel Admin"));
	}
	else if(event.gui instanceof GuiChat)
	{
		event.buttonList.add(new boutonhome(3, event.gui.width - 100, event.gui.height - 40, 90, 20, " faction home"));
	}
	else if(event.gui instanceof GuiContainerCreative)
	{
		event.buttonList.add(new boutonBoutique(2, x + 10, y + 20, 70, 20, "Boutique"));
		event.buttonList.add(new boutonAdmin(4, x + 10, y + 40, 70, 20, "Panel Admin"));
	}
 }
}
