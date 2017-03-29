package sidmeyer.spies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 29.03.17.
 */
public class Spy implements Observer, Observable {

    private String name;
    private String expansion;
    private String laundering;
    private String bribe;
    private List<Observer> observers = new ArrayList<>();

    public Spy(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(String expansion, String laundering, String bribe) {
        this.expansion = expansion;
        this.laundering = laundering;
        this.bribe = bribe;
        System.out.println("I'm " + name + ". I got data!");
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
        for(Observer observer : observers) {
            observer.handleEvent(expansion, laundering, bribe);
        }
    }
}
