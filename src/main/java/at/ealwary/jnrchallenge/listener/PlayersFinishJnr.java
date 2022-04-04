package at.ealwary.jnrchallenge.listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StopJnr;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayersFinishJnr implements Listener {

    private JnrChallenge plugin;

    public PlayersFinishJnr(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == plugin.getJnrWorld()) {
            Bukkit.broadcastMessage("d1");
            if (player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ()).getBlockData().getMaterial().equals(Material.GOLD_BLOCK)) {
                Bukkit.broadcastMessage("d2");
                if (plugin.getPlayerHashMap().get(player) != 0) return;
                Bukkit.broadcastMessage("d3");
                plugin.getPlayerHashMap().put(player, 1);

                if (!plugin.getPlayerHashMap().containsValue(0)) {
                    new StopJnr(plugin);
                    return;
                }

                player.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}
