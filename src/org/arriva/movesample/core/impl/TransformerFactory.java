package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;


public class TransformerFactory {

    public static Transformer getTransformer(GameMode gameMode) {
        switch (gameMode) {
            case STANDART:
                return null;
            case MODIFIED:
                return new ModifiedTransformerImpl();
        }

        return null;
    }
}
