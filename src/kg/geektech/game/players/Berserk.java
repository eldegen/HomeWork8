package kg.geektech.game.players;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        boss.setHealth(boss.getHealth() - boss.getDamage());

        System.out.println("================= Berserk's revert! =================");
        System.out.println("Berserk reverts " + boss.getDamage() + " HP to Boss");
        System.out.println("=====================================================");
    }
}
