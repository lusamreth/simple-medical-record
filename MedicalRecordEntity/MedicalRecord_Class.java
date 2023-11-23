package Medical_Record.MedicalRecordEntity;

import Medical_Record.Date_Class;
import Medical_Record.Doctor_Class;
import Medical_Record.Patient_Class;

public class MedicalRecord_Class {
    private String medID;
    private Date_Class dateofVisit;
    private Prescription prescription;
    private Diagnosis_Class diagnosis;
    private Patient_Class patientID;
    private Doctor_Class docID;
    private String description;
    public MedicalRecord_Class(String medID, Date_Class dateofVisit, Prescription prescription,
            Diagnosis_Class diagnosis, Patient_Class patientID, Doctor_Class docID, String description) {
        this.medID = medID;
        this.dateofVisit = dateofVisit;
        this.prescription = prescription;
        this.diagnosis = diagnosis;
        this.patientID = patientID;
        this.docID = docID;
        this.description = description;
    }
    
    public String getMedID() {
        return medID;
    }
    public void setMedID(String medID) {
        this.medID = medID;
    }
    public Date_Class getDateofVisit() {
        return dateofVisit;
    }
    public void setDateofVisit(Date_Class dateofVisit) {
        this.dateofVisit = dateofVisit;
    }
    public Prescription getPrescription() {
        return prescription;
    }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    public Diagnosis_Class getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(Diagnosis_Class diagnosis) {
        this.diagnosis = diagnosis;
    }
    public Patient_Class getPatientID() {
        return patientID;
    }
    public void setPatientID(Patient_Class patientID) {
        this.patientID = patientID;
    }
    public Doctor_Class getDocID() {
        return docID;
    }
    public void setDocID(Doctor_Class docID) {
        this.docID = docID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    

    

}
