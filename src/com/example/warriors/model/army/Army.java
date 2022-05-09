package com.example.warriors.model.army;

import com.example.warriors.battle.Battle;
import com.example.warriors.model.warrior.Healer;
import com.example.warriors.model.warrior.Shaman;
import com.example.warriors.model.warrior.Warlord;
import com.example.warriors.model.warrior.Warrior;
import com.example.warriors.model.weapon.Weapon;

import java.util.Iterator;
import java.util.LinkedList;

public class Army implements Iterable<Warrior> {

    private LinkedList<Warrior> warriors = new LinkedList<>();

    public Army addUnits(Class<? extends Warrior> type, int n) {
        if (type == Warlord.class) {
            if (getWarlord() != null) {
                return this;
            }
            n = 1;
        }
        for (int i = 0; i < n; i++) {
            warriors.addFirst(Warrior.ofType(type));
        }
        return this;
    }

    public boolean isEmpty() {

        return warriors.isEmpty();
    }


    private Warrior getWarrior() {
        mixWarriors();
        return warriors.getFirst();
    }


    private void removeWarrior() {
        warriors.removeFirst();
    }


    public void lineUp() {
        Iterator<Warrior> iterator = iterator();

        if (iterator.hasNext()) {
            Warrior currentWarrior = iterator.next();

            Warrior nextWarrior;
            while (iterator.hasNext()) {
                nextWarrior = iterator.next();
                currentWarrior.setNextWarrior(nextWarrior);
                currentWarrior = nextWarrior;
            }
        }
    }


    public void attack(Army anotherArmy) {

        Warrior warrior = this.getWarrior();
        Warrior enemy = anotherArmy.getWarrior();

        if (warrior == null || enemy == null) {
            return;
        }

        if (bothAreHealers(warrior, enemy) || bothAreShamans(warrior, enemy)) {
            removeWarrior();
            anotherArmy.removeWarrior();
            return;
        }

        if (Battle.fight(warrior, enemy)) {
            anotherArmy.removeWarrior();

            addEnemyWarrior(this, enemy);
            return;
        }
        this.removeWarrior();
        addEnemyWarrior(anotherArmy, warrior);
    }

    private void addEnemyWarrior(Army anotherArmy, Warrior warrior) {
        if (warrior.isHypnotized()) {
            anotherArmy.addUnit(warrior);
        }
    }

    public Army addUnit(Warrior enemy) {
        warriors.addFirst(enemy);
        return this;
    }

    private boolean bothAreShamans(Warrior warrior, Warrior enemy) {
        return warrior instanceof Shaman && enemy instanceof Shaman;
    }


    public void straightAttack(Army enemyArmy) {
        Iterator<Warrior> iterator = this.iterator();
        Iterator<Warrior> enemyIterator = enemyArmy.iterator();

        while (iterator.hasNext() && enemyIterator.hasNext()) {

            Warrior warrior = iterator.next();
            Warrior enemy = enemyIterator.next();

            if (bothAreHealers(warrior, enemy) || bothAreShamans(warrior, enemy)) {
                continue;
            }

            if (Battle.fight(warrior, enemy)) {
                enemyIterator.remove();
            } else {
                iterator.remove();
            }
        }
    }


    @Override
    public Iterator<Warrior> iterator() {
        return warriors.iterator();
    }

    public boolean isAlive() {
        Iterator<Warrior> iterator = this.iterator();
        while (iterator.hasNext()) {
            Warrior warrior = iterator.next();
            if (!warrior.isAlive()) {
                iterator.remove();
            }
        }
        return !isEmpty();
    }

    public void equipWarrior(int position, Weapon weapon) {
        if (position > warriors.size() || position < 0) {
            return;
        }
        Warrior warrior = warriors.get(position);
        warrior.equipWeapon(weapon);
    }

    private boolean bothAreHealers(Warrior warrior, Warrior enemy) {
        return warrior instanceof Healer && enemy instanceof Healer;
    }

    private Warlord getWarlord() {
        for (Warrior w : warriors) {
            if (w.getClass() == Warlord.class) {
                return (Warlord) w;
            }
        }
        return null;
    }

    public void mixWarriors() {
        Warlord warlord = getWarlord();
        if (warlord != null) {
            warriors = warlord.mixWarriors(this);
        }
    }
}
