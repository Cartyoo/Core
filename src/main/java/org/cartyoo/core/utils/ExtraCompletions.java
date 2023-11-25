package org.cartyoo.core.utils;

import co.aikar.commands.BukkitCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.cartyoo.core.Core;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;

public class ExtraCompletions extends JavaPlugin {

    public static Plugin plugin = Core.getPlugin(Core.class);
    public static BukkitCommandManager manager = new BukkitCommandManager(plugin);

    private static SimpleCommandMap getCommandMap() {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            return (SimpleCommandMap) commandMapField.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onEnable() {

        // @items completion
        Collection<String> items = new HashSet<>();
        Material[] mats = Material.values();
        for (Material material : mats) {
            items.add(material.name());
        }

        manager.getCommandCompletions().registerCompletion("items", c ->
                items
        );

        // @commands completion
        Collection<String> commands = new HashSet<>();
        Collection<Command> map = getCommandMap().getCommands();
        for (Command cmd : map){
            commands.add(cmd.getName());
        }
        manager.getCommandCompletions().registerCompletion("commands", c ->
                commands
        );

        // @plugins completion
        Collection<String> plugins = new HashSet<>();
        Plugin[] pl = Bukkit.getPluginManager().getPlugins();
        for (Plugin pluh : pl){
            plugins.add(pluh.getName());
        }
        manager.getCommandCompletions().registerCompletion("plugins", c ->
                plugins
        );

        // @offlineplayers completion
        Collection<String> offlineplayers = new HashSet<>();
        OfflinePlayer[] offline = Bukkit.getOfflinePlayers();
        for (OfflinePlayer play : offline){
            offlineplayers.add(play.getName());
        }
        manager.getCommandCompletions().registerCompletion("plugins", c ->
                offlineplayers
        );
    }
}
