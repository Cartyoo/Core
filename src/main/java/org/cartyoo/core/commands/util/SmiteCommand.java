package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class SmiteCommand extends BaseCommand {

    // TODO: add config msgs
    @CommandAlias("smite|shock")
    @CommandPermission("core.command.smite")
    @Syntax("[player]")
    @CommandCompletion("@players")
    public static void onCommand(Player player, @Optional Player target) {
        if (target == null){
            Location location = player.getTargetBlock(null, 100).getLocation();
            location.getWorld().strikeLightning(location);
        }
        else{
            target.getWorld().strikeLightning(target.getLocation());
        }
    }
}
