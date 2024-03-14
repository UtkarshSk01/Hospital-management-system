import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInitializer {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pr";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2002utk";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            insertSampleData(connection);
            System.out.println("Sample data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting sample data: " + e.getMessage());
        }
    }

    static void insertSampleData(Connection connection) throws SQLException {
        insertDoctors(connection);
        insertHospitals(connection);
        insertNurses(connection);
        // Add other insert methods as needed
    }

    private static void insertDoctors(Connection connection) throws SQLException {
        String sql = "INSERT INTO Doctor (name, specialization) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Dr. Gupta");
            statement.setString(2, "Cardiologist");
            statement.executeUpdate();

            statement.setString(1, "Dr. Patel");
            statement.setString(2, "Pediatrician");
            statement.executeUpdate();

            statement.setString(1, "Dr. Singh");
            statement.setString(2, "Orthopedic Surgeon");
            statement.executeUpdate();
        }
    }

    private static void insertHospitals(Connection connection) throws SQLException {
        String sql = "INSERT INTO Hospital (name, address) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "City Hospital");
            statement.setString(2, "123 MG Road, Mumbai");
            statement.executeUpdate();

            statement.setString(1, "Indian Medical Center");
            statement.setString(2, "456 Gandhi Nagar, Delhi");
            statement.executeUpdate();
        }
    }

    private static void insertNurses(Connection connection) throws SQLException {
        String sql = "INSERT INTO Nurse (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Priya Sharma");
            statement.executeUpdate();

            statement.setString(1, "Rajesh Kumar");
            statement.executeUpdate();

            statement.setString(1, "Anjali Gupta");
            statement.executeUpdate();
        }
    }
}
