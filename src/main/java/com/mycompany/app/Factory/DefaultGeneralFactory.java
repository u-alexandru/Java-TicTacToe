package com.mycompany.app.Factory;

import com.mycompany.app.*;
import com.mycompany.app.Helpers.ChoseFirstMoveEntity;
import com.mycompany.app.Helpers.GameSpeaker;
import com.mycompany.app.Interfaces.*;

public class DefaultGeneralFactory implements GeneralFactory {
    @Override
    public Speaker createSpeaker() {
        return new GameSpeaker();
    }

    @Override
    public GameService createGame() {
        return new Game(createPlayOrder());
    }

    @Override
    public Movable createMove() {
        return new Move();
    }

    @Override
    public Playable createComputer() {
        return new Computer();
    }

    @Override
    public Playable createPlayer() {
        return new Player();
    }

    @Override
    public Board createGameboard() {
        return new Gameboard();
    }

    @Override
    public DeterminePlayerOrder createPlayOrder() {
        return new ChoseFirstMoveEntity(createSpeaker());
    }
}
