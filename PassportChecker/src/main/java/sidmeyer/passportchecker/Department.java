package sidmeyer.passportchecker;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String name;
    private final String url;
    private final Type type;

    private List<Slot> slots = new ArrayList<Slot>();

    public Department(String name, String url, Type type) {
        this.name = name;
        this.url = url;
        this.type = type;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        ONE, TWO
    }
}
