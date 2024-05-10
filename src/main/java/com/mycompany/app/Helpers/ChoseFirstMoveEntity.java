package com.mycompany.app.Helpers;

import com.mycompany.app.Interfaces.DeterminePlayerOrder;
import com.mycompany.app.Interfaces.Speaker;

public class ChoseFirstMoveEntity implements DeterminePlayerOrder {

    final Speaker gameSpeaker;
    short playerTries;

    public ChoseFirstMoveEntity(Speaker speaker) {
        this.gameSpeaker = speaker;
    }

    @Override
    public char choseStartingEntity() throws Exception {

        if(playerTries >= 4) {
            playerTries = 0;
            throw new Exception("Too many wrong answers exiting...");
        }

        char playerAnswer = Character.toLowerCase(gameSpeaker.askQuestion("Do you want to begin first? Y/N"));

        if(playerAnswer == 'n') {
            return 'c';
        } else if(playerAnswer == 'y') {
            return 'p';
        } else {
            playerTries++;
            choseStartingEntity();
        }
        return 'p';
    }
}