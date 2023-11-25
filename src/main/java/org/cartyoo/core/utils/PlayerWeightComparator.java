package org.cartyoo.core.utils;

import org.bukkit.entity.Player;

import java.util.Comparator;

public class PlayerWeightComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(LuckPermsUtils.getRank(o1).getWeight().getAsInt(), LuckPermsUtils.getRank(o2).getWeight().getAsInt());
    }
}
