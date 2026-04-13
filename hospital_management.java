import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    boolean admitted;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.admitted = true;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

class Appointment {
    Patient patient;
    Doctor doctor;
    String date;

    Appointment(Patient p, Doctor d, String date) {
        this.patient = p;
        this.doctor = d;
        this.date = date;
    }
}

public class HospitalSystem {

    static HashMap<Integer, Patient> patients = new HashMap<>();
    static HashMap<Integer, Doctor> doctors = new HashMap<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addPatient() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.put(id, new Patient(id, name, age, disease));
        System.out.println("Patient added!");
    }

    static void addDoctor() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        doctors.put(id, new Doctor(id, name, spec));
        System.out.println("Doctor added!");
    }

    static void bookAppointment() {
        System.out.print("Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        if (patients.containsKey(pid) && doctors.containsKey(did)) {
            appointments.add(new Appointment(patients.get(pid), doctors.get(did), date));
            System.out.println("Appointment booked!");
        } else {
            System.out.println("Invalid IDs!");
        }
    }

    static void viewPatients() {
        for (Patient p : patients.values()) {
            System.out.println(p.id + " | " + p.name + " | " + p.disease + " | " + (p.admitted ? "Admitted" : "Discharged"));
        }
    }

    static void viewDoctors() {
        for (Doctor d : doctors.values()) {
            System.out.println(d.id + " | " + d.name + " | " + d.specialization);
        }
    }

    static void viewAppointments() {
        for (Appointment a : appointments) {
            System.out.println(a.patient.name + " -> " + a.doctor.name + " on " + a.date);
        }
    }

    static void dischargePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        if (patients.containsKey(id)) {
            patients.get(id).admitted = false;
            System.out.println("Patient discharged!");
        } else {
            System.out.println("Not found!");
        }
    }

    public static void main(String[] args) {

        // Preload doctors
        doctors.put(1, new Doctor(1, "Dr.Ravi", "Cardiology"));
        doctors.put(2, new Doctor(2, "Dr.Anita", "Neurology"));

        while (true) {
            System.out.println("\n=== HOSPITAL SYSTEM ===");
            System.out.println("1.Add Patient");
            System.out.println("2.Add Doctor");
            System.out.println("3.Book Appointment");
            System.out.println("4.View Patients");
            System.out.println("5.View Doctors");
            System.out.println("6.View Appointments");
            System.out.println("7.Discharge Patient");
            System.out.println("8.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1: addPatient(); break;
                case 2: addDoctor(); break;
                case 3: bookAppointment(); break;
                case 4: viewPatients(); break;
                case 5: viewDoctors(); break;
                case 6: viewAppointments(); break;
                case 7: dischargePatient(); break;
                case 8: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
