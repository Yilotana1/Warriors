package com.example.warriors.model.weapon;

public class Shield extends Weapon{



    @Override
    public int getHealth() {
        return Parameters.SHIELD_HEALTH;
    }

    @Override
    public int getAttack() {
        return Parameters.SHIELD_ATTACK;
    }

    @Override
    public int getDefense() {
        return Parameters.SHIELD_DEFENSE;
    }


}
