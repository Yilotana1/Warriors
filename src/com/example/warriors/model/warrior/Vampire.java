package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;

public class Vampire extends Warrior {

    private static final int HUNDRED_PERCENT = 100;

    private int vampirism;

    public Vampire() {
        vampirism = getOriginalVampirism();
    }

    @Override
    public void punch(Warrior enemy) {

        int previousEnemyHealth = enemy.getHealth();

        super.punch(enemy);

        setHealth(getHealth() + ((previousEnemyHealth - enemy.getHealth()) * getVampirism()) / HUNDRED_PERCENT);

    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        getVampirismFromWeapon(weapon);

    }

    private void getVampirismFromWeapon(Weapon weapon) {
        int generalVampirism = vampirism + weapon.getVampirism();
        if (generalVampirism > HUNDRED_PERCENT) {
            vampirism = HUNDRED_PERCENT;
        } else {
            vampirism = Math.max(0, generalVampirism);
        }
    }

    @Override
    protected void setHealth(int health) {
        if (health > getMaxHealth()) {
            this.health = getMaxHealth();
        }
        super.setHealth(health);
    }

    public int getVampirism() {
        return vampirism;
    }

    protected int getOriginalVampirism() {
        return Parameters.VAMPIRE_VAMPIRISM;
    }

    @Override
    public int getMaxHealth() {
        return Parameters.VAMPIRE_HEALTH;
    }

    @Override
    protected int getOriginalAttack() {
        return Parameters.VAMPIRE_ATTACK;
    }
}
