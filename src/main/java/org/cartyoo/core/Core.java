package org.cartyoo.core;

import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.cartyoo.core.commands.*;

import java.util.Arrays;

public final class Core extends JavaPlugin {
    @Getter public static Core instance;
    @Getter public static String prefix;

    @Override
    public void onEnable() {

        instance = this;

        this.saveDefaultConfig();
        prefix = this.getConfig().getString("prefix");



        BukkitCommandManager manager = new BukkitCommandManager(this);

        Arrays.asList(
                new GMCCommand(),
                new GMSCommand(),
                new GMACommand(),
                new GMSPCommand(),
                new GamemodeCommand(),
                new FlyCommand()
        ).forEach(manager::registerCommand);

    }

}
