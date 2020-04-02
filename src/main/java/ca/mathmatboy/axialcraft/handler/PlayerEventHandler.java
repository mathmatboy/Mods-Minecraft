package ca.mathmatboy.axialcraft.handler;

import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventHandler 
{
    @SubscribeEvent
    public void onNameFormat(PlayerEvent.NameFormat event)
    {
        if(event.username.equals("mathmatboy"))
        {
            event.displayname = "[AXAI] - " + event.username;
        }
        
        if(event.username.equals("Y3TiS"))
        {
            event.displayname = "[AXAI] - " + event.username;
        }
    }

}
