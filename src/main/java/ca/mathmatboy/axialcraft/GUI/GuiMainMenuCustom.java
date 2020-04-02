package ca.mathmatboy.axialcraft.GUI;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Random;

import net.minecraft.client.renderer.texture.TextureManager;

import org.lwjgl.opengl.GL11;

import ca.mathmatboy.axialcraft.API.ApiInfo;
import ca.mathmatboy.axialcraft.GETInfomation.GetInformation;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;

public class GuiMainMenuCustom extends GuiScreen
{
    private static final Random rand = new Random();
    BufferedReader buffer = null;
    FileOutputStream fos = null;
    InputStream is = null;
    private BufferedImage buffered;
    private String text;
    private int textPosition;
    net.minecraft.util.ResourceLocation bg;
    net.minecraft.util.ResourceLocation logo;
    private float updateCounter;
    private String field_92025_p;
	private ApiInfo info;
    private GetInformation infoping;
    private ApiInfo infos = new ApiInfo("axialcraft", "play.epicube.fr");
    String motd = infos.getMOTD();
    String serverName = infos.getName();
    String version = infos.getVersion();
    String population = infos.getPopulation();
    long ping = infos.getPing();
    boolean acceptedTexture = infos.getAcceptedTextures();
    public void initGui()
    {
        System.out.println("initialisation du menu >> By mathmatboy");
        this.bg = new net.minecraft.util.ResourceLocation("axialcraft", "textures/gui/bk.png");
        
        this.infoping = new GetInformation("play.epicube.fr");//
        this.infoping.getInfo();
        
        Object var1 = null;
        this.updateCounter = rand.nextFloat();
        this.field_92025_p = "";
        try
        {
            this.text = readFile("http://mathmatboy.franceserv.com/launcheraxialcraft/annonce.txt")    .replace("&2", "§2")
            	    .replace("&3", "§3")
            	    .replace("&4", "§4")
            	    .replace("&5", "§5")
            	    .replace("&6", "§6")
            	    .replace("&7", "§7")
            	    .replace("&8", "§8")
            	    .replace("&9", "§9")
            	    .replace("&a", "§a")
            	    .replace("&b", "§b")
            	    .replace("&c", "§c")
            	    .replace("&l", "§l")
            	    .replace("&k", "§k")
            	    .replace("&k", "§k")
            	    .replace("&r", "§r")
            	    .replace("&f", "§f")
            	    .replace("{USERNAME}", "" + 
            	    		 "\u00a7l\u00a7n" + this.mc.getSession().getUsername());
        }
        catch (Exception var3)
        {
            ;
        }
        this.buttonList.add(new GuiButton(0, this.width / 2 - 195, this.height - 90, 95, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 195, this.height - 65, 95, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 195, this.height - 115, 95, 20, I18n.format("Solo", new Object[0])));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 195, this.height - 140, 95, 20, I18n.format("TeamSpeak", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 195, this.height - 165, 95, 20, I18n.format("Join Server :)", new Object[0])));
    }

    private void connectToServer(ServerData par1ServerData)
    {
        this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, par1ServerData));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        URI var7;
        if (par1GuiButton.id == 0)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (par1GuiButton.id == 1)
        {
            this.mc.shutdown();
        }

        if (par1GuiButton.id == 2)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (par1GuiButton.id == 3)
        {
            try
            {
                var7 = new URI("http://google.fr");

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

        if (par1GuiButton.id == 4)
        {
        	FMLClientHandler.instance().setupServerList();
        	FMLClientHandler.instance().connectToServer(this, new ServerData("fallfight", "77.111.249.195:25565"));
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (this.textPosition < 0 - this.mc.fontRenderer.getStringWidth(this.text))
        {
            this.textPosition = this.width / 2 + 220;
        }

        this.textPosition -= 2;
    }
    public void drawBackground()
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
        this.mc.getTextureManager().bindTexture(bg);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)this.height, 0.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)this.width, (double)this.height, 0.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)this.width, 0.0D, 0.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.draw();
        drawRect(0, 0, this.width, 12, -1728053248);// texte en haut
        drawRect(0, this.height - 14, this.width, this.height, -1728053248);// en bas txt
        drawRect(this.width / 2 - 200, this.height - 220, this.width / 2 - 95, this.height - 35, -1728053248);
        
        drawRect(this.width / 2 - 180, this.height - 200, this.width / 2 - 115, this.height - 185, 653648127);//653648127
    }
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawBackground();
       // this.infoping.drawIcon(this.width / 2 - 25, this.height - 19 + 11);
       // this.drawString(this.fontRendererObj, this.infoping.getplayer().toString(), this.width / 2 - 5, this.height - 149 + 12, 0);
        //this.drawPing();
        this.drawString(this.fontRendererObj, EnumChatFormatting.WHITE + this.text, this.textPosition, 2, 12128795);
        String var9 = "AxialCraft v1.0 by" + EnumChatFormatting.RED + " mathmatboy :)";
        this.drawString(this.fontRendererObj, var9, 2, this.height - 10, 16777215);
        super.drawScreen(par1, par2, par3);
    }
    
    public void drawPing()
    {
        int middleX = this.width / 6 - 4;
        int middleY = this.height / 2;
        int titleLen = this.fontRendererObj.getStringWidth("§4" + infos.getName() + "§r " + infos.getVersion());
        int populationLen = this.fontRendererObj.getStringWidth(infos.getMOTD());
        titleLen = titleLen > populationLen ? titleLen : populationLen;
        boolean icon = true;
        int pingLen = this.fontRendererObj.getStringWidth(infos.getPing() + "ms") + (icon ? 12 : 0);

        this.drawCenteredString(this.fontRendererObj, infos.getMOTD(), middleX, middleY - 60, 0xffffff);
        this.drawString(this.fontRendererObj, infos.getPopulation(), middleX - titleLen / 2, middleY - 75, 0xffffff);
        infos.drawIconPing(this, middleX + titleLen / 2 - 30- pingLen, middleY - 75, icon);
    }

    public void drawTexturedModalRectWithOptionnalSize(int x, int y, int u, int v, int width, int height)
    {
        Tessellator tessellator = Tessellator.instance;
        float scaledX = 1.0F / (float)width;
        float scaledY = 1.0F / (float)height;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.draw();
    }

    public void drawTexturedModalRectWithOptionnalSize(int x, int y, int u, int v, int width, int height, int uSize, int vSize)
    {
        Tessellator tessellator = Tessellator.instance;
        float scaledX = 1.0F / (float)uSize;
        float scaledY = 1.0F / (float)vSize;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + height) * scaledY));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(u + width) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * scaledX), (double)((float)(v + 0) * scaledY));
        tessellator.draw();
    }

    private static String readFile(String url)
    {
        String text = "";

        try
        {
            URL e = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(e.openStream()));
            text = in.readLine();
            return text;
        }
        catch (Exception var4)
        {
            System.out.println("error while reading news");
            return "Connexion aux nouvelle echoue...";
        }
    }

    public static String getHTML(String urlToRead)
    {
        String result = "";

        try
        {
            URL e = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection)e.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            String line;

            for (rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); (line = rd.readLine()) != null; result = result + line)
            {
                ;
            }

            rd.close();
            return result;
        }
        catch (Exception var6)
        {
            System.out.println("error while reading online player");
            return "?";
        }
    }



    static BufferedImage access$102(GuiMainMenuCustom x0, BufferedImage x1)
    {
        return x0.buffered = x1;
    }
}
