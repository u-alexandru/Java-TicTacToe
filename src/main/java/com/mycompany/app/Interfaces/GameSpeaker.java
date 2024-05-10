package com.mycompany.app.Interfaces;

public interface GameSpeaker {
    void writeText(String text);

    String readInput();

    String askQuestion(String Question);
}