package com.example.warriors.model.warrior;

public class Healer extends Warrior {

    public void heal(Warrior ally){
        ally.increaseHealth(getHealing());
    }


    protected int getHealing() {
        return Parameters.HEALER_HEALING;
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
