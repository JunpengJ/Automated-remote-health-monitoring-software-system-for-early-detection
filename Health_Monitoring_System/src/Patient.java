public interface Patient {
    void registerPatient(DeviceObserver o);
    void removePatient(DeviceObserver o);
    void notifyPatient();
}
