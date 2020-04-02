package ca.mathmatboy.axialcraft.GETInfomation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import org.lwjgl.opengl.GL11;

public class GetInformation extends GuiScreen
{
    private ServerData server;
    private int pass;
    private Minecraft mc;
    private byte iconX;
    private int iconY;

    public GetInformation(String ip)
    {
        this.server = new ServerData("axialCraft", ip);
        this.mc = Minecraft.getMinecraft();
    }

    public void getInfo()
    {
        synchronized (ThreadGetInformation.getLock())
        {
            if (ThreadGetInformation.getPending() < 5 && !this.server.field_78841_f)
            {
                this.server.field_78841_f = true;
                this.server.pingToServer = -2L;
                this.server.serverMOTD = "";
                this.server.populationInfo = "";
                ThreadGetInformation.up();
                (new ThreadGetInformation(this.server)).start();
            }
        }

        boolean var1 = this.server.field_82821_f > 61;
        boolean var2 = this.server.field_82821_f < 61;
        boolean var3 = var1 || var2;
        this.iconX = 0;
        System.out.println("[INFO] R\u00e9cup\u00e9ration des informations du serveur.");

        if (var3)
        {
            this.iconY = 5;
        }
        else if (this.server.field_78841_f && this.server.pingToServer != -2L)
        {
            if (this.server.pingToServer < 0L)
            {
                this.iconY = 5;
            }
            else if (this.server.pingToServer < 150L)
            {
                this.iconY = 0;
            }
            else if (this.server.pingToServer < 300L)
            {
                this.iconY = 1;
            }
            else if (this.server.pingToServer < 600L)
            {
                this.iconY = 2;
            }
            else if (this.server.pingToServer < 1000L)
            {
                this.iconY = 3;
            }
            else
            {
                this.iconY = 4;
            }
        }
        else
        {
            this.iconX = 1;
            this.iconY = (int)(Minecraft.getSystemTime() / 100L + 0L & 7L);

            if (this.iconY > 4)
            {
                this.iconY = 8 - this.iconY;
            }
        }
    }

    public void drawIcon(int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(icons);
        this.drawTexturedModalRect(x, y, 0 + this.iconX * 10, 176 + this.iconY * 8, 10, 8);
    }

    public String getMOTD()
    {
        return this.server.serverMOTD;
    }

    public String getVersion()
    {
        return this.server.gameVersion;
    }

    public long getPing()
    {
        return this.server.pingToServer;
    }

    public String getIP()
    {
        return this.server.serverIP;
    }

    public String getplayer()
    {
        return this.server.populationInfo;
    }
}
