package at.ealwary.jnrchallenge.command;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.timer.JnrTimer;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChallengeCommand implements CommandExecutor {
    private JnrChallenge plugin;

    public ChallengeCommand(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ID.ONLY_FOR_PLAYERS);
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission(ID.PERMISSION_CHALLENGE)) {
            player.sendMessage(ID.NO_PERMS);
            return false;
        }

        if (args.length != 1 && args.length != 2) {
            player.sendMessage(ID.WRONG_USAGE + "challenge <start/resume/pause>");
            return false;
        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("reset") && args[1].equalsIgnoreCase("confirm")) {
                plugin.setTime(new Time(0));
                player.sendMessage(ID.CHALLENGE_RESET_SUCCESED);
            }
            return false;
        }

        if (args[0].equalsIgnoreCase("start") || args[0].equalsIgnoreCase("resume")) {
            if (plugin.getJnrTimer().isRunning()) {
                player.sendMessage(ID.CHALLENGE_ALREADY_RUNNING);
            } else {
                JnrTimer jnrTimer = new JnrTimer(plugin);
                plugin.setJnrTimer(jnrTimer);
                plugin.getJnrTimer().start();
                player.sendMessage(ID.CHALLENGE_RESUMED + (args[0].equalsIgnoreCase("start") ? "gestartet." : "fortgesetzt."));
            }
        } else if (args[0].equalsIgnoreCase("pause")) {
            if (!plugin.getJnrTimer().isRunning()) {
                player.sendMessage(ID.CHALLENGE_ALREADY_PAUSED);
            } else {
                plugin.getJnrTimer().stop();
                player.sendMessage(ID.CHALLENGE_PAUSED);
            }
        } else if (args[0].equalsIgnoreCase("reset")) {
            player.sendMessage(ID.CHALLENGE_RESET_CONFIRM);
        } else {
            player.sendMessage(ID.WRONG_USAGE + "challenge <start/resume/pause>");
            return false;
        }

        return false;
    }
}
