package at.ealwary.jnrchallenge.object;

public class PlayerCondition {
    private double health;
    private int foodLevel;

    public PlayerCondition(double health, int foodLevel) {
        this.health = health;
        this.foodLevel = foodLevel;
    }

    public double getHealth() {
        return health;
    }

    public int getFoodLevel() {
        return foodLevel;
    }
}
