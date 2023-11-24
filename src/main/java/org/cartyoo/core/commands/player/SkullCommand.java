package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand extends BaseCommand {
    @CommandAlias("skull|head|playerhead")
    @CommandPermission("core.command.skull")
    @Syntax("[player]")
    @CommandCompletion("@players")
    public static void onCommand(Player player, @Optional String target) {
        if (target == null){
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
            assert skullMeta != null;
            skullMeta.setOwnerProfile(player.getPlayerProfile());
            head.setItemMeta(skullMeta);
            player.getInventory().addItem(head);
        }
        else{
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
            assert skullMeta != null;
            skullMeta.setOwnerProfile(Bukkit.createPlayerProfile(target));
            head.setItemMeta(skullMeta);
            player.getInventory().addItem(head);
        }
    }
}
