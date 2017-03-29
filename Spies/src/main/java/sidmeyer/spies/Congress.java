package sidmeyer.spies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 29.03.17.
 */
public class Congress implements Observable {
    private String expansion;
    private String laundering;
    private String bribe;
    private List<Observer> observers = new ArrayList<>();

    public void makeBadThings() {
        expansion = "100 times";
        laundering = "washing machine";
        bribe = "100 UAH";
        System.out.println("Congress decided...");
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.handleEvent(expansion, laundering, bribe);
        }
    }
}
