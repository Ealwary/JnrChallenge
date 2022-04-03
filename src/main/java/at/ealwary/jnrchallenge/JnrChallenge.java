package at.ealwary.jnrchallenge;

import at.ealwary.jnrchallenge.command.ChallengeCommand;
import at.ealwary.jnrchallenge.command.SettingsCommand;
import at.ealwary.jnrchallenge.jumpAndRun.JnrLocation;
import at.ealwary.jnrchallenge.listener.*;
import at.ealwary.jnrchallenge.object.InventoryItem;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.provider.DatabaseProvider;
import at.ealwary.jnrchallenge.timer.JnrTimer;
import at.ealwary.jnrchallenge.util.ID;
import at.ealwary.jnrchallenge.util.RewardUtil;
import at.ealwary.jnrchallenge.util.TimerUtil;
import at.ealwary.jnrchallenge.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public final class JnrChallenge extends JavaPlugin {

    private World jnrWorld;
    private JnrLocation jnrLocation;
    private Jnr currentJnr;
    private HashMap<Player, Integer> playerHashMap;         //0 = ingame; 1 = geschafft; 2 = tot;
    private HashMap<Player, ArrayList<InventoryItem>> playerInventories;
    private HashMap<Player, Location> normalLocations;
    private Time time;
    private Settings settings;
    private RewardUtil rewardUtil;
    private TimerUtil timerUtil;
    private JnrTimer jnrTimer;
    private DatabaseProvider databaseProvider;
    FileConfiguration config;

    @Override
    public void onEnable() {
//        jnrLocation = new JnrLocation(this);
        currentJnr = null;
        playerHashMap = new HashMap<>();
        init(Bukkit.getPluginManager());

    }

    @Override
    public void onDisable() {
        databaseProvider.disconnect();
    }

    private void init(PluginManager pluginManager) {
        config = getConfig();

        databaseProvider = new DatabaseProvider(config.getString(ID.CPATH_HOST), config.getString(ID.CPATH_DATABASE), config.getString(ID.CPATH_USER), config.getString(ID.CPATH_PSWD));

        pluginManager.registerEvents(new EnvironmentListener(this), this);
        pluginManager.registerEvents(new PlayerConnectionListener(this), this);
        pluginManager.registerEvents(new PlayerDamageListener(this), this);
        pluginManager.registerEvents(new PlayersFinishJnr(this), this);
        pluginManager.registerEvents(new SettingsListener(this), this);

        getCommand("challenge").setExecutor(new ChallengeCommand(this));
        getCommand("settings").setExecutor(new SettingsCommand(this));

        WorldUtil worldUtil = new WorldUtil(this);
        jnrTimer = new JnrTimer(this);

        worldUtil.createWorld();
        jnrTimer.start();
//        jnrLocation.createJnr();
//        jnrLocation.fillJnr();
        time = new Time(0);
        settings = new Settings();
        rewardUtil = new RewardUtil(this);
        playerInventories = new HashMap<>();
        normalLocations = new HashMap<>();
        timerUtil = new TimerUtil(this);

//        new JnrLocation(this);
    }

    public HashMap<Player, Integer> getPlayerHashMap() {
        return playerHashMap;
    }

    public Jnr getCurrentJnr() {
        return currentJnr;
    }

    public World getJnrWorld() {
        return jnrWorld;
    }

    public Time getTime() {
        return time;
    }

    public JnrLocation getJnrLocation() {
        return jnrLocation;
    }

    public Settings getSettings() {
        return settings;
    }

    public RewardUtil getRewardUtil() {
        return rewardUtil;
    }

    public HashMap<Player, ArrayList<InventoryItem>> getPlayerInventories() {
        return playerInventories;
    }

    public HashMap<Player, Location> getNormalLocations() {
        return normalLocations;
    }

    public TimerUtil getTimerUtil() {
        return timerUtil;
    }

    public JnrTimer getJnrTimer() {
        return jnrTimer;
    }

    public DatabaseProvider getDatabaseProvider() {
        return databaseProvider;
    }

    public void setJnrWorld(World jnrWorld) {
        this.jnrWorld = jnrWorld;
    }

    public void setJnrTimer(JnrTimer jnrTimer) {
        this.jnrTimer = jnrTimer;
    }
}

//Delete JnrLocation?
//PlayerInvenotrys: Clear after restore
