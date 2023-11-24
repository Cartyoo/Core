package org.cartyoo.core.commands.gamemodes;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GMSPCommand extends BaseCommand {
    @CommandAlias("gmsp")//
    @CommandCompletion("@players")
    @CommandPermission("core.command.gamemode.spectator")
    @Syntax("[player]")
    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if (target == null) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmsp")));
        } else {
            if (target.getPlayer() == player) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmsp")));
            } else {
                target.getPlayer().setGameMode(GameMode.SPECTATOR);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmsp-other")));
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmsp")));
            }
        }
    }
}
