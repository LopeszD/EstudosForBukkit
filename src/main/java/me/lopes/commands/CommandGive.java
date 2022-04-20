package me.lopes.commands;

import me.lopes.items.ItemBuilder;
import me.lopes.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static me.lopes.Eventos.*;

public class CommandGive implements CommandExecutor {

    private final HashMap<Player, Long> time = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player)) return false;

        Player p = (Player) s;


        if (c.getName().equalsIgnoreCase("daritem")){

            if (time.containsKey(p) && !(System.currentTimeMillis() >= time.get(p))){
                p.sendMessage("Está em coldown aguarde " + convert(p) + " segundos");
                return false;
            } else time.remove(p);


            time.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

            //Metodo rapido para criar item costumizado (Codigo IAN)
            //Set lore via config com lines
            ItemStack i = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("&fEspada Teste")
                    .setLore(getInstance().getConfig().getStringList("Lore"))
                    .addEnchantment(Enchantment.DAMAGE_ALL, 1)
                    .build();
            p.getInventory().addItem(i);

            //Metodo rapido para criar item costumizado (Meu codigo)
/*            ItemStack dima = new ItemUtils(Material.DIAMOND, 1, (short) 0)
                    .setname("§fDiamante")
                    .setLore(Arrays.asList("§aLine 1", "Line 2"))
                    .getItemStack();
            ItemStack espada = new ItemUtils(Material.DIAMOND_SWORD, 1, (short) 0)
                    .setname("§fEspada de Diamante")
                    .setLore(Arrays.asList("§aLine 1", "Line 2"))
                    .setEnchant(Enchantment.DAMAGE_ALL, 1)
                    .getItemStack();

            p.getInventory().addItem(dima);
            p.getInventory().addItem(espada);
*/
            //Metodo mais demorado pra fazer item customizado
/*            ItemStack i = new ItemStack(Material.DIAMOND, 1, (short) 0);

            ItemMeta im = i.getItemMeta();

            im.setDisplayName("Item");
            im.setLore(Arrays.asList("Line 1", "Line 2"));

            i.setItemMeta(im);

            p.getInventory().addItem(i);


*/
        }

        return false;
    }

    private Long convert(Player p) {

        long time2 = System.currentTimeMillis() - time.get(p);
        return TimeUnit.MILLISECONDS.toSeconds(time2) * -1;

    }

}
