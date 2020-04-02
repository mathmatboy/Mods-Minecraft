package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordAxial extends ItemSword{

	public ItemSwordAxial(ToolMaterial mathieu) {
		super(mathieu);
		setCreativeTab(CreativeTabs.tabCombat);

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
