package at.ealwary.jnrchallenge.object;


import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class Jnr {

    private Location spawnLocation;         //1 Spawn Location + 6 Jump Blöcke + 1 Ziel
    private Location[] jumpLocations;
    private Location goal;
    private JnrChallenge plugin;

    private Material spawnMaterial;
    private Material jumpMaterial;
    private Material goalMaterial;

    public Jnr(JnrChallenge plugin, Location spawnLocation, Location[] jumpLocations, Location goal) {
        this.plugin = plugin;
        this.spawnLocation = spawnLocation;
        this.jumpLocations = jumpLocations;
        this.goal = goal;

        spawnMaterial = Material.NETHERITE_BLOCK;
        jumpMaterial = Material.ORANGE_TERRACOTTA;
        goalMaterial = Material.GOLD_BLOCK;
    }

    public void build() {
        World world = plugin.getJnrWorld();
        world.getBlockAt(spawnLocation).setType(spawnMaterial);
        world.getBlockAt(goal).setType(goalMaterial);
        for(Location currentLocation : jumpLocations) {
            world.getBlockAt(currentLocation).setType(jumpMaterial);
        }
    }

    public void remove() {
        World world = plugin.getJnrWorld();
        world.getBlockAt(spawnLocation).setType(Material.AIR);
        world.getBlockAt(goal).setType(Material.AIR);
        for(Location currentLocation : jumpLocations) {
            world.getBlockAt(currentLocation).setType(Material.AIR);
        }
    }

    public Location getGoal() {
        return goal;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public Location[] getJumpLocations() {
        return jumpLocations;
    }

    public void setGoal(Location goal) {
        this.goal = goal;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public void setJumpLocations(Location[] jumpLocations) {
        this.jumpLocations = jumpLocations;
    }
}
