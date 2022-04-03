package at.ealwary.jnrchallenge.object;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class InventoryItem {
    private ItemStack itemStack;
    private int slot;

    public InventoryItem(ItemStack itemStack, int slot) {
        this.itemStack = itemStack;
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
