package ca.mathmatboy.axialcraft.recipes;


import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesTools;

public class RecipeTools {

    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;
    private static final String __OBFID = "CL_00000096";

	public RecipeTools()
    {
        this.recipeItems = new Object[][] {{axialcraftMain.azurite_ingot, axialcraftMain.rubis_ingot, axialcraftMain.platine_ingot, axialcraftMain.alliage_or_platine_ingot, axialcraftMain.axial_ingot}, {axialcraftMain.azurite_pickaxe, axialcraftMain.rubis_pickaxe, axialcraftMain.platine_pickaxe, axialcraftMain.alliage_or_platine_pickaxe, axialcraftMain.axial_pickaxe}, {axialcraftMain.azurite_shovel, axialcraftMain.rubis_shovel, axialcraftMain.platine_shovel, axialcraftMain.alliage_or_platine_shovel, axialcraftMain.axial_shovel}, {axialcraftMain.azurite_axe, axialcraftMain.rubis_axe, axialcraftMain.platine_axe, axialcraftMain.alliage_or_platine_axe, axialcraftMain.axial_axe}, {axialcraftMain.azurite_hoe, axialcraftMain.rubis_hoe, axialcraftMain.platine_hoe, axialcraftMain.alliage_or_platine_hoe, axialcraftMain.axial_hoe}};
    }
	
    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                par1CraftingManager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', Items.stick, 'X', object});
            }
        }
    }
}