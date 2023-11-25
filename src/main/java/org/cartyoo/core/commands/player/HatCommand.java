package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatCommand extends BaseCommand {
    @CommandAlias("hat|helmet")
    @CommandPermission("core.command.hat")
    @Syntax("")

    public static void onCommand(Player player, String[] args) {
        PlayerInventory inv = player.getInventory();
        ItemStack hat = inv.getItemInMainHand();
        inv.setHelmet(hat);
        inv.remove(hat);
        if (inv.getHelmet() != null) {
            ItemStack helm = inv.getHelmet();
            inv.addItem(helm);
        }
    }
}
