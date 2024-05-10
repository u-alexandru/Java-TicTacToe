package com.mycompany.app.Helpers;

import com.mycompany.app.Interfaces.Speaker;

import java.util.Scanner;

public class GameSpeaker implements Speaker {
    public void writeText(String textToWrite) {
        System.out.println(textToWrite);
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public char askQuestion(String Question) {
        writeText(Question);
        return readInput().charAt(0);
    }
}