package ca.mathmatboy.axialcraft.perle;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemPerleFireResistance extends Item
{
    public ItemPerleFireResistance()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(16);
        setCreativeTab(CreativeTabs.tabFood);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {

        var3.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 400, 2));
        var1.damageItem(1, var3);
        return var1;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack var1)
    {
        return 16;
 
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);

        
     par3List.add(EnumChatFormatting.GOLD +"Cette perle vous donne");
     par3List.add(EnumChatFormatting.GOLD +"6 de la resistance au feu !");


        }
}
