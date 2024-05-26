package pr.lofe.lib.xbase;

import org.bukkit.plugin.java.JavaPlugin;
import pr.lofe.lib.xbase.cmd.APILoader;

public class xBase extends JavaPlugin {

    @Override
    public void onLoad() {
        if(getConfig().getBoolean("load-commandapi-shade", false)) {
            APILoader.load(this);
            Const.commandapi_loaded = true;
        }
    }

    @Override
    public void onEnable() {
        if(Const.commandapi_loaded) {
            APILoader.enable();
        }
    }

    @Override
    public void onDisable() {
        if(Const.commandapi_loaded) {
            APILoader.disable();
        }
    }

    public static class Const {
        public static boolean commandapi_loaded = false;
    }

}