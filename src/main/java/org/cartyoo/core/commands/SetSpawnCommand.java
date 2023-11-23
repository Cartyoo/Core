package org.cartyoo.core.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;
import org.cartyoo.core.utils.SpawnUtils;
import org.cartyoo.core.utils.WarpUtils;

public class SetSpawnCommand extends BaseCommand {

    @CommandAlias("setspawn")
    @CommandPermission("core.command.setspawn")
    @Syntax("")

    public static void onCommand(Player player, String[] args) {

        SpawnUtils.setSpawn(player.getLocation());
        player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.setspawn")));

    }


}
