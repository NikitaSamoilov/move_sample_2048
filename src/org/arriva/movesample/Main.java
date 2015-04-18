package org.arriva.movesample;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (game.getGameState() != GameState.FINISH) {
            if (game.getGameState() != GameState.INITIALIZATION) {
                input = scanner.next();
            }
            game.process(input);
        }
    }
}
