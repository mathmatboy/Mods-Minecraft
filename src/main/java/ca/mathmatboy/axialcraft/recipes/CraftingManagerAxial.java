package ca.mathmatboy.axialcraft.recipes;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingManagerAxial {
	
	public static void loadRecipes()
	{
		new RecipeWeapons().addRecipes(CraftingManager.getInstance());
		new RecipeArmor().addRecipes(CraftingManager.getInstance());
		new RecipeTools().addRecipes(CraftingManager.getInstance());
		new RecipeIngots().addRecipes(CraftingManager.getInstance());
		loadItems();
		loadBlocks();
		loadSmelting();
	}
	
	protected static void loadItems()
	{
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.Perle_speed),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.ender_pearl, 'Y', Items.sugar });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.Perle_regeneration),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.ender_pearl, 'Y', Items.ghast_tear });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.Perle_heal),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.ender_pearl, 'Y', Items.speckled_melon });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.Perle_fire_resistance),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.ender_pearl, 'Y', Items.magma_cream });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.Perle_strength),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.ender_pearl, 'Y', Items.blaze_powder });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.pizza),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.wheat, 'Y', Items.rotten_flesh });
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.painEpice),  new Object[] { 
			"XXX",
			"XYX",
			"XXX",
			'X', Items.wheat, 'Y', Items.cookie });
	}
	
	protected static void loadBlocks() 
	{
		GameRegistry.addShapedRecipe(new ItemStack(axialcraftMain.alliage_or_platine_ingot),  new Object[] { 
			"XXX",
			'X', axialcraftMain.pourdre_platine });
	}
	protected static void loadSmelting()
	{
		GameRegistry.addSmelting(axialcraftMain.platine_ore, new ItemStack(axialcraftMain.pourdre_platine), 0.1F);
		GameRegistry.addSmelting(axialcraftMain.pourdre_platine, new ItemStack(axialcraftMain.platine_ingot), 0.1F);
	}

}
