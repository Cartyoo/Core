package org.cartyoo.core.commands.weathers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import org.bukkit.entity.Player;

public class WeatherSunCommand extends BaseCommand {
    @CommandPermission("core.command.weather.sun")
    @CommandAlias("sun")
    public static void onCommand(Player player) {
        player.getWorld().setStorm(false);
        player.getWorld().setThundering(false);
    }
}
