package org.cartyoo.core.commands.social;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;

import static org.cartyoo.core.Core.lastSenderMap;

public class MessageCommand extends BaseCommand {
    @CommandAlias("msg|message|tell|whisper|w")
    @CommandPermission("core.command.msg")
    @Syntax("<player> <message>")
    @CommandCompletion("@players")
    public void onCommand(Player p, Player target, String msg){
        target.sendMessage("From " + p.getName() + " > " + msg);
        p.sendMessage("To " + p.getName() + " > " + msg);
        lastSenderMap.put(target, p);
    }
}
