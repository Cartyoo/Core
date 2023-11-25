package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class PingCommand extends BaseCommand {
    @CommandAlias("ping|pong")
    @CommandPermission("core.command.ping")
    @Syntax("[player]")
    @CommandCompletion("@players")
    public static void onCommand(Player player, @Optional Player target) {
        if (target == null){
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("ping").replaceAll("%ping%", String.valueOf(player.getPing()))));
        }
        else{
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("ping-other").replaceAll("%ping%", String.valueOf(target.getPing()).replaceAll("%target%", target.getName()))));
        }
    }
}
