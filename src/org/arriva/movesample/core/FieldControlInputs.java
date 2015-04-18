package org.arriva.movesample.core;

public enum FieldControlInputs {
    UP ("w"),
    DOWN("s"),
    RIGHT("d"),
    LEFT("a"),
    UNDEFINED (null);

    private String input;

    private FieldControlInputs(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    @Override
    public String toString() {
        return input;
    }

    public static FieldControlInputs convertStringToControlInput(String input) {
        if (!isContolInput(input)) {
            return UNDEFINED;
        }

        if (input.equals(UP)) {
            return UP;
        }
        if (input.equals(DOWN)) {
            return DOWN;
        }
        if (input.equals(RIGHT)) {
            return RIGHT;
        }
        return LEFT;
    }

    public static boolean isContolInput(String input) {
        if (input.equals(UP) || input.equals(DOWN) ||
                input.equals(RIGHT) || input.equals(LEFT)) {
            return true;
        }

        return false;
    }
}
