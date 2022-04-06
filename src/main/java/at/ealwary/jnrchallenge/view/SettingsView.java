package at.ealwary.jnrchallenge.view;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;
import at.ealwary.jnrchallenge.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SettingsView {
    private Player player;
    private Inventory inventory;
    private Settings settings;
    private JnrChallenge plugin;

    public SettingsView(JnrChallenge plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        this.inventory = Bukkit.createInventory(null, 9 * 4, ID.INVENTORY_NAME_START + ID.INVENTORY_NAME_SETTINGS);
    }

    public void build() {
        settings = plugin.getSettings();

        fill9_4(inventory);
        inventory.setItem(10, new ItemBuilder(Material.CLOCK).setDisplayName("§6§lTimer anzeigen").setLore("§aWenn aktiviert: §rZeigt dir den Timer an.").create());
        inventory.setItem(12, new ItemBuilder(Material.CHEST).setDisplayName("§6§lInventar behalten").setLore("§aWenn aktiviert: §rBehalte dein Inventar, ", "§rwenn du bei einem Jump and Run stirbst.").create());
        inventory.setItem(14, new ItemBuilder(Material.DIAMOND).setDisplayName("§6§lBelohnungen").setLore("§aWenn aktiviert: §rErhalte eine zufällige Belohnung,", "§rwenn du ein Jump and Run schaffst.").addEnchantment(Enchantment.DURABILITY, 0).create());
        inventory.setItem(16, new ItemBuilder(Material.REDSTONE).setDisplayName("§6§lWarnung vor JumpAndRun").setLore("§aWenn aktiviert: §rErhalte eine Chatnachricht", "§rbevor du in ein JumpAndRun teleportiert wirst.").create());
//10, 12, 14, 16
        //19, 21, 23, 25

        if (settings.isShowTimer()) {
            inventory.setItem(19, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(19, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if (settings.isKeepInventory()) {
            inventory.setItem(21, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(21, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if (settings.isGetReward()) {
            inventory.setItem(23, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(23, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if (settings.isGetWarnedBeforeTeleport()) {
            inventory.setItem(25, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(25, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }
    }

    public void show() {
        this.player.openInventory(this.inventory);
    }


    private void fill9_4(Inventory inventory) {
        for (int i = 0; i <= 35; i++) {
            inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").create());
        }
    }
}
