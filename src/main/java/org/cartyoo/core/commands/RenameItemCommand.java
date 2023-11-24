package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class RenameItemCommand extends BaseCommand {
    
    @CommandAlias("renameitem|itemrename|rename")
    @CommandPermission("core.command.renameitem")
    @Syntax("<itemName>")
    
    
    public static void onCommand(Player player, String name) {

        if(player.getInventory().getItemInMainHand().getItemMeta() == null) {
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.rename-blocked")));
        } else {

            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();

            meta.setDisplayName(CC.translate(name));
            player.getInventory().getItemInMainHand().setItemMeta(meta);

            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.renamed").replaceAll("%name%", name)));
        }
        
    }
    
    
}
