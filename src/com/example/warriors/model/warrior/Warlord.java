package com.example.warriors.model.warrior;

import com.example.warriors.model.army.Army;

import java.util.LinkedList;
import java.util.List;

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

    public LinkedList<Warrior> mixWarriors(Army army) {

        LinkedList<Warrior> healers = new LinkedList<>();
        LinkedList<Warrior> warriors = new LinkedList<>();

        for (Warrior warrior : army) {

            if (warrior instanceof Healer) {
                healers.addLast(warrior);
            } else if (warrior instanceof Lancer) {
                warriors.addFirst(warrior);
            } else if (!(warrior instanceof Warlord)) {
                warriors.addLast(warrior);
            }
        }

        if (warriors.isEmpty()) {
            if (healers.isEmpty()) {
                return new LinkedList<>(List.of(this));
            }
            healers.addLast(this);
            return healers;
        }
        warriors.addAll(1, healers);
        warriors.addLast(this);
        return warriors;
    }


}
