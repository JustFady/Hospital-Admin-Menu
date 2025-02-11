import java.util.Scanner;

public class HospitalAdminMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalAdmin admin = new HospitalAdmin();

        System.out.println("=========================================");
        System.out.println("   Welcome to the Hospital Admin Menu   ");
        System.out.println("=========================================");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Assign Doctor to Patient");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String pid = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String pname = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int page = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Ailment: ");
                    String pailment = scanner.nextLine();
                    admin.addPatient(pid, pname, page, pailment);
                    break;
                case 2:
                    System.out.print("Enter Doctor ID: ");
                    String did = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = scanner.nextLine();
                    System.out.print("Enter Specialty: ");
                    String specialty = scanner.nextLine();
                    admin.addDoctor(did, dname, specialty);
                    break;
                case 3:
                    System.out.print("Enter Doctor ID: ");
                    String docId = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String patId = scanner.nextLine();
                    admin.assignDoctorToPatient(docId, patId);
                    break;
                case 4:
                    admin.viewPatients();
                    break;
                case 5:
                    admin.viewDoctors();
                    break;
                case 6:
                    admin.saveDataToFile();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}