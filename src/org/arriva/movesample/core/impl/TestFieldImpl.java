package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Field;

public class TestFieldImpl extends Field {

    protected int[][] field;

    @Override
    public boolean moveLeft(int[][] testField, int[][] referenseField) {
        for (int i = 0; i < rowCount; i++) {
            FieldImplHelper.moveRowLeft(i, transformer, testField);
        }

        if (field == referenseField) return true;
    }

    @Override
    public boolean moveRight(int[][] testField, int[][] referenseField) {
        for (int i = 0; i < rowCount; i++) {
            FieldImplHelper.moveRowRight(i, transformer, testField);
        }

        if (field == referenseField) return true;
    }

    @Override
    public boolean moveDown(int[][] testField, int[][] referenseField) {
        for (int i = 0; i < colCount; i++) {
            FieldImplHelper.moveColDown(i, transformer, testField);
        }

        if (field == referenseField) return true;
    }

    @Override
    public boolean moveUp(int[][] testField, int[][] referenseField) {
        for (int i = 0; i < colCount; i++) {
            FieldImplHelper.moveColUp(i, transformer, testField);
        }

        if (field == referenseField) return true;
    }
}
