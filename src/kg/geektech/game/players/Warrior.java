package kg.geektech.game.players;

import java.util.Random;

public class Warrior extends Hero{
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        Random rand = new Random();
        int minCrit = 2;
        int maxCrit = 4;
        int randCritMultiply = minCrit + (int) (Math.random() * ((maxCrit - minCrit) + 1));

        boss.setHealth(boss.getHealth() - (heroes[0].getDamage() * randCritMultiply));
        System.out.println("============ Warrior deals critical damage! ============");
        System.out.println("Warrior's total critical damage " + (getDamage() + (getDamage() * randCritMultiply)));
        System.out.println("========================================================");
    }
}
