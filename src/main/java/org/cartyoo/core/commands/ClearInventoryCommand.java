package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class ClearInventoryCommand extends BaseCommand {

    @CommandAlias("clearinventory|clear|ci")
    @CommandPermission("core.command.clear")
    @Syntax("[player]")
    @CommandCompletion("@players")

    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            player.getInventory().clear();
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.inventory-cleared")));
        } else {
            target.getPlayer().getInventory().clear();
            target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.inventory-cleared")));
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.inventory-cleared-other").replaceAll("%target%", target.getName())));
        }
    }
}
