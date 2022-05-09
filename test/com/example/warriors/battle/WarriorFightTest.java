package com.example.warriors.battle;

import com.example.warriors.model.warrior.Defender;
import com.example.warriors.model.warrior.Knight;
import com.example.warriors.model.warrior.Warrior;
import org.junit.jupiter.api.Test;

import static com.example.warriors.battle.Battle.fight;
import static org.junit.jupiter.api.Assertions.*;

class WarriorFightTest {


    class Rookie extends Warrior {

        private static final int ATTACK = 1;

        @Override
        public int getAttack() {
            return ATTACK;
        }

        Rookie() {
            super.health = 50;
        }
    }

    @Test
    void test1() {
        Warrior carl = new Warrior();
        Warrior jim = new Knight();

        assertFalse(fight(carl, jim));
    }

    @Test
    void test2() {
        Warrior ramon = new Knight();
        Warrior slevin = new Warrior();

        assertTrue(fight(ramon, slevin));
    }

    @Test
    void test3() {
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    void test4() {
        Warrior zeus = new Knight();
        Warrior godkiller = new Warrior();

        fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    void test5() {
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();

        fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    void test6() {
        Warrior dragon = new Warrior();
        Warrior knight = new Knight();

        fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    void test7() {
        Warrior unit1 = new Warrior();
        Warrior unit2 = new Knight();
        Warrior unit3 = new Warrior();

        fight(unit1, unit2);

        assertFalse(fight(unit2, unit3));

    }


    @Test
    void test8() {
        Warrior unit1 = new Defender();
        Warrior unit2 = new Rookie();
        fight(unit1, unit2);

        assertEquals(60, unit1.getHealth());
    }

    @Test
    void test9() {
        Warrior unit1 = new Defender();
        Warrior unit2 = new Rookie();
        Warrior unit3 = new Warrior();
        fight(unit1, unit2);
        assertTrue(fight(unit1, unit3));

    }


}