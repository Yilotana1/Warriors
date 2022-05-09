package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Defender extends Warrior {

    private static final int DEFENSE = 2;
    private static final int ATTACK = 3;
    private static final int MAX_HEALTH = 60;

    @Override
    protected void decreaseHealth(int attack) {
        if (attack > getDefense()) {
            super.decreaseHealth(attack - getDefense());
        }
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public int getOriginalAttack() {
        return ATTACK;
    }


    public int getOriginalDefense(){
        return DEFENSE;
    }

    public int getDefense() {
        int weaponsDefense = getWeapons().stream().mapToInt(Weapon::getDefense).sum();
        int generalDefense = getOriginalDefense() + weaponsDefense;

        return Math.max(generalDefense, 0);
    }
}
