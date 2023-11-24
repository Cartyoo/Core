package org.cartyoo.core;

import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.cartyoo.core.commands.*;
import org.cartyoo.core.commands.gamemodes.*;
import org.cartyoo.core.commands.weathers.*;
import org.cartyoo.core.listeners.PlayerChatListener;

import java.util.Arrays;

public final class Core extends JavaPlugin {
    @Getter public static Core instance;
    @Getter public static String prefix;
    @Getter public static boolean chatPlaceholdersEnabled;

    @Override
    public void onEnable() {

        instance = this;
        this.saveDefaultConfig();

        if(this.getConfig().getString("prefix") == null) {
            prefix = "&8[&a&lCORE&8] ";
        } else {
            prefix = this.getConfig().getString("prefix");
        }

        if(this.getConfig().getBoolean("chat.enabled")) {
            if(this.getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
                this.getLogger().severe("Chat format is enabled, and Placeholders are in use, but PlaceholderAPI is not found. Chat format is now disabled.");
                this.getLogger().severe("Please download PlaceholderAPI to continue using chat format, or disable it in /plugins/Core/config.yml");
                //this.getConfig().set("chat.enabled", false);
                chatPlaceholdersEnabled = false;
            } else {
                this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
                chatPlaceholdersEnabled = true;
            }
        }


        BukkitCommandManager manager = new BukkitCommandManager(this);

        Arrays.asList(
                new WeatherCommand(),
                new SunCommand(),
                new StormCommand(),
                new ThunderCommand(),

                new GamemodeCommand(),
                new GMACommand(),
                new GMCCommand(),
                new GMSCommand(),
                new GMSPCommand(),

                new FlyCommand(),

                new SetSpawnCommand(),
                new SpawnCommand(),

                new WarpCommand(),
                new DeleteWarpCommand(),
                new SetWarpCommand(),

                //new GiveCommand(), //Removed temporarily due to not working

                new RenameItemCommand(),

                new ClearInventoryCommand(),

                new ClearChatCommand(),

                new HealCommand(),

                new MessageCommand(),
                new ReplyCommand()

        ).forEach(manager::registerCommand);

    }
}
