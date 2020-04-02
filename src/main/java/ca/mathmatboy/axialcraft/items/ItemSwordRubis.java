package ca.mathmatboy.axialcraft.items;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordRubis extends ItemSword{

	public ItemSwordRubis(ToolMaterial mathieu) {
		super(mathieu);
		setCreativeTab(CreativeTabs.tabCombat);

	}
    public boolean getIsRepairable(ItemStack input, ItemStack repair)
    {
        if(repair.getItem() == axialcraftMain.rubis_ingot)
        {
            return true;
        }
        return false;
    }

}
