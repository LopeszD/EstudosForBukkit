package me.lopes.entites;

import me.lopes.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.lopes.Eventos.*;

public class Inventory {

    private org.bukkit.inventory.Inventory Inventory;

    public Inventory() {

        Inventory = Bukkit.createInventory(null, 9 * getInstance().getConfig().getInt("Tamanho"), "§5Teste");
        insertItens();

    }

    private void insertItens(){
        ItemStack i = new ItemBuilder(Material.DIAMOND, 1,  (short) 0).setDisplayName("§9Diamante").build();

        Inventory.setItem(13, i);

    }

    public org.bukkit.inventory.Inventory getInv() {
        return Inventory;
    }
}
