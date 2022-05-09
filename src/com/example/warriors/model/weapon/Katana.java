package com.example.warriors.model.weapon;


public class Katana extends Weapon {



    @Override
    public int getHealth() {
        return Parameters.KATANA_HEALTH;
    }

    @Override
    public int getAttack() {
        return Parameters.KATANA_ATTACK;
    }

    @Override
    public int getDefense() {
        return Parameters.KATANA_DEFENSE;
    }

    @Override
    public int getVampirism() {
        return Parameters.KATANA_VAMPIRISM;
    }
}
