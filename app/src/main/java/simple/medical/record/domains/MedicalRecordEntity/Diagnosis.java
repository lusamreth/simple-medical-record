package simple.medical.record.domains.MedicalRecordEntity;

public class Diagnosis {
    private String diagID;
    private String diagName;
    private String symptom;
    private String remark;

    public Diagnosis(String diagID, String diagName, String symptom, String remark) {
        this.diagID = diagID;
        this.diagName = diagName;
        this.symptom = symptom;
        this.remark = remark;
    }

    public String getFormatDiagnosis() {
        String formattedDiagnosis = String.format(
                "Diagnosis ID: %d%nDiagnosis Name: %s%nSymptom: %s%nRemark: %s%n",
                diagID, diagName, symptom, remark);
        return formattedDiagnosis;
    }
}
