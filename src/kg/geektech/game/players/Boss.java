package kg.geektech.game.players;

public class Boss extends GameEntity{
    private int stunnedForRounds;
    private boolean wasStunned;
    public Boss(int health, int damage, boolean wasStunned) {
        super(health, damage);
        this.wasStunned = wasStunned;
    }

    public boolean isWasStunned() {
        return wasStunned;
    }

    public void setWasStunned(boolean wasStunned) {
        this.wasStunned = wasStunned;
    }

    public int getStunnedForRounds() {
        return stunnedForRounds;
    }

    public void setStunnedForRounds(int stunnedForRounds) {
        this.stunnedForRounds = stunnedForRounds;
    }
}
