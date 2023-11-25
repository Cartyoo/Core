package org.cartyoo.core.utils;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.group.GroupManager;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LuckPermsUtils {

    public static String getDisplayName(Player player){
        return CC.translate(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix() + player.getName());
    }

    public static String getSuffix(Player player){
        return LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix();
    }

    public static String getRankColorWithoutName(Player player){
        return LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix();
    }

    public static String getSuffix(UUID uuid){
        return LuckPermsProvider.get().getUserManager().getUser(uuid).getCachedData().getMetaData().getSuffix();
    }

    public static String getNameWithPrefix(Player player, boolean nickname){
            return CC.translate(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix() + player.getName());
    }

    public static String getRankName(Player player){
        return LuckPermsProvider.get().getGroupManager().getGroup(getRank(player).getName()).getCachedData().getMetaData().getSuffix() + LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getPrimaryGroup();
    }

    public static Group getRank(Player player){
        return LuckPermsProvider.get().getGroupManager().getGroup(LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getPrimaryGroup());
    }

    public static String getFancyName(Group group) {
        GroupManager groupManager = LuckPermsProvider.get().getGroupManager();
        String suffix = groupManager.getGroup(group.getName()).getCachedData().getMetaData().getSuffix();
        String displayName = groupManager.getGroup(group.getName()).getDisplayName();

        return CC.translate(suffix + displayName);
    }

    public static String getFancyRankColor(Group group){
        GroupManager groupManager = LuckPermsProvider.get().getGroupManager();
        String suffix = groupManager.getGroup(group.getName()).getCachedData().getMetaData().getSuffix();

        return CC.translate(suffix);
    }

    public static List<Group> getSortedValueCache() {
        return Collections.unmodifiableList(LuckPermsProvider.get().getGroupManager().getLoadedGroups().stream().sorted(new RankWeightComparator().reversed().thenComparing(new RankWeightComparator())).collect(Collectors.toList()));
    }

}
