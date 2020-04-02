package ca.mathmatboy.axialcraft.register;

import ca.mathmatboy.axialcraft.BarSign.TileEntityBlockBarSign;
import ca.mathmatboy.axialcraft.FireCamps.TileEntityBlockFireCamps;
import ca.mathmatboy.axialcraft.commodeMini.TileEntityBlockCommode;
import ca.mathmatboy.axialcraft.common.axialcraftMain;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlocks {
	
	public static void loadRegister()
	{
		GameRegistry.registerBlock(axialcraftMain.azurite_block, "azurite_block");
		GameRegistry.registerBlock(axialcraftMain.rubis_block, "rubis_block");
		GameRegistry.registerBlock(axialcraftMain.platine_block, "platine_block");
		GameRegistry.registerBlock(axialcraftMain.alliage_or_platine_block, "alliage_or_platine_block");
		GameRegistry.registerBlock(axialcraftMain.axial_block, "axial_block");
		GameRegistry.registerBlock(axialcraftMain.invisible_Block_admin, "invisible_Block_admin");
		GameRegistry.registerBlock(axialcraftMain.azurite_ore, "azurite_ore");
		GameRegistry.registerBlock(axialcraftMain.rubis_ore, "rubis_ore");
		GameRegistry.registerBlock(axialcraftMain.platine_ore, "platine_ore");
		
		GameRegistry.registerBlock(axialcraftMain.commode_mini, "commode_mini");
		GameRegistry.registerTileEntity(TileEntityBlockCommode.class, "commode_mini");
		GameRegistry.registerBlock(axialcraftMain.bar_sign, "bar_sign");
		GameRegistry.registerTileEntity(TileEntityBlockBarSign.class, "bar_sign");
		GameRegistry.registerBlock(axialcraftMain.fire_camp, "fire_camp");
		GameRegistry.registerTileEntity(TileEntityBlockFireCamps.class, "fire_camp");
	}

}
