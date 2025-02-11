import java.io.*;
import java.util.*;
import java.util.logging.Logger;

// Hospital Administration System to manage patients, billing, and doctors
class HospitalAdmin {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String DOCTORS_FILE = "doctors.txt";
    private static final Logger logger = Logger.getLogger(HospitalAdmin.class.getName());

    public HospitalAdmin() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        loadPatientsFromFile();
        loadDoctorsFromFile();
    }

    private void loadPatientsFromFile() {
        try (Scanner scanner = new Scanner(new File(PATIENTS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] details = scanner.nextLine().split(",");
                if (details.length == 5) {
                    Patient p = new Patient(details[0], details[1], Integer.parseInt(details[2]), details[3]);
                    p.updateBill(Double.parseDouble(details[4]));
                    patients.add(p);
                }
            }
        } catch (IOException e) {
            logger.warning("Could not load patients from file.");
        }
    }

    private void loadDoctorsFromFile() {
        try (Scanner scanner = new Scanner(new File(DOCTORS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] details = scanner.nextLine().split(",");
                if (details.length == 3) {
                    doctors.add(new Doctor(details[0], details[1], details[2]));
                }
            }
        } catch (IOException e) {
            logger.warning("Could not load doctors from file.");
        }
    }

    public void addPatient(String id, String name, int age, String ailment) {
        patients.add(new Patient(id, name, age, ailment));
        logger.info("Patient added successfully: " + name);
    }

    public void addDoctor(String id, String name, String specialty) {
        doctors.add(new Doctor(id, name, specialty));
        logger.info("Doctor added successfully: " + name);
    }

    public void assignDoctorToPatient(String doctorId, String patientId) {
        Doctor doctor = doctors.stream().filter(d -> d.getId().equals(doctorId)).findFirst().orElse(null);
        Patient patient = patients.stream().filter(p -> p.getId().equals(patientId)).findFirst().orElse(null);

        if (doctor != null && patient != null) {
            doctor.assignPatient(patientId);
            logger.info("Doctor " + doctor.getName() + " assigned to patient " + patient.getName());
        } else {
            logger.warning("Invalid doctor or patient ID.");
        }
    }

    public void updateBill(String id, double amount) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                p.updateBill(amount);
                logger.info("Bill updated for patient: " + p.getName() + ". New total: $" + p.getBill());
                return;
            }
        }
        logger.warning("Error: Patient ID not found.");
    }

    public void savePatientsToFile() {
        try (PrintWriter writer = new PrintWriter(new File(PATIENTS_FILE))) {
            for (Patient p : patients) {
                writer.println(p.getId() + "," + p.getName() + "," + p.getAge() + "," + p.getAilment() + "," + p.getBill());
            }
        } catch (IOException e) {
            logger.warning("Error saving patients to file.");
        }
    }

    public void saveDoctorsToFile() {
        try (PrintWriter writer = new PrintWriter(new File(DOCTORS_FILE))) {
            for (Doctor d : doctors) {
                writer.println(d.getId() + "," + d.getName() + "," + d.getSpecialty());
            }
        } catch (IOException e) {
            logger.warning("Error saving doctors to file.");
        }
    }
}