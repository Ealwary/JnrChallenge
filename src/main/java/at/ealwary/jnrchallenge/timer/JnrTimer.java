package at.ealwary.jnrchallenge.timer;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.jumpAndRun.StartJnr;
import at.ealwary.jnrchallenge.object.Time;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class JnrTimer extends Timer {

    private JnrChallenge plugin;
    private boolean isRunning;

    public JnrTimer(JnrChallenge plugin) {
        this.plugin = plugin;
    }


    @Override
    public void start() {
        isRunning = true;

        taskID = new BukkitRunnable() {
            @Override
            public void run() {
                plugin.setTime(new Time(plugin.getTime().getCounter() + 1));

                if (plugin.getSettings().isShowTimer()) {
                    plugin.getTimerUtil().setTimer();
                }

                if (plugin.getTime().isCountdownFinished()) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            new StartJnr(plugin);
                            cancel();
                        }
                    }.runTask(plugin);
                    cancel();
                    isRunning = !isRunning;
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 3)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_3);
                            key.playSound(key.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                        });
                    }
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 2)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_2);
                            key.playSound(key.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                        });
                    }
                } else if (plugin.getTime().isCountdownFinished(plugin.getTime().getCounter() + 1)) {
                    if (plugin.getSettings().isGetWarnedBeforeTeleport()) {
                        plugin.getPlayerHashMap().forEach((key, value) -> {
                            key.sendMessage(ID.TP_WARN_MESSAGE_1);
                            key.playSound(key.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                        });
                    }
                }
            }
        }.runTaskTimerAsynchronously(plugin, 20, 20).getTaskId();
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


