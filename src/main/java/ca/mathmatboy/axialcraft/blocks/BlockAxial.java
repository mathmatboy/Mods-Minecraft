package ca.mathmatboy.axialcraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class BlockAxial extends Block {

	public BlockAxial() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(7.0F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
	}

}
