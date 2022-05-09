package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Healer extends Warrior {

    private int healing;
    private static final int HUNDRED_PERCENT = 100;

    public void heal(Warrior ally){
        ally.increaseHealth(getHealing());
    }


    protected int getHealing() {
        return healing;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        getHealingFromWeapon(weapon);
    }

    private void getHealingFromWeapon(Weapon weapon) {
        int generalHealing = healing + weapon.getHealing();
        if (generalHealing > HUNDRED_PERCENT) {
            healing = HUNDRED_PERCENT;
        } else {
            healing = Math.max(0, generalHealing);
        }
    }

    @Override
    public int getOriginalAttack() {
        return Parameters.HEALER_ATTACK;
    }

    @Override
    public int getMaxHealth() {
        return Parameters.HEALER_HEALTH;
    }


}
