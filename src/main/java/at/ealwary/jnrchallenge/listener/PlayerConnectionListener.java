package at.ealwary.jnrchallenge.listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    private JnrChallenge plugin;

    public PlayerConnectionListener(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        plugin.getPlayerHashMap().put(player, 0);
    }

    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        plugin.getPlayerHashMap().remove(player);
    }
}
