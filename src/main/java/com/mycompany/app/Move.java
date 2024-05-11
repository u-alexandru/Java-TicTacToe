package com.mycompany.app;

import com.mycompany.app.Interfaces.Board;
import com.mycompany.app.Interfaces.Movable;
import com.mycompany.app.Interfaces.Playable;

import java.util.Scanner;

public class Move implements Movable {

    private final Playable player;
    private final Playable computer;

    public Move(Playable player, Playable computer) {
        this.player = player;
        this.computer = computer;
    }

    @Override
    public void makeMove() {
    }

    @Override
    public void playerMove(char piece) {
        player.drawBoard();
        System.out.println("Type your move. EX. 1A\n");
        Scanner scanner = new Scanner(System.in);
        String inputMove = scanner.nextLine();
        if(!player.validMove(inputMove)) {
            playerMove(piece);
        }
        player.move(piece, inputMove);
    }

    @Override
    public void computerMove(char piece) {
        computer.drawBoard();
        computer.move(piece);
    }

}