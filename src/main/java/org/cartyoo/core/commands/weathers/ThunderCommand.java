package org.cartyoo.core.commands.weathers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;

public class ThunderCommand extends BaseCommand {
    @CommandPermission("core.command.weather.rain")
    @CommandAlias("lightning|thunder")
    @Syntax("")

    public static void onCommand(Player player, String[] args) {

        player.getWorld().setThundering(true);
        player.getWorld().setStorm(false);
    }

}