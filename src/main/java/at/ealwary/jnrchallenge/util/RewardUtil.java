package at.ealwary.jnrchallenge.util;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class RewardUtil {
    private JnrChallenge plugin;

    public RewardUtil(JnrChallenge plugin) {
        this.plugin = plugin;

        rewards();
    }

    public ArrayList<ItemStack> rewards() {
        ArrayList<ItemStack> rewards = new ArrayList<>();

        return rewards;
    }

    public ItemStack getRandomReward() {
        Collections.shuffle(rewards());
        return rewards().get(0);
    }
}
