package com.example.warriors.model.weapon;


public class MagicWand extends Weapon {


    @Override
    public int getHealth() {
        return Parameters.MAGIC_WAND_HEALTH;
    }

    @Override
    public int getAttack() {
        return Parameters.MAGIC_WAND_ATTACK;
    }

    @Override
    public int getHealing() {
        return Parameters.MAGIC_WAND_HEALING;
    }
}
