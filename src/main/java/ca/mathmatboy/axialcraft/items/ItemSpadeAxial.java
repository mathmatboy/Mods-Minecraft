package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class ItemSpadeAxial extends ItemSpade
{
	public ItemSpadeAxial(ToolMaterial mathieu) 
	{
		super(mathieu);
		setCreativeTab(CreativeTabs.tabTools);

	}
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == axialcraftMain.axial_ingot)
        {
            return true;
        }
        return false;
    }

}
