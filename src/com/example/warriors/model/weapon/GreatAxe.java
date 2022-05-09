package com.example.warriors.model.weapon;

public class GreatAxe extends Weapon {


    @Override
    public int getAttack() {
        return Parameters.GREAT_AXE_ATTACK;
    }

    @Override
    public int getHealth() {
        return Parameters.GREAT_AXE_HEALTH;
    }

    @Override
    public int getDefense() {
        return Parameters.GREAT_AXE_DEFENSE;
    }

    @Override
    public int getVampirism() {
        return Parameters.GREAT_AXE_VAMPIRISM;
    }
}
