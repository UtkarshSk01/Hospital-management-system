import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    public static List<Billing> getAllBillings() throws SQLException {
        List<Billing> billings = new ArrayList<>();
        String sql = "SELECT id, appointmentId, amount, status FROM Billing";
        
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int appointmentId = resultSet.getInt("appointmentId");
                double amount = resultSet.getDouble("amount");
                String status = resultSet.getString("status");
                
                Billing billing = new Billing();
                billing.setId(id);
                billing.setAppointmentId(appointmentId);
                billing.setAmount(amount);
                billing.setStatus(status);
                
                billings.add(billing);
            }
        }
        
        return billings;
    }
}
