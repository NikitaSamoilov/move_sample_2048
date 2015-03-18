package org.arriva.movesample;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.impl.FieldImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new FieldImpl(4, 4);
        field.generateInitialState();
        System.out.println(field.toString());

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String input = scanner.next();
            if (!isControlKey(input)) {
                break;
            }

            if (input.equals("a")) {
                field.moveLeft();
            } else {
                field.moveRight();
            }

            System.out.println(field.toString());
        }
    }

    public static boolean isControlKey(String input) {
        if (input.equals("a") || input.equals("d")) {
            return true;
        }

        return false;
    }
}
