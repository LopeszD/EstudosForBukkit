package me.lopes.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import static me.lopes.Eventos.*;

public class EventTest implements Listener {

    @EventHandler
    public void PingEvent(ServerListPingEvent e){

        if (!Bukkit.hasWhitelist()) e.setMotd(getInstance().getConfig().getString("Motd.mensagem").replace("&" , "§"));
        else e.setMotd(getInstance().getConfig().getString("Motd.whit").replace("&" , "§"));

    }

}
