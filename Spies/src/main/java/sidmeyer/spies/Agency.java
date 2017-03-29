package sidmeyer.spies;

/**
 * Created by stas on 29.03.17.
 */
public class Agency implements Observer {
    @Override
    public void handleEvent(String expansion, String laundering, String bribe) {
        System.out.println("Agency got data!");
    }
}
