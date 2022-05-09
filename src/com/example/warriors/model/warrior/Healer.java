package com.example.warriors.model.warrior;

public class Healer extends Warrior {

    private static final int MAX_HEALTH = 60;
    private static final int ATTACK = 0;
    private static final int HEALING = 2;



    public void heal(Warrior ally){
        ally.increaseHealth(getHealing());
    }


    protected int getHealing() {
        return HEALING;
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
