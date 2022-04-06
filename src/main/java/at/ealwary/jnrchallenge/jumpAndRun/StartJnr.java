package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.InventoryItem;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Location;
import org.bukkit.World;
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
        createJnr();
        sendMessageToPlayers();
        saveInventories();
        buildJnr();
        teleport();
    }

    private void bindPlayerLocations() {
        plugin.getPlayerHashMap().forEach((key, value) -> plugin.getNormalLocations().put(key, key.getLocation()));
    }

    public void createJnr() {
        World world = plugin.getJnrWorld();
        Location spawnLocation = new Location(world, 0, 200, 0, 0, 0);    //z+?

        Location[] jumpLocs = new Location[6];
        Location jumpGoal = new Location(world, 0, 0, 0);


        for (int i = 0; i < jumpLocs.length + 1; i++) {
            if (i == 0) {
                jumpLocs[0] = createJnrUtil(spawnLocation);
            } else if (i == 6) {
                jumpGoal = createJnrUtil(jumpLocs[i - 1]);
            } else {
                jumpLocs[i] = createJnrUtil(jumpLocs[i - 1]);
            }
        }

        this.jnr = new Jnr(plugin, spawnLocation, jumpLocs, jumpGoal);
        plugin.setCurrentJnr(this.jnr);
    }

    private Location createJnrUtil(Location lastLoc) {
        World world = plugin.getJnrWorld();

        int randX = new Random().nextInt(3);
        int randPlusOrMinus = new Random().nextInt(2);
        int x = lastLoc.getBlockX();
        if (randPlusOrMinus == 0) {
            x = x + randX;
        } else {
            x = x - randX;
        }
        int randY = new Random().nextInt(2);
        int y = lastLoc.getBlockY() + randY;
        int randZ = new Random().nextInt(3);
        int z = lastLoc.getBlockZ() + randZ + 1;
        if (y != 1) {
            z = z + 1;
        }

        Location thisLoc = new Location(world, x, y, z);
        return thisLoc;
    }


    public void sendMessageToPlayers() {
        plugin.getPlayerHashMap().forEach((key, value) -> key.sendMessage(ID.TP_MESSAGE));
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
        plugin.getPlayerHashMap().forEach((key, value) -> {
            key.teleport(jnr.getSpawnLocation());
            key.getInventory().clear();
        });
    }
}