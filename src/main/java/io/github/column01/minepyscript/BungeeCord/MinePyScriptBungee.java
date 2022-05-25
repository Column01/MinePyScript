package io.github.column01.minepyscript.BungeeCord;

import io.github.column01.minepyscript.BungeeCord.events.BungeeEventListeners;
import io.github.column01.minepyscript.MinePyScript;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Logger;

public final class MinePyScriptBungee extends Plugin {
    public static MinePyScriptBungee instance;
    public static MinePyScript sharedInstance;
    public static BungeeEventListeners listeners;


    @Override
    public void onEnable() {
        instance = this;
        Logger logger = getLogger();
        logger.info("Initializing MinePyScript");
        sharedInstance = new MinePyScript();

        // crappy registration of all events in bungee...
        listeners = new BungeeEventListeners();
        getProxy().getPluginManager().registerListener(this, listeners);

        // Internally register an event listener
        boolean registered = registerEventListener("ChatEvent");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean registerEventListener(String eventName) {
        EventListenerBungee listener = new EventListenerBungee(eventName);
        if (listener.isRegistered()) {
            // Register our custom event listener class
            listeners.registerListener(listener.getEventClass(), listener);
            getLogger().info("Custom event listener registered for event: " + eventName);
            return true;
        } else {
            getLogger().info("Custom event listener failed to register! Does the event class exist?");
            return false;
        }
    }

    public MinePyScriptBungee getInstance() {
        return instance;
    }

    public MinePyScript getSharedInstance() {
        return sharedInstance;
    }
}
