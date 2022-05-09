package com.example.warriors.model.warrior;

public class Lancer extends Warrior {

    private static final int ATTACK = 6;
    private static final int DECREASED_ATTACK = 50;
    private static final int HUNDRED_PERCENT = 100;

    @Override
    public void punch(Warrior enemy) {

        super.punch(enemy);

        Warrior nextEnemy = enemy.getNextWarrior();
        if (nextEnemy != null) {
            nextEnemy.decreaseHealth(getAttack() * getDecreasedAttack() / HUNDRED_PERCENT);
        }

    }

    protected int getDecreasedAttack() {
        return DECREASED_ATTACK;
    }

    @Override
    public int getOriginalAttack() {
        return ATTACK;
    }
}
