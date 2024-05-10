package com.mycompany.app;

import com.mycompany.app.Interfaces.GameService;

public class Initializer {
    private final GameService gameService;

    public Initializer(GameService gameService) {
        this.gameService = gameService;
    }

    public void init() throws Exception {
        this.gameService.startGame();
    }
}