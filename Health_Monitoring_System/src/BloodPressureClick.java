public class BloodPressureClick extends HealthDecorator{
    private int systolic;
    private int diastolic;

    public BloodPressureClick(PatientData patientData){
        super(patientData);
        this.systolic = 120;
        this.diastolic = 80;
    }

    public BloodPressureClick(PatientData patientData, int systolic, int diastolic){
        super(patientData);
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public int[] getMeasurementValues(){
        return new int[]{systolic,diastolic};
    }
    public void setBloodPressure(int systolic, int diastolic){
        this.systolic = systolic;
        this.diastolic = diastolic;
        measurementsChange();
    }

    public String getMeasurement(){
        String status = "Normal";
        if(systolic >= 140 || diastolic >= 90){
            status = "Hypertension";
        }
        else if(systolic >= 130 || diastolic >= 85){
            status = "Pre Hypertension";
        }
        else if(systolic < 90 || diastolic < 60){
            status = "Hypotension";
        }
        else{
            status = "Ideal Blood Pressure";
        }
        switch(status){
            case "Hypertension":
                System.out.println(" Suggestion: Please seek medical attention immediately, medication may be required for treatment");
                break;
            case "Pre Hypertension":
                System.out.println(" Suggestion: Pay attention to your diet, reduce salt intake, and increase physical activity");
                break;
            case "Hypotension":
                System.out.println(" Suggestion: Properly increase the intake of salt and water");
                break;
            case "Ideal Blood Pressure":
                System.out.println(" Suggestion: Maintain good living habits");
                break;
        }

        return String.format("Blood Pressure: %d/%d mmHg (%s)", systolic, diastolic, status);
    }

    public void display(){
        System.out.println("Blood Pressure Monitor: ");
        System.out.println(" " + getMeasurement());
    }
}
