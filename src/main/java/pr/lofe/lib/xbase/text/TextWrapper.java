package pr.lofe.lib.xbase.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TextWrapper {

    protected static final MiniMessage mm = MiniMessage.miniMessage();

    public static Component text(String string) {
        return mm.deserialize(string);
    }



}
