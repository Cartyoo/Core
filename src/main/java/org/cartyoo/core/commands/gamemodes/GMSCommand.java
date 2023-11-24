package org.cartyoo.core.commands.gamemodes;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GMSCommand extends BaseCommand {

    @CommandAlias("gms")
    @CommandCompletion("@players")
    @CommandPermission("core.command.gamemode.survival")
    @Syntax("[player]")

    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if (target == null) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gms")));
        } else {
            if (target.getPlayer() == player) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gms")));
            } else {
                target.getPlayer().setGameMode(GameMode.SURVIVAL);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gms-other")));
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gms")));
            }
        }
    }
}
