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

public class ArmorInvisible extends ItemArmor {
	
	public ArmorInvisible(ArmorMaterial armorMaterial, int type, int layer) {
		super(armorMaterial, type, layer);
		setCreativeTab(CreativeTabs.tabCombat);

	}
	
	  
	  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	  {
		  if(slot == 2)
		  {
			  return axialcraftMain.MODID + ":textures/models/armor/invisible_layer_2.png";
		  }
		  return axialcraftMain.MODID + ":textures/models/armor/invisible_layer_1.png";
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

		if(boots.getItem() == axialcraftMain.invisible_boots && legs.getItem() == axialcraftMain.invisible_leggings &&

				chest.getItem() == axialcraftMain.invisible_chestplate && helmet.getItem() == axialcraftMain.invisible_helmet)

		{

			player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), -1, 0)); 

		}

	}

}
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
{
    super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);

    
 par3List.add(EnumChatFormatting.GRAY +"Cette armures permet");
 par3List.add(EnumChatFormatting.GOLD +"d'être invisible !");


    }

}
