package ca.mathmatboy.axialcraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockInvisible extends Block
{
    private static final String __OBFID = "CL_00000317";

    public BlockInvisible()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
    

}