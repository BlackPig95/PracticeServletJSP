package ra.practiceemployee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB
{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Blackpigsql666";

    public static Connection getConnection()
    {
        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connectionn)
    {
        try
        {
            if (!connectionn.isClosed())
            {
                connectionn.close();
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
