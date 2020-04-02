package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordAzurite extends ItemSword{

	public ItemSwordAzurite(ToolMaterial mathieu) {
		super(mathieu);
		setCreativeTab(CreativeTabs.tabCombat);

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
