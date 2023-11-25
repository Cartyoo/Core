package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Syntax;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.cartyoo.core.utils.LuckPermsUtils;
import org.cartyoo.core.utils.PlayerWeightComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListCommand extends BaseCommand {

    @CommandAlias("list|online|players")
    @Syntax("")


    public static void onCommand(Player player){
        player.sendMessage(StringUtils.join(LuckPermsUtils.getSortedValueCache()
                .stream()
                .map(LuckPermsUtils::getFancyName)
                .collect(Collectors.toList()), ChatColor.WHITE + ", "
        ));

        player.sendMessage(ChatColor.WHITE + "(" + getSortedPlayer().size() + "/" + Bukkit.getMaxPlayers() + ") [" + StringUtils.join(getSortedPlayer().stream()
                        .map(LuckPermsUtils::getDisplayName)
                        .collect(Collectors.toList()),
                ChatColor.WHITE + ", ") + ChatColor.WHITE + "]");


    }

    public static List<Player> getSortedPlayer(){
        final List<Player> toReturn = new ArrayList<>();

        for(Player loopPlayer : Bukkit.getOnlinePlayers()){
            toReturn.add(loopPlayer);
        }

        return toReturn.stream().sorted(new PlayerWeightComparator().reversed()).collect(Collectors.toList());

    }

}
