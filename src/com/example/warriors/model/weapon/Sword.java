package com.example.warriors.model.weapon;

public class Sword extends Weapon {


    private static final int HEALTH = 5;
    private static final int ATTACK = 2;

    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
