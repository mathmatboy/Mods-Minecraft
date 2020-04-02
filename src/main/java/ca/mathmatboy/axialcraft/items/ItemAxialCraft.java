package ca.mathmatboy.axialcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import ca.mathmatboy.axialcraft.common.axialcraftMain;
import ca.mathmatboy.axialcraft.items.armors.ArmorAlliOrPlatine;
import ca.mathmatboy.axialcraft.items.armors.ArmorAxial;
import ca.mathmatboy.axialcraft.items.armors.ArmorAzurite;
import ca.mathmatboy.axialcraft.items.armors.ArmorInvisible;
import ca.mathmatboy.axialcraft.items.armors.ArmorPlatine;
import ca.mathmatboy.axialcraft.items.armors.ArmorRubis;
import ca.mathmatboy.axialcraft.perle.ItemPerleFireResistance;
import ca.mathmatboy.axialcraft.perle.ItemPerleHeal;
import ca.mathmatboy.axialcraft.perle.ItemPerleRegeneration;
import ca.mathmatboy.axialcraft.perle.ItemPerleSpeed;
import ca.mathmatboy.axialcraft.perle.ItemPerleStrength;

public class ItemAxialCraft {
	
	public static void loadItems() 
	{
		axialcraftMain.azurite_ingot = new MineraisAxial().setUnlocalizedName("azurite_ingot").setTextureName(axialcraftMain.MODID + ":azurite_ingot");
		axialcraftMain.azurite_helmet = new ArmorAzurite(axialcraftMain.ArmorAzurite,0, 0).setUnlocalizedName("azurite_helmet").setTextureName(axialcraftMain.MODID + ":azurite_helmet");
		axialcraftMain.azurite_chestplate = new ArmorAzurite(axialcraftMain.ArmorAzurite, 0, 1).setUnlocalizedName("azurite_chestplate").setTextureName(axialcraftMain.MODID + ":azurite_chestplate");
		axialcraftMain.azurite_leggings = new ArmorAzurite(axialcraftMain.ArmorAzurite, 0, 2).setUnlocalizedName("azurite_leggings").setTextureName(axialcraftMain.MODID + ":azurite_leggings");
		axialcraftMain.azurite_boots = new ArmorAzurite(axialcraftMain.ArmorAzurite, 0, 3).setUnlocalizedName("azurite_boots").setTextureName(axialcraftMain.MODID + ":azurite_boots");
		axialcraftMain.azurite_pickaxe = new ItemPickaxeAzurite(axialcraftMain.ToolAzurite).setUnlocalizedName("azurite_pickaxe").setTextureName(axialcraftMain.MODID + ":azurite_pickaxe");
		axialcraftMain.azurite_axe = new ItemAxeAzurite(axialcraftMain.ToolAzurite).setUnlocalizedName("azurite_axe").setTextureName(axialcraftMain.MODID + ":azurite_axe");
		axialcraftMain.azurite_shovel = new ItemSpadeAzurite(axialcraftMain.ToolAzurite).setUnlocalizedName("azurite_shovel").setTextureName(axialcraftMain.MODID + ":azurite_shovel");
		axialcraftMain.azurite_hoe = new ItemHoeAzurite(axialcraftMain.ToolAzurite).setUnlocalizedName("azurite_hoe").setTextureName(axialcraftMain.MODID + ":azurite_hoe");
		axialcraftMain.azurite_sword = new ItemSwordAzurite(axialcraftMain.ToolAzurite).setUnlocalizedName("azurite_sword").setTextureName(axialcraftMain.MODID + ":azurite_sword");
		
		axialcraftMain.rubis_ingot = new MineraisAxial().setUnlocalizedName("rubis_ingot").setTextureName(axialcraftMain.MODID + ":rubis_ingot");
		axialcraftMain.rubis_helmet = new ArmorRubis(axialcraftMain.ArmorRubis,0, 0).setUnlocalizedName("rubis_helmet").setTextureName(axialcraftMain.MODID + ":rubis_helmet");
		axialcraftMain.rubis_chestplate = new ArmorRubis(axialcraftMain.ArmorRubis, 0, 1).setUnlocalizedName("rubis_chestplate").setTextureName(axialcraftMain.MODID + ":rubis_chestplate");
		axialcraftMain.rubis_leggings = new ArmorRubis(axialcraftMain.ArmorRubis, 0, 2).setUnlocalizedName("rubis_leggings").setTextureName(axialcraftMain.MODID + ":rubis_leggings");
		axialcraftMain.rubis_boots = new ArmorRubis(axialcraftMain.ArmorRubis, 0, 3).setUnlocalizedName("rubis_boots").setTextureName(axialcraftMain.MODID + ":rubis_boots");
		axialcraftMain.rubis_pickaxe = new ItemPickaxeRubis(axialcraftMain.ToolRubis).setUnlocalizedName("rubis_pickaxe").setTextureName(axialcraftMain.MODID + ":rubis_pickaxe");
		axialcraftMain.rubis_axe = new ItemAxeRubis(axialcraftMain.ToolRubis).setUnlocalizedName("rubis_axe").setTextureName(axialcraftMain.MODID + ":rubis_axe");
		axialcraftMain.rubis_shovel = new ItemSpadeRubis(axialcraftMain.ToolRubis).setUnlocalizedName("rubis_shovel").setTextureName(axialcraftMain.MODID + ":rubis_shovel");
		axialcraftMain.rubis_hoe = new ItemHoeRubis(axialcraftMain.ToolRubis).setUnlocalizedName("rubis_hoe").setTextureName(axialcraftMain.MODID + ":rubis_hoe");
		axialcraftMain.rubis_sword = new ItemSwordRubis(axialcraftMain.ToolRubis).setUnlocalizedName("rubis_sword").setTextureName(axialcraftMain.MODID + ":rubis_sword");
		
		axialcraftMain.platine_ingot = new MineraisAxial().setUnlocalizedName("platine_ingot").setTextureName(axialcraftMain.MODID + ":platine_ingot");
		axialcraftMain.platine_helmet = new ArmorPlatine(axialcraftMain.ArmorPlatine,0, 0).setUnlocalizedName("platine_helmet").setTextureName(axialcraftMain.MODID + ":platine_helmet");
		axialcraftMain.platine_chestplate = new ArmorPlatine(axialcraftMain.ArmorPlatine, 0, 1).setUnlocalizedName("platine_chestplate").setTextureName(axialcraftMain.MODID + ":platine_chestplate");
		axialcraftMain.platine_leggings = new ArmorPlatine(axialcraftMain.ArmorPlatine, 0, 2).setUnlocalizedName("platine_leggings").setTextureName(axialcraftMain.MODID + ":platine_leggings");
		axialcraftMain.platine_boots = new ArmorPlatine(axialcraftMain.ArmorPlatine, 0, 3).setUnlocalizedName("platine_boots").setTextureName(axialcraftMain.MODID + ":platine_boots");
		axialcraftMain.platine_pickaxe = new ItemPickaxePlatine(axialcraftMain.ToolPlatine).setUnlocalizedName("platine_pickaxe").setTextureName(axialcraftMain.MODID + ":platine_pickaxe");
		axialcraftMain.platine_axe = new ItemAxePlatine(axialcraftMain.ToolPlatine).setUnlocalizedName("platine_axe").setTextureName(axialcraftMain.MODID + ":platine_axe");
		axialcraftMain.platine_shovel = new ItemSpadePlatine(axialcraftMain.ToolPlatine).setUnlocalizedName("platine_shovel").setTextureName(axialcraftMain.MODID + ":platine_shovel");
		axialcraftMain.platine_hoe = new ItemHoePlatine(axialcraftMain.ToolPlatine).setUnlocalizedName("platine_hoe").setTextureName(axialcraftMain.MODID + ":platine_hoe");
		axialcraftMain.platine_sword = new ItemSwordPlatine(axialcraftMain.ToolPlatine).setUnlocalizedName("platine_sword").setTextureName(axialcraftMain.MODID + ":platine_sword");
		
		axialcraftMain.alliage_or_platine_ingot = new MineraisAxial().setUnlocalizedName("alliage_or_platine_ingot").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_ingot");
		axialcraftMain.alliage_or_platine_helmet = new ArmorAlliOrPlatine(axialcraftMain.ArmorAlliOrPlatine,0, 0).setUnlocalizedName("alliage_or_platine_helmet").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_helmet");
		axialcraftMain.alliage_or_platine_chestplate = new ArmorAlliOrPlatine(axialcraftMain.ArmorAlliOrPlatine, 0, 1).setUnlocalizedName("alliage_or_platine_chestplate").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_chestplate");
		axialcraftMain.alliage_or_platine_leggings = new ArmorAlliOrPlatine(axialcraftMain.ArmorAlliOrPlatine, 0, 2).setUnlocalizedName("alliage_or_platine_leggings").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_leggings");
		axialcraftMain.alliage_or_platine_boots = new ArmorAlliOrPlatine(axialcraftMain.ArmorAlliOrPlatine, 0, 3).setUnlocalizedName("alliage_or_platine_boots").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_boots");
		axialcraftMain.alliage_or_platine_pickaxe = new ItemPickaxeAlliOrPlatine(axialcraftMain.ToolAlliOrPlatine).setUnlocalizedName("alliage_or_platine_pickaxe").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_pickaxe");
		axialcraftMain.alliage_or_platine_axe = new ItemAxeAlliOrPlatine(axialcraftMain.ToolAlliOrPlatine).setUnlocalizedName("alliage_or_platine_axe").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_axe");
		axialcraftMain.alliage_or_platine_shovel = new ItemSpadeAlliOrPlatine(axialcraftMain.ToolAlliOrPlatine).setUnlocalizedName("alliage_or_platine_shovel").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_shovel");
		axialcraftMain.alliage_or_platine_hoe = new ItemHoeAlliOrPlatine(axialcraftMain.ToolAlliOrPlatine).setUnlocalizedName("alliage_or_platine_hoe").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_hoe");
		axialcraftMain.alliage_or_platine_sword = new ItemSwordAlliOrPlatine(axialcraftMain.ToolAlliOrPlatine).setUnlocalizedName("alliage_or_platine_sword").setTextureName(axialcraftMain.MODID + ":alliage_or_platine_sword");
		
		axialcraftMain.axial_ingot = new MineraisAxial().setUnlocalizedName("axial_ingot").setTextureName(axialcraftMain.MODID + ":axial_ingot");
		axialcraftMain.axial_helmet = new ArmorAxial(axialcraftMain.ArmorAxial,0, 0).setUnlocalizedName("axial_helmet").setTextureName(axialcraftMain.MODID + ":axial_helmet");
		axialcraftMain.axial_chestplate = new ArmorAxial(axialcraftMain.ArmorAxial, 0, 1).setUnlocalizedName("axial_chestplate").setTextureName(axialcraftMain.MODID + ":axial_chestplate");
		axialcraftMain.axial_leggings = new ArmorAxial(axialcraftMain.ArmorAxial, 0, 2).setUnlocalizedName("axial_leggings").setTextureName(axialcraftMain.MODID + ":axial_leggings");
		axialcraftMain.axial_boots = new ArmorAxial(axialcraftMain.ArmorAxial, 0, 3).setUnlocalizedName("axial_boots").setTextureName(axialcraftMain.MODID + ":axial_boots");
		axialcraftMain.axial_pickaxe = new ItemPickaxeAxial(axialcraftMain.ToolAxial).setUnlocalizedName("axial_pickaxe").setTextureName(axialcraftMain.MODID + ":axial_pickaxe");
		axialcraftMain.axial_axe = new ItemAxeAxial(axialcraftMain.ToolAxial).setUnlocalizedName("axial_axe").setTextureName(axialcraftMain.MODID + ":axial_axe");
		axialcraftMain.axial_shovel = new ItemSpadeAxial(axialcraftMain.ToolAxial).setUnlocalizedName("axial_shovel").setTextureName(axialcraftMain.MODID + ":axial_shovel");
		axialcraftMain.axial_hoe = new ItemHoeAxial(axialcraftMain.ToolAxial).setUnlocalizedName("axial_hoe").setTextureName(axialcraftMain.MODID + ":axial_hoe");
		axialcraftMain.axial_sword = new ItemSwordAxial(axialcraftMain.ToolAxial).setUnlocalizedName("axial_sword").setTextureName(axialcraftMain.MODID + ":axial_sword");
		
		axialcraftMain.Perle_speed = new ItemPerleSpeed().setUnlocalizedName("Perle_speed").setTextureName(axialcraftMain.MODID + ":Perle_speed");
		axialcraftMain.Perle_regeneration = new ItemPerleRegeneration().setUnlocalizedName("Perle_regeneration").setTextureName(axialcraftMain.MODID + ":Perle_regeneration");
		axialcraftMain.Perle_heal = new ItemPerleHeal().setUnlocalizedName("Perle_heal").setTextureName(axialcraftMain.MODID + ":Perle_heal");
		axialcraftMain.Perle_fire_resistance = new ItemPerleFireResistance().setUnlocalizedName("Perle_fire_resistance").setTextureName(axialcraftMain.MODID + ":Perle_fire_resistance");
		axialcraftMain.Perle_strength = new ItemPerleStrength().setUnlocalizedName("Perle_strength").setTextureName(axialcraftMain.MODID + ":Perle_strength");
		
		axialcraftMain.pourdre_platine = new MineraisAxial().setUnlocalizedName("pourdre_platine").setTextureName(axialcraftMain.MODID + ":pourdre_platine");
		axialcraftMain.pizza = new ItemFood(5, 0.6F, true).setUnlocalizedName("pizza").setTextureName(axialcraftMain.MODID + ":pizza").setCreativeTab(CreativeTabs.tabFood);
		axialcraftMain.painEpice = new ItemFood(5, 0.6F, true).setUnlocalizedName("painEpice").setTextureName(axialcraftMain.MODID + ":painEpice").setCreativeTab(CreativeTabs.tabFood);
		
		axialcraftMain.invisible_helmet = new ArmorInvisible(axialcraftMain.Armorinvisible,0, 0).setUnlocalizedName("invisible_helmet").setTextureName(axialcraftMain.MODID + ":invisible_helmet");
		axialcraftMain.invisible_chestplate = new ArmorInvisible(axialcraftMain.Armorinvisible, 0, 1).setUnlocalizedName("invisible_chestplate").setTextureName(axialcraftMain.MODID + ":invisible_chestplate");
		axialcraftMain.invisible_leggings = new ArmorInvisible(axialcraftMain.Armorinvisible, 0, 2).setUnlocalizedName("invisible_leggings").setTextureName(axialcraftMain.MODID + ":invisible_leggings");
		axialcraftMain.invisible_boots = new ArmorInvisible(axialcraftMain.Armorinvisible, 0, 3).setUnlocalizedName("invisible_boots").setTextureName(axialcraftMain.MODID + ":invisible_boots");
	}

}
