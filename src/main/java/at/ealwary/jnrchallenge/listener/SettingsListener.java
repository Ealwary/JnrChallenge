package at.ealwary.jnrchallenge.listener;

import at.ealwary.jnrchallenge.JnrChallenge;
import at.ealwary.jnrchallenge.object.Settings;
import at.ealwary.jnrchallenge.util.ID;
import at.ealwary.jnrchallenge.util.TimerUtil;
import at.ealwary.jnrchallenge.view.SettingsView;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SettingsListener implements Listener {
    private JnrChallenge plugin;
    private TimerUtil timerUtil;

    public SettingsListener(JnrChallenge plugin) {
        this.plugin = plugin;
        timerUtil = plugin.getTimerUtil();
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
        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {
            case 11:
            case 20: {      //timer
                plugin.getSettings().setShowTimer(!plugin.getSettings().isShowTimer());
                reopenInv(player);
                timerUtil = plugin.getTimerUtil();
                if (plugin.getSettings().isShowTimer()) {
                    timerUtil.setTimer();
                } else {
                    timerUtil.deleteTimer();
                }
                break;
            }


            case 12:
            case 21: {      //keepInventory
                plugin.getSettings().setKeepInventory(!plugin.getSettings().isKeepInventory());
                reopenInv(player);
                break;
            }

            case 13:
            case 22: {      //reward
                plugin.getSettings().setGetReward(!plugin.getSettings().isGetReward());
                reopenInv(player);
                break;
            }

            case 14:
            case 23: {      //warn
                plugin.getSettings().setGetWarnedBeforeTeleport(!plugin.getSettings().isGetWarnedBeforeTeleport());
                reopenInv(player);
                break;
            }

            case 15:
            case 24: {      //saveInventory

                break;
            }

            default: {
                break;
            }
        }
    }

    private void reopenInv(Player player) {
        SettingsView settingsView = new SettingsView(plugin, player);
        settingsView.build();
        settingsView.show();
    }
}
