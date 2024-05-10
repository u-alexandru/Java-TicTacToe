package com.mycompany.app;

import com.mycompany.app.Factory.DefaultGeneralFactory;
import com.mycompany.app.Helpers.ChoseFirstMoveEntity;
import com.mycompany.app.Interfaces.DeterminePlayerOrder;
import com.mycompany.app.Interfaces.GameService;
import com.mycompany.app.Interfaces.GeneralFactory;

public class Main {

    public static void main(String[] args) {
        try {
            GeneralFactory defaultFactory = new DefaultGeneralFactory();
            GameService game = defaultFactory.createGame();
            game.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

