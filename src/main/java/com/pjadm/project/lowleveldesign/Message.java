package com.pjadm.project.lowleveldesign;

public enum Message {
    LUCKY("Feeling Lucky to use Ladder 😊😊😊"),
    UNLUCKY("Bad Luck to get to face a Snake 😒😒😒");

    private final String message;
    Message(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
