package com.pjadm.project.lowleveldesign;

public class Cell {
    private int row;
    private int col;

    private String id;
    private int position;
    private Obstacle obstacle;

    private boolean isBlocked;
    Cell(int row,int col,int position){
        this.row=row;
        this.col=col;
        this.position=position;
        this.obstacle=null;
        this.id=".";
    }

    public void setObstacle(Obstacle obstacle){
        this.obstacle=obstacle;
    }

    public Obstacle getObstacle(){
        return this.obstacle;
    }

    public boolean hasObstacle(){
        return this.obstacle!=null;
    }

    public void block(){
        this.isBlocked=true;
    }
    public boolean isBlocked(){
        return this.isBlocked;
    }
    public int getPosition(){
        return this.position;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }
}
