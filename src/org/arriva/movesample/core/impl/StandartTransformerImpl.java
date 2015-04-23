package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;

import java.util.ArrayList;
import java.util.List;

public class StandartTransformerImpl implements Transformer {

    @Override
    public List<Integer> transform(List<Integer> originalValues) {
        //TODO: It must be separated
        int maxSize = originalValues.size();
        originalValues = getOnlyNotEmptyValues(originalValues);
        List<Integer> values = new ArrayList<Integer>();
        int originalIndex = 0;

        while (originalIndex < originalValues.size() - 1) {
            int currentValue = originalValues.get(originalIndex);
            int steps = 1;

            if (currentValue == 0) {
                originalIndex += 1;
                continue;
            }

            while (steps <= (originalValues.size() - originalIndex)) {
                if ((currentValue != originalValues.get(originalIndex + steps)) && (originalValues.get(originalIndex + steps) != 0)) {
                    values.add(currentValue);
                    originalIndex = originalIndex + steps;
                    break;
                }

                if (currentValue == originalValues.get(originalIndex + steps)) {
                    values.add(currentValue * 2);
                    originalIndex = originalIndex + steps +1;
                    break;
                }

                if ( (steps == (originalValues.size() - originalIndex)) && (currentValue != originalValues.get(originalIndex + steps)) ) {
                    values.add(currentValue);
                    break;
                }

                if (originalValues.get(originalIndex + steps) == 0) {
                    steps++;
                }
            }
        }

        if (originalIndex < originalValues.size()) {
            values.add(originalValues.get(originalIndex));
        }

        if (values.size() < maxSize) {
            for (int i = values.size(); i < maxSize; i++) {
                values.add(0);
            }
        }

        return values;
    }

    private List<Integer> getOnlyNotEmptyValues(List<Integer> values) {
        List<Integer> notEmptyValues = new ArrayList<Integer>();
        for (int value : values) {
            if (value != 0) {
                notEmptyValues.add(value);
            }
        }

        return notEmptyValues;
    }
}