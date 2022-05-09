package com.example.warriors.model.warrior;

public class Knight extends Warrior {


   @Override
   public int getOriginalAttack(){
       return Parameters.KNIGHT_ATTACK;
   }

    @Override
    public int getMaxHealth() {
        return Parameters.KNIGHT_HEALTH;
    }
}
