package me.lopes.events;

import me.lopes.items.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ManageInventory implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() != Material.STONE) return;

        ItemStack helmet = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName("§5Helmet Multiplicador").build();
        p.getInventory().setHelmet(helmet);

        //Verificar Slot

        ItemStack item = p.getInventory().getItem(0);

        //Debug para puxar o nome do item
       // if (item != null) System.out.println(item.getType().name());

        if (item != null) p.sendMessage("Que legal você tem um " + item.getType().name());




        //p.sendMessage("§aVocê quebrou uma pedra");

/*        //Verificar nome / material / lore etc do item para quebrar

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType() == Material.DIAMOND){
            p.sendMessage("§aVocê quebrou com um diamante");
        }

        //Debug para indentificar o erro


     System.out.println(item.hasItemMeta());
        System.out.println(item.getItemMeta().hasDisplayName());

        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§fDiamante")){

            p.sendMessage("§6Isto é um diamante modificado");

        } */

    }

}
