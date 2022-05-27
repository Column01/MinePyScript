package io.github.column01.minepyscript.BungeeCord;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.IntegerMemberValue;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Event;

import java.util.logging.Logger;

public class EventListenerBungee {
    public static int id;
    public static Logger logger;
    public static Class<?> eventClass;
    public static Class<?> eventHandlerClass;
    public boolean validEvent;

    public EventListenerBungee(String eventName) {
        id = MinePyScriptBungee.instance.getSharedInstance().getId();
        logger = MinePyScriptBungee.instance.getInstance().getLogger();
        // Find the event class for the given event name
        eventClass = findEventClass(eventName);


        // If we found an actual event class, then make sure to set the registered flag
        if (eventClass != null) {
            eventHandlerClass = buildEventHandlerClass(eventClass);
            validEvent = eventHandlerClass != null;
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

    public Class<?> buildEventHandlerClass (Class<?> clazz) {
        ClassPool pool = ClassPool.getDefault();

        try {
            // Create the dynamic event listener class
            CtClass cc = pool.makeClass("DynamicEventListener");
            CtClass interf = pool.get("net.md_5.bungee.api.plugin.Listener");
            cc.addInterface(interf);
            // create the event handler method
            CtMethod mthd = CtNewMethod.make(
                    "public void onEvent(" + clazz.getName() + " e) { " +
                                "System.out.print(\"Event triggered: \" + e.getClass().getName()); " +
                            "}", cc);

            cc.addMethod(mthd);

            ClassFile ccFile = cc.getClassFile();
            ConstPool constpool = ccFile.getConstPool();

            // Create the EventHandler annotation
            AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
            Annotation annot = new Annotation("net.md_5.bungee.event.EventHandler", constpool);
            attr.addAnnotation(annot);
            mthd.getMethodInfo().addAttribute(attr);
            return cc.toClass();
        } catch (CannotCompileException | NotFoundException e) {
            logger.warning("Error when creating dynamic event handler class!");
            e.printStackTrace();
            return null;
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

    public Class<?> getEventListenerClass() {
        return eventHandlerClass;
    }

    public boolean isValidEvent() {
        return validEvent;
    }
}
