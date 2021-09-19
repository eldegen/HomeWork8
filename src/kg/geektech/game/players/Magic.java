package kg.geektech.game.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        Random rand = new Random();
        int dmgBoost = rand.nextInt(5);

        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + dmgBoost);
        }
        System.out.println("================= Magic's boost! =================");
        System.out.println("Magic buffed to all heroes " + dmgBoost + " DMG");
        System.out.println("==================================================");
    }
}
