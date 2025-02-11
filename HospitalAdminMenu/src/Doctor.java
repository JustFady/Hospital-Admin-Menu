import java.util.ArrayList;
import java.util.List;

// Represents a doctor in the hospital system
class Doctor {
    private String id;
    private String name;
    private String specialty;
    private List<String> assignedPatients;

    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.assignedPatients = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public List<String> getAssignedPatients() { return assignedPatients; }

    public void assignPatient(String patientId) {
        assignedPatients.add(patientId);
    }

    public void removePatient(String patientId) {
        assignedPatients.remove(patientId);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Specialty: " + specialty + ", Assigned Patients: " + assignedPatients;
    }
}