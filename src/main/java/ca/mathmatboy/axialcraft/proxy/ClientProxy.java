package ca.mathmatboy.axialcraft.proxy;

import ca.mathmatboy.axialcraft.BarSign.TileEntityBarSignSpecialRenderer;
import ca.mathmatboy.axialcraft.BarSign.TileEntityBlockBarSign;
import ca.mathmatboy.axialcraft.FireCamps.TileEntityBlockFireCamps;
import ca.mathmatboy.axialcraft.FireCamps.TileEntityFireCampsSpecialRenderer;
import ca.mathmatboy.axialcraft.TESR.TESRInventoryRenderer;
import ca.mathmatboy.axialcraft.commodeMini.TileEntityBlockCommode;
import ca.mathmatboy.axialcraft.commodeMini.TileEntityCommodeMiniSpecialRenderer;
import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;


public class ClientProxy extends CommonProxy
{
    public static int tesrRenderId;
    @Override
    public void registerRender()
    {
        System.out.println("méthode côté client");
        
        tesrRenderId = RenderingRegistry.getNextAvailableRenderId();
       RenderingRegistry.registerBlockHandler(new TESRInventoryRenderer());
        
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockCommode.class, new TileEntityCommodeMiniSpecialRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockBarSign.class, new TileEntityBarSignSpecialRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockFireCamps.class, new TileEntityFireCampsSpecialRenderer());
    }
    

}