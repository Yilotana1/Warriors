package com.example.warriors.battle;

import com.example.warriors.model.army.Army;
import com.example.warriors.model.warrior.Warrior;

import java.util.function.Consumer;

public class Battle {

    private Battle() {
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        while (warrior1.isAlive() || !warrior1.isHypnotized()) {

            warrior1.punch(warrior2);

            if (!warrior2.isAlive() || warrior2.isHypnotized()) {
                return true;
            }
            warrior2.punch(warrior1);
        }
        return false;
    }


    public static boolean fight(Army army1, Army army2) {

        lineUpArmies(army1, army2);

        return armyFight(army1, army2, army1::attack);
    }


    public static boolean straightFight(Army army1, Army army2) {
        return armyFight(army1, army2, army1::straightAttack);
    }


    private static void lineUpArmies(Army army1, Army army2) {
        army1.lineUp();
        army2.lineUp();
    }

    private static boolean armyFight(Army army1, Army army2, Consumer<Army> attack) {
        while (army1.isAlive()) {
            attack.accept(army2);

            if (!army2.isAlive()) {
                return true;
            }
        }

        return false;
    }

}
