package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

public class StartJnr {
    private JnrChallenge plugin;
    private Jnr jnr;
    private Settings settings;

    public StartJnr(JnrChallenge plugin) {
        this.plugin = plugin;
        settings = plugin.getSettings();

        createJnr();
        sendMessageToPlayers();
        saveInventories();
        buildJnr();
        teleport();
    }

    public void createJnr() {
        World world = plugin.getJnrWorld();
        Location spawnLocation = new Location(world, 0, 200, 0, 0, 0);    //z+?

        Location[] jumpLocs = new Location[6];
        Location jumpGoal = new Location(world, 0, 0, 0);


        for (int i = 0; i < jumpLocs.length + 1; i++) {
            if (i == 0) {
                jumpLocs[0] = new Location(world, spawnLocation.getBlockX() + new Random().nextInt(3), spawnLocation.getBlockY() + new Random().nextInt(2), spawnLocation.getBlockZ() + new Random().nextInt(4));
            } else if (i == 6) {
                jumpGoal = new Location(world, jumpLocs[5].getBlockX() + new Random().nextInt(3), jumpLocs[5].getBlockY() + new Random().nextInt(2), jumpLocs[5].getBlockZ() + new Random().nextInt(4));
            } else {
                jumpLocs[i] = new Location(world, jumpLocs[i--].getBlockX() + new Random().nextInt(3), jumpLocs[i--].getBlockY() + new Random().nextInt(2), jumpLocs[i--].getBlockZ() + new Random().nextInt(3) + 1);
            }
        }

        this.jnr = new Jnr(plugin, spawnLocation, jumpLocs, jumpGoal);
    }

    public void sendMessageToPlayers() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            key.sendMessage(ID.TP_MESSAGE);
        });
    }

    public void saveInventories() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            plugin.getPlayerInventories().put(key, key.getInventory());
        });

        if (!settings.isSaveInventorysToMySQL()) return;

        //push Inventories
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