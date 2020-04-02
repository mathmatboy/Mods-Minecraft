package ca.mathmatboy.axialcraft.common;

import ca.mathmatboy.axialcraft.AntiCheat.AntiCheat;
import ca.mathmatboy.axialcraft.GUI.GuiBoutique;
import ca.mathmatboy.axialcraft.GUI.GuiInGameMenuCustom;
import ca.mathmatboy.axialcraft.GUI.GuiMainMenuCustom;
import ca.mathmatboy.axialcraft.blocks.BlockAxialCraft;
import ca.mathmatboy.axialcraft.blocks.GeneratorOreAxial;
import ca.mathmatboy.axialcraft.handler.InventoryInitHandler;
import ca.mathmatboy.axialcraft.handler.PlayerEventHandler;
import ca.mathmatboy.axialcraft.items.ItemAxialCraft;
import ca.mathmatboy.axialcraft.proxy.CommonProxy;
import ca.mathmatboy.axialcraft.recipes.CraftingManagerAxial;
import ca.mathmatboy.axialcraft.register.RegisterBlocks;
import ca.mathmatboy.axialcraft.register.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.InventoryEffectRenderer;

/*
 * Author mods : mathmatboy
 */
@Mod(modid = axialcraftMain.MODID, version = axialcraftMain.VERSION)
public class axialcraftMain
{
    public static final String MODID = "axialcraft";
    public static final String VERSION = "1.1";
    
	@SidedProxy(clientSide = "ca.mathmatboy.axialcraft.proxy.ClientProxy", serverSide = "ca.mathmatboy.axialcraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	GeneratorOreAxial eventmanager = new GeneratorOreAxial();
	public static axialcraftMain modInstance;
    /**ToolsMaterial*/
	public static ToolMaterial ToolAzurite = EnumHelper.addToolMaterial("ToolAzurite", 3, 1700, 8.0F, 3.3F, 5);
	public static ToolMaterial ToolRubis = EnumHelper.addToolMaterial("ToolRubis", 3, 1800, 8.5F, 3.5F, 7);
	public static ToolMaterial ToolPlatine = EnumHelper.addToolMaterial("ToolPlatine", 3, 1900, 9.0F, 3.7F, 7);
	public static ToolMaterial ToolAlliOrPlatine = EnumHelper.addToolMaterial("ToolAlliOrPlatine", 3, 2200, 10.0F, 3.9F, 7);
	public static ToolMaterial ToolAxial = EnumHelper.addToolMaterial("ToolAxial", 3, 2600, 12.0F, 4.2F, 7);
    /**ArmorMaterial*/
	public static ArmorMaterial ArmorAzurite = EnumHelper.addArmorMaterial("ArmorAzurite", 35, new int[] { 3, 8, 6, 3 }, 8);
	public static ArmorMaterial ArmorRubis = EnumHelper.addArmorMaterial("ArmorRubis", 37, new int[] { 4, 8, 6, 3 }, 8);
	public static ArmorMaterial ArmorPlatine = EnumHelper.addArmorMaterial("ArmorPlatine", 39, new int[] { 3, 8, 7, 3 }, 8);
	public static ArmorMaterial ArmorAlliOrPlatine = EnumHelper.addArmorMaterial("ArmorAlliOrPlatine", 41, new int[] { 4, 8, 7, 3 }, 8);
	public static ArmorMaterial ArmorAxial = EnumHelper.addArmorMaterial("ArmorAxial", 45, new int[] { 4, 8, 7, 4 }, 8);
	public static ArmorMaterial Armorinvisible = EnumHelper.addArmorMaterial("Armorinvisible", 47, new int[] { 4, 9, 7, 4 }, 8);
	
	/**SECTION ITEMS*/
	/**Azurite*/
	public static Item azurite_helmet, azurite_chestplate, azurite_leggings, azurite_boots, azurite_pickaxe, azurite_axe, azurite_shovel, azurite_sword, azurite_hoe, azurite_ingot;
	/**Rubis*/
	public static Item rubis_helmet, rubis_chestplate, rubis_leggings, rubis_boots, rubis_pickaxe, rubis_axe, rubis_shovel, rubis_sword, rubis_hoe, rubis_ingot;
	/**Platine*/
	public static Item platine_helmet, platine_chestplate, platine_leggings, platine_boots, platine_pickaxe, platine_axe, platine_shovel, platine_sword, platine_hoe, platine_ingot;
	/**alliage or platine*/
	public static Item alliage_or_platine_helmet, alliage_or_platine_chestplate, alliage_or_platine_leggings, alliage_or_platine_boots, alliage_or_platine_pickaxe,
	alliage_or_platine_axe, alliage_or_platine_shovel, alliage_or_platine_sword, alliage_or_platine_hoe, alliage_or_platine_ingot;
	/**axial*/
	public static Item axial_helmet, axial_chestplate, axial_leggings, axial_boots, axial_pickaxe, axial_axe, axial_shovel, axial_sword, axial_hoe, axial_ingot;
	/**Autres*/
	public static Item pourdre_platine, pizza, painEpice;
	/**Perles*/
	public static Item Perle_speed, Perle_regeneration, Perle_heal, Perle_fire_resistance, Perle_strength;
	/**invisible ARMOR*/
	public static Item invisible_helmet, invisible_chestplate, invisible_leggings, invisible_boots;
	
	
	/**SECTION BLOCK*/
	/**Azurite*/
	public static Block azurite_block, azurite_ore;
	/**Rubis*/
	public static Block rubis_block, rubis_ore;
	/**Platine*/
	public static Block platine_block, platine_ore;
	/**alliage or platine*/
	public static Block alliage_or_platine_block;
	/**Axial*/
	public static Block axial_block;
	/**Autres*/
	public static Block invisible_Block_admin, pierre_mouvant_block, bar_sign, fire_camp;
	/**Commode mini*/
	public static Block commode_mini;
	
	/**loads Items, Blocks*/
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		ItemAxialCraft.loadItems();
		RegisterItems.loadRegister();
		BlockAxialCraft.loadBlock();
		RegisterBlocks.loadRegister();
		CraftingManagerAxial.loadRecipes();
		GameRegistry.registerWorldGenerator(eventmanager, 0);
		proxy.registerRender();
	}

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Mods axialCraft is loaded !!");
		FMLCommonHandler.instance().bus().register(this);
        FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new InventoryInitHandler());
        
        if(event.getSide().isClient())
        {
        FMLCommonHandler.instance().bus().register(new RenderEventGuiInGame());
        MinecraftForge.EVENT_BUS.register(new RenderEventGuiInGame());
        
        }
	}
    
    
    /**Gui menu*/
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onTickClient(TickEvent.ClientTickEvent event)
	{
		if(event.phase == Phase.END)
		{
			Minecraft mc = Minecraft.getMinecraft();
			GuiScreen currentScreen = mc.currentScreen;
			GuiMainMenuCustom customMenu = new GuiMainMenuCustom();

			if(currentScreen instanceof GuiMainMenu && !currentScreen.equals(customMenu))
			{
				mc.displayGuiScreen(customMenu);
			}
		}
		if(event.phase == Phase.END)
		{
			Minecraft mc = Minecraft.getMinecraft();
			GuiScreen currentScreen = mc.currentScreen;
			GuiInGameMenuCustom customMenu = new GuiInGameMenuCustom();

			if(currentScreen instanceof GuiIngameMenu && !currentScreen.equals(customMenu))
			{
				mc.displayGuiScreen(customMenu);
			}
		}

	}
	

}
