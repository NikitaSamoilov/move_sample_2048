package org.arriva.movesample.core;

public abstract class Field implements InputObserver {

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

    @Override
    public void processInput(String input) {
        FieldControlInputs controlInput =
                FieldControlInputs.convertStringToControlInput(input);
        switch (controlInput) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case UNDEFINED:
                break;
        }
    }

    public abstract void generateInitialState();
    public abstract void generateRandomTile();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveDown();
    public abstract void moveUp();
    public abstract boolean isMovesPossible();

}
