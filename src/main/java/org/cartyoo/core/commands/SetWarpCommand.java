package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.WarpUtils;

public class SetWarpCommand extends BaseCommand {

    @CommandAlias("setwarp|createwarp")
    @CommandPermission("core.command.setwarp")
    @Syntax("<warpName>")

    public static void onCommand(Player player, String warpName) {
        WarpUtils.createWarp(warpName, player.getLocation());
        player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.setwarp").replaceAll("%warpname%", warpName)));
    }
}
