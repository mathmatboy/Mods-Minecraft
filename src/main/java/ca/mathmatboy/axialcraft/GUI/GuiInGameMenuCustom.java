package ca.mathmatboy.axialcraft.GUI;

import java.awt.Desktop;
import java.awt.Menu;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiInGameMenuCustom extends GuiScreen
{
    private float field_147048_u;
    private float field_147047_v;
    private int field_146445_a;
    private int field_146444_f;
    private static final ResourceLocation logo = new ResourceLocation("textures/gui/logo.png");
    private static final String __OBFID = "CL_00000703";

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        boolean var1 = true;
        boolean var2 = true;
        this.buttonList.add(new GuiButton(1, this.width / 8 - 47, this.height - 50, 95, 20, StatCollector.translateToLocal("Retour a l'accueil")));

        if (!this.mc.isIntegratedServerRunning())
        {
            ((GuiButton)this.buttonList.get(0)).displayString = StatCollector.translateToLocal("Se Deconnecter");
        }

        int var3 = this.height / 4 + 48;
        this.buttonList.add(new GuiButton(4, this.width / 8 - 47, this.height / 5, 95, 20, I18n.format("Quitter le menu", new Object[0])));
        this.buttonList.add(new GuiButton(5, this.width / 8 - 47, this.height - 110, 95, 20, I18n.format("Success", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 8 - 47, this.height - 80, 95, 20, I18n.format("Options", new Object[0])));
        this.buttonList.add(new GuiButton(10, this.width / 8 - 47, this.height / 2 - 45, 95, 20, I18n.format("Teamspeak", new Object[0])));
        this.buttonList.add(new GuiButton(11, this.width / 8 - 47, this.height / 2 - 20, 95, 20, I18n.format("Site", new Object[0])));
    }

    protected void actionPerformed(GuiButton par1GuiButton)
    {
        String obj;
        Session session = GuiInGameMenuCustom.this.mc.getSession();
        URI var7;
        switch (par1GuiButton.id)
        {
            case 0:
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;

            case 1:
                par1GuiButton.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld((WorldClient)null);
                this.mc.displayGuiScreen(new GuiMainMenu());

            case 2:
            case 3:
            case 8:
            case 9:
            default:
                break;

            case 4:
                this.mc.displayGuiScreen((GuiScreen)null);
                this.mc.setIngameFocus();
                break;

            case 5:
                this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
                break;

            case 6:
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
                break;

            case 7:
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;

            case 10:
            {
            	Desktop desktop = null;
            	java.net.URI url;
            	try {
            		url = new java.net.URI("ts3server://SERVER_IP/?&nickname=" + session.getUsername());
            		if (Desktop.isDesktopSupported())
            		{
            			desktop = Desktop.getDesktop();
            			desktop.browse(url);
            		}
            	}
            	catch (Exception ex) {
            	}
            }
            	break;

            case 11:
            {
                try
                {
                    var7 = new URI("http://axialcraft.franceserv.com/accueil/");

                    if (Desktop.isDesktopSupported())
                    {
                        Desktop.getDesktop().browse(var7);
                    }
                }
                catch (Exception var4)
                {
                    var4.printStackTrace();
                }
            }
                break;
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        ++this.field_146444_f;
    }

    public void drawLogo()
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.mc.getTextureManager().bindTexture(logo);
        this.drawTexturedModalRectWithOptionnalSize(this.width / 2 - 45, 40, 0, 0, 95, 90, 95, 90);
    }

    public void drawTexturedModalRectWithOptionnalSize(int x, int y, int u, int v, int width, int height, int uSize, int vSize)
    {
        float scaledX = 1.0F / (float)uSize;
        float scaledY = 1.0F / (float)vSize;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.draw();
    }

    public static void drawPlayerOnGui(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par1, (float)par2, 100.0F);
        GL11.glScalef((float)(-par3), (float)par3, (float)par3);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float var6 = par0Minecraft.thePlayer.renderYawOffset;
        float var7 = par0Minecraft.thePlayer.rotationYaw;
        float var8 = par0Minecraft.thePlayer.rotationPitch;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par5 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par0Minecraft.thePlayer.renderYawOffset = (float)Math.atan((double)(par4 / 40.0F)) * 20.0F;
        par0Minecraft.thePlayer.rotationYaw = (float)Math.atan((double)(par4 / 40.0F)) * 40.0F;
        par0Minecraft.thePlayer.rotationPitch = -((float)Math.atan((double)(par5 / 40.0F))) * 20.0F;
        par0Minecraft.thePlayer.rotationYawHead = par0Minecraft.thePlayer.rotationYaw;
        GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        par0Minecraft.thePlayer.renderYawOffset = var6;
        par0Minecraft.thePlayer.rotationYaw = var7;
        par0Minecraft.thePlayer.rotationPitch = var8;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        drawRect(0, 0, this.width / 4, this.height, -1728053248);
        String var4 = EnumChatFormatting.GOLD + "Bienvenue sur AxialCraft " + this.mc.getSession().getUsername() + ", que d\u00e9sirez-vous faire ?";
        String var5 = "\u00a7nMenu Principal";
        this.drawString(this.fontRendererObj, var5, this.width / 7 - this.fontRendererObj.getStringWidth(var4) / 6, this.height / 8, -1);
        this.drawString(this.fontRendererObj, var4, this.width / 2 - this.fontRendererObj.getStringWidth(var4) / 2, 4, -1);
        drawPlayerOnGui(this.mc, this.width / 2 - 0, this.height - 40, 60, (float)(this.width / 2 + 51) - (float)par1, (float)(this.height + 0 - 100) - (float)par2);
        String s1 = "Dev MathMatBoy.";
        this.drawString(this.fontRendererObj, s1, this.width - this.fontRendererObj.getStringWidth(s1) -2, this.height - 10, -100);
        super.drawScreen(par1, par2, par3);
    }
}
