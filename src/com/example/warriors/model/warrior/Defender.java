package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Defender extends Warrior {

    private int defense;

    public Defender() {
        defense = getOriginalDefense();
    }

    @Override
    protected void decreaseHealth(int attack) {
        if (attack > getDefense()) {
            super.decreaseHealth(attack - getDefense());
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        getDefenseFromWeapon(weapon);
    }

    private void getDefenseFromWeapon(Weapon weapon) {
        int generalDefense = defense + weapon.getDefense();
        defense = Math.max(0, generalDefense);
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
        return defense;
    }
}
