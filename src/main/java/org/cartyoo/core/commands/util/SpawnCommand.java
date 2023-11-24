package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.SpawnUtils;

public class SpawnCommand extends BaseCommand {

    @CommandAlias("spawn")
    @Syntax("")

    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            player.teleport(SpawnUtils.getSpawn());
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.spawn")));
        } else {
            if(player.hasPermission("core.command.spawn.others")) {
                target.getPlayer().teleport(SpawnUtils.getSpawn());
                target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.spawn")));
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.sent-to-spawn").replaceAll("%target%", target.getName())));
            }
        }
    }
}
