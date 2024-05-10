package com.mycompany.app;

import com.mycompany.app.Helpers.Speaker;
import com.mycompany.app.Interfaces.GameService;
import com.mycompany.app.Interfaces.GameSpeaker;

public class App {

    public static void main(String[] args) {
        GameSpeaker speaker = new Speaker();
        GameService game = new Game(speaker);
        Initializer initializer = new Initializer(game);
        initializer.init();
    }
}

