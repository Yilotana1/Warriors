package com.example.warriors.model.warrior;

import com.example.warriors.model.army.Army;

import java.util.Collections;
import java.util.LinkedList;

public class Warlord extends Defender {

    @Override
    public int getOriginalDefense() {
        return Parameters.WARLORD_DEFENSE;
    }

    @Override
    public int getOriginalAttack() {
        return Parameters.WARRIOR_ATTACK;
    }

    @Override
    public int getMaxHealth() {
        return Parameters.WARLORD_HEALTH;
    }

    public LinkedList<Warrior> moveUnits(Army army) {

        LinkedList<Warrior> healers = new LinkedList<>();
        LinkedList<Warrior> warriors = new LinkedList<>();

        boolean firstLancerFound = false;
        for (Warrior w : army) {
            if (w.getClass() == Healer.class) {
                healers.addLast(w);
            } else if (w.getClass() != Warlord.class) {
                if (!firstLancerFound && w.getClass() == Lancer.class) {
                    warriors.addFirst(w);
                    firstLancerFound = true;
                } else {
                    warriors.addLast(w);
                }
            }
        }

        if (warriors.isEmpty()) {
            if (healers.isEmpty()) {
                return new LinkedList<>(Collections.singletonList(this));
            }
            healers.addLast(this);
            return healers;
        }
        warriors.addAll(1, healers);
        warriors.addLast(this);
        return warriors;

    }
}
