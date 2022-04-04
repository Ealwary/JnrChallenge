package at.ealwary.jnrchallenge.timer;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StartJnr;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Bukkit;

public class JnrTimer extends Timer {

    private JnrChallenge plugin;
    private boolean isRunning;


    public JnrTimer(JnrChallenge plugin) {
        this.plugin = plugin;
    }


    @Override
    public void start() {
        isRunning = true;
        taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                plugin.setTime(new Time(plugin.getTime().getCounter() + 1));

                if (plugin.getSettings().isShowTimer()) {
                    plugin.getTimerUtil().setTimer();
                    Bukkit.broadcastMessage(String.valueOf(plugin.getTime().getCounter()));
                }

                if (plugin.getTime().isCountdownFinished()) {
                    new StartJnr(plugin);
                    stop();
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 3)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_3);
                        });
                    }
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 2)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_2);
                        });
                    }
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 1)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_1);
                        });
                    }
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

    public boolean isRunning() {
        return isRunning;
    }
}


