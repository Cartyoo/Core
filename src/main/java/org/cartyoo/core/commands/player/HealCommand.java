package org.cartyoo.core.commands.player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;
import org.cartyoo.core.utils.CC;

public class HealCommand extends BaseCommand {

    @CommandAlias("heal")
    @CommandPermission("core.command.heal")
    @Syntax("[player]")


    public static void onCommand(Player player, @Optional OfflinePlayer target) {
        if (target == null) {
            player.setHealthScale(20.00);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.healed")));
        } else {
            target.getPlayer().setHealthScale(20.00);
            player.sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.healed-other").replaceAll("%target%", target.getName())));
            target.getPlayer().sendMessage(CC.translate(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.healed")));
        }
    }
}
