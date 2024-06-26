package pr.lofe.lib.xbase.cmd;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import pr.lofe.lib.xbase.xBase;

public abstract class Command {

    private final Plugin base;
    public final CommandAPICommand src;

    protected abstract void execute(CommandSender sender, CommandArguments args);

    public Command(String name) {
        this.src = new CommandAPICommand(name).executes(this::execute);
        base = null;
    }

    public Command(String name, Plugin plugin) {
        this.src = new CommandAPICommand(name).executes(this::execute);
        base = plugin;
    }

    public void register() {
        src.register();
        if(base != null) xBase.I.registry.add(base, this);
    }

}
