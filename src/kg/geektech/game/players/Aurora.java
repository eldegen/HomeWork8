package kg.geektech.game.players;

public class Aurora extends Hero{
    public Aurora(int health, int damage) {
        super(health, damage, SuperAbility.INVISIBILITY);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {

    }
}
