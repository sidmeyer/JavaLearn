package sidmeyer.spies;

/**
 * Created by stas on 29.03.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Start main");

        Agency agency = new Agency();

        Spy spy1 = new Spy("Petro");
        Spy spy2 = new Spy("Grygorii");

        Congress congress = new Congress();

        spy1.addObserver(agency);
        spy2.addObserver(agency);

        congress.addObserver(spy1);
        congress.addObserver(spy2);

        congress.makeBadThings();

        System.out.println("Finish main");
    }
}
