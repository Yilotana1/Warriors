package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Defender extends Warrior {

    @Override
    protected void decreaseHealth(int attack) {
        if (attack > getDefense()) {
            super.decreaseHealth(attack - getDefense());
        }
    }

    @Override
    public int getMaxHealth() {
        return Parameters.DEFENDER_HEALTH;
    }

    @Override
    public int getOriginalAttack() {
        return Parameters.DEFENDER_ATTACK;
    }


    public int getOriginalDefense(){
        return Parameters.DEFENDER_DEFENSE;
    }

    public int getDefense() {
        int weaponsDefense = getWeapons().stream().mapToInt(Weapon::getDefense).sum();
        int generalDefense = getOriginalDefense() + weaponsDefense;

        return Math.max(generalDefense, 0);
    }
}
