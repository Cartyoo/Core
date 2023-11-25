package org.cartyoo.core.commands.gui;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.entity.Player;

public class InvseeCommand extends BaseCommand {
    @CommandAlias("invsee|inventory")
    @CommandPermission("core.command.invsee")
    @Syntax("[player]")
    @CommandCompletion("@players")

    public static void onCommand(Player player, @Optional Player target) {
        if(target == null) {
            player.openInventory(player.getInventory());
        } else {
            player.openInventory(target.getInventory());
        }
    }
}
