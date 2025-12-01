public abstract class HealthDecorator implements DeviceObserver, Display{
    protected PatientData patientData;

    public HealthDecorator(PatientData patientData) {
        this.patientData = patientData;
        patientData.registerPatient(this);
    }

    public abstract String getMeasurement();

    public void update(Patient p){
        if (p instanceof PatientData){
            measurementsChange();
        }
    }

    public void measurementsChange(){display();}
    public abstract void display();
}
