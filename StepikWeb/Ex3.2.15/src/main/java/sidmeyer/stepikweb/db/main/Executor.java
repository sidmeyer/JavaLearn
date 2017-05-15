package sidmeyer.stepikweb.db.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by stas on 11.05.17.
 */
public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public int execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        return stmt.getUpdateCount();
    }

    public <T> T execQuery(String query, ResultHandler<T> resultHandler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet rs = stmt.getResultSet();
        T value = resultHandler.handle(rs);
        return value;
    }
}
