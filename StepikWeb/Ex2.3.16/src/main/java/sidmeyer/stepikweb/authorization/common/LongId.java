package sidmeyer.stepikweb.authorization.common;

/**
 * Created by stas on 09.05.17.
 */
public class LongId<T> {
    private final long id;

    public LongId(long id) {
        this.id = id;
    }

    public long getLong() {
        return id;
    }
}
