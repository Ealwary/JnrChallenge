package at.ealwary.jnrchallenge.jumpAndRun;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;

public class StartJnr {
    private JnrChallenge plugin;
    private Jnr jnr;
    private Settings settings;

    public StartJnr(JnrChallenge plugin) {
        this.plugin = plugin;
        settings = plugin.getSettings();

        if (plugin.getJumpAndRuns().size() == 0) {
            plugin.getJnrLocation().fillJnr();
        }
        this.jnr = plugin.getJumpAndRuns().get(0);

        sendMessageToPlayers();
        saveInventories();
        buildJnr();
        teleport();
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