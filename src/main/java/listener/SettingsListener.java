package listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.util.ID;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsListener implements Listener {
    private JnrChallenge plugin;

    public SettingsListener(JnrChallenge plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getRawSlot() < 0) return;
        if (event.getSlot() < 0) return;

        if (!(event.getView().getTitle().startsWith(ID.INVENTORY_NAME_START))) return;
        event.setCancelled(true);
        if (event.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) return;
        if (event.getClickedInventory() != event.getView().getTopInventory()) return;

        switch (event.getSlot()) {
            case 10:
            case 19: {      //keepInventory
                plugin.getSettings().setKeepInventory(!plugin.getSettings().isKeepInventory());
                break;
            }

            case 12:
            case 21: {      //reward
                plugin.getSettings().setGetReward(!plugin.getSettings().isGetReward());
                break;
            }

            case 14:
            case 23: {      //warn
                plugin.getSettings().setGetWarnedBeforeTeleport(!plugin.getSettings().isGetWarnedBeforeTeleport());
                break;
            }

            case 16:
            case 25: {      //saveInventory
                plugin.getSettings().setSaveInventorysToMySQL(!plugin.getSettings().isSaveInventorysToMySQL());
                break;
            }

            default: {
                break;
            }

        }
    }
}
