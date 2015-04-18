package org.arriva.movesample;


import org.arriva.movesample.core.InputObservable;
import org.arriva.movesample.core.InputObserver;

import java.util.ArrayList;
import java.util.List;

public class GameHelper implements InputObservable {

    private List<InputObserver> inputObservers = new ArrayList<InputObserver>();

    @Override
    public void addObserver(InputObserver observer) {
        inputObservers.add(observer);
    }

    @Override
    public void removeObserver(InputObserver observer) {
        inputObservers.remove(observer);
    }

    @Override
    public void notify(String input) {
        System.out.print("NOTIFY " + input);
        for (InputObserver observer : inputObservers) {
            observer.processInput(input);
        }
    }
}
