package org.arriva.movesample.core;

import java.util.List;

public interface Transformer {
    List<Integer> transform(List<Integer> originalValues);
}
