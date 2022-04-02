package at.ealwary.jnrchallenge.command;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.PlayerInventory;

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

        if (args.length != 1) {
            player.sendMessage(ID.WRONG_USAGE + "challenge <start/resume/pause>");
            return false;
        }

        if (args[0].equalsIgnoreCase("start") || args[0].equalsIgnoreCase("resume")) {
            if(plugin.getJnrTimer().isRunning()) {
                player.sendMessage(ID.CHALLENGE_ALREADY_RUNNING);
            } else {
                player.sendMessage(ID.CHALLENGE_RESUMED + (args[0].equalsIgnoreCase("start") ? "gestartet." : "fortgesetzt."));
            }
        } else if (args[0].equalsIgnoreCase("pause")) {
            if(!plugin.getJnrTimer().isRunning()) {
                player.sendMessage(ID.CHALLENGE_ALREADY_PAUSED);
            } else {
                player.sendMessage(ID.CHALLENGE_PAUSED);
            }
        } else {
            player.sendMessage(ID.WRONG_USAGE + "challenge <start/resume/pause>");
            return false;
        }

        return false;
    }
}
