package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.CMDSpyUtils;

public class CommandSpyCommand extends BaseCommand {

    @CommandAlias("cmdspy|commandspy")
    @CommandPermission("core.command.commandspy")
    @Syntax("[enable|disable]")

    public static void onCommand(Player player, String action) {

        if(action == null) {

            if(CMDSpyUtils.commandSpyEnabled(player)) {
                CMDSpyUtils.removeFromCMDSPY(player);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-disabled")));
            } else {
                CMDSpyUtils.addToCMDSpy(player);
                player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-enabled")));
            }

        } else {


            if(action.equalsIgnoreCase("enable")) {
                if(CMDSpyUtils.commandSpyEnabled(player)) {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-error-enabled")));
                } else {
                    CMDSpyUtils.addToCMDSpy(player);
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-enabled")));
                }
            } else if(action.equalsIgnoreCase("disable")) {
                if(CMDSpyUtils.commandSpyEnabled(player)) {
                    CMDSpyUtils.removeFromCMDSPY(player);
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-disabled")));
                } else {
                    player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.cmd-spy-error-disabled")));
                }
            }

        }

    }

}
