package listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StopJnr;
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
            if (player.getLocation().getBlock().getBlockData().getMaterial().equals(Material.GOLD_BLOCK)) {
                if (plugin.getPlayerHashMap().get(player) != 0) return;
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
