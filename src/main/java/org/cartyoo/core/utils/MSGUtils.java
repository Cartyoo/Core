package org.cartyoo.core.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MSGUtils {

        private static final Map<Player, Player> lastMessageSenders = new HashMap<>();

        public static void setLastMessageSender(Player recipient, Player sender) {
            lastMessageSenders.put(recipient, sender);
        }

        public static Player getLastMessageSender(Player recipient) {
            return lastMessageSenders.get(recipient);
        }

}
