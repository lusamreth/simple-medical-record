# simple-medical-record
OOC projects


# Overview

Challenges in the current healthcare system impede efficient patient care and pose risks for both patients and
healthcare professionals. A major concern is the lack of patient access to medical records, limiting their engagement
in their healthcare journey. The prevalent use of paper-based records further jeopardizes the integrity and security of
sensitive health information. Patients' constrained access hinders informed decision-making, potentially leading
to suboptimal outcomes. On the provider side, reliance on traditional methods like handwritten records consumes
time and introduces error risks. The dependence on memory for recalling patient information also poses risks of
oversight in care delivery. Addressing these issues requires a comprehensive solution to enhance patient access, secure
data exchange, and streamline record-keeping for improved healthcare quality. The object of this project is:

1. Implementation of Electronic Health Records (EHR): Transitioning from paper-based records to a secure and centralized
EHR system will facilitate efficient patient information storage, retrieval, and exchange. This digital format minimizes the risk of
data loss, enhances accuracy, and ensures the integrity of health records.

2. Patient Portals for Enhanced Access: Introducing user-friendly patient portals connected to the EHR system will empower
patients to access their medical records securely. This access includes information on diagnoses, treatments, medications,
cwand test results, fostering informed decision-making and active patient participation in their healthcare.


# System Primary Functions

1. Create Doctor Account
2. Create Patient Account
3. Create Medical Record
4. Generate Report



# The Detail of Each Class(Report)
**Directory: [Domain/MedicalRecordEntity](app/src/main/java/simple/medical/record/domains)**

1. _[Diagnosis Class](app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Diagnosis.java)_: 
    Attributes:
        - Private diagID: This is a unique identifier generated for each instance of the Diagnosis class. It ensures that each diagnosis has a distinct identifier.	
            + Usage: The diagID is generated using UniqueIdGenerator.genId() in the constructor, and the generated value is assigned to this private field.
        - Private diagName: Stores the name of the diagnosis.
        - Private symptom: Stores information about the symptoms associated with the diagnosis.
        - Private remark: Provides additional remarks or information related to the diagnosis.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The diagID is conceptually used to generate a unique identifier for each diagnosis instance, promoting uniqueness and identification.
        - The diagName, symptom, and remark fields are conceptually used to store specific information about the diagnosis, allowing for a detailed representation.
        - The getFormatDiagnosis() method, though not directly using attributes, conceptually utilizes the private fields to construct a formatted string representing the diagnosis information.

2. _[Intake Class](app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Intake.java)_
    Attributes:
        - Private timeUse: Represents the time of day for the intake, such as morning or afternoon.
            + Usage: The timeUse is initialized in the constructor with the value passed as an argument. Accessed through the getTimeUse() method to retrieve the time of intake. Modified through the setTimeUse() method to update the time of intake.
        - Private frequency: Represents the frequency of intake.
            + Usage: The frequency is initialized in the constructor with the value passed as an argument. Accessed through the getFrequency() method to retrieve the intake frequency. Modified through the setFrequency() method to update the intake frequency.
        - Private remark: Provides additional remarks or information related to the intake.
            + Usage: The remark is initialized in the constructor with the value passed as an argument. Accessed through the getRemark() method to retrieve remarks about the intake. Modified through the setRemark() method to update remarks about the intake.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The timeUse, frequency, and remark fields are conceptually used to store specific information about the intake schedule, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify the intake information in a controlled manner.
        - The constructor initializes the intake information when an instance of the Intake class is created, ensuring that essential details are provided at the time of object creation.


