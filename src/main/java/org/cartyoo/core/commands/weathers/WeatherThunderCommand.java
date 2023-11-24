package org.cartyoo.core.commands.weathers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import org.bukkit.entity.Player;

public class WeatherThunderCommand extends BaseCommand {
    @CommandPermission("core.command.weather.rain")
    @CommandAlias("lightning|thunder")
    public static void onCommand(Player player) {
        player.getWorld().setThundering(true);
        player.getWorld().setStorm(false);
    }
}