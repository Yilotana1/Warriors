package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Healer extends Warrior {

    private static final int MAX_HEALTH = 60;
    private static final int ATTACK = 0;
    private static final int HEALING = 2;
    public static final int HUNDRED_PERCENT = 100;
    private int healing;


    public Healer() {
        healing = getOriginalHealing();
    }

    public int getOriginalHealing() {
        return HEALING;
    }

    public void heal(Warrior ally) {
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
        return ATTACK;
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }


}
