package at.ealwary.jnrchallenge.command;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.util.ID;
import at.ealwary.jnrchallenge.view.SettingsView;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SettingsCommand implements CommandExecutor {
    private JnrChallenge plugin;
    private SettingsView settingsView;

    public SettingsCommand(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ID.ONLY_FOR_PLAYERS);
            return false;
        }
        Player player = (Player) sender;
        if(!player.hasPermission(ID.PERMISSION_SETTINGS)) {
            player.sendMessage(ID.NO_PERMS);
            return false;
        }

        settingsView = new SettingsView(plugin, player);
        settingsView.build();
        settingsView.show();

        return false;
    }
}
