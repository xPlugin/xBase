package pr.lofe.lib.xbase.cmd;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;

public abstract class Command {

    public final CommandAPICommand src;

    abstract void execute(CommandSender sender, CommandArguments args);

    public Command(String name) {
        this.src = new CommandAPICommand(name).executes(this::execute);
    }

    public void register() {
        src.register();
    }

}
