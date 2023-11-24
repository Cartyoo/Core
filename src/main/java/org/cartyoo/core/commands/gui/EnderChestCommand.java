package org.cartyoo.core.commands.gui;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class EnderChestCommand extends BaseCommand {
    @CommandAlias("enderchest|ec|endersee")
    @CommandPermission("core.command.enderchest")
    @Syntax("[player]")
    @CommandCompletion("@players")
    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            player.openInventory(player.getEnderChest());
        } else {
            player.openInventory(target.getPlayer().getEnderChest());
        }
    }
}
