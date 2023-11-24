package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

import java.util.Map;

public class GiveCommand extends BaseCommand {

    @CommandAlias("give|i")
    @CommandPermission("core.command.give")
    @CommandCompletion("<item> 1|32|64 @players")
    @Syntax("<item> [amount] [player]")


    public void onCommand(Player player, Material item, @Optional int amount, @Optional Player target) {
        //TODO: fix

        if (amount == 0){
            final ItemStack Item = new ItemStack(item, 1);
            final Map<Integer, ItemStack> map = player.getInventory().addItem(Item);
            if (!map.isEmpty()) {
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                        .getString("messages.inv-full")
                        .replaceAll("%item%", item.toString())
                        .replaceAll("%amount%", "1")
                        .replaceAll("%target%", player.getName())));
            }
            else{
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                        .getString("messages.given-item")
                        .replaceAll("%item%", item.toString())
                        .replaceAll("%amount%", "1")
                        .replaceAll("%target%", player.getName())));
            }
        }
        else{
            if (target == null){
                final ItemStack Item = new ItemStack(item, amount);
                final Map<Integer, ItemStack> map = player.getInventory().addItem(Item);
                if (!map.isEmpty()) {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                            .getString("messages.inv-full")
                            .replaceAll("%item%", item.toString())
                            .replaceAll("%amount%", String.valueOf(amount))
                            .replaceAll("%target%", player.getName())));
                }
                else{
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                            .getString("messages.given-item")
                            .replaceAll("%item%", item.toString())
                            .replaceAll("%amount%", String.valueOf(amount))
                            .replaceAll("%target%", player.getName())));
                }
            }
            else{
                final ItemStack Item = new ItemStack(item, amount);
                final Map<Integer, ItemStack> map = target.getInventory().addItem(Item);
                if (!map.isEmpty()) {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                            .getString("messages.inv-full")
                            .replaceAll("%item%", item.toString())
                            .replaceAll("%amount%", String.valueOf(amount))
                            .replaceAll("%target%", target.getName())));
                }
                else{
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig()
                            .getString("messages.given-other-item")
                            .replaceAll("%item%", item.toString())
                            .replaceAll("%amount%", String.valueOf(amount))
                            .replaceAll("%target%", target.getName())));
                }
            }
        }

    }
}
