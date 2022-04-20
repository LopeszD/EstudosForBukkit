package me.lopes.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class SpawnEntity implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player))return false;

        Player p = (Player) s;


        if (c.getName().equalsIgnoreCase("entidade")){

            if (args.length == 0){
                p.sendMessage("Você deu spawn em uma entidade");

                //spawnEntiy(p);
                spawnNPC(p);

            }

            if (args.length == 1){
                if (args[0].equalsIgnoreCase("remover")){

                    for (World world : Bukkit.getWorlds()){
                        for (Entity en : world.getEntities()){
                            if (en.getCustomName() != null && en.getCustomName().equalsIgnoreCase("§aDunny")) en.remove();
                        }
                    }

                }
            }

        }

        return false;
    }


   /* public void spawnEntiy(Player p){
        // PARA PEGAR NOME DO MUNDO Bukkit.getWorld(p.getWorld().getName())
        //Zombie zombie = (Zombie) Bukkit.getWorld(getInstance().getConfig().getString("World"));
        Zombie zombie = (Zombie) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
        ItemStack helmet = new ItemBuilder(Material.IRON_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build();
        zombie.getEquipment().setHelmet(helmet);
        zombie.setCustomName("§aDunny");
        zombie.setCustomNameVisible(true);

        //PRA SETAR ATRIBUTOS
        zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3);

        //DROP CHANCE
        zombie.getEquipment().setHelmetDropChance(50);



    }
*/


    public void spawnNPC(Player p){

        Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        villager.setCustomNameVisible(true);
        villager.setCustomName("§aMercador");
        villager.setProfession(Villager.Profession.BLACKSMITH);
        villager.setCareer(Villager.Career.WEAPON_SMITH);
        villager.setAI(false);
        villager.setInvulnerable(true);

    }

}
