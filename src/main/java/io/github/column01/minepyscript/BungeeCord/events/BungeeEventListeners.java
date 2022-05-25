package io.github.column01.minepyscript.BungeeCord.events;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.github.column01.minepyscript.BungeeCord.EventListenerBungee;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Collection;

public class BungeeEventListeners implements Listener {
    public Multimap<Class<?>, EventListenerBungee> listeners;

    public BungeeEventListeners() {
        listeners = ArrayListMultimap.create();
    }

    public void registerListener(Class<?> eventClass, EventListenerBungee listener) {
        listeners.put(eventClass, listener);
    }

    public Collection<EventListenerBungee> getEventListeners(Class<?> eventClass) {
        return listeners.get(eventClass);
    }

    // HACKY CRAPPY WAY OF HAVING ALL EVENTS
    // TODO: Find dynamic way to register an event listener... Not likely gonna exist cause bungeecord doesn't have it
    @EventHandler
    public void onChat(ChatEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onClientConnect(ClientConnectEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onLogin(LoginEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onPermissionCheck(PermissionCheckEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onPlayerHandshake(PlayerHandshakeEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onPreLogin(PreLoginEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onProxyPing(ProxyPingEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onProxyReload(ProxyReloadEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onServerConnected(ServerConnectedEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onServerConnect(ServerConnectEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onServerDisconnect(ServerDisconnectEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onServerKick(ServerKickEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onServerSwitch(ServerSwitchEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onSettingsChanged(SettingsChangedEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onTabCompleteResponse(TabCompleteResponseEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
            if (event.isCancelled()) {
                break;
            }
        }
    }

    @EventHandler
    public void onTargeted(TargetedEvent event) {
        Collection<EventListenerBungee> eventListeners = getEventListeners(event.getClass());
        for (EventListenerBungee listener: eventListeners) {
            listener.onEvent(event);
        }
    }
}
