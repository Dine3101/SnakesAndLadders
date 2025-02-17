package com.pjadm.project.lowleveldesign;

import java.util.Random;

public class Dice {
    private int diceCount;
    private final int MIN=1;
    private final int MAX=6;

    private Random random;

    Dice(int diceCount){
        this.diceCount=diceCount;
        random=new Random();
    }
    public int roll(){
        int total=0;
        for(int i=1;i<=diceCount;i++){
            total+=(random.nextInt(MIN,MAX+1));
        }
        return total;
    }

}
