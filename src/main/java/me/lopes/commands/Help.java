package me.lopes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Help implements CommandExecutor {

    //Adicionar coldown em comandos ou outras coisas
    private final HashMap<Player, Long> help = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if (!(s instanceof Player)) return false;
        Player p = (Player) s;


        if (c.getName().equalsIgnoreCase("ajuda")){

            //Adicionar tempo no comando ou outras coisas
            if (help.containsKey(p) && !(System.currentTimeMillis() >= help.get(p))){
                p.sendMessage("Aguarde está em coldown " + convert(p) + " segundos");
                return false;
            } else help.remove(p);




            //Adiconar tempo
            help.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis( 10));


            //Args = 0 para pegar a primeira coisa dps do AJUDA
            if (args.length == 0){

                p.sendMessage("");
                p.sendMessage("Digite /ajuda 1 - PARA O SERVIDOR");
                p.sendMessage("Digete /ajuda 2 - PARA DISCORD DO SERVIDOR");
                return true;
            }

            if (args.length == 1){
                if (args[0].equalsIgnoreCase("1")){

                    p.sendMessage("O servidor está na versão 1.12.2");
                    return true;

                }

                if (args[0].equalsIgnoreCase("2")){

                    p.sendMessage("nosso discord é discord.gg/");
                    return true;

                }
            }
            if (args.length == 2){
                if (args[1].equalsIgnoreCase("server")){
                    p.sendMessage("server teste");
                }
            }
        }

        return false;
    }


    //Pegar o coldown do player
    private Long convert(Player p) {

        long time = System.currentTimeMillis() - help.get(p);
        return TimeUnit.MILLISECONDS.toSeconds(time) * -1;

    }

}
