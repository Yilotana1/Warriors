package com.example.warriors.model.weapon;

public class GreatAxe extends Weapon {

    private static final int HEALTH = -15;
    private static final int ATTACK = 5;
    private static final int DEFENSE = -2;
    private static final int VAMPIRISM = 50;

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public int getVampirism() {
        return VAMPIRISM;
    }
}
