package at.ealwary.jnrchallenge.config;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class ConfigManager {
    private JnrChallenge plugin;
    private FileConfiguration config;

    public ConfigManager(JnrChallenge plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    public void prepareConfig() {
        config.addDefault(ID.CPATH_SHOW_TIMER, true);
        config.addDefault(ID.CPATH_KEEP_INV, true);
        config.addDefault(ID.CPATH_GET_REWARD, true);
        config.addDefault(ID.CPATH_WARN_BEFORE_TP, true);
        config.addDefault(ID.CPATH_COUNTER, 0);

        plugin.saveConfig();
    }

    public void loadConfig() {
        if (config.get(ID.CPATH_SHOW_TIMER) != null) {
            plugin.getSettings().setShowTimer(config.getBoolean(ID.CPATH_SHOW_TIMER));
        }
        if (config.get(ID.CPATH_KEEP_INV) != null) {
            plugin.getSettings().setKeepInventory(config.getBoolean(ID.CPATH_KEEP_INV));
        }
        if (config.get(ID.CPATH_GET_REWARD) != null) {
            plugin.getSettings().setGetReward(config.getBoolean(ID.CPATH_GET_REWARD));
        }
        if (config.get(ID.CPATH_WARN_BEFORE_TP) != null) {
            plugin.getSettings().setGetWarnedBeforeTeleport(config.getBoolean(ID.CPATH_WARN_BEFORE_TP));
        }
        if (config.get(ID.CPATH_COUNTER) != null) {
            plugin.setTime(new Time(config.getInt(ID.CPATH_COUNTER)));
        }

    }

    public void saveConfig() {
        config.set(ID.CPATH_SHOW_TIMER, plugin.getSettings().isShowTimer());
        config.set(ID.CPATH_KEEP_INV, plugin.getSettings().isKeepInventory());
        config.set(ID.CPATH_GET_REWARD, plugin.getSettings().isGetReward());
        config.set(ID.CPATH_WARN_BEFORE_TP, plugin.getSettings().isGetWarnedBeforeTeleport());
        config.set(ID.CPATH_COUNTER, plugin.getTime().getCounter());
        plugin.saveConfig();
    }

    public void saveConfigAsynchronously() {
        new BukkitRunnable() {
            @Override
            public void run() {
                saveConfig();
            }
        }.runTaskTimerAsynchronously(plugin, 20*60, 20*60);
    }
}
