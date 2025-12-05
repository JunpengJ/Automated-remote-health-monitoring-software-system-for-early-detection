import java.util.ArrayList;
import java.util.List;

public class CurrentHealthDisplay implements Patient, DeviceObserver, Display{
    private PatientData patientData;
    private List<DeviceObserver> devices = new  ArrayList<>();
    private List<HealthDecorator>  healthDecorators = new  ArrayList<>();

    public CurrentHealthDisplay(PatientData patientData) {
        this.patientData = patientData;
        patientData.registerPatient(this);
    }

    public void addHealthDecorator(HealthDecorator decorator) {
        healthDecorators.add(decorator);
        patientData.registerPatient(decorator);
    }

    public void removeHealthDecorator(HealthDecorator decorator) {
        healthDecorators.remove(decorator);
        patientData.removePatient(decorator);
    }

    public Patient getPatient() {return patientData;}

    public void setPatient(PatientData patientData) {
        if (this.patientData != null) {
            this.patientData.removePatient(this);
            for (HealthDecorator decorator : healthDecorators) {
                this.patientData.removePatient(decorator);
            }
        }
        this.patientData = patientData;
        if (patientData != null) {
            patientData.registerPatient(this);

            for (HealthDecorator decorator : healthDecorators) {
                patientData.registerPatient(decorator);
            }
        }
    }

    public void registerPatient(DeviceObserver device) {
        if (!devices.contains(device)) {
            devices.add(device);
        }
    }

    public void removePatient(DeviceObserver device){devices.remove(device);}

    public void notifyPatient(){
        for (DeviceObserver device: devices){
            device.update(this);
        }
    };
    public void update(Patient p) {
        if (p instanceof PatientData) {
            display();
        }
    }

    public void display(){
        System.out.println("\n=== Current Health Display ===");
        System.out.println("Patient Name: " + patientData.getName());
        System.out.println("Blood Type: " + patientData.getBloodType());
        System.out.println("Base Blood Pressure: " + patientData.getHighBlood() +
                "/" + patientData.getLowBlood());

        System.out.println("\nHealth Decorators:");
        if (healthDecorators.isEmpty()) {
            System.out.println("  No health decorators added");
        } else {
            for (HealthDecorator decorator : healthDecorators) {
                decorator.display();
            }
        }
    }
}
