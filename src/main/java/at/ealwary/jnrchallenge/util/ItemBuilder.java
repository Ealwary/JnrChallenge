package at.ealwary.jnrchallenge.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, short subId) {
        this.itemStack = new ItemStack(material, 1, subId);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, int amount, short subId) {
        this.itemStack = new ItemStack(material, amount, subId);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setDisplayName(String displayName) {
        this.itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder addAllItemFlags() {
        for (ItemFlag itemFlag : ItemFlag.values()) {
            itemMeta.addItemFlags(itemFlag);
        }
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder setUnbreakable() {
        this.itemMeta.setUnbreakable(true);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int enchantmentLevel) {
        this.itemStack.addUnsafeEnchantment(enchantment, enchantmentLevel);
        return this;
    }

    public ItemBuilder addLore(String lore) {
        List<String> aLore = this.itemMeta.getLore() != null ? this.itemMeta.getLore() : new ArrayList<>();
        aLore.add(lore);
        this.itemMeta.setLore(aLore);
        return this;
    }

    public ItemBuilder setLocalizedName(String name) {
        this.itemMeta.setLocalizedName(name);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStack create() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
