package org.cartyoo.core.commands.gamemodes;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GMCCommand extends BaseCommand {
    @CommandAlias("gmc")
    @CommandCompletion("@players")
    @CommandPermission("core.command.gamemode.creative")
    @Syntax("[player]")
    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if (target == null) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmc")));
        } else {
            if (target.getPlayer() == player) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmc")));
            } else {
                target.getPlayer().setGameMode(GameMode.CREATIVE);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmc-other")));
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.gmc")));
            }
        }
    }
}