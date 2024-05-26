package pr.lofe.lib.xbase;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pr.lofe.lib.xbase.cmd.APILoader;
import pr.lofe.lib.xbase.cmd.CommandRegistry;

public class xBase extends JavaPlugin {

    public static xBase I;
    public final CommandRegistry registry = new CommandRegistry();

    @Override
    public void onLoad() {
        if(getConfig().getBoolean("load-commandapi-shade", false)) {
            APILoader.load(this);
            Const.commandapi_loaded = true;
        }
    }

    @Override
    public void onEnable() {
        I = this;

        if(Const.commandapi_loaded) APILoader.enable();

        Bukkit.getPluginManager().registerEvents(registry, this);
    }

    @Override
    public void onDisable() {
        if(Const.commandapi_loaded) APILoader.disable();
    }

    public static class Const {
        public static boolean commandapi_loaded = false;
    }

}