package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.Transformer;

public class FieldImpl extends Field {

    private Transformer transformer;
    protected int[][] field;

    public FieldImpl(int rowCount, int colCount) {
        super(rowCount, colCount);
        field = new int[rowCount][colCount];
    }

    @Override
    public void generateInitialState() {

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

    }

    @Override
    public void moveUp() {

    }
}
