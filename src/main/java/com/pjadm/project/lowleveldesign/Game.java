package com.pjadm.project.lowleveldesign;

import java.util.*;

public class Game {

    private static int boardRowCount;
    private static int boardColCount;
    private static int cellCount;
    private static int obstacleCellCount;
    private static int diceCount;
    private static int playerCount;
    private static int snakeCount;
    private static int ladderCount;
    private static Board board;
    private static Dice dice;
    private static Random random;
    private static Deque<Player> playerQueue;

    public static void initGame(){
        boardRowCount=5;
        boardColCount=5;
        cellCount=boardColCount*boardRowCount;
        diceCount=2;
        playerCount=2;
        snakeCount=3;
        ladderCount=4;
        obstacleCellCount=0;
        board=new Board(boardRowCount,boardColCount);
        dice=new Dice(diceCount);
        random=new Random();
        playerQueue=new ArrayDeque<>();
        for(int i=1;i<=playerCount;i++) {
            playerQueue.offerLast(new Player(i, board.getCell(0)));
        }
        for(int i=1;i<=snakeCount && obstacleCellCount<cellCount;){
            int randomStartPosition=random.nextInt(1,cellCount-1);
            int randomEndPosition=random.nextInt(1,cellCount-1);
            if(randomEndPosition>=randomStartPosition) continue;
            Cell startCell=board.getCell(randomStartPosition);
            Cell endCell=board.getCell(randomEndPosition);
            if(startCell.isBlocked() || endCell.isBlocked()) continue;
            Obstacle obstacle=ObstacleFactory.getObstacle("SNAKE",randomStartPosition,randomEndPosition,i);
            startCell.setObstacle(obstacle);
            startCell.block();
            startCell.setId(obstacle.getId());
            endCell.block();
            endCell.setId(obstacle.getId());
            obstacleCellCount+=2;
            i++;
        }
        for(int i=1;i<=ladderCount && obstacleCellCount<cellCount;){
            int randomStartPosition=random.nextInt(1,cellCount-1);
            int randomEndPosition=random.nextInt(1,cellCount-1);
            if(randomEndPosition<=randomStartPosition) continue;
            Cell startCell=board.getCell(randomStartPosition);
            Cell endCell=board.getCell(randomEndPosition);
            if(startCell.isBlocked() || endCell.isBlocked()) continue;
            Obstacle obstacle=ObstacleFactory.getObstacle("LADDER",randomStartPosition,randomEndPosition,i);
            startCell.setObstacle(obstacle);
            startCell.block();
            startCell.setId(obstacle.getId());
            endCell.block();
            endCell.setId(obstacle.getId());
            obstacleCellCount+=2;
            i++;
        }
        displayMessage("Board set");
        board.diplay();
    }

    public static void displayMessage(String message){
        System.out.println(message);
    }
    public static void main(String[] args) throws InterruptedException {
        initGame();
        displayMessage("Game Started!!!");
        displayMessage("Players are at position :0 need to move to position :"+(cellCount-1)+" to win");
        while(!playerQueue.isEmpty()) {
            Player player = playerQueue.pollFirst();
            Cell currentCell = player.getCell();
            int move = dice.roll();
            displayMessage("Player :" + player.getId() + " at position :" + currentCell.getPosition() + " -> move :" + move);
            int nextPosition=currentCell.getPosition() + move;
            if (nextPosition >= cellCount) nextPosition=cellCount-1;

            Cell nextCell = board.getCell(nextPosition);
            while (nextCell.hasObstacle()) {
                Obstacle obstacle = nextCell.getObstacle();
                obstacle.displayMessage();
                nextCell = board.getCell(obstacle.getEndPosition());
            }
            player.setCell(nextCell);
            displayMessage("Player :" + player.getId() + " moved to position :" + nextCell.getPosition());
            if (nextCell.getPosition() == cellCount - 1) {
                displayMessage("Player :" + player.getId() + " has win🎉🎉🎉");
                break;
            }

            playerQueue.offerLast(player);
            Thread.sleep(1000);
        }
        displayMessage("Game Over!!!");

    }

    
}
