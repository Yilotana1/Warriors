package com.example.warriors.battle;

import com.example.warriors.model.army.Army;
import com.example.warriors.model.warrior.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StraightFightTest {

    Army army1;
    Army army2;


    @BeforeEach
    void beforeEach() {
        army1 = new Army();
        army2 = new Army();
    }

    @ParameterizedTest
    @CsvSource({"5,3,4,2,4,4,6,5"})
    void test1(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        army1.addUnits(Lancer.class, n1);
        army1.addUnits(Vampire.class, n2);
        army1.addUnits(Warrior.class, n3);
        army1.addUnits(Defender.class, n4);
        army2.addUnits(Warrior.class, n5);
        army2.addUnits(Defender.class, n6);
        army2.addUnits(Vampire.class, n7);
        army2.addUnits(Lancer.class, n8);

        assertFalse(Battle.straightFight(army1, army2));

    }

    @ParameterizedTest
    @CsvSource({"7,3,4,2,4,4,6,4"})
    void test2(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        army1.addUnits(Lancer.class, n1);
        army1.addUnits(Vampire.class, n2);
        army1.addUnits(Warrior.class, n3);
        army1.addUnits(Defender.class, n4);
        army2.addUnits(Warrior.class, n5);
        army2.addUnits(Defender.class, n6);
        army2.addUnits(Vampire.class, n7);
        army2.addUnits(Lancer.class, n8);

        assertTrue(Battle.straightFight(army1, army2));

    }

    @Test
    void test3() {
        army1.addUnits(Warrior.class, 2);
        army2.addUnits(Warrior.class, 2);

        var result = Battle.straightFight(army1, army2);
        assertTrue(result);
    }

    @Test
    void test4() {
        army1.addUnits(Vampire.class, 3);
        army2.addUnits(Warrior.class, 2);
        army2.addUnits(Knight.class, 1);

        var result = Battle.straightFight(army1, army2);
        assertFalse(result);
    }

    @Test
    void test5() {
        army1.addUnits(Vampire.class, 4);
        army2.addUnits(Warrior.class, 2);
        army2.addUnits(Knight.class, 1);

        var result = Battle.straightFight(army1, army2);
        assertTrue(result);
    }

    @Test
    void test6() {
        army1.addUnits(Vampire.class, 4);
        army2.addUnits(Healer.class, 1);
        army2.addUnits(Warrior.class, 2);

        var result = Battle.straightFight(army1, army2);
        assertTrue(result);
    }

    @Test
    void test7() {
        army1.addUnits(Vampire.class, 4);
        army2.addUnits(Lancer.class, 1);
        army2.addUnits(Warrior.class, 2);

        var result = Battle.straightFight(army1, army2);
        assertTrue(result);
    }
}
