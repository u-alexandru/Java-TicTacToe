package com.mycompany.app;

import com.mycompany.app.Interfaces.ChoseFirstMoveService;
import com.mycompany.app.Interfaces.GameService;

public class Game implements GameService {
    private char firstToMove = 'p';
    private final ChoseFirstMoveService ChoseStartingEntity;

    public Game(ChoseFirstMoveService ChoseStartingEntity) {
        this.ChoseStartingEntity = ChoseStartingEntity;
    }

    public void setFirstToMove(char firstToMove) {
        this.firstToMove = firstToMove;
    }

    @Override
    public void startGame() {
        this.setFirstToMove(ChoseStartingEntity.choseStartingEntity());
    }


}