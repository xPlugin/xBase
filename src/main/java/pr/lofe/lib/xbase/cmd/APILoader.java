package pr.lofe.lib.xbase.cmd;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class APILoader {

    public static void load(JavaPlugin plugin) {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(plugin).verboseOutput(true));
    }

    public static void enable() {
        CommandAPI.onEnable();
    }

    public static void disable() {
        CommandAPI.onDisable();
    }

}
