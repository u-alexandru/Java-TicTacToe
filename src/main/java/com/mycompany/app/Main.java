package com.mycompany.app;

import com.mycompany.app.Helpers.ChoseFirstMoveEntity;
import com.mycompany.app.Interfaces.DeterminePlayerOrder;
import com.mycompany.app.Interfaces.GameService;

public class Main {

    public static void main(String[] args) {
        DeterminePlayerOrder choseFirstToMove = new ChoseFirstMoveEntity();
        GameService game = new Game(choseFirstToMove);
        Initializer initializer = new Initializer(game);
        initializer.init();
    }
}

