package me.lopes.events;

import me.lopes.entites.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NpcClickEvent implements Listener {


    @EventHandler

    public void onInteract(PlayerInteractEntityEvent e){

        Player p =  e.getPlayer();
        if (!(e.getRightClicked() instanceof Villager)) return;

        Villager v = (Villager) e.getRightClicked();
        if (v.getCustomName() == null || !v.getCustomName().equalsIgnoreCase("§aMercador")) return;
        e.setCancelled(true);
        p.openInventory(new Inventory().getInv());


    }



}
