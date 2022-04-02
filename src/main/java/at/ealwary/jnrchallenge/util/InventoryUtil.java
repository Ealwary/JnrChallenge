package at.ealwary.jnrchallenge.util;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class InventoryUtil {
    private JnrChallenge plugin;

    public InventoryUtil(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    public void restoreInventory(Player player) {
        player.getInventory().setContents(player.getInventory().getContents());


    }

    public void storeInventory(Player player) {
        PlayerInventory inventory = player.getInventory();

    }
}
