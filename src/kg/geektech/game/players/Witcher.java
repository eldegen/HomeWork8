package kg.geektech.game.players;

import java.util.Random;

public class Witcher extends Hero{
    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.RESURRECTION);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        Random rand = new Random();
        int resurrectionChance = rand.nextInt(100);

        if (resurrectionChance >= 60 && getHealth() != 0) { // Шанс 40%
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() <= 0 && i != 7) {
                    heroes[i].setHealth(getHealth());
                    setHealth(0);
                    System.out.println("============= Witcher resurrected someone! =============");
                    System.out.println("Witcher resurrected " + heroes[i].getClass().getSimpleName() + " by sacrificing himself");
                    System.out.println("========================================================");
                    break;
                }
            }
        }
    }
}
