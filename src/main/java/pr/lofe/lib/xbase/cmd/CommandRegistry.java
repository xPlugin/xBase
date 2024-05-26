package pr.lofe.lib.xbase.cmd;

import dev.jorel.commandapi.CommandAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandRegistry implements Listener {

    private final HashMap<Command, Plugin> commands = new HashMap<>();

    public boolean add(@NotNull Plugin plugin, @NotNull Command command) {
        for (Command cmd : commands.keySet()) {
            if(cmd != null && !cmd.src.getName().equals(command.src.getName())) {
                commands.put(command, plugin);
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        Plugin disabled = event.getPlugin();
        for (Command cmd : commands.keySet()) {
            Plugin parent = commands.get(cmd);
            if(disabled.getName().equals(parent.getName())) {
                CommandAPI.unregister(cmd.src.getName());
            }
        }
    }

}
