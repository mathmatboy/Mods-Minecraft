package ca.mathmatboy.axialcraft.blocks;

import java.util.Random;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOreAxial extends Block
{
    private static final String __OBFID = "CL_00000282";

    public BlockOreAxial()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == axialcraftMain.azurite_ore ? axialcraftMain.azurite_ingot : (this == axialcraftMain.rubis_ore ? axialcraftMain.rubis_ingot : Item.getItemFromBlock(this));
    }
}
