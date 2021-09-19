package kg.geektech.game.players;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.DEFENCE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        double takeDamage = 0.2;
        if (boss.isWasStunned() == false) {
            if (heroes[6].getHealth() != 0) {
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() >= 1) {
                        heroes[i].setHealth(heroes[i].getHealth() + (boss.getDamage() * takeDamage));
                    }
                }
                heroes[6].setHealth(heroes[6].getHealth() - ((boss.getDamage() * takeDamage) * 2));
                System.out.println("============ Golem took the damage! ============");
                System.out.println("Golem took " + takeDamage + " of the boss damage");
                System.out.println("================================================");
            }
        }
    }
}
