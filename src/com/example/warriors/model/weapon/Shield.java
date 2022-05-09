package com.example.warriors.model.weapon;

public class Shield extends Weapon{

    private static final int HEALTH = 20;
    private static final int ATTACK = -1;
    private static final int DEFENSE = -2;


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


}
