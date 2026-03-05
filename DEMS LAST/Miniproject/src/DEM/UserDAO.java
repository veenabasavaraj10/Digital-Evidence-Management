package DEM;
//
//import java.sql.*;
//
//public class UserDAO {
//
//    public User login(String username, String password) {
//
//        String query = "SELECT * FROM users WHERE username=? AND password=?";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setString(1, username);
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                return new User(
//                        rs.getString("username"),
//                        rs.getString("role")
//                );
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}
import java.sql.*;

public class UserDAO {

    // LOGIN
    public String login(String username, String password) {

        String query = "SELECT role FROM users WHERE username=? AND password=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("role");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    // REGISTER OFFICER
    public boolean register(String username, String password) {

        String query = "INSERT INTO users(username, password, role) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, "OFFICER");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Officer Registered Successfully!");
                return true;
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username already exists!");
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}