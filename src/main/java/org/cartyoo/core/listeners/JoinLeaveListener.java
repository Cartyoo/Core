package org.cartyoo.core.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class JoinLeaveListener implements Listener {

    public void onJoin(PlayerJoinEvent event) {
        if (Core.getInstance().getConfig().getString("join-message") != null) {

            if (Core.getInstance().getConfig().getBoolean("join-placeholder-api")) {
                if (Core.getInstance().getServer().getPluginManager().getPlugin("PlaceholderAPI") == null && Core.getInstance().getConfig().getBoolean("join-placeholder-api")) {
                    event.setJoinMessage(CC.translate(Core.getInstance().getConfig().getString("join-message")));
                }
            } else {
                event.setJoinMessage(CC.translate(Core.getInstance().getConfig().getString("join-message")));
            }

            if (Core.getInstance().getConfig().getBoolean("motd.enabled")) {

                for (String message : Core.getInstance().getConfig().getStringList("motd.lines")) {
                    if (Core.getInstance().getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
                        event.getPlayer().sendMessage(CC.translate(message));
                    } else {
                        event.getPlayer().sendMessage(CC.translate(PlaceholderAPI.setPlaceholders(event.getPlayer(), message)));
                    }
                }

            }
        }
    }


    @EventHandler
    public void onQuit (PlayerQuitEvent event){

        if (Core.getInstance().getConfig().getString("leave-message") != null) {

            if (Core.getInstance().getConfig().getBoolean("leave-placeholder-api")) {
                if (Core.getInstance().getServer().getPluginManager().getPlugin("PlaceholderAPI") == null && Core.getInstance().getConfig().getBoolean("leave-placeholder-api")) {
                }

                event.setQuitMessage(CC.translate(Core.getInstance().getConfig().getString("leave-message")));
            }
        }


    }

}