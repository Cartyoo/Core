package org.cartyoo.core.commands.gui;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class AnvilCommand extends BaseCommand {
    @CommandAlias("anvil")
    @CommandPermission("core.command.anvil")
    public static void onCommand(Player player) {
        Inventory inv = Bukkit.createInventory(player, InventoryType.ANVIL);
        player.openInventory(inv);
    }
}
