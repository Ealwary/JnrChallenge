package at.ealwary.jnrchallenge.timer;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StartJnr;
import at.ealwary.jnrchallenge.object.Time;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collections;

public class JnrTimer extends Timer {

    private JnrChallenge plugin;
    private int counter;
    private boolean isRunning;


    public JnrTimer(JnrChallenge plugin) {
        this.plugin = plugin;

        counter = 0;
    }

    public void timeJnr() {
        BukkitTask jnrTimer = new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimerAsynchronously(plugin, 20 * 60 * 5, 20 * 60 * 5);

        int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

            }
        }, 0, 20);
    }


    @Override
    public void start() {
        isRunning = true;
        taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
            @Override
            public void run() {
                counter++;
                plugin.getTime().addCounter();

                if (plugin.getTime().isCountdownFinished()) {
                    new StartJnr(plugin);
                    stop();
                }
            }
        }, 20, 20);

    }

    @Override
    public void stop() {
        if (isRunning) {
            Bukkit.getScheduler().cancelTask(taskID);
            isRunning = false;
        }
    }
}


