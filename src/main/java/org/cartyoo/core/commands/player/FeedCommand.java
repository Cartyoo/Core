package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class FeedCommand extends BaseCommand {

    @CommandAlias("feed|hunger")
    @CommandPermission("core.command.feed")
    @Syntax("[player]")
    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            player.setFoodLevel(20);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fed")));

        } else {
            player.setFoodLevel(20);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fed-other").replaceAll("%target%", target.getName())));
            target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.fed")));
        }
    }
}
