package at.ealwary.jnrchallenge.listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StopJnr;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

    private JnrChallenge plugin;

    public PlayerDamageListener(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        if (plugin.getJnrWorld() == null) return;
        if (player.getWorld() == plugin.getJnrWorld()) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerFallDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) return;
        Player player = ((Player) event.getEntity()).getPlayer();
        if (plugin.getJnrWorld() == null) return;
        if (player.getWorld() != plugin.getJnrWorld()) return;
        plugin.getPlayerHashMap().put(player, 2);

        event.setCancelled(true);

        if (!plugin.getPlayerHashMap().containsValue(0)) {
            new StopJnr(plugin);
            return;
        }

        player.teleport(plugin.getCurrentJnr().getSpawnLocation());
        player.setGameMode(GameMode.SPECTATOR);
    }

}
