package sidmeyer.stepikweb.db.main;

import java.sql.*;

/**
 * Created by stas on 11.05.17.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        String jdbcDriverClassname = "com.mysql.jdbc.Driver";
        Driver driver = (Driver) Class.forName(jdbcDriverClassname).newInstance();
        DriverManager.registerDriver(driver);

        String jdbcUrl = "jdbc:mysql://localhost:3306/webserver?user=root&password=root";
        Connection connection = DriverManager.getConnection(jdbcUrl);

        Statement st = connection.createStatement();
        String query = "SELECT * FROM Users;";
        st.execute(query);

        ResultSet rs = st.getResultSet();

        while (!rs.isLast()) {
            rs.next();
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",
                    rs.getLong("Id"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getInt("Confirmed") == 1 ? "true" : "false",
                    rs.getString("SignUpDate"));
        }

        connection.close();
    }
}
