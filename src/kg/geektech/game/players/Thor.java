package kg.geektech.game.players;

import java.util.Random;

public class Thor extends Hero{
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUNNING);
    }


    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        Random rand = new Random();
        boolean canUseStun = rand.nextBoolean();

        if (canUseStun && !boss.isWasStunned()) {
            boss.setStunnedForRounds(2);
            boss.setWasStunned(true);
            System.out.println("============ Thor does stun! ============");
            System.out.println("Boss was stunned by Thor for one round");
            System.out.println("=========================================");
        }
    }
}
