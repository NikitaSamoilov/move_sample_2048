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

    public static boolean hasFreeTiles (int[][] field) {
        int i = 0;
        int j = 0;
        boolean possibility = false;

        while (i<4) {
            while (j<4) {
                if (field[i][j] == 0) {
                    possibility = true;
                    break;
                }
                j++;
            }
            if (possibility) break;
            j = 0;
            i++;
        }
        return possibility;
    }

    public static boolean canMoveHor (int[][] field) {
        int i = 0;
        int j = 0;
        boolean possibility = false;

        while (i<3) {
            while (j<3) {
                if (field[i][j] == field[i][j+1]) {
                    possibility = true;
                    break;
                }
                j++;
            }
            if (possibility) break;
            j = 0;
            i++;
        }
        return possibility;
    }

    public static boolean canMoveVer (int[][] field) {
        int i = 0;
        int j = 0;
        boolean possibility = false;

        while (j<3) {
            while (i<3) {
                if (field[i][j] == field[i+1][j]) {
                    possibility = true;
                    break;
                }
                i++;
            }
            if (possibility) break;
            i = 0;
            j++;
        }
        return possibility;
    }

   public static int countFreeTiles (int[][] field) {

        int i = 0;
        int j = 0;
        int countOfFreeTiles = 0;

        while (i<4) {
            while (j<4) {
                if (field[i][j] == 0) {
                    countOfFreeTiles++;
                }
                j++;
            }
            j = 0;
            i++;
        }

        return countOfFreeTiles;
    }

    public static int getValueForTile () {
        int valueForNewTile = 0;
        float p = (float) Math.random();
        if (p<0.1) {
            valueForNewTile = 4;
        } else {
            valueForNewTile = 2;
        }
        return valueForNewTile;
    }

    public static void setFreeRandomTile(int[][] field, int valueForNewTile) {
        int countOfFreeTiles = countFreeTiles(field);

        int r = (int) (Math.random()*countOfFreeTiles+1);
        int k = 0;

        while (k < (countOfFreeTiles+1)) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j< 4; j++) {
                    if (field[i][j] == 0) {
                        k++;
                        if (k == r) {
                            field[i][j] = valueForNewTile;
                            break;
                        }
                    }
                    if (k == r) break;
                }
                if (k == r) break;
            }
        }

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
