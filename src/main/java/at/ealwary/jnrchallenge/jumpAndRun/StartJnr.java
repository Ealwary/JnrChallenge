package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.InventoryItem;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Random;

public class StartJnr {
    private JnrChallenge plugin;
    private Jnr jnr;
    private Settings settings;

    public StartJnr(JnrChallenge plugin) {
        this.plugin = plugin;
        settings = plugin.getSettings();

        bindPlayerLocations();
        stopTimer();
        createJnr();
        sendMessageToPlayers();
        saveInventories();
        buildJnr();
        teleport();
    }

    private void bindPlayerLocations() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            plugin.getNormalLocations().put(key, key.getLocation());
        });
    }

    private void stopTimer() {
        plugin.getJnrTimer().stop();
    }

    public void createJnr() {
        World world = plugin.getJnrWorld();
        Location spawnLocation = new Location(world, 0, 200, 0, 0, 0);    //z+?

        Location[] jumpLocs = new Location[6];
        Location jumpGoal = new Location(world, 0, 0, 0);


        for (int i = 0; i < jumpLocs.length + 1; i++) {
            if (i == 0) {
                int randX = new Random().nextInt(3);
                int randPlusOrMinus = new Random().nextInt(2);
                int x = spawnLocation.getBlockX();
                if (randPlusOrMinus == 0) {
                    x = x + randX;
                } else {
                    x = x - randX;
                }
                int randY = new Random().nextInt(2);
                int y = spawnLocation.getBlockY() + randY;
                int randZ = new Random().nextInt(3);
                int z = spawnLocation.getBlockZ() + randZ + 1;
                if (y != 1) {
                    z = z + 1;
                }

                jumpLocs[0] = new Location(world, x, y, z);
            } else if (i == 6) {
                int randX = new Random().nextInt(3);
                int x = jumpLocs[i - 1].getBlockX() + randX;
                int randY = new Random().nextInt(2);
                int y = jumpLocs[i - 1].getBlockY() + randY;
                int randZ = new Random().nextInt(3);
                int z = jumpLocs[i - 1].getBlockZ() + randZ + 1;
                if (y != 1) {
                    z = z + 1;
                }

                jumpGoal = new Location(world, x, y, z);
            } else {
                int randX = new Random().nextInt(3);
                int x = jumpLocs[i - 1].getBlockX() + randX;
                int randY = new Random().nextInt(2);
                int y = jumpLocs[i - 1].getBlockY() + randY;
                int randZ = new Random().nextInt(3);
                int z = jumpLocs[i - 1].getBlockZ() + randZ + 1;
                if (y != 1) {
                    z = z + 1;
                }

                jumpLocs[i] = new Location(world, x, y, z);
            }
        }

        this.jnr = new Jnr(plugin, spawnLocation, jumpLocs, jumpGoal);
        plugin.setCurrentJnr(this.jnr);
    }

    public void sendMessageToPlayers() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            key.sendMessage(ID.TP_MESSAGE);
        });
    }

    public void saveInventories() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            PlayerInventory inventory = key.getInventory();
            ArrayList<InventoryItem> items = new ArrayList<>();

            for (int i = 0; i < inventory.getSize(); i++) {
                if (inventory.getItem(i) != null) {
                    items.add(new InventoryItem(inventory.getItem(i), i));
                }
            }
            plugin.getPlayerInventories().put(key, items);
            key.getInventory().clear();
        });
    }

    private void buildJnr() {
        jnr.build();
    }

    private void teleport() {
        plugin.getPlayerHashMap().forEach((key, value) -> {         //for(Player current: Bukkit.getPlayers) ???
            key.teleport(jnr.getSpawnLocation());
            key.getInventory().clear();
        });
    }
}