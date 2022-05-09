package com.example.warriors.model.weapon;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Weapon {

    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healing;

}
