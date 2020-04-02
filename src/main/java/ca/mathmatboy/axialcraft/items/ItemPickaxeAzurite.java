package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxeAzurite extends ItemPickaxe {

	public ItemPickaxeAzurite(ToolMaterial mathieu) 
	{
		super(mathieu);
		setCreativeTab(CreativeTabs.tabTools);
	}
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == axialcraftMain.azurite_ingot)
        {
            return true;
        }
        return false;
    }

}
