package sidmeyer.passportchecker;

public class Slot {
    private final String date;
    private final String time;

    public Slot(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
