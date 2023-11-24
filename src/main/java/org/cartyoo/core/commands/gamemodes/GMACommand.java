package org.cartyoo.core.commands.gamemodes;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GMACommand extends BaseCommand {
    @CommandAlias("gma")
    @CommandCompletion("@players")
    @CommandPermission("core.command.gamemode.adventure")
    @Syntax("[player]")
    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if (target == null) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gma")));
        } else {
            if (target.getPlayer() == player) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gma")));
            } else {
                target.getPlayer().setGameMode(GameMode.ADVENTURE);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gma-other")));
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gma")));
            }
        }
    }
}