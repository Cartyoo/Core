package org.cartyoo.core.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CMDSpyUtils {

    private static final Map<UUID, Player> commandSpyEnabled = new HashMap<>();

    public static void addToCMDSpy(Player player) {

        commandSpyEnabled.put(player.getUniqueId(), player);

    }

    public static void removeFromCMDSPY(Player player) {

        commandSpyEnabled.remove(player.getUniqueId());

    }


    public static boolean commandSpyEnabled(Player player) {

        return commandSpyEnabled.containsKey(player.getUniqueId());

    }

}
