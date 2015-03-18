package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;

import java.util.ArrayList;
import java.util.List;

public class TransformerImpl implements Transformer {

    @Override
    public List<Integer> transform(List<Integer> originalValues) {
        List<Integer> values = new ArrayList<Integer>();
        int originalIndex = 0;

        while (originalIndex < originalValues.size() - 1) {
            int currentValue = originalValues.get(originalIndex);

            if (currentValue == 0) {
                originalIndex += 1;
                continue;
            }

            if (currentValue == originalValues.get(originalIndex + 1)) {
                // TODO: for me - add logic
            }
        }

        return values;
    }
}
