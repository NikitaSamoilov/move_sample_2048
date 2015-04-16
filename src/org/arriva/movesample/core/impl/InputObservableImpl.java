package org.arriva.movesample.core.impl;

import org.arriva.movesample.core.InputObservable;
import org.arriva.movesample.core.InputObserver;

import java.util.ArrayList;
import java.util.List;


public class InputObservableImpl implements InputObservable {

    private List<InputObserver> observers = new ArrayList<InputObserver>();

    @Override
    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(InputObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String input) {
        for (InputObserver observer : observers) {
            observer.processInput(input);
        }
    }
}
