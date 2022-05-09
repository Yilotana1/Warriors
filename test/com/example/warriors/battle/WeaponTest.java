package com.example.warriors.battle;

import com.example.warriors.model.army.Army;

import com.example.warriors.model.warrior.*;
import com.example.warriors.model.weapon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {


    @Test
    void test1() {
        Warrior unit1 = Warrior.ofType(Warrior.class);
        Warrior unit2 = Warrior.ofType(Vampire.class);

        Weapon weapon = Weapon.builder()
                .health(-10)
                .attack(5)
                .defense(0)
                .vampirism(40)
                .healing(0).build();
        Weapon sword = new Sword();

        unit1.equipWeapon(weapon);
        unit2.equipWeapon(sword);

        assertTrue(Battle.fight(unit1, unit2));
    }

    @Test
    void test2() {
        Warrior unit1 = Warrior.ofType(Defender.class);
        Warrior unit2 = Warrior.ofType(Lancer.class);

        Weapon weapon1 = new Shield();
        Weapon weapon2 = new GreatAxe();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        assertFalse(Battle.fight(unit1, unit2));
    }


    @Test
    void test3() {
        Warrior unit1 = Warrior.ofType(Healer.class);
        Warrior unit2 = Warrior.ofType(Knight.class);

        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new Katana();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        assertFalse(Battle.fight(unit1, unit2));
    }

    @Test
    void test4() {
        Warrior unit1 = Warrior.ofType(Defender.class);
        Warrior unit2 = Warrior.ofType(Vampire.class);

        Weapon weapon1 = new Shield();
        Weapon weapon2 = new MagicWand();
        Weapon weapon3 = new Shield();
        Weapon weapon4 = new Katana();

        unit1.equipWeapon(weapon1);
        unit1.equipWeapon(weapon2);

        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(weapon4);
        assertFalse(Battle.fight(unit1, unit2));
    }


    @Test
    void test5() {
        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new GreatAxe();

        Army army1 = new Army();
        army1.addUnits(Knight.class, 1);
        army1.addUnits(Lancer.class, 1);

        Army army2 = new Army();
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 1);

        army1.equipWarrior(0, weapon1);
        army1.equipWarrior(1, weapon2);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon2);

        assertTrue(Battle.fight(army1, army2));

    }

    @Test
    void test6() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();

        Army army1 = new Army();
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warrior.class, 1);

        Army army2 = new Army();
        army2.addUnits(Knight.class, 1);
        army2.addUnits(Healer.class, 1);

        army1.equipWarrior(0, weapon2);
        army1.equipWarrior(1, weapon2);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon1);

        assertTrue(Battle.fight(army1, army2));

    }


    @Test
    void test7() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();

        Army army1 = new Army();
        army1.addUnits(Defender.class, 2);

        Army army2 = new Army();
        army2.addUnits(Knight.class, 1);
        army2.addUnits(Vampire.class, 1);

        army1.equipWarrior(0, weapon1);
        army1.equipWarrior(1, weapon1);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon1);

        assertFalse(Battle.fight(army1, army2));

    }

    @Test
    void test8() {
        Weapon weapon1 = Weapon.builder()
                .health(-20)
                .attack(6)
                .defense(1)
                .vampirism(40)
                .healing(-2).build();

        Weapon weapon2 = Weapon.builder()
                .health(-20)
                .attack(-2)
                .defense(2)
                .vampirism(-55)
                .healing(3).build();

        Army army1 = new Army();
        army1.addUnits(Knight.class, 3);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 1);
        army2.addUnits(Defender.class, 2);

        army1.equipWarrior(0, weapon1);
        army1.equipWarrior(1, weapon1);
        army1.equipWarrior(2, weapon2);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon2);
        army2.equipWarrior(2, weapon2);

        assertTrue(Battle.fight(army1, army2));

    }

    @Test
    void test9() {
        Weapon weapon1 = Weapon.builder()
                .health(-20)
                .attack(1)
                .defense(1)
                .vampirism(40)
                .healing(-2).build();

        Weapon weapon2 = Weapon.builder()
                .health(20)
                .attack(2)
                .defense(2)
                .vampirism(-55)
                .healing(3).build();

        Army army1 = new Army();
        army1.addUnits(Vampire.class, 3);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 1);
        army2.addUnits(Defender.class, 2);

        army1.equipWarrior(0, weapon1);
        army1.equipWarrior(1, weapon1);
        army1.equipWarrior(2, weapon2);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon2);
        army2.equipWarrior(2, weapon2);

        assertFalse(Battle.straightFight(army1, army2));

    }



    @Test
    void test10() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();

        Army army1 = new Army();
        army1.addUnits(Vampire.class, 3);

        Army army2 = new Army();
        army2.addUnits(Warrior.class, 1);
        army2.addUnits(Defender.class, 1);

        army1.equipWarrior(0, weapon2);
        army1.equipWarrior(1, weapon2);
        army1.equipWarrior(2, weapon2);

        army2.equipWarrior(0, weapon1);
        army2.equipWarrior(1, weapon1);

        assertTrue(Battle.straightFight(army1, army2));

    }

}
