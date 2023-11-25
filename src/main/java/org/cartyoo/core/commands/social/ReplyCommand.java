package org.cartyoo.core.commands.social;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.entity.Player;

import static org.cartyoo.core.Core.lastSenderMap;

public class ReplyCommand extends BaseCommand {
    @CommandAlias("reply|r")
    @CommandPermission("core.command.reply")
    @Syntax("<message>")
    public void onCommand(Player p, String msg) {
        Player lastSender = lastSenderMap.get(p);
        if (lastSender != null) {
            lastSender.sendMessage("From " + p.getName() + " > " + msg);
            p.sendMessage("To " + lastSender.getName() + " > " + msg);
        } else {
            p.sendMessage("No one to reply to.");
        }
    }
}
