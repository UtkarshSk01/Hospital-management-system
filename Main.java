

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.AppointmentDAO;


public class Main {
    public static void main(String[] args) {
        try {
            // Initialize database and insert sample data
            initializeDatabase();

            // Perform operations related to hospitals, patients, doctors, appointments, nurses, and billing
            operateHospital();
            operatePatient();
            operateDoctor();
            operateAppointment();
            operateNurse();
            operateBilling();
        } catch (SQLException e) {
            System.err.println("Error occurred while interacting with the database: " + e.getMessage());
        }
    }

    private static void initializeDatabase() throws SQLException {
        // Initialize database and insert sample data
        try (Connection connection = DBUtil.getConnection()) {
            DataInitializer.insertSampleData(connection);
            System.out.println("Sample data inserted successfully.");
        }
    }

    private static void operateHospital() throws SQLException {
        System.out.println("Hospitals:");
        List<Hospital> hospitals = HospitalDAO.getAllHospitals();
        for (Hospital hospital : hospitals) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(hospital.getId());
            stringBuilder.append(": ");
            stringBuilder.append(hospital.getName());
            stringBuilder.append(", ");
            stringBuilder.append(hospital.getAddress());
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    private static void operatePatient() throws SQLException {
        System.out.println("Patients:");
        List<Patient> patients = PatientDAO.getAllPatients();
        for (Patient patient : patients) {
            System.out.println(patient.getId() + ": " + patient.getName() + ", Age: " + patient.getAge() + ", Gender: " + patient.getGender());
        }
        System.out.println();
    }

    private static void operateDoctor() throws SQLException {
        System.out.println("Doctors:");
        List<Doctor> doctors = DoctorDAO.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getId() + ": " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
        }
        System.out.println();
    }

    private static void operateAppointment() throws SQLException {
        System.out.println("Appointments:");
        List<Appointment> appointments = AppointmentDAO.getAllAppointments();
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getId() + ": Patient " + appointment.getPatientId() + " - Doctor " + appointment.getDoctorId() + ", Date: " + appointment.getDate() + ", Status: " + appointment.getStatus());
        }
        System.out.println();
    }

    private static void operateNurse() throws SQLException {
        System.out.println("Nurses:");
        List<Nurse> nurses = NurseDAO.getAllNurses();
        for (Nurse nurse : nurses) {
            System.out.println(nurse.getId() + ": " + nurse.getName());
        }
        System.out.println();
    }

    private static void operateBilling() throws SQLException {
        System.out.println("Billings:");
        List<Billing> billings = BillingDAO.getAllBillings();
        for (Billing billing : billings) {
            System.out.println(billing.getId() + ": Appointment " + billing.getAppointmentId() + ", Amount: " + billing.getAmount() + ", Status: " + billing.getStatus());
        }
        System.out.println();
    }
}
