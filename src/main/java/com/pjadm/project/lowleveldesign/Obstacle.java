package com.pjadm.project.lowleveldesign;

public abstract class Obstacle {

    private int startPosition;
    private int endPosition;

    Obstacle(int startPosition,int endPosition){
        this.startPosition=startPosition;
        this.endPosition=endPosition;
    }
    public int getStartPosition(){
        return this.startPosition;
    }

    public int getEndPosition(){
        return this.endPosition;
    }

    public abstract void displayMessage();
    public abstract String getId();

}
