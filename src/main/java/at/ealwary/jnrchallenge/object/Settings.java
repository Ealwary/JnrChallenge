package at.ealwary.jnrchallenge.object;

public class Settings {

    private boolean showTimer;
    private boolean keepInventory;
    private boolean getReward;                      //
    private boolean getWarnedBeforeTeleport;        //
    private boolean saveInventorysToMySQL;

    public Settings() {
        this.showTimer = true;
        this.keepInventory = true;
        this.getReward = true;
        this.getWarnedBeforeTeleport = true;
        this.saveInventorysToMySQL = false;
    }

    public boolean isShowTimer() {
        return showTimer;
    }

    public boolean isKeepInventory() {
        return keepInventory;
    }

    public boolean isGetReward() {
        return getReward;
    }

    public boolean isSaveInventorysToMySQL() {
        return saveInventorysToMySQL;
    }

    public void setShowTimer(boolean showTimer) {
        this.showTimer = showTimer;
    }

    public boolean isGetWarnedBeforeTeleport() {
        return getWarnedBeforeTeleport;
    }

    public void setGetReward(boolean getReward) {
        this.getReward = getReward;
    }

    public void setKeepInventory(boolean keepInventory) {
        this.keepInventory = keepInventory;
    }

    public void setGetWarnedBeforeTeleport(boolean getWarnedBeforeTeleport) {
        this.getWarnedBeforeTeleport = getWarnedBeforeTeleport;
    }

    public void setSaveInventorysToMySQL(boolean saveInventorysToMySQL) {
        this.saveInventorysToMySQL = saveInventorysToMySQL;
    }
}
