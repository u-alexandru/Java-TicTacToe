package com.mycompany.app;

import com.mycompany.app.Helpers.ChoseFirstMoveEntity;
import com.mycompany.app.Helpers.Speaker;
import com.mycompany.app.Interfaces.ChoseFirstMoveService;
import com.mycompany.app.Interfaces.GameService;
import com.mycompany.app.Interfaces.GameSpeaker;

public class App {

    public static void main(String[] args) {
        ChoseFirstMoveService choseFirstToMove = new ChoseFirstMoveEntity();
        GameService game = new Game(choseFirstToMove);
        Initializer initializer = new Initializer(game);
        initializer.init();
    }
}

