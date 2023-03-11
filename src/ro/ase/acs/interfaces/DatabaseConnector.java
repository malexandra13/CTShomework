package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnector {
    Connection connectToDatabase() throws ClassNotFoundException, SQLException;
}
