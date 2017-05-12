package sidmeyer.stepikweb.db.main;

import java.sql.Connection;

/**
 * Created by stas on 11.05.17.
 */
public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update) {

    }

    public void execQuery(String query, ResultHandler resultHandler) {

    }
}
