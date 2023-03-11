package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface EntityCreator {
    void createEntity(Connection connection) throws SQLException;
}
