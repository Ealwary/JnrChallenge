package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.timer.JnrTimer;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

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
        resetStats();
    }

    private void teleportBack() {
        plugin.getNormalLocations().forEach(Entity::teleport);
    }

    private void giveReward() {
        if (!settings.isGetReward()) return;

        plugin.getPlayerHashMap().forEach((key, value) -> {
            if (value != 1) return;
            key.getWorld().dropItem(key.getLocation(), plugin.getRewardUtil().getRandomReward());
            key.sendMessage(ID.PREFIX + "§aDu hast eine Belohnung erhalten!");
        });
    }

    private void restoreInventory() {
        HashMap<Player, String> playerInventories = plugin.getPlayerInventories();
        boolean keepInventory = settings.isKeepInventory();

        plugin.getPlayerHashMap().forEach((key, value) -> {
            if (value != 2) {
                key.getInventory().clear();
                //Set Inventory
            } else {
                if (keepInventory) {
                    key.getInventory().clear();
                    //Set Inventory
                } else {
                    key.getInventory().clear();
                }
            }
            playerInventories.remove(key);
        });


        plugin.getPlayerHashMap().forEach((key, value) -> {
            if (value != 2) return;
            key.getInventory().clear();
        });
    }

    private void continueTimer() {
        new JnrTimer(plugin).start();
    }

    private void resetStats() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            value = 0;
        });
    }


}
