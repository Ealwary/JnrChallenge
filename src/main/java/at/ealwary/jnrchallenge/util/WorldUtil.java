package at.ealwary.jnrchallenge.util;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.*;

public class WorldUtil {

    private JnrChallenge plugin;

    public WorldUtil(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    public void createWorld() {
        WorldCreator worldCreator = new WorldCreator("JumpAndRunWorld");
        worldCreator.type(WorldType.FLAT);
        worldCreator.generateStructures(false);
        worldCreator.hardcore(false);
        World world = Bukkit.getServer().createWorld(worldCreator);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        plugin.setJnrWorld(world);
    }
}
