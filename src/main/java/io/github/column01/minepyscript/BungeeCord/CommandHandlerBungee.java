package io.github.column01.minepyscript.BungeeCord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.util.logging.Logger;

public class CommandHandlerBungee extends Command {
    public static Logger logger;

    public CommandHandlerBungee(String name) {
        super(name);
        // Get an ID from the shared instance
        logger = MinePyScriptBungee.instance.getInstance().getLogger();

        logger.info("Command handler created for command: " + name);

    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        //
    }
}
