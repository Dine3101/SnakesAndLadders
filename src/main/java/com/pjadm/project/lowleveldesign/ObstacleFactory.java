package com.pjadm.project.lowleveldesign;

public class ObstacleFactory {
    public static Obstacle getObstacle(String obstacle,int startPosition,int endPosition,int id){
        switch(obstacle){
            case "SNAKE":return new Snake(startPosition,endPosition,id);
            case "LADDER":return new Ladder(startPosition,endPosition,id);
        }
        return null;
    }
}
