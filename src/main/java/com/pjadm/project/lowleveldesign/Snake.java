package com.pjadm.project.lowleveldesign;

public class Snake extends Obstacle{

    private int id;
    Snake(int startPosition,int endPosition,int id){
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
        System.out.println(Message.UNLUCKY.getMessage());
    }
    public String getId(){
        return "S"+this.id;
    }

}
