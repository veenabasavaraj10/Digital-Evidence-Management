package DEM;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        EvidenceDAO evidenceDAO = new EvidenceDAO();
        ReportGenerator report = new ReportGenerator();

        while (true) {

            System.out.println("=================================================");
            System.out.println("   DIGITAL EVIDENCE MANAGEMENT SYSTEM (DEMS)");
            System.out.println("=================================================");
            System.out.println("1. Register (New Officer)");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            // ================= REGISTER =================
            if (choice == 1) {

                System.out.println("\n----------- OFFICER REGISTRATION -----------");
                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                if (userDAO.register(user, pass)) {
                    System.out.println("User Registered Successfully!\n");
                }

            }
            // ================= LOGIN =================
            else if (choice == 2) {

                System.out.println("\n---------------- LOGIN ----------------");
                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                String role = userDAO.login(username, password);

                if (role == null) {
                    System.out.println("Invalid Credentials!\n");
                    continue;
                }

                System.out.println("\nLogin Successful!");
                System.out.println("Role: " + role);

                // ================= ADMIN MENU =================
                if (role.equals("ADMIN")) {

                    while (true) {

                        System.out.println("\n===============================================");
                        System.out.println("                 ADMIN MENU");
                        System.out.println("===============================================");
                        System.out.println("1. Add Evidence");
                        System.out.println("2. View All Evidence");
                        System.out.println("3. Update Evidence Status");
                        System.out.println("4. Delete Evidence");
                        System.out.println("5. Generate Full Report");
                        System.out.println("6. Logout");
                        System.out.print("Choose option: ");

                        int adminChoice = sc.nextInt();
                        sc.nextLine();

                        switch (adminChoice) {

                            case 1:
                                System.out.println("\n----------- ADD NEW EVIDENCE -----------");
                                System.out.print("Enter Case ID: ");
                                String caseId = sc.nextLine();

                                System.out.print("Enter Evidence Name: ");
                                String name = sc.nextLine();

                                System.out.print("Enter Description: ");
                                String desc = sc.nextLine();

                                System.out.print("Enter Date (YYYY-MM-DD): ");
                                String date = sc.nextLine();

                                System.out.print("Enter Status: ");
                                String status = sc.nextLine();

                                evidenceDAO.addEvidence(caseId, name, desc, username, date, status);
                                break;

                            case 2:
                                evidenceDAO.viewAllEvidence();
                                break;

                            case 3:
                                System.out.print("Enter Evidence ID: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter New Status: ");
                                String newStatus = sc.nextLine();

                                evidenceDAO.updateStatus(updateId, newStatus);
                                break;

                            case 4:
                                System.out.print("Enter Evidence ID: ");
                                int deleteId = sc.nextInt();
                                sc.nextLine();

                                evidenceDAO.deleteEvidence(deleteId);
                                break;

                            case 5:
                                report.fullReport();
                                break;

                            case 6:
                                System.out.println("Logging out...\n");
                                break;

                            default:
                                System.out.println("Invalid Option!");
                        }

                        if (adminChoice == 6) break;
                    }
                }

                // ================= OFFICER MENU =================
                else if (role.equals("OFFICER")) {

                    while (true) {

                        System.out.println("\n===============================================");
                        System.out.println("                OFFICER MENU");
                        System.out.println("===============================================");
                        System.out.println("1. Add Evidence");
                        System.out.println("2. View My Evidence");
                        System.out.println("3. Update My Evidence Status");
                        System.out.println("4. Generate My Report");
                        System.out.println("5. Logout");
                        System.out.print("Choose option: ");

                        int officerChoice = sc.nextInt();
                        sc.nextLine();

                        switch (officerChoice) {

                            case 1:
                                System.out.println("\n----------- ADD NEW EVIDENCE -----------");
                                System.out.print("Enter Case ID: ");
                                String caseId = sc.nextLine();

                                System.out.print("Enter Evidence Name: ");
                                String name = sc.nextLine();

                                System.out.print("Enter Description: ");
                                String desc = sc.nextLine();

                                System.out.print("Enter Date (YYYY-MM-DD): ");
                                String date = sc.nextLine();

                                System.out.print("Enter Status: ");
                                String status = sc.nextLine();

                                evidenceDAO.addEvidence(caseId, name, desc, username, date, status);
                                break;

                            case 2:
                                evidenceDAO.viewMyEvidence(username);
                                break;

                            case 3:
                                System.out.print("Enter Evidence ID: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter New Status: ");
                                String newStatus = sc.nextLine();

                                evidenceDAO.updateStatus(updateId, newStatus);
                                break;

                            case 4:
                                report.officerReport(username);
                                break;

                            case 5:
                                System.out.println("Logging out...\n");
                                break;

                            default:
                                System.out.println("Invalid Option!");
                        }

                        if (officerChoice == 5) break;
                    }
                }

            }
            // ================= EXIT =================
            else if (choice == 3) {
                System.out.println("System Exited.");
                break;
            }

            else {
                System.out.println("Invalid Option!\n");
            }
        }

        sc.close();
    }
}