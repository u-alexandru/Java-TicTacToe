package com.mycompany.app.Helpers;

import com.mycompany.app.Interfaces.GameSpeaker;

import java.util.Scanner;

public class Speaker implements GameSpeaker {
    public void writeText(String textToWrite) {
        System.out.println(textToWrite);
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String askQuestion(String Question) {
        writeText(Question);
        return readInput();
    }
}