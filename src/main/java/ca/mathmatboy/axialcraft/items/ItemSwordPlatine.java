package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordPlatine extends ItemSword{

	public ItemSwordPlatine(ToolMaterial mathieu) {
		super(mathieu);
		setCreativeTab(CreativeTabs.tabCombat);

	}
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == axialcraftMain.platine_ingot)
        {
            return true;
        }
        return false;
    }

}
