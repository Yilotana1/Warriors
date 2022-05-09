package com.example.warriors.model.warrior;

import com.example.warriors.model.weapon.Weapon;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedList;

@Data
public class Warrior {

    private static final int ATTACK = 5;
    private static final int MAX_HEALTH = 50;

    private int attack;
    @Setter(value = AccessLevel.PROTECTED)
    protected int health;
    private Warrior nextWarrior;
    @Getter(value = AccessLevel.PROTECTED)
    private Collection<Weapon> weapons = new LinkedList<>();

    public Warrior() {
        health = getMaxHealth();
        attack = getOriginalAttack();
    }

    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
        getHealthFromWeapon(weapon);
        getAttackFromWeapon(weapon);
    }

    private void getHealthFromWeapon(Weapon weapon) {
        int generalHealth = health + weapon.getHealth();
        if (generalHealth > getMaxHealth()) {
            health = getMaxHealth();
        } else {
            health = Math.max(0, generalHealth);
        }
    }

    private void getAttackFromWeapon(Weapon weapon) {
        int generalAttack = attack + weapon.getAttack();
        attack = Math.max(0, generalAttack);
    }


    public Warrior getNextWarrior() {
        return nextWarrior;
    }

    public void setNextWarrior(Warrior nextWarrior) {
        this.nextWarrior = nextWarrior;
    }


    public void punch(Warrior enemy) {
        enemy.decreaseHealth(getAttack());
        notifyAboutPunch();
    }

    protected void notifyAboutPunch() {
        askForHealing();
        if (nextWarrior != null) {
            nextWarrior.notifyAboutPunch();
        }
    }

    private void askForHealing() {
        Warrior ally = getNextWarrior();
        if (ally instanceof Healer) {
            ((Healer) ally).heal(this);
        }
    }

    public int getHealth() {
        return health;
    }

    protected void decreaseHealth(int attack) {
        this.health = this.getHealth() - attack;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    protected int getOriginalAttack() {
        return Warrior.ATTACK;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public static Warrior ofType(Class<? extends Warrior> type) {
        try {
            Constructor<? extends Warrior> constructor = type.getDeclaredConstructor();
            return constructor.newInstance();

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void increaseHealth(int health) {

        if (getHealth() + health > getMaxHealth()) {
            setHealth(getMaxHealth());
            return;
        }
        setHealth(getHealth() + health);
    }
}
