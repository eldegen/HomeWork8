package kg.geektech.game.general;

import kg.geektech.game.players.*;

public class RPG_Game {

    public static void start() {

        Boss boss = new Boss(1500, 50, false);

        Warrior warrior = new Warrior(250, 15);
        Medic doc = new Medic(200, 5, 15);
        Magic magic = new Magic(270, 20);
        Berserk berserk = new Berserk(300, 20);
        Medic assistant = new Medic(280, 10, 5);
        Thor thor = new Thor(300, 15);
        Golem golem = new Golem(600, 5);
        Witcher witcher = new Witcher(200, 0);
        Aurora aurora = new Aurora(250, 10);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor, golem, witcher, aurora};
        printStatistics(heroes, boss);

        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHits(heroes, boss);
        heroesHit(heroes, boss);
        applySuperPowers(heroes, boss);
        bossStun(boss);
//        isEntityHealthNegative(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && !boss.isWasStunned()) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void applySuperPowers(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && i != 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void bossStun(Boss boss) {
        boss.setStunnedForRounds(boss.getStunnedForRounds() - 1);
        if (boss.isWasStunned()) {
            if (boss.getStunnedForRounds() <= 0) {
                boss.setWasStunned(false);
                System.out.println("========= He is back! =========");
                System.out.println("         Boss woke up");
                System.out.println("===============================");
            }
        }
    }

    /*private static void isEntityHealthNegative (Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0) {
                heroes[i].setHealth(0);
            }
        }
        if (boss.getHealth() <= 0) {
            boss.setHealth(0);
        }
    }*/

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("================ Round recap ================");
        System.out.println("Boss health: " + boss.getHealth() +
                ", damage: " + boss.getDamage() + ", Stunned: " + boss.isWasStunned());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: "
                    + heroes[i].getHealth() +
                    ", damage: " + heroes[i].getDamage());
        }
        System.out.println("=============================================");
    }
}
