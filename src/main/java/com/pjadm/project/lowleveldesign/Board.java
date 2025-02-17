package com.pjadm.project.lowleveldesign;

public class Board {
    private int rowCount;
    private int colCount;

    private Cell[][] cells;

    Board(int rowCount,int colCount){
        this.rowCount=rowCount;
        this.colCount=colCount;
        cells=new Cell[rowCount][colCount];
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                cells[i][j]=new Cell(i,j,i*colCount+j);
            }
        }
    }
    public Cell getCell(int position){
        int rowPos=position/colCount;
        int colPos=position%colCount;
        return cells[rowPos][colPos];
    }

    public void diplay(){
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                System.out.print(cells[i][j].getId()+" ");
            }
            System.out.println();
        }
    }

}
