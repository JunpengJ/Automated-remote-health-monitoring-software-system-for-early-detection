import java.util.ArrayList;
import java.util.List;

public class PatientData implements Patient {
    private int highBlood;
    private int lowBlood;
    private String  name;
    private String bloodType;
    private List<DeviceObserver> observers = new ArrayList<>();
    public PatientData(int highBlood, int lowBlood, String name, String bloodType) {
        this.name = name;
        this.highBlood = highBlood;
        this.lowBlood = lowBlood;
        this.bloodType = bloodType;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
        notifyPatient();
    }

    public String getBloodType() {return  bloodType;}
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
        notifyPatient();
    }

    public int getHighBlood(){return highBlood;}
    public void setHighBlood(int highBlood){
        this.highBlood = highBlood;
        notifyPatient();
    }

    public int getLowBlood(){return lowBlood;}
    public void setLowBlood(int lowBlood){
        this.lowBlood = lowBlood;
        notifyPatient();
    }

    public void setBloodPressure(int highBlood, int lowBlood) {
        this.highBlood = highBlood;
        this.lowBlood = lowBlood;
        notifyPatient();
    }

    public void registerPatient(DeviceObserver o){observers.add(o);}
    public void removePatient(DeviceObserver o){observers.remove(o);}
    public void notifyPatient(){
        for (DeviceObserver device : observers){
            device.update(this);
        }
    }
}
