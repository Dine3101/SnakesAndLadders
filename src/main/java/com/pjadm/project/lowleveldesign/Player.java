package com.pjadm.project.lowleveldesign;

public class Player {
    private int id;
    private Cell cell;

    Player(int id,Cell cell){
        this.id=id;
        this.cell=cell;
    }
    public void setCell(Cell cell){
        this.cell=cell;
    }

    public Cell getCell(){
        return this.cell;
    }

    public int getId(){
        return this.id;
    }
}
