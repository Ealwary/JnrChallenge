package at.ealwary.jnrchallenge;

import at.ealwary.jnrchallenge.jumpAndRun.JnrLocation;
import at.ealwary.jnrchallenge.object.Jnr;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.timer.JnrTimer;
import at.ealwary.jnrchallenge.util.RewardUtil;
import at.ealwary.jnrchallenge.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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
    private ArrayList<Jnr> jumpAndRuns;
    private HashMap<Player, Integer> playerHashMap;         //0 = ingame; 1 = geschafft; 2 = tot;
    private HashMap<Player, PlayerInventory> playerInventories;
    private HashMap<Player, Location> normalLocations;
    private Time time;
    private Settings settings;
    private RewardUtil rewardUtil;

    @Override
    public void onEnable() {
        jnrLocation = new JnrLocation(this);
        jumpAndRuns = new ArrayList<>();
        playerHashMap = new HashMap<>();
        init(Bukkit.getPluginManager());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void init(PluginManager pluginManager) {
        WorldUtil worldUtil = new WorldUtil(this);
        JnrTimer jnrTimer = new JnrTimer(this);

        worldUtil.createWorld();
        jnrTimer.timeJnr();
        jnrLocation.createJnr();
        jnrLocation.fillJnr();
        time = new Time(0);
        settings = new Settings();
        rewardUtil = new RewardUtil(this);
        playerInventories = new HashMap<>();
        normalLocations = new HashMap<>();

        new JnrLocation(this);

        Collections.shuffle(jumpAndRuns);
    }

    public HashMap<Player, Integer> getPlayerHashMap() {
        return playerHashMap;
    }

    public ArrayList<Jnr> getJumpAndRuns() {
        return jumpAndRuns;
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

    public HashMap<Player, PlayerInventory> getPlayerInventories() {
        return playerInventories;
    }

    public HashMap<Player, Location> getNormalLocations() {
        return normalLocations;
    }

    public void setJnrWorld(World jnrWorld) {
        this.jnrWorld = jnrWorld;
    }


}
