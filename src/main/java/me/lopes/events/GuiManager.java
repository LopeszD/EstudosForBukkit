package me.lopes.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GuiManager implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

        if (!e.getInventory().getName().equalsIgnoreCase("§5Teste")) return;
        e.setCancelled(true);

        ItemStack i = e.getCurrentItem();

        Player p = (Player) e.getWhoClicked();

   //VERIFICAÇÃO POR TIPO DE MATERIAL
        if (i.getType() == Material.DIAMOND){

            p.closeInventory();
            p.sendMessage("Aqui é quando clica no diamond");
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK,10, 10);

        }
/*     //codigo para verificar o item por nome
        if (!(i.hasItemMeta() && i.getItemMeta().hasDisplayName())) return;

        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("Nome o item")){
            //CODIGO QUE VAI FAZER QUANDO CLICAR NO ITEM
        }*/

    }

}
