package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Vampire extends Warrior {

    private static final int VAMPIRISM = 50;
    private static final int ATTACK = 4;
    private static final int MAX_HEALTH = 40;
    private static final int HUNDRED_PERCENT = 100;

    @Override
    public void punch(Warrior enemy) {

        int previousEnemyHealth = enemy.getHealth();

        super.punch(enemy);

        setHealth(getHealth() + ((previousEnemyHealth - enemy.getHealth()) * getVampirism()) / HUNDRED_PERCENT);

    }


    @Override
    protected void setHealth(int health) {
        if (health > getMaxHealth()) {
            this.health = getMaxHealth();
        }
        super.setHealth(health);
    }

    public int getVampirism() {
        int weaponsVampirism = getWeapons().stream().mapToInt(Weapon::getVampirism).sum();
        int generalVampirism = getOriginalVampirism() + weaponsVampirism;

        if (generalVampirism > HUNDRED_PERCENT) {
            return HUNDRED_PERCENT;
        }

        return Math.max(generalVampirism, 0);
    }

    protected int getOriginalVampirism() {
        return VAMPIRISM;
    }

    @Override
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    protected int getOriginalAttack() {
        return ATTACK;
    }
}
