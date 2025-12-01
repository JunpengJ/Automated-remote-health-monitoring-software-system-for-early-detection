import java.util.ArrayList;
import java.util.List;

public class CurrentHealthDisplay implements Patient, DeviceObserver, Display{
    private PatientData patientData;
    private List<DeviceObserver> devices = new  ArrayList<>();
    private List<HealthDecorator>  healthDecorators = new  ArrayList<>();

    public CurrentHealthDisplay(PatientData patientData){
        this.patientData = patientData;
        patientData.registerPatient(this);
    }

    public void addHealthDecorator(HealthDecorator decorator){
        healthDecorators.add(decorator);
    }
    public Patient getPatient() {return patientData;}
    public void setPatient(PatientData patientData) {this.patientData = patientData;}

    public void registerPatient(DeviceObserver device){devices.add(device);}
    public void removePatient(DeviceObserver device){devices.remove(device);}

    public void notifyPatient(){
        for (DeviceObserver device: devices){
            device.update(this);
        }
    };
    public void update(Patient p){
        if (p )
    };

    public void display(){
        System.out.println("Current Health Display");
        System.out.println("Patient Name: " + patientData.getName());
        System.out.println("Blood Pressure: " + patientData.getHighBlood() + "/" + patientData.getLowBlood());
        System.out.println("Blood Type: " + patientData.getBloodType());
    }


}
