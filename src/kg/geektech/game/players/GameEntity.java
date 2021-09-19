package kg.geektech.game.players;

public abstract class GameEntity {
    private double health;
    private int damage;

    public GameEntity(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
