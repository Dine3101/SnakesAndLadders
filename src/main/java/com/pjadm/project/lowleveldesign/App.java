package com.pjadm.project.lowleveldesign;

public class App 
{
    public static void main( String[] args )
    {

        Dice dice=new Dice(1);
        for(int i=1;i<=10;i++){
            System.out.println(dice.roll());
        }
    }
}
