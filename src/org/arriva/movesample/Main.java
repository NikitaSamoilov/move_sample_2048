package org.arriva.movesample;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.impl.FieldImpl;
import org.arriva.movesample.core.impl.FieldImplHelper;
import org.arriva.movesample.core.impl.GameMode;
import org.arriva.movesample.core.impl.TransformerFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new FieldImpl(4, 4);
        //field.generateInitialState();
        field.generateRandomTile();
        System.out.println(field.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert 0 for standard mode, 1 - for modified mode");

        GameMode gameMode = GameMode.STANDART;
        String insert = scanner.next();
        if (isModeKey(insert)) {
            if (insert.equals("0")) {
                gameMode = GameMode.STANDART;
            } else {
                gameMode = GameMode.MODIFIED;
            }
        }

        System.out.println(gameMode);
        field.setTransformer(TransformerFactory.getTransformer(gameMode));

        while (field.isMovesPossible()) {
            while (scanner.hasNext()) {
                //TODO: for Artem - add checking possibility of moves

                String input = scanner.next();

                if (!isControlKey(input)) {
                    break;
                }

                if (input.equals("a")) {
                    field.moveLeft();
                } else if (input.equals("d")) {
                    field.moveRight();
                } else if (input.equals("w")) {
                    field.moveUp();
                } else {
                    field.moveDown();
                }

                field.generateRandomTile();

                /*
                //требует версии 1.7!
                switch (input) {
                    case "a": field.moveLeft();
                        break;
                    case "d": field.moveRight();
                        break;
                    case "w": field.moveUp();
                        break;
                    case "s": field.moveDown();
                        break;
                    default: System.out.println("Use w, a, s or d keys!");
                }
                */

                System.out.println(field.toString());
            }
        }
    }

    public static boolean isControlKey(String input) {
        if (input.equals("a") || input.equals("d") || input.equals("s") || input.equals("w")) {
            return true;
        }

        return false;
    }

    public static boolean isModeKey (String input) {
        if (input.equals("0") || input.equals("1")) {
            return true;
        }

        return false;
    }
}
