package org.arriva.movesample.core;

/**
 * Created by nikita.samoilov on 16.04.2015.
 */
public interface InputObservable {
    void addObserver(InputObserver observer);
    void removeObserver(InputObserver observer);
    void notify(String input);
}
