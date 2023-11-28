package Medical_Record.MedicalRecordEntity;

import Medical_Record.Date;
import Medical_Record.Doctor;
import Medical_Record.Patient;

public class MedicalRecord {
    private String medID;
    private Date dateofVisit;
    private Prescription prescription;
    private Diagnosis diagnosis;
    private Patient patientID;
    private Doctor docID;
    private String description;

    public MedicalRecord(String medID, Date dateofVisit, Prescription prescription,
            Diagnosis diagnosis, Patient patientID, Doctor docID, String description) {
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

    public Date getDateofVisit() {
        return dateofVisit;
    }

    public void setDateofVisit(Date dateofVisit) {
        this.dateofVisit = dateofVisit;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public Doctor getDocID() {
        return docID;
    }

    public void setDocID(Doctor docID) {
        this.docID = docID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
