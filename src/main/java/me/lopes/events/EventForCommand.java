package me.lopes.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventForCommand implements Listener {


    //Metodo para usar comando sem registrar (NÃO RECOMENDADO) apenas em casos simples
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){

        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/youtube")){
            p.sendMessage("indisponivel");
            e.setCancelled(true);
        }

    }


}
