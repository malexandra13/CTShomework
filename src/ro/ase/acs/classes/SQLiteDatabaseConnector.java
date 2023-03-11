package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabaseConnector implements DatabaseConnector {
    @Override
    public Connection connectToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        connection.setAutoCommit(false);

        return connection;
    }
}
