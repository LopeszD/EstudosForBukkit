package me.lopes.commands;

import me.lopes.entites.Inventory;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventoryCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player)) return false;

        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("inv")){
            p.sendMessage("§aAbrindo o menu");
            p.openInventory(new Inventory().getInv());
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 5);

        }

        return false;
    }
}
