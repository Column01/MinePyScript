package io.github.column01.minepyscript.BungeeCord;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Event;

import java.util.logging.Logger;

public class EventListenerBungee {
    public static int id;
    public static Logger logger;
    public static Class<?> eventClass;
    public boolean registered;

    public EventListenerBungee(String eventName) {
        id = MinePyScriptBungee.instance.getSharedInstance().getId();
        logger = MinePyScriptBungee.instance.getInstance().getLogger();
        // Find the event class for the given event name
        eventClass = findEventClass(eventName);

        // If we found an actual event class, then make sure to set the registered flag
        if (eventClass != null) {
            registered = true;
        }
    }

    public void onEvent(Event event) {
        logger.info("Event fired that matches this listener's event!");
        logger.info("Event type: " + event.getClass().getName());

        // TEST CODE FOR NOW
        if (event instanceof ChatEvent) {
            ChatEvent event1 = (ChatEvent) event;
            logger.info("Chat Message event: " + event1.getMessage());
        }
    }

    public Class<?> findEventClass(String eventName) {
        try {
            return Class.forName("net.md_5.bungee.api.event." + eventName);
        } catch (ClassNotFoundException e) {
            logger.warning("Event class lookup failed for event: " + eventName);
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public Class<?> getEventClass() {
        return eventClass;
    }

    public boolean isRegistered() {
        return registered;
    }
}
