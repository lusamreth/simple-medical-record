package simple.medical.record.domains.MedicalRecordEntity;

public class Prescription {
    private String perID;
    private String medName;
    private String dosageUnit;
    private int dosage;
    private Intake intakeInstruction;

    public Prescription(String perID, String medName, String dosageUnit, int dosage, Intake intakeInstruction) {
        this.perID = perID;
        this.medName = medName;
        this.dosageUnit = dosageUnit;
        this.dosage = dosage;
        this.intakeInstruction = intakeInstruction;
    }

    public String getPerID() {
        return perID;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public Intake getIntakeInstruction() {
        return intakeInstruction;
    }

    public void setIntakeInstruction(Intake intakeInstruction) {
        this.intakeInstruction = intakeInstruction;
    }

}
