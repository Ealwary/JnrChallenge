package at.ealwary.jnrchallenge;

import at.ealwary.jnrchallenge.command.ChallengeCommand;
import at.ealwary.jnrchallenge.command.SettingsCommand;
import at.ealwary.jnrchallenge.config.ConfigManager;
import at.ealwary.jnrchallenge.jumpAndRun.JnrLocation;
import at.ealwary.jnrchallenge.listener.*;
import at.ealwary.jnrchallenge.object.InventoryItem;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.object.Time;
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
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
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
    private FileConfiguration config;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
//        jnrLocation = new JnrLocation(this);
        currentJnr = null;
        playerHashMap = new HashMap<>();
        init(Bukkit.getPluginManager());

        for(Player current : Bukkit.getOnlinePlayers()) {
            playerHashMap.put(current, 0);
        }
    }

    @Override
    public void onDisable() {
        configManager.saveConfig();
    }

    private void init(PluginManager pluginManager) {
        config = getConfig();

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
//        jnrLocation.createJnr();
//        jnrLocation.fillJnr();
        time = new Time(0);
        settings = new Settings();
        rewardUtil = new RewardUtil(this);
        playerInventories = new HashMap<>();
        normalLocations = new HashMap<>();
        timerUtil = new TimerUtil(this);
        configManager = new ConfigManager(this);
        configManager.loadConfig();
        configManager.saveConfigAsynchronously();

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

    public void setTime(Time time) {
        this.time = time;
    }

    public void setJnrWorld(World jnrWorld) {
        this.jnrWorld = jnrWorld;
    }

    public void setJnrTimer(JnrTimer jnrTimer) {
        this.jnrTimer = jnrTimer;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void setCurrentJnr(Jnr currentJnr) {
        this.currentJnr = currentJnr;
    }
}

//Delete JnrLocation?
//PlayerInvenotrys: Clear after restore
//Recognise goal
