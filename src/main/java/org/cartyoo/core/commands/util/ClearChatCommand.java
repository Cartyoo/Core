package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class ClearChatCommand extends BaseCommand {

    @CommandAlias("clearchat|cc")
    @CommandPermission("core.command.clearchat")
    @Syntax("")


    public static void onCommand(Player player, String[] args) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage(" ".repeat(500));
        }
        Bukkit.getServer().broadcastMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cleared-chat-announcement").replaceAll("%player%", player.getName())));
    }
}
