package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.entity.Player;

public class PingCommand extends BaseCommand {
    @CommandAlias("ping|pong")
    @CommandPermission("core.command.ping")
    @Syntax("[player]")
    @CommandCompletion("@players")
    public static void onCommand(Player player, @Optional Player target) {
        if (target == null){
            player.sendMessage(String.valueOf(player.getPing()));
        }
        else{
            player.sendMessage(String.valueOf(target.getPing()));
        }
    }
}
