package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class FlyCommand extends BaseCommand {

    @CommandAlias("fly|f")
    @CommandPermission("core.command.fly")
    @CommandCompletion("@players")
    @Syntax("[player]")


    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            if (player.getAllowFlight()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-disable")));
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-enable")));
            }
        } else {
            if (target.getPlayer().getAllowFlight()) {
                target.getPlayer().setFlying(false);
                target.getPlayer().setAllowFlight(false);
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-disable")));
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-disable-other").replaceAll("%target%", target.getName())));
            } else {
                target.getPlayer().setAllowFlight(true);
                target.getPlayer().setFlying(true);
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-enable")));
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fly-enable-other").replaceAll("%target%", target.getName())));
            }
        }
    }
}
