package DEM;

import java.sql.*;

public class EvidenceDAO {

    public void addEvidence(String caseId, String name, String desc,
                            String officer, String date, String status) {

        String query = "INSERT INTO evidence(case_id,evidence_name,description,collected_by,date_collected,status) VALUES(?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, caseId);
            ps.setString(2, name);
            ps.setString(3, desc);
            ps.setString(4, officer);
            ps.setString(5, date);
            ps.setString(6, status);

            ps.executeUpdate();
            System.out.println("\nEvidence Added Successfully!\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
 // VIEW MY EVIDENCE (Officer Only)
    public void viewMyEvidence(String username) {

        String query = "SELECT evidence_id, case_id, evidence_name, status " +
                       "FROM evidence WHERE collected_by=?";

        int count = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n==============================================================");
            System.out.printf("%-5s %-10s %-20s %-15s\n",
                    "ID", "CaseID", "Evidence Name", "Status");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                count++;
                System.out.printf("%-5d %-10s %-20s %-15s\n",
                        rs.getInt("evidence_id"),
                        rs.getString("case_id"),
                        rs.getString("evidence_name"),
                        rs.getString("status"));
            }

            System.out.println("--------------------------------------------------------------");
            System.out.println("Total Records: " + count);
            System.out.println("==============================================================\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // VIEW ALL (JOIN)
    public void viewAllEvidence() {

        String query = "SELECT e.evidence_id, e.case_id, e.evidence_name, " +
                       "u.username, u.role, e.status " +
                       "FROM evidence e JOIN users u " +
                       "ON e.collected_by = u.username";

        int count = 0;

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n======================================================================");
            System.out.printf("%-5s %-10s %-20s %-15s %-12s %-15s\n",
                    "ID", "CaseID", "Evidence Name", "Officer", "Role", "Status");
            System.out.println("----------------------------------------------------------------------");

            while (rs.next()) {
                count++;
                System.out.printf("%-5d %-10s %-20s %-15s %-12s %-15s\n",
                        rs.getInt("evidence_id"),
                        rs.getString("case_id"),
                        rs.getString("evidence_name"),
                        rs.getString("username"),
                        rs.getString("role"),
                        rs.getString("status"));
            }

            System.out.println("----------------------------------------------------------------------");
            System.out.println("Total Records: " + count);
            System.out.println("======================================================================\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStatus(int id, String status) {

        String query = "UPDATE evidence SET status=? WHERE evidence_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("\nStatus Updated Successfully!\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteEvidence(int id) {

        String query = "DELETE FROM evidence WHERE evidence_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("\nEvidence Deleted Successfully!\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}