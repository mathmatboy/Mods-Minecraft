package ca.mathmatboy.axialcraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ca.mathmatboy.axialcraft.BarSign.BlockBarSign;
import ca.mathmatboy.axialcraft.FireCamps.BlockFireCamps;
import ca.mathmatboy.axialcraft.commodeMini.BlockcommodeMini;
import ca.mathmatboy.axialcraft.common.axialcraftMain;

public class BlockAxialCraft {
	
    public static void loadBlock()
    {
    	axialcraftMain.azurite_block = new BlockAxial().setBlockName("azurite_block").setBlockTextureName(axialcraftMain.MODID + ":azurite_block");
    	axialcraftMain.rubis_block = new BlockAxial().setBlockName("rubis_block").setBlockTextureName(axialcraftMain.MODID + ":rubis_block");
    	axialcraftMain.platine_block = new BlockAxial().setBlockName("platine_block").setBlockTextureName(axialcraftMain.MODID + ":platine_block");
    	axialcraftMain.alliage_or_platine_block = new BlockAxial().setBlockName("alliage_or_platine_block").setBlockTextureName(axialcraftMain.MODID + ":alliage_or_platine_block");
    	axialcraftMain.axial_block = new BlockAxial().setBlockName("axial_block").setBlockTextureName(axialcraftMain.MODID + ":axial_block");
    	axialcraftMain.invisible_Block_admin = new BlockInvisible().setBlockName("invisible_Block_admin").setBlockTextureName(axialcraftMain.MODID + ":invisible_Block");
    	
    	axialcraftMain.azurite_ore = new BlockOreAxial().setBlockName("azurite_ore").setBlockTextureName(axialcraftMain.MODID + ":azurite_ore");
    	axialcraftMain.rubis_ore = new BlockOreAxial().setBlockName("rubis_ore").setBlockTextureName(axialcraftMain.MODID + ":rubis_ore");
    	axialcraftMain.platine_ore = new BlockOreAxial().setBlockName("platine_ore").setBlockTextureName(axialcraftMain.MODID + ":platine_ore");
    	
    	axialcraftMain.commode_mini = new BlockcommodeMini(Material.wood).setHardness(1.5F).setResistance(10.0F).setBlockName("commode_mini").setBlockTextureName(axialcraftMain.MODID + ":commode_mini").setCreativeTab(CreativeTabs.tabBlock);
    	axialcraftMain.bar_sign = new BlockBarSign(Material.wood).setHardness(1.5F).setResistance(10.0F).setBlockName("bar_sign").setBlockTextureName(axialcraftMain.MODID + ":bar_sign").setCreativeTab(CreativeTabs.tabBlock);
    	axialcraftMain.fire_camp = new BlockFireCamps(Material.wood).setHardness(1.5F).setResistance(10.0F).setBlockName("fire_camp").setBlockTextureName(axialcraftMain.MODID + ":fire_camp").setCreativeTab(CreativeTabs.tabBlock);

    	
    }
}
