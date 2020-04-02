package ca.mathmatboy.axialcraft.recipes;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesArmor;

public class RecipeArmor{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeItems;
    private static final String __OBFID = "CL_00000080";

    public RecipeArmor()
    {
        this.recipeItems = new Object[][] {{axialcraftMain.azurite_ingot, axialcraftMain.rubis_ingot, axialcraftMain.platine_ingot, axialcraftMain.alliage_or_platine_ingot, axialcraftMain.axial_ingot}, {axialcraftMain.azurite_helmet, axialcraftMain.rubis_helmet, axialcraftMain.platine_helmet, axialcraftMain.alliage_or_platine_helmet, axialcraftMain.axial_helmet}, {axialcraftMain.azurite_chestplate, axialcraftMain.rubis_chestplate, axialcraftMain.platine_chestplate, axialcraftMain.alliage_or_platine_chestplate, axialcraftMain.axial_chestplate}, {axialcraftMain.azurite_leggings, axialcraftMain.rubis_leggings, axialcraftMain.platine_leggings, axialcraftMain.alliage_or_platine_leggings, axialcraftMain.axial_leggings}, {axialcraftMain.azurite_boots, axialcraftMain.rubis_boots, axialcraftMain.platine_boots, axialcraftMain.alliage_or_platine_boots, axialcraftMain.axial_boots}};
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                par1CraftingManager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], 'X', object});
            }
        }
    }
}
