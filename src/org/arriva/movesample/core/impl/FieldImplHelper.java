package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;

import java.util.ArrayList;
import java.util.List;

public class FieldImplHelper {

    public static int getSomeValue() {
        int choice = (int)(Math.random() * 100);
        if (choice <= 40) {
            return 0;
        }

        if (choice >= 80) {
            return 4;
        }

        return 2;
    }

    public static int getValueForRandomTile() {
        int choice = (int)(Math.random() * 100);
        if (choice >= 80) {
            return 4;
        }

        return 2;
    }

    public static void setFreeRandomTile(int[][] field, int valueForNewTile) {
        //TODO: for Artem - finish it
    }

    public static void moveRowLeft(int row, Transformer transformer, int[][] field) {
        List<Integer> values = getValuesForLeftMove(row, field);
        List<Integer> transformValues = transformer.transform(values);

        for (int i = 0; i < field[row].length; i++) {
            field[row][i] = transformValues.get(i);
        }
    }

    public static void moveRowRight(int row, Transformer transformer, int[][] field) {
        List<Integer> values = getValuesForRightMove(row, field);
        List<Integer> transformValues = transformer.transform(values);

        for (int i = field[row].length - 1; i >= 0; i--) {
            field[row][i] = transformValues.get(field.length - i - 1);
        }
    }

    public static void moveColUp(int col, Transformer transformer, int[][] field) {
        List<Integer> values = getValuesForDownMove(col, field);
        List<Integer> transformValues = transformer.transform(values);

        for (int i = 0; i < field[col].length; i++) {
            field[i][col] = transformValues.get(i);
        }
        }

    public static void moveColDown (int col, Transformer transformer, int[][] field) {
        List<Integer> values = getValuesForUpMove(col, field);
        List<Integer> transformValues = transformer.transform(values);

        for (int i = field[col].length-1; i>= 0; i--) {
            field[i][col] = transformValues.get(field.length - i - 1);
        }
    }

    private static List<Integer> getValuesForLeftMove(int row, int[][] field) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < field[row].length; i++) {
            values.add(field[row][i]);
        }

        return values;
    }

    private static List<Integer> getValuesForRightMove(int row, int[][] field) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = field[row].length - 1; i >= 0; i--) {
            values.add(field[row][i]);
        }

        return values;
    }

    private static List<Integer> getValuesForDownMove(int col, int[][] field) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < field[col].length; i++) {
            values.add(field[i][col]);
        }
        return values;
    }

    private static List<Integer> getValuesForUpMove(int col, int[][] field) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = field[col].length - 1; i >= 0; i--) {
            values.add(field[i][col]);
        }
        return values;
    }
}
