package org.cartyoo.core.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cartyoo.core.Core;

public class JoinLeaveListener implements Listener {

    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(Core.getInstance().getConfig().getString("join-message"));
    }

    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(Core.getInstance().getConfig().getString("leave-message"));
    }

}
