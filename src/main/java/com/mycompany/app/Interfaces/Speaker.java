package com.mycompany.app.Interfaces;

public interface Speaker {
    void writeText(String text);

    String readInput();

    char askQuestion(String Question);
}