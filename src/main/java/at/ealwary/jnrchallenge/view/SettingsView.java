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

    public SettingsView(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, 9*4, ID.INVENTORY_NAME_START + ID.INVENTORY_NAME_SETTINGS);
    }

    public void build() {
        fill9_4(inventory);
        inventory.setItem(10, new ItemBuilder(Material.CHEST).setDisplayName("§6Inventar behalten").setLore("§aWenn aktiviert: §rBehalte dein Inventar, ", "wenn du bei einem Jump and Run stirbst").create());
        inventory.setItem(12, new ItemBuilder(Material.DIAMOND).setDisplayName("§6Belohnungen").setLore("§aWenn aktiviert: §rErhalte eine zufällige Belohnung,", "wenn du ein Jump and Run schaffst.").addEnchantment(Enchantment.DURABILITY, 0).create());
        inventory.setItem(14, new ItemBuilder(Material.CLOCK).setDisplayName("§6Warnung vor JumpAndRun").setLore("§aWenn aktiviert: §rErhalte eine Chatnachricht", "bevor du in ein JumpAndRun teleportiert wirst.").create());
        inventory.setItem(16, new ItemBuilder(Material.ENDER_CHEST).setDisplayName("§6Sichere Speicherung").setLore("§aWenn aktiviert: §rInventare werden in Datenbank gespeichert", "(Vorteil: Falls der Server während eines Jump and Runs", "abstürzt, gehen die Inventare nicht verloren.").create());


        if(settings.isKeepInventory()) {
            inventory.setItem(19, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(19, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isGetReward()) {
            inventory.setItem(21, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(21, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isGetWarnedBeforeTeleport()) {
            inventory.setItem(23, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(23, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }

        if(settings.isSaveInventorysToMySQL()) {
            inventory.setItem(25, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayName("§a§l» Aktiviert").create());
        } else {
            inventory.setItem(25, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setDisplayName("§c§l» Deaktiviert").create());
        }
    }

    public void show() {
        this.player.openInventory(this.inventory);
    }



    private void fill9_4(Inventory inventory) {
        int[] slots = new int[]{0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,21,23,25,27,28,29,30,31,32,33,34,35};
        for (int i : slots) {
            inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("§8").create());
        }
    }
}