3. _[Prescription Class](app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Prescription.java)_
    Attributes:
        - Private perID: Represents a unique identifier for each prescription.
            + Usage: The perID is generated using UniqueIdGenerator.genId() in the constructor, ensuring each prescription has a distinct identifier. Accessed through the getPerID() method to retrieve the prescription identifier. Modified through the setPerID() method to update the prescription identifier.
        - Private medName: Represents the name of the prescribed medication.
            + Usage: Initialized in the constructor with the value passed as an argument. Accessed through the getMedName() method to retrieve the medication name. Modified through the setMedName() method to update the medication name.
        - Private dosageUnit: Represents the unit of measurement for the medication dosage.
            + Usage: Initialized in the constructor with the value passed as an argument. Accessed through the getDosageUnit() method to retrieve the dosage unit. Modified through the setDosageUnit() method to update the dosage unit.
        - Private dosage: Represents the prescribed dosage amount.
            + Usage: Initialized in the constructor with the value passed as an argument. Accessed through the getDosage() method to retrieve the prescribed dosage. Modified through the setDosage() method to update the prescribed dosage.
        - Private intakeInstruction: Represents information about the intake schedule for the prescribed medication.
            + Usage: Initialized in the constructor with the Intake instance passed as an argument. Accessed through the getIntakeInstruction() method to retrieve the intake instructions. Modified through the setIntakeInstruction() method to update the intake instructions.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The perID, medName, dosageUnit, and dosage fields are conceptually used to store specific information about the prescription, allowing for a detailed representation.
        - The Intake instance provides information about the recommended intake schedule for the prescribed medication, enhancing the completeness of the prescription information.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify prescription information in a controlled manner.
        - The constructor initializes the prescription details when an instance of the Prescription class is created, ensuring that essential information is provided at the time of object creation.


4. _[MedicalRecord Class](app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/MedicalRecord.java)_
    Attributes:
        - Private medID: Represents a unique identifier for each medical record.
        - Private dateofVisit: Represents the date of the patient's visit.
        - Private prescription: Represents information about the prescribed medication for the patient's visit.
        - Private diagnosis: Represents information about the diagnosis for the patient's visit.
        - Private patientID: Represents the patient associated with the medical record.
        - Private docID: Represents the doctor associated with the medical record.
        - Private description: Represents additional description or notes related to the medical record.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The medID, dateofVisit, prescription, diagnosis, patientID, docID, and description fields are conceptually used to store specific information about the medical record, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify medical record information in a controlled manner.
        - The constructor initializes the medical record details when an instance of the MedicalRecord class is created, ensuring that essential information is provided at the time of object creation.

5. _[PersonInterface](app/src/main/java/simple/medical/record/domains/meta/PersonInterface.java)_


6. _[Address Class](app/src/main/java/simple/medical/record/domains/Address.java)_
    Attributes:
        - Private street: Represents the street name of the address.
        - Private village: Represents the village or locality of the address.
        - Private district: Represents the district of the address.
        - Private province: Represents the province or state of the address.

    Methods:
        - Public toString(): Returns a formatted string representing the complete address to get a human-readable representation of the address.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The street, village, district, and province fields are conceptually used to store specific information about the address, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify address information in a controlled manner.
        - The toString() method provides a human-readable representation of the complete address by concatenating the individual components.

7. _[Doctor Class](app/src/main/java/simple/medical/record/domains/Doctor.java)_
    Attributes:
        - Private doctorID: Represents a unique identifier for each doctor.
        - Private email: Represents the email address of the doctor.
        - Private specialty: Represents the medical specialty of the doctor.
        - Private qualification: Represents the educational qualification of the doctor.
        - Private medRecidency: Represents the medical residency information of the doctor.
        - Private description: Represents additional information or notes about the doctor.
        - Private personInfo: Represents personal information about the doctor, extending the Person class.
            + Note: The Person class is assumed to be a superclass containing general personal information like name, sex, date of birth, address, etc.

    Methods:
        - Public displayInformation(): Displays a formatted output of general and specialized information about the doctor.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The doctorID, email, specialty, qualification, medRecidency, description, and personInfo fields are conceptually used to store specific information about the doctor, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify doctor information in a controlled manner.
        - The constructor initializes the doctor details when an instance of the Doctor class is created, ensuring that essential information is provided at the time of object creation.
        - The displayInformation() method provides a formatted output of both general and specialized information about the doctor, facilitating easy readability of key details.

8. _[Hospital Class](app/src/main/java/simple/medical/record/domains/Hospital.java)_
    Attributes:
        - Private name: Represents the name of the hospital.
        - Private address: Represents the physical address of the hospital.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The name and address fields are conceptually used to store specific information about the hospital, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify hospital information in a controlled manner.
        - The constructor initializes the hospital details when an instance of the Hospital class is created, ensuring that essential information is provided at the time of object creation.

