package com.example.warriors.model.warrior;

public class Shaman extends Warrior {

    @Override
    public int getMaxHealth() {
        return Parameters.SHAMAN_HEALTH;
    }

    @Override
    public int getOriginalAttack() {
        return Parameters.SHAMAN_ATTACK;
    }

    @Override
    public void punch(Warrior enemy) {
        if (!(enemy instanceof Warlord)) {
            enemy.becomeHypnotized();
        }
    }
}
