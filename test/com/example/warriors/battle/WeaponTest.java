package com.example.warriors.battle;

import com.example.warriors.model.warrior.Vampire;
import com.example.warriors.model.warrior.Warrior;
import com.example.warriors.model.weapon.Sword;
import com.example.warriors.model.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                .healPower(0).build();
        Weapon sword = new Sword();

        unit1.equipWeapon(weapon);
        unit2.equipWeapon(sword);

        assertTrue(Battle.fight(unit1, unit2));
    }
}
