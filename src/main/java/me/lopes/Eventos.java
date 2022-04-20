package me.lopes;

import me.lopes.commands.CommandGive;
import me.lopes.commands.Help;
import me.lopes.commands.InventoryCommand;
import me.lopes.commands.SpawnEntity;
import me.lopes.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Eventos extends JavaPlugin {

    private static Eventos instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        //String ligado = getConfig().getString("Mensagem.ligado").replace("&" , "§");
        Bukkit.getConsoleSender().sendMessage(getConfig().getString("Mensagem.ligado").replace("&", "§"));
        //Para registrar eventos
        registerEvents();
        registerCommands();
        //new EstudoScheduler().startScheduler();
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(getConfig().getString("Mensagem.desligado").replace("&", "§"));
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }


    public static Eventos getInstance() {
        return instance;
    }


    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new EventsListener(), this);
        Bukkit.getPluginManager().registerEvents(new EventTest(), this);
        Bukkit.getPluginManager().registerEvents(new EventForCommand(), this);
        Bukkit.getPluginManager().registerEvents(new ManageInventory(), this);
        Bukkit.getPluginManager().registerEvents(new GuiManager(), this);
    }

    private void registerCommands() {
        getCommand("ajuda").setExecutor(new Help());
        getCommand("daritem").setExecutor(new CommandGive());
        getCommand("inv").setExecutor(new InventoryCommand());
        getCommand("entidade").setExecutor(new SpawnEntity());
    }

}
