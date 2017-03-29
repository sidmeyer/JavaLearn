package sidmeyer.spies;

/**
 * Created by stas on 29.03.17.
 */
public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
