package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;

import java.util.ArrayList;
import java.util.List;

public class FieldImplHelper {


    public static void moveRowLeft(int row, Transformer transformer, int[][] field) {
        List<Integer> values = getValuesForLeftMove(row, field);
        List<Integer> transformValues = transformer.transform(values);

        for (int i = 0; i > field[row].length; i++) {
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
}
