import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NurseDAO {

    public static List<Nurse> getAllNurses() throws SQLException {
        List<Nurse> nurses = new ArrayList<>();
        String sql = "SELECT id, name FROM Nurse";
        
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                
                Nurse nurse = new Nurse();
                nurse.setId(id);
                nurse.setName(name);
                
                nurses.add(nurse);
            }
        }
        
        return nurses;
    }
}
