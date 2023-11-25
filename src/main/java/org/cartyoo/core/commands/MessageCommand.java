package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.MSGUtils;

public class MessageCommand extends BaseCommand {

    @CommandAlias("msg|message|w|whisper|tell")
    @Syntax("<player> <message>")
    @CommandCompletion("@players ")


    public static void onCommand(Player player, OfflinePlayer target, String message) {

        if(target.getPlayer() == player) {
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.message-self")));
        } else {

            player.sendMessage(CC.translate(Core.getInstance().getConfig().getString("messages.message-sender").replaceAll("%message%", message).replaceAll("%target%", target.getName())));
            target.getPlayer().sendMessage(CC.translate(Core.getInstance().getConfig().getString("messages.message-receiver").replaceAll("%message%", message).replaceAll("%sender%", player.getName())));

            MSGUtils.setLastMessageSender(player, target.getPlayer());

        }

    }
}
