import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class AppointmentDAO {

    public static List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT id, patientId, doctorId, date, status FROM Appointment";
        
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int patientId = resultSet.getInt("patientId");
                int doctorId = resultSet.getInt("doctorId");
                Date date = resultSet.getDate("date");
                String status = resultSet.getString("status");
                
                Appointment appointment = new Appointment();
                appointment.setId(id);
                appointment.setPatientId(patientId);
                appointment.setDoctorId(doctorId);
                appointment.setDate(date);
                appointment.setStatus(status);
                
                appointments.add(appointment);
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            System.err.println("Error fetching appointments: " + ex.getMessage());
            throw ex; // Propagate the exception
        }
        
        return appointments;
    }
}
