package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;


public class TransformerFactory {

    public static Transformer getTransformer(FieldTransformerMode gameMode) {
        switch (gameMode) {
            case STANDART:
                return new StandartTransformerImpl();
            case MODIFIED:
                return new ModifiedTransformerImpl();
        }

        return null;
    }
}
