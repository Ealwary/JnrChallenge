package at.ealwary.jnrchallenge.util;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Time;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class TimerUtil {
    private JnrChallenge plugin;

    public TimerUtil(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    public String getTimeString() {
        Time time = plugin.getTime();
        String timeString = ID.TIMER_PREFIX1;

        if (time.getHours() > 0) {
            if (time.getHours() < 10) {
                timeString = timeString + "0";
            }
            timeString = timeString + time.getHours() + ID.TIMER_PREFIX2;
        }

        if (time.getMinutes() < 10) {
            if (time.getMinutes() == 0) {
                timeString = timeString + "00";
            } else {
                timeString = timeString + "0" + time.getMinutes();
            }
        } else {
            timeString = timeString + time.getMinutes();
        }

        timeString = timeString + ID.TIMER_PREFIX2;

        if (time.getSeconds() < 10) {
            if (time.getSeconds() == 0) {
                timeString = timeString + "00";
            } else {
                timeString = timeString + "0" + time.getSeconds();
            }
        } else {
            timeString = timeString + time.getSeconds();
        }

        return timeString;
    }

    public void setTimer() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            key.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(getTimeString()));
        });
    }

    public void deleteTimer() {
        plugin.getPlayerHashMap().forEach((key, value) -> {
            key.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
        });
    }
}
