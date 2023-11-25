package org.cartyoo.core.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        if (event.getPlayer().hasPermission(Core.getInstance().getConfig().getString("chat.chatcolor-permission"))) {
            event.setFormat(CC.translate(PlaceholderAPI.setPlaceholders(event.getPlayer(), Core.getInstance().getConfig().getString("chat.chatcolor-format").replaceAll("%message%", event.getMessage()))));
        } else {
            event.setFormat(CC.translate(PlaceholderAPI.setPlaceholders(event.getPlayer(), Core.getInstance().getConfig().getString("chat.default-format").replaceAll("%message%", event.getMessage()))));
        }
    }
}

