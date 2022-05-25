package io.github.column01.minepyscript.Spigot;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MinePyScriptSpigot extends JavaPlugin {
    public static MinePyScriptSpigot instance;
    public static Logger logger;

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
