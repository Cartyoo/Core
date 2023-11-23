package org.cartyoo.core.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.cartyoo.core.Core;

import java.io.File;
import java.io.IOException;

public class SpawnUtils {

    public static void setSpawn(Location location) {
        File configFile = new File(Core.getInstance().getDataFolder(), "spawn.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        config.set("spawnLocation.world", location.getWorld().getName());
        config.set("spawnLocation.x", location.getX());
        config.set("spawnLocation.y", location.getY());
        config.set("spawnLocation.z", location.getZ());
        config.set("spawnLocation.yaw", location.getYaw());
        config.set("spawnLocation.pitch", location.getPitch());

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location getSpawn() {
        File configFile = new File(Core.getInstance().getDataFolder(), "spawn.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        if (config.contains("spawnLocation")) {
            String worldName = config.getString("spawnLocation.world");
            double x = config.getDouble("spawnLocation.x");
            double y = config.getDouble("spawnLocation.y");
            double z = config.getDouble("spawnLocation.z");
            float yaw = (float) config.getDouble("spawnLocation.yaw");
            float pitch = (float) config.getDouble("spawnLocation.pitch");

            return new Location(Core.getInstance().getServer().getWorld(worldName), x, y, z, yaw, pitch);
        }
        return Core.getInstance().getServer().getWorlds().get(0).getSpawnLocation();
    }

}
