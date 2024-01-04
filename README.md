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


# **The Detail of Each Class(Report)**
### We have 25 classes. For Class (1-13) use to call the information about patient, doctor, receptionist, medical record as well. For Class (14-17) use for the **Store Data Service** for all information of the user. For class (18) use for the **REGISTER SERVICE** for the new user. For Class(19) use for **Generate ID** for the identification for the primary key of each information class. For class (20-23) Use for **LOGIN SERVICE**. for (24-25) use for running as the main of the whole program.
_______________________________________________
**Directory: [Domain/MedicalRecordEntity]((https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains))**

1. _[Diagnosis Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Diagnosis.java)_:

2. _[Intake Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Intake.java))_

3. _[Prescription Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Prescription.java))_


4. _[MedicalRecord Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/MedicalRecord.java))_


5. _[PersonInterface]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/meta/PersonInterface.java))_


6. _[Address Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Address.java))_

7. _[Doctor Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Doctor.java))_

8. _[Hospital Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Hospital.java))_

9. _[MedicalDate Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/MedicalDate.java))_

10. _[Patient Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Patient.java))_

11. _[Person Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Person.java))_

12. _[Receptionist Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Receptionist.java))_

13. _[Person Interface](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/meta/PersonInterface.java)_

**Directory: [Reposity](https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/repository)**

14. _[BaseRepository Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/repository/BaseRepository.java)_: An abstract class providing a generic structure for a repository with CRUD operations.

15. _[FileRepo Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/repository/FileRepo.java)_: An abstract class representing a file repository for managing data storage in a medical record system.

16. _[FileRepoJSon Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/repository/FileRepoJson.java)_

17. _[PersonRepo Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/repository/PersonRepo.java)_

**Directory: [Services](https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/services)**

18.  _[RegisterSevice Class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/services/RegisterService.java)_

**Directory: [util]([https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/services](https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/utils))**

19.  _[UniqueIdGenerator class](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/utils/UniqueIdGenerator.java)_

**Directory: [validation](https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/validation)**

20.  _[EnumsField](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/validation/EnumsField.java)_

21.  _[InputField](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/validation/InputField.java)_

22.  _[PasswordField](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/validation/PasswordField.java)_

23.  _[StringField](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/validation/StringField.java)_

**Directory: [Record](https://github.com/lusamreth/simple-medical-record/tree/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record)**

24.  _[App.java](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/App.java)_

25.  _[CLIFormFetcher](https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/CLIFormFetcher.java)_


# **Inheritance**
**Super Class & Sub Class**:
    - We have one super class is [Person Class]((https://github.com/lusamreth/simple-medical-record/blob/7f1fd28d62b4ffbd4380bd678f633a7f7b43dbeb/app/src/main/java/simple/medical/record/domains/Person.java)), because all the user has the similar personal information of the user.
    - We have 3 sub class include: Patint Class, Doctor, Receptionist extends from super class Person

**Constructor**:


### **Overloading Method**


### **Override Method**


# **Polymorphism**
### **Casting**


# **Encapsulation**
- Private
- Protected:
    + In the field RepoField Class:
        1. Protected Fields:
            + protected String dataEntryPoint;
            + protected String fullRepoPath;
            + protected boolean hasException = false;
                These fields are marked as protected to allow subclasses (classes that extend FileRepo) to access them directly. Subclasses can inherit and manipulate these fields as needed for specific implementations without exposing them to the entire package or external classes.
        2. Protected Methods:
            + protected synchronized String readFullContent() throws IOException;
            + protected boolean writeFullContent(String content) throws IOException;
        3.  Protected Constructor
            + The fileObject is marked as protected to allow subclasses to access and manipulate the File object directly.

# **Abstraction**
### **Abstract Class**
- Abstract class at BaseRepository<Entity> in ---: designed to provide a generic and abstract foundation for creating repositories that handle basic CRUD operations (Create, Read, Update, Delete) for entities in a data storage system.
- Abstract class at InputField.java: designed to provide a framework for handling and validating input fields.

### **interface**



# **Exception Handling**


# **File I/O**
We utilize a single 'appdb.json' file for both storing and validating user information during authentication. This approach simplifies data management, improves code organization, and enhances readability. Having a unified file as the sole source of truth promotes simplicity, reducing complexity and potential errors. This design choice provides a streamlined solution, ensuring efficient scalability and adaptability to changes in user data.

# **Anonymous inner class**
public void writeJsonFile(Dictionary<String, Object> content) throws IOException {
        Function<String, Boolean> repoWriter = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String content) {
                try {
                    return writeFullContent(content);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        };

# **functional interface or Lambda Expression**


# **Lambda Expression**


# **Static Method**



