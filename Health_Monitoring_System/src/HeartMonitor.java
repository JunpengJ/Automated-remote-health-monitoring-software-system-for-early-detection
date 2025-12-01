public class HeartMonitor extends HealthDecorator{
    private int heartRate;

    public HeartMonitor(PatientData patientData){
        super(patientData);
        this.heartRate = 90;
    }

    public HeartMonitor(PatientData patientData, int initialHeartRate){
        super(patientData);
        this.heartRate = initialHeartRate;
    }

    public int getHeartRate(){return heartRate;}

    public void setHeartRate(int heartRate){
        this.heartRate = heartRate;
        measurementsChange();
    }

    public String getMeasurement() {
        String states = "Normal";
        if (heartRate > 100) {
            states = "Heart Hurry";
        }
        else if (heartRate < 60) {
            states = "Heart Slow";
        }
        return String.format("Heart Rate: %d BPM (%s)", heartRate, states);
    }

    public void display(){
        System.out.println("Heart Monitor");
        System.out.println(" " + getMeasurement());

        if(heartRate > 100){
            System.out.println(" Suggestion: Please take appropriate rest and avoid strenuous exercise");
        }
        else if (heartRate < 60) {
            System.out.println(" Suggestion: Please consult a doctor, you may need to have some tests");
        }
        else{
            System.out.println(" Suggestion: Heart rate is normal, please keep it");
        }
    }
}
