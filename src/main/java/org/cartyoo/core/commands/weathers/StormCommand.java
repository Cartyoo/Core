package org.cartyoo.core.commands.weathers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;

public class StormCommand extends BaseCommand {
    @CommandPermission("core.command.weather.rain")
    @CommandAlias("rain|storm")
    @Syntax("")

    public static void onCommand(Player player, String[] args) {

        player.getWorld().setThundering(false);
        player.getWorld().setStorm(true);

    }
}
