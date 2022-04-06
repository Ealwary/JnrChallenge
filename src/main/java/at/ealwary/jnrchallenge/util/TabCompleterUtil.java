package at.ealwary.jnrchallenge.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabCompleterUtil implements TabCompleter {
    private static final String[] COMMANDS1 = {"pause", "resume", "start", "reset"};
    private static final String[] COMMANDS2 = {"confirm"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission(ID.PERMISSION_CHALLENGE)) {

                final List<String> completions = new ArrayList<>();
                StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS1), completions);
                if (args.length > 1) {
                    StringUtil.copyPartialMatches(args[1], Arrays.asList(COMMANDS2), completions);
                }
                Collections.sort(completions);

                return completions;
            }
            return null;
        }
        return null;
    }
}
