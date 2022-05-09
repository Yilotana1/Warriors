package com.example.warriors.battle;

import com.example.warriors.model.army.Army;
import com.example.warriors.model.warrior.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.warriors.battle.Battle.fight;
import static org.junit.jupiter.api.Assertions.*;

class ArmyFightTest {

    Army army1;
    Army army2;


    @BeforeEach
    void beforeEach() {
        army1 = new Army();
        army2 = new Army();
    }

    @ParameterizedTest(name = "[{index}] n1 = {0}, n2 = {1}")
    @CsvSource({"1,2", "2,3", "5,7"})
    void test1(int n1, int n2) {
        army1.addUnits(Warrior.class, n1);
        army2.addUnits(Warrior.class, n2);

        assertFalse(fight(army1, army2));
    }

    @ParameterizedTest(name = "[{index}] n1 = {0}, n2 = {1}")
    @CsvSource({"20,21", "10,11", "11,7"})
    void test2(int n1, int n2) {
        army1.addUnits(Warrior.class, n1);
        army2.addUnits(Warrior.class, n2);

        assertTrue(fight(army1, army2));
    }

    @Test
    void test3() {
        army1.addUnits(Warrior.class, 5)
                .addUnits(Defender.class, 4)
                .addUnits(Defender.class, 5);

        army2.addUnits(Warrior.class, 4);

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void test4() {
        army1.addUnits(Defender.class, 5).addUnits(Warrior.class, 20);
        army2.addUnits(Warrior.class, 21).addUnits(Defender.class, 4);
        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    void test5() {
        army1.addUnits(Warrior.class, 10).addUnits(Defender.class, 5);
        army2.addUnits(Warrior.class, 10).addUnits(Defender.class, 5);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void test6() {
        army1.addUnits(Defender.class, 2).addUnits(Warrior.class, 1);
        army2.addUnits(Defender.class, 1).addUnits(Warrior.class, 5);
        assertFalse(Battle.fight(army1, army2));
    }

    @ParameterizedTest
    @CsvSource({"5,6,7,6,6,6", "2,3,4,4,4,3"})
    void test7(int n1, int n2, int n3, int n4, int n5, int n6) {
        army1.addUnits(Defender.class, n1).addUnits(Vampire.class, n2)
                .addUnits(Warrior.class, n3);

        army2.addUnits(Warrior.class, n4).addUnits(Defender.class, n5)
                .addUnits(Vampire.class, n6);

        assertFalse(Battle.fight(army1, army2));
    }


    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(11, 13, 4, 4, 4, 13),
                Arguments.of(9, 3, 8, 4, 4, 13)

        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void test9(int n1, int n2, int n3, int n4, int n5, int n6) {
        army1.addUnits(Defender.class, n1).addUnits(Vampire.class, n2)
                .addUnits(Warrior.class, n3);

        army2.addUnits(Warrior.class, n4).addUnits(Defender.class, n5)
                .addUnits(Vampire.class, n6);

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void test10() {
        army1.addUnits(Lancer.class, 5);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 5);

        assertFalse(Battle.fight(army1, army2));
    }


    @Test
    void test11() {
        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);

        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void test12(){
        army1.addUnits(Lancer.class, 1);
        army1.addUnits(Warrior.class, 3);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Knight.class, 2);
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Healer.class, 1);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);
        assertFalse(Battle.fight(army1, army2));
    }



}
