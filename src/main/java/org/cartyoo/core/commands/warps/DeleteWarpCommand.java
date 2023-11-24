package org.cartyoo.core.commands.warps;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.WarpUtils;

public class DeleteWarpCommand extends BaseCommand {

    @CommandAlias("delwarp|deletewarp")
    @CommandPermission("core.command.deletewarp")
    @Syntax("<warpName>")

    public static void onCommand(Player player, String warpName) {
        if (WarpUtils.getWarpLocation(warpName) != null) {
            WarpUtils.deleteWarp(warpName);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.deleted-warp").replaceAll("%awrpname%", warpName)));
        } else {
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.warp-not-found").replaceAll("%warpname%", warpName)));
        }
    }
}
