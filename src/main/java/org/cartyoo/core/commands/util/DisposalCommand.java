package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DisposalCommand extends BaseCommand {
    @CommandAlias("disposal|bin")
    @CommandPermission("core.command.disposal")
    @Syntax("")
    public static void onCommand(Player player) {
        Inventory bin = Bukkit.createInventory(player, 6, "Disposal");
        player.openInventory(bin);
    }
}
