package org.cartyoo.core;

import co.aikar.commands.BukkitCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.cartyoo.core.commands.*;
import org.cartyoo.core.commands.gamemodes.*;
import org.cartyoo.core.commands.weathers.*;

import java.util.Arrays;

public final class Core extends JavaPlugin {
    @Getter public static Core instance;
    @Getter public static String prefix;

    @Override
    public void onEnable() {

        instance = this;
        this.saveDefaultConfig();

        if(this.getConfig().getString("prefix") == null) {
            prefix = "&8[&a&lCORE&8] ";
        } else {
            prefix = this.getConfig().getString("prefix");
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

                new HealCommand()

        ).forEach(manager::registerCommand);

    }
}
