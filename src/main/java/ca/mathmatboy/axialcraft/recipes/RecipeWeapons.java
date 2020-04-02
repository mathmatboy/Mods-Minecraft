package ca.mathmatboy.axialcraft.recipes;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesWeapons;

public class RecipeWeapons {
    private String[][] recipePatterns = new String[][] {{"X", "X", "#"}};
    private Object[][] recipeItems;
    private static final String __OBFID = "CL_00000097";

    public RecipeWeapons()
    {
        this.recipeItems = new Object[][] {{axialcraftMain.azurite_ingot, axialcraftMain.rubis_ingot, axialcraftMain.platine_ingot, axialcraftMain.alliage_or_platine_ingot, axialcraftMain.axial_ingot}, {axialcraftMain.azurite_sword, axialcraftMain.rubis_sword, axialcraftMain.platine_sword, axialcraftMain.alliage_or_platine_sword, axialcraftMain.axial_sword}};
    }

    /**
     * Adds the weapon recipes to the CraftingManager.
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
