package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.Transformer;

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
            for (int j = 0; j <colCount; j++) {
                field[i][j] = 0; //TODO: for me - make it by const
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
    }

    @Override
    public void moveUp() {
        //TODO: for Artem - implement it
    }
}
