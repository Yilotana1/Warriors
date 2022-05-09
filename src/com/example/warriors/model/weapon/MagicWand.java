package com.example.warriors.model.weapon;


public class MagicWand extends Weapon {

    private static final int HEALTH = 30;
    private static final int ATTACK = 3;
    private static final int HEAL_POWER = 3;

    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getHealing() {
        return HEAL_POWER;
    }
}
