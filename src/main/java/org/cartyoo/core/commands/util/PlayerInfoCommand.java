package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class PlayerInfoCommand extends BaseCommand {

    @CommandAlias("playerinfo|pinfo")
    @CommandPermission("core.command.playerinfo")
    @CommandCompletion("@players")
    @Syntax("[player]")

    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if(target == null) {

            for (String message : Core.getInstance().getConfig().getStringList("messages.player-info.messages")) {
                if (Core.getInstance().getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
                    player.sendMessage(CC.translate(message)
                            .replaceAll("%name%", player.getName())
                            .replaceAll("%ip%", player.getAddress().getHostName())
                            .replaceAll("%country%","")
                            .replaceAll("%x%", String.valueOf(player.getLocation().getX()))
                            .replaceAll("%y%", String.valueOf(player.getLocation().getY()))
                            .replaceAll("%z%", String.valueOf(player.getLocation().getZ()))
                    );
                } else {
                    player.sendMessage(CC.translate(PlaceholderAPI.setPlaceholders(player, message)
                            .replaceAll("%name%", player.getName())
                            .replaceAll("%ip%", player.getAddress().getHostName())
                            .replaceAll("%country%", "")
                            .replaceAll("%x%", String.valueOf(player.getLocation().getX()))
                            .replaceAll("%y%", String.valueOf(player.getLocation().getY()))
                            .replaceAll("%z%", String.valueOf(player.getLocation().getZ()))
                    ));
                }
            }

        }

    }

}
