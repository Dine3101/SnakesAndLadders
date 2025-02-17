package com.pjadm.project.lowleveldesign;

public class Ladder extends Obstacle{
    private int id;
    Ladder(int startPosition,int endPosition,int id){
        super(startPosition,endPosition);
        this.id=id;
    }

    public int getStartPosition(){
        return super.getStartPosition();
    }

    public int getEndPosition(){
        return super.getEndPosition();
    }

    public void displayMessage(){
        System.out.println(Message.LUCKY.getMessage());
    }

    public String getId(){
        return "L"+this.id;
    }
}
