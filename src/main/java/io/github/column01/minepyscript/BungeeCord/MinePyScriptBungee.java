package io.github.column01.minepyscript.BungeeCord;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Logger;

public final class MinePyScriptBungee extends Plugin {
    public static MinePyScriptBungee instance;
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
