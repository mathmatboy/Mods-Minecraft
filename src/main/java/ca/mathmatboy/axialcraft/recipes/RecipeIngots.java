package ca.mathmatboy.axialcraft.recipes;

import ca.mathmatboy.axialcraft.common.axialcraftMain;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipeIngots
{
    private Object[][] recipeItems;
    private static final String __OBFID = "CL_00000089";

    public RecipeIngots()
    {
        this.recipeItems = new Object[][] {{axialcraftMain.azurite_block, new ItemStack(axialcraftMain.azurite_ingot, 9)}, {axialcraftMain.rubis_block, new ItemStack(axialcraftMain.rubis_ingot, 9)}, {axialcraftMain.platine_block, new ItemStack(axialcraftMain.platine_ingot, 9)}, {axialcraftMain.alliage_or_platine_block, new ItemStack(axialcraftMain.alliage_or_platine_ingot, 9)}, {axialcraftMain.axial_block, new ItemStack(axialcraftMain.axial_ingot, 9)}};
    }

    /**
     * Adds the ingot recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        for (int var2 = 0; var2 < this.recipeItems.length; ++var2)
        {
            Block var3 = (Block)this.recipeItems[var2][0];
            ItemStack var4 = (ItemStack)this.recipeItems[var2][1];
            par1CraftingManager.addRecipe(new ItemStack(var3), new Object[] {"###", "###", "###", '#', var4});
            par1CraftingManager.addRecipe(var4, new Object[] {"#", '#', var3});
        }

    }
}
