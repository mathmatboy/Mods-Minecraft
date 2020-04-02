package ca.mathmatboy.axialcraft.items.armors;

import java.util.List;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ArmorAxial extends ItemArmor{
	
	public ArmorAxial(ArmorMaterial armorMaterial, int type, int layer) {
		super(armorMaterial, type, layer);
		setCreativeTab(CreativeTabs.tabCombat);

	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == axialcraftMain.axial_ingot)
		return true;
		return false;
	}
	  
	  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	  {
		  if(slot == 2)
		  {
			  return axialcraftMain.MODID + ":textures/models/armor/axial_layer_2.png";
		  }
		  return axialcraftMain.MODID + ":textures/models/armor/axial_layer_1.png";
	  }
	  


public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack)

{

	int parX = (int)player.posX, parY = (int)player.posY, parZ =  (int)player.posZ;

	ItemStack boots = player.getCurrentArmor(0);

	ItemStack legs = player.getCurrentArmor(1);

	ItemStack chest = player.getCurrentArmor(2);

	ItemStack helmet = player.getCurrentArmor(3);



	if(boots != null && legs != null && chest != null && helmet != null)

	{

		if(boots.getItem() == axialcraftMain.axial_boots && legs.getItem() == axialcraftMain.axial_leggings &&

				chest.getItem() == axialcraftMain.axial_chestplate && helmet.getItem() == axialcraftMain.axial_helmet)

		{

			player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), -1, 2)); 

		}

	}

}

public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
{
    super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);

    
 par3List.add(EnumChatFormatting.GOLD +"Cette armures rajoute la ");
 par3List.add(EnumChatFormatting.GOLD +"regeneration a votre vie !");


    }

}
