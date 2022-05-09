package com.example.warriors.model.weapon;

public class Sword extends Weapon {

    @Override
    public int getHealth() {
        return Parameters.SWORD_HEALTH;
    }

    @Override
    public int getAttack() {
        return Parameters.SWORD_ATTACK;
    }
}
