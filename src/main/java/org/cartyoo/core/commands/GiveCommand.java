package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class GiveCommand extends BaseCommand {

    @CommandAlias("give|i")
    @CommandPermission("core.command.give")
    @CommandCompletion("1|32|64 @players")
    @Syntax("[amount] [player] <item>")


    public void onCommand(Player player, @Optional int amount, @Optional OfflinePlayer target, Material item) {
        //TODO: fix

        if(target == null || Material.getMaterial(target.getName()) != null) {

            if(amount == 0) {

                if (player.getInventory().firstEmpty() != -1) {
                    player.getInventory().addItem(new ItemStack(item));
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.given-item").replaceAll("%item%", item.name()).replaceAll("%amount%", String.valueOf(amount))));
                } else {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.inventory-full")));
                }

            } else {
                if (player.getInventory().firstEmpty() != -1) {
                    player.getInventory().addItem(new ItemStack(item, amount));
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.given-item").replaceAll("%item%", item.name()).replaceAll("%amount%", String.valueOf(amount))));
                } else {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.inventory-full")));
                }
            }

        } else {

            if(amount == 0) {

                if (target.getPlayer().getInventory().firstEmpty() != -1) {
                    target.getPlayer().getInventory().addItem(new ItemStack(item));
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.given-other-item").replaceAll("%item%", item.name()).replaceAll("%amount%", String.valueOf(amount))));
                } else {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.other-inventory-full")));
                }

            } else {
                if (player.getInventory().firstEmpty() != -1) {
                    player.getInventory().addItem(new ItemStack(item, amount));
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.given-other-item").replaceAll("%item%", item.name()).replaceAll("%amount%", String.valueOf(amount))));
                } else {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.other-inventory-full")));
                }
            }

        }

    }
}