9. _[MedicalDate Class](app/src/main/java/simple/medical/record/domains/MedicalDate.java)_
    Attributes:
        - Private day: Represents the day component of the medical date
        - Private month: Represents the month component of the medical date.
        - Private year: Represents the year component of the medical date.
        - Static age: Represents the calculated age, shared across all instances of the class.

    Methods:
        - Public static int calculateAge(Date birthDate, Date currentDate): Calculates the age based on the provided birth date and current date.
            - Usage: Invoked to determine the age by comparing the year components of the birthDate and currentDate. Updates the static age variable with the calculated age and returns the calculated age.

    Concept:
        - The use of private access modifiers ensures that day, month, and year attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The calculateAge() method calculates the age by comparing the year components of the birthDate and currentDate. It adjusts the age if the birthdate hasn't occurred yet in the current year.
        - The static age variable is used to store the calculated age and is shared across all instances of the class.
        - The getter and setter methods provide controlled access to the private day, month, and year attributes, allowing external classes to retrieve or modify date information in a controlled manner.
        - The constructor initializes the date components when an instance of the MedicalDate class is created, ensuring that essential information is provided at the time of object creation.

10. _[Patient Class](app/src/main/java/simple/medical/record/domains/Patient.java)_
    Attributes:
        - Private patientID: Represents a unique identifier for each patient.
        - Private emer_call: Represents the emergency contact number for the patient.
        - Private last_visited: Represents the date of the patient's last visit.

    Methods:
        - Public displayInformation(): Displays a formatted output of information about the patient.

    Concept:
        - The use of private access modifiers ensures that these attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The patientID, emer_call, and last_visited fields are conceptually used to store specific information about the patient, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private fields, allowing external classes to retrieve or modify patient information in a controlled manner.
        - The constructor initializes the patient details when an instance of the Patient class is created, ensuring that essential information is provided at the time of object creation.
        - The displayInformation() method provides a formatted output of general and specific information about the patient, facilitating easy readability of key details.

11. _[Person Class](app/src/main/java/simple/medical/record/domains/Person.java)_
    Attributes:
        - Private userId: Represents a unique identifier for each person.
        - Private fullname: Represents the full name of the person (combination of first name and last name).
        - Private firstname: Represents the first name of the person.
        - Private lastname: Represents the last name of the person.
        - Private sex: Represents the gender/sex of the person.
        - Private dateofbirth: Represents the date of birth of the person.
        - Private address: Represents the physical address of the person.
        - Private phoneNumber: Represents an array of phone numbers associated with the person.
        - Private password: Represents the password associated with the person.

    Methods:
        - Public int calculateAge(): Calculates the age of the person based on the date of birth.
            + Usage: Invoked to calculate and return the age using the MedicalDate.calculateAge() method.
        - Public String displayPhoneNumber(): Formats and returns a string representation of the phone numbers.
         - Public void splitFullName(String fullName): Splits the full name into first name and last name and updates the corresponding fields.

    Concept:
        - The use of private access modifiers ensures that attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The userId, fullname, firstname, lastname, sex, dateofbirth, address, phoneNumber, and password fields are conceptually used to store specific information about the person, allowing for a detailed representation.
        - The calculateAge() method uses the MedicalDate.calculateAge() method to determine and return the age of the person.
        - The displayPhoneNumber() method provides a formatted string representation of the phone numbers for easy readability.
        - The splitFullName() method splits the full name into first name and last name, facilitating updates to the corresponding fields.

12. _[Receptionist Class](app/src/main/java/simple/medical/record/domains/Receptionist.java)_
    Attributes:
        - Private receptionistID: Represents a unique identifier for each receptionist.
        - Private lastname
        - Private sex  
        - Private dateofbirth
        - Private phoneNumber
        - Private address

    Methods:
        - Public void displayInformation(): Displays a formatted output of information about the receptionist.

    Concept:
        - The use of private access modifiers ensures that attributes are not directly accessible from outside the class, promoting encapsulation and data integrity.
        - The receptionistID field is conceptually used to store specific information about the receptionist, allowing for a detailed representation.
        - The getter and setter methods provide controlled access to the private receptionistID field, allowing external classes to retrieve or modify receptionist information in a controlled manner.
        - The constructor initializes the receptionist details when an instance of the Receptionist class is created, ensuring that essential information is provided at the time of object creation.
        - The displayInformation() method provides a formatted output of general and specific information about the receptionist, facilitating easy readability of key details.
        - The calculateAge() method, displayPhoneNumber() method, and other relevant methods from the parent class (Person) are inherited, enabling the Receptionist class to leverage the functionality defined in the Person class.
