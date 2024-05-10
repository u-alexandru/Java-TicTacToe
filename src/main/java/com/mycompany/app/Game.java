package com.mycompany.app;

import com.mycompany.app.Interfaces.DeterminePlayerOrder;
import com.mycompany.app.Interfaces.GameService;

public class Game implements GameService {

    private char firstToMove = 'p';

    private final DeterminePlayerOrder ChoseStartingEntity;

    public Game(DeterminePlayerOrder ChoseStartingEntity) {
        this.ChoseStartingEntity = ChoseStartingEntity;
    }

    public void setFirstToMove(char firstToMove) {
        this.firstToMove = firstToMove;
    }

    @Override
    public void startGame() throws Exception {
        this.setFirstToMove(ChoseStartingEntity.choseStartingEntity());
    }


}