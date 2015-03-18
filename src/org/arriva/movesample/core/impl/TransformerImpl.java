package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.Transformer;

import java.util.ArrayList;
import java.util.List;

public class TransformerImpl implements Transformer {

    @Override
    public List<Integer> transform(List<Integer> originalValues) {
        // TODO: for me - add a little bit of beauty and make const for "empty value"
        List<Integer> values = new ArrayList<Integer>();
        int originalIndex = 0;

        while (originalIndex < originalValues.size() - 1) {
            int currentValue = originalValues.get(originalIndex);

            if (currentValue == 0) {
                originalIndex += 1;
                continue;
            }

            if (currentValue == originalValues.get(originalIndex + 1)) {
                values.add(currentValue * 2);
                originalIndex += 2;
            }
        }

        if (values.size() < originalValues.size()) {
            for (int i = values.size(); i < originalValues.size(); i++) {
                values.add(0);
            }
        }

        return values;
    }
}
