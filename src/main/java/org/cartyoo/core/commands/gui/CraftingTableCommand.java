package org.cartyoo.core.commands.gui;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.entity.Player;

public class CraftingTableCommand extends BaseCommand {
    @CommandAlias("craft|workbench")
    @CommandPermission("core.command.craft")
    public static void onCommand(Player player) {
        player.openWorkbench(player.getLocation(), true);
    }
}
