package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class KillCommand extends BaseCommand {

    @CommandAlias("kill")
    @CommandPermission("core.command.kill")
    @Syntax("[player]")
    @CommandCompletion("@players")

    public static void onCommand(Player player, @Optional OfflinePlayer target) {

        if(target == null) {
            player.setHealth(0);
        } else {
            target.getPlayer().setHealth(0);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.kill-other").replaceAll("%target%", target.getName())));
        }

    }

}
