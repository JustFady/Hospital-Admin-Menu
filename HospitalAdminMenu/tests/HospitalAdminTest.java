// Unit tests for the Hospital Administration System
public class HospitalAdminTest {
    public static void main(String[] args) {
        HospitalAdmin admin = new HospitalAdmin();

        // Test adding a patient
        admin.addPatient("P001", "John Doe", 35, "Flu");
        admin.addPatient("P002", "Jane Smith", 28, "Cough");
        admin.viewPatients();

        // Test updating bill
        admin.updateBill("P001", 200.50);
        admin.updateBill("P002", 100.75);
        admin.viewPatients();

        // Test invalid bill update
        admin.updateBill("P999", 300.00);

        // Save to file and reload
        admin.savePatientsToFile();
        admin = new HospitalAdmin(); // Reload patients from file
        admin.viewPatients();
    }
}