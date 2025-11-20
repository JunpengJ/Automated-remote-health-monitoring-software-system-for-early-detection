import java.util.Observer;

public interface Patient {
    void registerPatient(Observer o);
    void removePatient(Observer o);
    void notifyPatient();
}
