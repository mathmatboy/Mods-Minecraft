package ca.mathmatboy.axialcraft.API;

import java.net.UnknownHostException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.OldServerPinger;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ApiInfo
{
    private static final ThreadPoolExecutor tpe = new ScheduledThreadPoolExecutor(5, (new ThreadFactoryBuilder()).setNameFormat("Server Pinger #%d").setDaemon(true).build());
    private final Minecraft mc;
    private ServerData data;
    private OldServerPinger pinger = new OldServerPinger();
    private ResourceLocation icon;
    private DynamicTexture dt;
    private long last = 0;
    private static final String __OBFID = "CL_10000817";

    public ApiInfo(String defaultName, String ip)
    {
        this.data = new ServerData(defaultName, ip);
        this.mc = Minecraft.getMinecraft();
        this.icon = new ResourceLocation("servers/" + ip + "/icon");
        this.dt = (DynamicTexture)this.mc.getTextureManager().getTexture(this.icon);
    }

    public void pre_init()
    {
    	init(true);
    }
    
    private void init(boolean init)
    {
    	if (init)
    	{
    		this.data.field_78841_f = true;
        	this.data.pingToServer = -2L;
        	this.data.serverMOTD = "";
        	this.data.populationInfo = "";
    	}
    	tpe.submit(new Runnable()
    	{
    		private static final String __OBFID = "CL_0000818";
    		public void run()
    		{
    			try
    			{
    				ApiInfo.this.pinger.func_147224_a(ApiInfo.this.data);
    			}
    			catch (UnknownHostException var2)
    			{
    				ApiInfo.this.data.pingToServer = -1L;
    				ApiInfo.this.data.serverMOTD = EnumChatFormatting.DARK_RED + "Can\'t resolve hostname";
    			}
    			catch (Exception var3)
    			{
    				ApiInfo.this.data.pingToServer = -1L;
    				ApiInfo.this.data.serverMOTD = EnumChatFormatting.DARK_RED + "Can\'t connect to server.";
    			}
    		}
    	});
    }
    
    public void refresh()
    {
    	long now = System.currentTimeMillis();
    	if (now - last > 10000L)
    	{
    		last = now;
    		init(false);
    	}
    	pinger.func_147223_a();
    }
    
    public void close()
    {
    	pinger.func_147226_b();
    }
    
    public String getPopulation()
    {
    	return data.populationInfo;
    }    
    public String getVersion()
    {
    	return data.gameVersion;
    }
    
    public String getMOTD()
    {
    	return data.serverMOTD;
    }
    
    public String getName()
    {
    	return data.serverName;
    }
    
    public long getPing()
    {
    	return data.pingToServer;
    }
    
    public boolean getAcceptedTextures()
    {
    	return data.field_78841_f;
    }
    
    public void drawIconPing(GuiScreen gui, int x, int y, boolean with_status)
    {

        byte dx = 0;
        int dy = 0;
        String status = "";

        if (data.field_78841_f && data.pingToServer != -2L)
        {
            if (this.data.pingToServer < 0L)
                dy = 5;
            else if (data.pingToServer < 150L)
                dy = 0;
            else if (data.pingToServer < 300L)
                dy = 1;
            else if (data.pingToServer < 600L)
                dy = 2;
            else if (data.pingToServer < 1000L)
                dy = 3;
            else
                dy = 4;
            if (data.pingToServer < 0L)
                status = "(no connection)";
            else
                status = this.data.pingToServer + "ms";
        }
        else
        {
            dx = 1;
            dy = (int)(Minecraft.getSystemTime() / 100L);
            if (dy > 4)
                dy = 8 - dy;
            status = "Pinging...";
        }
        int decay = !with_status ? 0 : mc.fontRenderer.getStringWidth(status) + 5;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(Gui.icons);
        Gui.func_146110_a(x + decay, y, (float)(dx * 10), (float)(176 + dy * 8), 10, 8, 256.0F, 256.0F);
        if (with_status)
            gui.drawString(mc.fontRenderer, status, x, y, 0xffffff);
    }
}