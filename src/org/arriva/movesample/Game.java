package org.arriva.movesample;

import org.arriva.movesample.core.Field;
import org.arriva.movesample.core.impl.FieldImpl;
import org.arriva.movesample.core.impl.FieldTransformerMode;
import org.arriva.movesample.core.impl.TransformerFactory;

public class Game {
    protected Field field, testField, referenseField;
    protected GameState gameState;
    protected GameHelper gameHelper;

    public GameState getGameState() {
        return gameState;
    }

    public Game() {
        field = new FieldImpl(4, 4);
        gameState = GameState.INITIALIZATION;
        gameHelper = new GameHelper();
    }

    public void process(String input) {
        switch (gameState) {
            case INITIALIZATION:
                processInitialization();
                break;
            case MODE_CHOOSING:
                processModeChoosing(input);
                break;
            case PLAYING:
                processPlaying(input);
                break;
            case FINISH:
                processFinish();
                break;
            case TEST:
                processTest(input);
            case WORK_CHOOSING:
                processWorkChoosing(input);
            default:
                break;
        }
    }

    protected void processWorkChoosing(String input) {
        if (input.equals("y")) {
            gameState = GameState.TEST;
        } else {
            gameState = GameState.MODE_CHOOSING;
        }
    }

    private void processTest(String input) {
        boolean passed = false;
        System.out.println("Test mode");
        System.out.println("Insert 0 for standard mode, 1 - for modified mode");
        FieldTransformerMode fieldTransformerMode;
        if (input.equals("0")) {
            fieldTransformerMode = FieldTransformerMode.STANDART;
        } else {
            fieldTransformerMode = FieldTransformerMode.MODIFIED;
        }

        System.out.println(fieldTransformerMode);
        field.setTransformer(TransformerFactory.getTransformer(fieldTransformerMode));


    }

    private void processFinish() {
        System.out.println("That's all");
    }

    protected void processPlaying(String input) {
        gameHelper.notify(input);
        field.generateRandomTile();
        System.out.println(field.toString());

        if (!field.isMovesPossible()) {
            gameState = GameState.FINISH;
        }
    }

    protected void processModeChoosing(String input) {
        FieldTransformerMode fieldTransformerMode;
        if (input.equals("0")) {
            fieldTransformerMode = FieldTransformerMode.STANDART;
        } else {
            fieldTransformerMode = FieldTransformerMode.MODIFIED;
        }

        System.out.println(fieldTransformerMode);
        field.setTransformer(TransformerFactory.getTransformer(fieldTransformerMode));
        //field.generateInitialState();
        field.generateRandomTile();
        System.out.println(field.toString());

        gameHelper.addObserver(field);

        gameState = GameState.PLAYING;
    }

    protected void processInitialization() {
        System.out.println("== 2048 ==\n\n");
        System.out.println("Would you like to enter test mode?");
        gameState = GameState.WORK_CHOOSING;
        System.out.println("Insert 0 for standard mode, 1 - for modified mode");
        gameState = GameState.MODE_CHOOSING;
    }

}
