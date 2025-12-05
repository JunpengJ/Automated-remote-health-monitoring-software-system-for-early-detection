
public class HealthMonitoringSystemTestDrive {
    public static void main(String[] args) {
        System.out.println("=== Health Monitoring System ===");

        PatientData patient = new PatientData(120, 80, "John Doe", "O+");

        CurrentHealthDisplay display = new CurrentHealthDisplay(patient);

        HeartMonitor heartMonitor = new HeartMonitor(patient, 75);
        BloodPressureClick bloodPressureMonitor = new BloodPressureClick(patient, 120, 80);

        display.addHealthDecorator(heartMonitor);
        display.addHealthDecorator(bloodPressureMonitor);

        System.out.println("\nInitial State:");
        display.display();

        System.out.println("\n1. Updating patient blood pressure...");
        patient.setBloodPressure(150, 95);

        System.out.println("\n2. Updating heart rate...");
        heartMonitor.setHeartRate(110);

        System.out.println("\n3. Updating blood pressure monitor...");
        bloodPressureMonitor.setBloodPressure(145, 92);

        System.out.println("\n4. Updating patient name...");
        patient.setName("Jane Smith");

        System.out.println("\n5. Removing heart monitor...");
        display.removeHealthDecorator(heartMonitor);

        System.out.println("\n6. Final update - changing blood pressure...");
        patient.setBloodPressure(130, 85);

        System.out.println("\nFinal State:");
        display.display();

        System.out.println("\n=== System Test Complete ===");
    }
}