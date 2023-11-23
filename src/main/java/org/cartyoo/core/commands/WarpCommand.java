package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.WarpUtils;

public class WarpCommand extends BaseCommand {

    @CommandAlias("warp")
    @Syntax("<warpName>")

    public static void onCommand(Player player, String[] args) {

        if(args.length == 1) {

            String warpName = args[0];
            Location warpLocation = WarpUtils.getWarpLocation(warpName);

            if(warpLocation == null) {
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.warp-not-found").replaceAll("%warpname%", warpName)));
            } else {
                player.teleport(warpLocation);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.warped").replaceAll("%warpname%", warpName)));
            }
        }


    }

}
