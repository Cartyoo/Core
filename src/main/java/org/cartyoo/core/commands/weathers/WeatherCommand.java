package org.cartyoo.core.commands.weathers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class WeatherCommand extends BaseCommand {
    @CommandAlias("weather")
    @Syntax("<weather>")
    @CommandCompletion("sun|storm|thunder")
    @CommandPermission("core.command.weather")
    public static void onCommand(Player player, String weather) {
        if (weather.equalsIgnoreCase("storm") || weather.equalsIgnoreCase("rain")){
            player.getWorld().setThundering(false);
            player.getWorld().setStorm(true);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.weather-rain")));
        }
        else if (weather.equalsIgnoreCase("thunder") || weather.equalsIgnoreCase("lightning")){
            player.getWorld().setStorm(false);
            player.getWorld().setThundering(true);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.weather-thunder")));
        }
        else if (weather.equalsIgnoreCase("sun") || weather.equalsIgnoreCase("clear")){
            player.getWorld().setThundering(false);
            player.getWorld().setStorm(false);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.weather-sun")));
        }
    }
}
