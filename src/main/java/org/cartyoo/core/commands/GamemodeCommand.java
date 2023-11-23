package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GamemodeCommand extends BaseCommand {

    @CommandAlias("gamemode|gm")
    @CommandCompletion("@players|creative|survival|spectator|adventure")
    @Syntax("<gamemode> [player]")
    @CommandPermission("core.command.gamemode")

    public static void onCommand(Player player, GameMode gamemode, @Optional OfflinePlayer target) {

        if(target == null) {

            player.setGameMode(gamemode);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gamemode").replaceAll("%gamemode%", gamemode.toString())));

        } else {
            target.getPlayer().setGameMode(gamemode);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gamemode-other").replaceAll("%gamemode%", gamemode.toString()).replaceAll("%target%", target.getName())));
            target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gamemode").replaceAll("%gamemode%", gamemode.toString())));
        }

    }

}
