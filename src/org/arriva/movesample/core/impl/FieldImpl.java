package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Field;

public class FieldImpl extends Field {

    protected int[][] field;

    public FieldImpl(int rowCount, int colCount) {
        super(rowCount, colCount);
        field = new int[rowCount][colCount];
        transformer = new TransformerImpl();
    }

    @Override
    public void generateInitialState() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {

                field[i][j] = FieldImplHelper.getSomeValue(); //TODO: for me - make it by const
            }
        }
    }

    @Override
    public void moveLeft() {
        for (int i = 0; i < rowCount; i++) {
            FieldImplHelper.moveRowLeft(i, transformer, field);
        }
    }

    @Override
    public void moveRight() {
        for (int i = 0; i < rowCount; i++) {
            FieldImplHelper.moveRowRight(i, transformer, field);
        }
    }

    @Override
    public void moveDown() {
        //TODO: for Artem - implement it
        for (int i = 0; i < colCount; i++) {
            FieldImplHelper.moveColDown(i, transformer, field);
        }
    }

    @Override
    public void moveUp() {
        //TODO: for Artem - implement it
        for (int i = 0; i < colCount; i++) {
            FieldImplHelper.moveColUp(i, transformer, field);
        }
    }

    @Override
    public String toString() {
        StringBuffer strBuffer = new StringBuffer();
        for (int[] row : field) {
            for (int value : row) {
                strBuffer.append(String.format("%d ", value));
            }
            strBuffer.append("\n");
        }

        return strBuffer.toString();
    }
}
