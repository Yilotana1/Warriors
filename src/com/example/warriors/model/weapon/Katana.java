package com.example.warriors.model.weapon;


public class Katana extends Weapon {

    private static final int HEALTH = -20;
    private static final int ATTACK = 6;
    private static final int DEFENSE = -5;
    private static final int VAMPIRISM = 50;


    @Override
    public int getHealth() {
        return HEALTH;
    }

    @Override
    public int getAttack() {
        return ATTACK;
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
