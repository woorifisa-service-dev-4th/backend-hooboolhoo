package dev.hooboolhoo;

//import dev.hooboolhoo.model.Choice;
import dev.hooboolhoo.service.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}