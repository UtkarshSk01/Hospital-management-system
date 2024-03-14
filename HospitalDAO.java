import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {

    public static List<Hospital> getAllHospitals() throws SQLException {
        List<Hospital> hospitals = new ArrayList<>();
        String sql = "SELECT id, name, address FROM Hospital";
        
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                
                Hospital hospital = new Hospital();
                hospital.setId(id);
                hospital.setName(name);
                hospital.setAddress(address);
                
                hospitals.add(hospital);
            }
        }
        
        return hospitals;
    }
}
