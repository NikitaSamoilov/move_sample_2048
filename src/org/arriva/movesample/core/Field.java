package org.arriva.movesample.core;

public abstract class Field {

    protected int rowCount;
    protected int colCount;
    protected Transformer transformer;

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    public Field(int colCount, int rowCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public abstract void generateInitialState();
    public abstract void generateRandomTile();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveDown();
    public abstract void moveUp();
    public abstract boolean isMovesPossible();

}
