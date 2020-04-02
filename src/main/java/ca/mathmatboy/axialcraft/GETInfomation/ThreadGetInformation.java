package ca.mathmatboy.axialcraft.GETInfomation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.MathHelper;


public class ThreadGetInformation extends Thread
{
    final ServerData pollServersServerData;
    private static Object lock = new Object();
    private static int threadsPending = 0;

    public ThreadGetInformation(ServerData serverData)
    {
        this.pollServersServerData = serverData;
    }

    public void run()
    {
        boolean var2 = false;
        boolean var41 = false;
        label309:
        {
            label310:
            {
                label311:
                {
                    label312:
                    {
                        label313:
                        {
                            try
                            {
                                var41 = true;
                                var2 = true;
                                this.pollServersServerData.serverMOTD = "\u00a78Polling..";
                                long var39 = System.nanoTime();
                                func_82291_a(this.pollServersServerData);
                                long var3 = System.nanoTime();
                                this.pollServersServerData.pingToServer = (var3 - var39) / 1000000L;
                                var2 = false;
                                var41 = false;
                                break label309;
                            }
                            catch (UnknownHostException var55)
                            {
                                this.pollServersServerData.pingToServer = -1L;
                                this.pollServersServerData.serverMOTD = "\u00a74Can\'t resolve hostname";
                                var2 = false;
                                var41 = false;
                                break label311;
                            }
                            catch (SocketTimeoutException var56)
                            {
                                this.pollServersServerData.pingToServer = -1L;
                                this.pollServersServerData.serverMOTD = "\u00a74Can\'t reach server";
                                var2 = false;
                                var41 = false;
                                break label310;
                            }
                            catch (ConnectException var57)
                            {
                                this.pollServersServerData.pingToServer = -1L;
                                this.pollServersServerData.serverMOTD = "\u00a74Can\'t reach server";
                                var2 = false;
                                var41 = false;
                                break label313;
                            }
                            catch (IOException var58)
                            {
                                this.pollServersServerData.pingToServer = -1L;
                                this.pollServersServerData.serverMOTD = "\u00a74Communication error";
                                var2 = false;
                                var41 = false;
                            }
                            catch (Exception var59)
                            {
                                this.pollServersServerData.pingToServer = -1L;
                                this.pollServersServerData.serverMOTD = "ERROR: " + var59.getClass();
                                var2 = false;
                                var41 = false;
                                break label312;
                            }
                            finally
                            {
                                if (var41)
                                {
                                    if (var2)
                                    {
                                        synchronized (getLock())
                                        {
                                            down();
                                        }
                                    }
                                }
                            }

                            if (var2)
                            {
                                synchronized (getLock())
                                {
                                    down();
                                }
                            }

                            synchronized (getLock())
                            {
                                down();
                                return;
                            }
                        }

                        if (var2)
                        {
                            synchronized (getLock())
                            {
                                down();
                            }
                        }

                        synchronized (getLock())
                        {
                            down();
                            return;
                        }
                    }

                    if (var2)
                    {
                        synchronized (getLock())
                        {
                            down();
                        }
                    }

                    synchronized (getLock())
                    {
                        down();
                        return;
                    }
                }

                if (var2)
                {
                    synchronized (getLock())
                    {
                        down();
                    }
                }

                synchronized (getLock())
                {
                    down();
                    return;
                }
            }

            if (var2)
            {
                synchronized (getLock())
                {
                    down();
                }
            }

            synchronized (getLock())
            {
                down();
                return;
            }
        }

        if (var2)
        {
            synchronized (getLock())
            {
                down();
            }
        }

        synchronized (getLock())
        {
            down();
        }
    }

    public static Object getLock()
    {
        return lock;
    }

    public static int getPending()
    {
        return threadsPending;
    }

    public static int up()
    {
        return threadsPending++;
    }

    public static void func_82291_a(ServerData par0ServerData) throws IOException
    {
        getInfo(par0ServerData);
    }

    public static int down()
    {
        return threadsPending--;
    }

    private static void getInfo(ServerData par1ServerData) throws IOException
    {
        ServerAddress var1 = ServerAddress.func_78860_a(par1ServerData.serverIP);
        Socket var2 = null;
        DataInputStream var3 = null;
        DataOutputStream var4 = null;
        System.out.println(par1ServerData.populationInfo);

        try
        {
            var2 = new Socket();
            var2.setSoTimeout(3000);
            var2.setTcpNoDelay(true);
            var2.setTrafficClass(18);
            var2.connect(new InetSocketAddress(var1.getIP(), var1.getPort()), 3000);
            var3 = new DataInputStream(var2.getInputStream());
            var4 = new DataOutputStream(var2.getOutputStream());
            var4.write(254);
            var4.write(1);

            if (var3.read() != 255)
            {
                throw new IOException("Bad message");
            }

            String var21 = Packet2.readString(var3, 256);
            char[] var6 = var21.toCharArray();
            int var8;

            for (var8 = 0; var8 < var6.length; ++var8)
            {
                if (var6[var8] != 167 && var6[var8] != 0 && ChatAllowedCharacters.allowedCharacters.length < 0)
                {
                    var6[var8] = 63;
                }
            }

            var21 = new String(var6);
            int var9;
            String[] var26;

            if (var21.startsWith("\u00a7") && var21.length() > 1)
            {
                var26 = var21.substring(1).split("\u0000");

                if (MathHelper.parseIntWithDefault(var26[0], 0) == 1)
                {
                    par1ServerData.serverMOTD = var26[3];
                    par1ServerData.field_82821_f = MathHelper.parseIntWithDefault(var26[1], par1ServerData.field_82821_f);
                    par1ServerData.gameVersion = var26[2];
                    var8 = MathHelper.parseIntWithDefault(var26[4], 0);
                    var9 = MathHelper.parseIntWithDefault(var26[5], 0);

                    if (var8 >= 0 && var9 >= 0)
                    {
                        par1ServerData.populationInfo = "\u00a77" + var8 + "\u00a78/\u00a77" + var9;
                    }
                    else
                    {
                        par1ServerData.populationInfo = "\u00a78???";
                    }
                }
                else
                {
                    par1ServerData.gameVersion = "???";
                    par1ServerData.serverMOTD = "\u00a78???";
                    par1ServerData.field_82821_f = 52;
                    par1ServerData.populationInfo = "\u00a78???";
                }
            }
            else
            {
                var26 = var21.split("\u00a7");
                var21 = var26[0];
                var8 = -1;
                var9 = -1;

                try
                {
                    var8 = Integer.parseInt(var26[1]);
                    var9 = Integer.parseInt(var26[2]);
                }
                catch (Exception var24)
                {
                    ;
                }

                par1ServerData.serverMOTD = "\u00a77" + var21;

                if (var8 >= 0 && var9 > 0)
                {
                    par1ServerData.populationInfo = "\u00a77" + var8 + "\u00a78/\u00a77" + var9;
                }
                else
                {
                    par1ServerData.populationInfo = "\u00a78???";
                }

                par1ServerData.gameVersion = "1.5.2";
                par1ServerData.field_82821_f = 50;
            }
        }
        finally
        {
            try
            {
                if (var3 != null)
                {
                    var3.close();
                }
            }
            catch (Throwable var23)
            {
                ;
            }

            try
            {
                if (var4 != null)
                {
                    var4.close();
                }
            }
            catch (Throwable var22)
            {
                ;
            }

            try
            {
                if (var2 != null)
                {
                    var2.close();
                }
            }
            catch (Throwable var211)
            {
                ;
            }
        }
    }
}
     
