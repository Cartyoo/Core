package org.cartyoo.core;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.cartyoo.core.commands.gamemodes.*;
import org.cartyoo.core.commands.gui.*;
import org.cartyoo.core.commands.player.*;
import org.cartyoo.core.commands.social.MessageCommand;
import org.cartyoo.core.commands.social.ReplyCommand;
import org.cartyoo.core.commands.util.*;
import org.cartyoo.core.commands.warps.*;
import org.cartyoo.core.commands.weather.*;
import org.cartyoo.core.listeners.PlayerChatListener;

import java.util.HashMap;
import java.util.Map;

public final class Core extends JavaPlugin {
    @Getter public static Core instance;
    @Getter public static String prefix;
    @Getter public static boolean chatPlaceholdersEnabled;
    @Getter public static BukkitCommandManager manager;
    public static Map<Player, Player> lastSenderMap = new HashMap<>();


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

        manager = new BukkitCommandManager(this);


        register(
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
                new GiveCommand(),
                new RenameItemCommand(),
                new ClearInventoryCommand(),
                new ClearChatCommand(),
                new HealCommand(),
                new EnderChestCommand(),
                new HatCommand(),
                new InvseeCommand(),
                new DisposalCommand(),
                new SmiteCommand(),
                new CraftingTableCommand(),
                new AnvilCommand(),
                new PingCommand(),
                new SkullCommand(),
                new BroadcastCommand(),
                new MessageCommand(),
                new ReplyCommand()
        );
    }
    private void register(BaseCommand... commands) {
        for (BaseCommand command : commands) {
            getManager().registerCommand(command);
        }
    }
}
