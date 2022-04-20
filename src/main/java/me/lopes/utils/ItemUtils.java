package me.lopes.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtils {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemUtils(Material m, int quantidade, short data){
        itemStack = new ItemStack(m, quantidade, data);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemUtils setname (String name){
        itemMeta.setDisplayName(name.replaceAll("&" , "§"));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemUtils setLore(List<String> lore){
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return this;
    }


    public ItemUtils setEnchant(Enchantment enchant, int level){
        itemMeta.addEnchant(enchant, level, false);
        itemStack.setItemMeta(itemMeta);
        return this;

    }


    public ItemStack getItemStack() {
        return itemStack;
    }

}
