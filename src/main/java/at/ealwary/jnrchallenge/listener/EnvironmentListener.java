package at.ealwary.jnrchallenge.listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EnvironmentListener implements Listener {

    private JnrChallenge plugin;

    public EnvironmentListener(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!(event.getPlayer().getWorld() == plugin.getJnrWorld())) return;
        event.setCancelled(true);
    }
}
