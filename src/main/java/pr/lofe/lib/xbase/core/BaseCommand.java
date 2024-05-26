package pr.lofe.lib.xbase.core;

import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.TextArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import pr.lofe.lib.xbase.cmd.Command;
import pr.lofe.lib.xbase.text.TextWrapper;
import pr.lofe.lib.xbase.xBase;

public class BaseCommand extends Command {

    public BaseCommand() {
        super("xbase", xBase.I);

        src.withSubcommands(
                new Command("git") {
                    @Override
                    protected void execute(CommandSender sender, CommandArguments args) {
                        String info = args.getRaw("info");
                        assert info != null;

                        if(info.equals("repo")) {
                            sender.sendMessage(TextWrapper.text("Repository URL: <click:open_url:'https://github.com/xPlugin/xBase'><color:#94a5f2>[GitHub]</color></click>"));
                        }
                    }
                }.src.withArguments(new TextArgument("info").replaceSuggestions(ArgumentSuggestions.strings("repo")))
        );
        register();
    }

    @Override protected void execute(CommandSender sender, CommandArguments args) {}

}
