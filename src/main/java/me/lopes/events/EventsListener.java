package me.lopes.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.lopes.Eventos.*;

public class EventsListener implements Listener {

    @EventHandler
    public void breakEvent(BlockBreakEvent e){
        //Puxar o player
        Player p = e.getPlayer();
        //Puxar o Bloco
        Block b = e.getBlock();

        if (b.getType() != Material.GRASS) return;

        p.sendMessage(getInstance().getConfig().getString("Mensagem.quebrado").replace("&" , "§"));
        //Metodo para setar porção (20 ticks = 1 segundo)
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 10, 0, true, true));

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("§aBem-Vindo");

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(getInstance().getConfig().getString("ActionBar").replaceAll("&", "§")));
    }

}
