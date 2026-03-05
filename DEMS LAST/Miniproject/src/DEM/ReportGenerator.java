
package DEM;

import java.sql.*;

public class ReportGenerator {

    // FULL REPORT
    public void fullReport() {

        String query = "SELECT e.evidence_id, e.case_id, e.evidence_name, " +
                "u.username, e.date_collected, e.status " +
                "FROM evidence e JOIN users u " +
                "ON e.collected_by = u.username";

        int count = 0;

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("===== COMPLETE EVIDENCE REPORT =====");

            while (rs.next()) {
                count++;
                System.out.println(
                        rs.getInt("evidence_id") + " | " +
                        rs.getString("case_id") + " | " +
                        rs.getString("evidence_name") + " | " +
                        rs.getString("username") + " | " +
                        rs.getString("date_collected") + " | " +
                        rs.getString("status")
                );
            }

            System.out.println("Total Records: " + count);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // OFFICER REPORT
    public void officerReport(String officer) {

        String query = "SELECT case_id, evidence_name, status FROM evidence WHERE collected_by=?";

        int count = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, officer);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                System.out.println(
                        rs.getString("case_id") + " | " +
                        rs.getString("evidence_name") + " | " +
                        rs.getString("status")
                );
            }

            System.out.println("Total Records: " + count);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // CASE REPORT
    public void caseReport(String caseId) {

        String query = "SELECT e.evidence_name, u.username, e.status " +
                "FROM evidence e JOIN users u " +
                "ON e.collected_by = u.username WHERE e.case_id=?";

        int count = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, caseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                System.out.println(
                        rs.getString("evidence_name") + " | " +
                        rs.getString("username") + " | " +
                        rs.getString("status")
                );
            }

            System.out.println("Total Records: " + count);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}