package org.arriva.movesample;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.impl.FieldImpl;
import org.arriva.movesample.core.impl.FieldTransformerMode;
import org.arriva.movesample.core.impl.TransformerFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new FieldImpl(4, 4);
        field.generateInitialState();
        System.out.println(field.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert 0 for standard mode, 1 - for modified mode");

        FieldTransformerMode gameMode = FieldTransformerMode.STANDART;
        String insert = scanner.next();
        if (isModeKey(insert)) {
            if (insert.equals("0")) {
                gameMode = FieldTransformerMode.STANDART;
            } else {
                gameMode = FieldTransformerMode.MODIFIED;
            }
        }

        System.out.println(gameMode);
        field.setTransformer(TransformerFactory.getTransformer(gameMode));

        boolean isPossible = true;
        GameHelper gameHelper = new GameHelper();
        gameHelper.addObserver(field);

        while (scanner.hasNext()) {
            while (isPossible) {
                String input = scanner.next();
                gameHelper.notify(input);
                field.generateRandomTile();

                System.out.println(field.toString());
                isPossible = field.isMovesPossible();
                System.out.println(isPossible);
            }
        }
    }

    public static boolean isModeKey (String input) {
        if (input.equals("0") || input.equals("1")) {
            return true;
        }

        return false;
    }
}
