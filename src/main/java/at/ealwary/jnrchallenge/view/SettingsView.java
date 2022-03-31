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
        this.inventory = Bukkit.createInventory(null, 9*4, ID.INVENTORY_NAME_START + ID.INVENTORY_NAME_SETTINGS);
    }

    public void build() {
        settings = plugin.getSettings();

        fill9_4(inventory);
        inventory.setItem(11, new ItemBuilder(Material.CLOCK).setDisplayName("§6Timer anzeigen").setLore("§aWenn aktiviert: §rZeigt dir den Timer an.").create());
        inventory.setItem(12, new ItemBuilder(Material.CHEST).setDisplayName("§6Inventar behalten").setLore("§aWenn aktiviert: §rBehalte dein Inventar, ", "wenn du bei einem Jump and Run stirbst.").create());
        inventory.setItem(13, new ItemBuilder(Material.DIAMOND).setDisplayName("§6Belohnungen").setLore("§aWenn aktiviert: §rErhalte eine zufällige Belohnung,", "wenn du ein Jump and Run schaffst.").addEnchantment(Enchantment.DURABILITY, 0).create());
        inventory.setItem(14, new ItemBuilder(Material.REDSTONE).setDisplayName("§6Warnung vor JumpAndRun").setLore("§aWenn aktiviert: §rErhalte eine Chatnachricht", "bevor du in ein JumpAndRun teleportiert wirst.").create());
        inventory.setItem(15, new ItemBuilder(Material.ENDER_CHEST).setDisplayName("§6Sichere Speicherung").setLore("§aWenn aktiviert: §rInventare werden in Datenbank gespeichert", "(Vorteil: Falls der Server während eines Jump and Runs", "abstürzt, gehen die Inventare nicht verloren.").create());


        if(settings.isShowTimer()) {
            inventory.setItem(20, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(20, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isGetReward()) {
            inventory.setItem(21, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(21, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isGetWarnedBeforeTeleport()) {
            inventory.setItem(22, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(22, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isSaveInventorysToMySQL()) {
            inventory.setItem(23, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(23, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isSaveInventorysToMySQL()) {
            inventory.setItem(24, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(24, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
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
