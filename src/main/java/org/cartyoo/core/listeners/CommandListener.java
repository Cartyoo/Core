package org.cartyoo.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.CMDSpyUtils;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {

        for (Player players : Bukkit.getOnlinePlayers()) {

            if(players == event.getPlayer()) {
                continue;
            }

            if(CMDSpyUtils.commandSpyEnabled(players)) {

                if (players.hasPermission("core.commandspy")) {
                    players.sendMessage(CC.translate(Core.getInstance().getConfig().getString("messages.command-spy").replaceAll("%player%", event.getPlayer().getName()).replaceAll("%command%", event.getMessage())));
                }
            }

        }

    }

}
