package at.ealwary.jnrchallenge.object;

import org.bukkit.inventory.ItemStack;

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
