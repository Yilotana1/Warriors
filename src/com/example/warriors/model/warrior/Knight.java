package com.example.warriors.model.warrior;

public class Knight extends Warrior {

   private static final int ATTACK = 7;

   @Override
   public int getOriginalAttack(){
       return Knight.ATTACK;
   }
}
