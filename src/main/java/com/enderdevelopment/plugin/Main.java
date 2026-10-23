package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("MobileMobPlugin has been enabled!");
        getServer().getPluginManager().registerEvents(new MobListener(), this);
        this.getCommand("spawnmobilemob").setExecutor(new SpawnCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MobileMobPlugin has been disabled!");
    }
}