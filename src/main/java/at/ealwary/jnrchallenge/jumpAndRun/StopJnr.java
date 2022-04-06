package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.InventoryItem;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.timer.JnrTimer;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class StopJnr {
    private JnrChallenge plugin;
    private Settings settings;
    private Jnr jnr;

    public StopJnr(JnrChallenge plugin) {
        this.plugin = plugin;
        this.jnr = plugin.getCurrentJnr();

        settings = plugin.getSettings();

        teleportBack();
        restoreInventory();
        giveReward();
        continueTimer();
        removeJnr();
        resetStats();
    }

    private void teleportBack() {
        plugin.getNormalLocations().forEach(Entity::teleport);
        plugin.getNormalLocations().forEach((key, value) -> key.setGameMode(GameMode.SURVIVAL));
    }

    private void giveReward() {
        if (!settings.isGetReward()) return;

        plugin.getPlayerHashMap().forEach((key, value) -> {
            if (value != 1) return;
            key.getWorld().dropItem(key.getLocation(), plugin.getRewardUtil().getRandomReward());
            key.sendMessage(ID.RECEIVED_REWARD);
        });
    }

    private void restoreInventory() {
        HashMap<Player, ArrayList<InventoryItem>> playerInventories = plugin.getPlayerInventories();
        boolean keepInventory = settings.isKeepInventory();

        plugin.getPlayerHashMap().forEach((key, value) -> {
            if (value != 2) {
                key.getInventory().clear();
                ArrayList<InventoryItem> items = plugin.getPlayerInventories().get(key);
                if (items != null) {
                    for (InventoryItem item : items) {
                        key.getInventory().setItem(item.getSlot(), item.getItemStack());
                    }
                    plugin.getPlayerInventories().remove(key);
                }
            } else {
                key.getInventory().clear();
                if (keepInventory) {
                    ArrayList<InventoryItem> items = plugin.getPlayerInventories().get(key);
                    if (items != null) {
                        for (InventoryItem item : items) {
                            key.getInventory().setItem(item.getSlot(), item.getItemStack());
                        }
                    }
                    plugin.getPlayerInventories().remove(key);
                }
            }
            playerInventories.remove(key);
        });
    }

    private void continueTimer() {
        JnrTimer timer = new JnrTimer(plugin);
        plugin.setJnrTimer(timer);
        plugin.getJnrTimer().start();
    }

    private void removeJnr() {
        jnr.remove();
    }

    private void resetStats() {
        plugin.getPlayerHashMap().forEach((key, value) -> plugin.getPlayerHashMap().replace(key, 0));
    }


}
