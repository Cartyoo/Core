package org.cartyoo.core.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.cartyoo.core.Core;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class WarpUtils {

    public static void createWarp(String warpName, Location location) {
        File configFile = new File(Core.getInstance().getDataFolder(), "warps.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        config.set("warps." + warpName + ".world", location.getWorld().getName());
        config.set("warps." + warpName + ".x", location.getX());
        config.set("warps." + warpName + ".y", location.getY());
        config.set("warps." + warpName + ".z", location.getZ());
        config.set("warps." + warpName + ".yaw", location.getYaw());
        config.set("warps." + warpName + ".pitch", location.getPitch());

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWarp(String warpName) {
        File configFile = new File(Core.getInstance().getDataFolder(), "warps.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        config.set("warps." + warpName, null);

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location getWarpLocation(String warpName) {
        File configFile = new File(Core.getInstance().getDataFolder(), "warps.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        String path = "warps." + warpName;

        if (config.contains(path)) {
            String worldName = config.getString(path + ".world");
            double x = config.getDouble(path + ".x");
            double y = config.getDouble(path + ".y");
            double z = config.getDouble(path + ".z");
            float yaw = (float) config.getDouble(path + ".yaw");
            float pitch = (float) config.getDouble(path + ".pitch");

            return new Location(Core.getInstance().getServer().getWorld(worldName), x, y, z, yaw, pitch);
        }

        return null;
    }

    public Set<String> getWarpNames() {
        File configFile = new File(Core.getInstance().getDataFolder(), "warps.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        return config.getConfigurationSection("warps").getKeys(false);
    }

}
