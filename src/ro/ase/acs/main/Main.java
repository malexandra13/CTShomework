package ro.ase.acs.main;
import ro.ase.acs.classes.*;
import ro.ase.acs.interfaces.DataInserter;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.DatabaseConnector;
import ro.ase.acs.interfaces.EntityCreator;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector connectionCreator = new SQLiteDatabaseConnector();
        try {
            Connection connection = connectionCreator.connectToDatabase();

            EntityCreator tableCreator = new TableCreator();
            tableCreator.createEntity(connection);

            DataInserter employeeInserter = new EmployeeInserter();
            employeeInserter.insertData(connection, new Employee(1, "Popescu Ion", "Bucharest", 4000));
            employeeInserter.insertData(connection, new Employee(2, "Ionescu Maria", "Brasov", 4500));

            DataReader employeeReader = new EmployeeReader();
            employeeReader.readData(connection);

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}