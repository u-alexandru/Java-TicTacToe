package com.mycompany.app.Interfaces;

public interface GeneralFactory {
    Speaker createSpeaker();

    GameService createGame();

    Movable createMove();

    Playable createComputer();

    Playable createPlayer();

    Board createGameboard();

    DeterminePlayerOrder createPlayOrder();
}
