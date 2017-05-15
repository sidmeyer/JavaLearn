package sidmeyer.stepikweb.db.main;

import java.sql.ResultSet;

public interface ResultHandler<T> {
    T handle(ResultSet rs);
}
