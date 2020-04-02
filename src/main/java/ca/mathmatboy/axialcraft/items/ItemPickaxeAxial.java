package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxeAxial extends ItemPickaxe {

	public ItemPickaxeAxial(ToolMaterial mathieu) 
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
