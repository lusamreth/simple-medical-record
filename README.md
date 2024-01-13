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
We have 25 classes. For Class (1-13) use to call the information about patient, doctor, receptionist, medical record as well. For Class (14-17) use for the **Store Data Service** for all information of the user. For class (18) use for the **REGISTER SERVICE** for the new user. For Class(19) use for **Generate ID** for the identification for the primary key of each information class. For class (20-23) Use for **LOGIN SERVICE**. for (24-25) use for running as the main of the whole program.
_______________________________________________
1. _[Diagnosis Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Diagnosis.java)_

2. _[Intake Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Intake.java)_

3. _[Prescription Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/Prescription.java)_

4. _[MedicalRecord Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/MedicalRecordEntity/MedicalRecord.java)_

5. _[PersonInterface](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/meta/PersonInterface.java)_

6. _[Address Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Address.java)_

7. _[Doctor Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Doctor.java)_

8. _[Hospital Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Hospital.java)_

9. _[MedicalDate Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/MedicalDate.java)_

10. _[Patient Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Patient.java)_

11. _[Person Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Person.java)_

12. _[Receptionist Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/domains/Receptionist.java)_

13. _[BaseRepoStore Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/BaseRepoStore.java)_

14. . _[BaseRepository Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/BaseRepository.java)_: An abstract class providing a generic structure for a repository with CRUD operations.

15. _[DoctorRepo Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/DoctorRepo.java)_

16. _[FileRepo Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/FileRepo.java)_: An abstract class representing a file repository for managing data storage in a medical record system.

17. _[FileRepoJSon Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/FileRepoJson.java)_

18. _[PersonRepo Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/PersonRepo.java)_

19. _[DoctorService Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/services/DoctorService.java)_

20. _[LoginService Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/services/LoginService.java)_

21. _[RegisterSevice Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/services/RegisterService.java)_

22. _[Cypher Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/utils/Cypher.java)_

23. _[MapUtil Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/utils/MapUtils.java)_

24. _[PasswordCypher Class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/utils/PasswordCypher.java)_

25. _[UniqueIdGenerator class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/utils/UniqueIdGenerator.java)_

26. _[UnixTimestampAdapter class](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/utils/UnixTimestampAdapter.java)_

27.  _[EnumsField](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/validation/EnumsField.java)_

28.  _[InputField](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/validation/InputField.java)_

29.  _[PasswordField](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/validation/PasswordField.java)_

30.  _[StringField](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/validation/StringField.java)_

31.  _[App.java](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/App.java)_

32.  _[CLIFormFetcher](https://github.com/lusamreth/simple-medical-record/blob/7fd6b6ccee68092fde7e55556a8dcefb4808e8a6/app/src/main/java/simple/medical/record/CLIFormFetcher.java)_

33. _[appdb.json](https://github.com/lusamreth/simple-medical-record/blob/117d45f45e2463a57226af864227bad39b36a874/appdb.json)_: this is use to store the patient data input

34. _[db.json](https://github.com/lusamreth/simple-medical-record/blob/eb654a03874074caf60d2d23e8d470cc47a3e87e/db.json)_: it is use to store the doctor data input


# **Inheritance**
**Super Class & Sub Class**:
Inheritance is the class"Super Class" that can use by other class"Sub-class". It make the code more reusable and fast when there are many similar field of of class that we want to impliment. 
Here is where we have impliment 4 inheritance class serve differently

- Person Class: all the user has the similar personal information of the user.
    + We have 3 sub class include: Patint Class, Doctor, Receptionist extends from super class Person
- [FileRepo Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/FileRepo.java): the [FileRepoJson]() use for the customize the reader object from the user input. 
    + We have a sub class [FileRepoJson]() extends from the super class [FileRepo]()
- [BaseRepository](): all the 2 sub class is th exaplainable code for each function which call in the super class. 
    + We have a sub class include [BaseRepoStore](), [PersonRepo]() extends from the super class [BaseRepository](). 
- [InputField](): all the class use for making sure the use will input more properly as we wanted.
    + We have a sub class include [EnumsField](), [PasswordField](), [StringField]() extends from the super class [InputField]().

**Constructor**:
What: The special method use to create object for the class, It is used to initialize the object's state, allocate resources, or perform any other setup tasks.
Why: The constructor is to ensure that an object is properly initialized when it is instantiated
How: In our class files, we have include the contructor on nearly every files. 


### **Overloading Method**
What: it is the method or function which allow to use with the same name but different field input.
Why: It is reusable and reliable to keep the function going while they are involve using with many classes. It will create a constant name for all developer to remember more easy.
How: We have use it in many places like:
- [FileRepo Class](https://github.com/lusamreth/simple-medical-record/blob/3510efc7c4bbf7b7e25955cd27c629150172590e/app/src/main/java/simple/medical/record/repository/FileRepo.java): it has 3 overloading method  
    + First method is use for call  the file input of the datas will store  
    ``` java
        
        public FileRepo(String repoPath, String dataEntryPoint) {
            this.init(repoPath, dataEntryPoint);
        }

    ```
    + Second Method is use for indicating setup or initialization logic for data entry. 
    ```java
        public FileRepo(String dataEntryPoint) {
            String DEFAULT_DIR = System.getProperty("user.dir");
    
            this.dataEntryPoint = dataEntryPoint;
            this.fullRepoPath = DEFAULT_DIR + "/" + dataEntryPoint + ".json";
            this.fileObject = new File(this.fullRepoPath);
            this.init(DEFAULT_DIR, dataEntryPoint);
        }
    ```
    + Third Method: use for assuming default values for the data entry point and sets up the FileRepo object with default configurations.
    ```java
        public FileRepo() {
            String DEFAULT_DIR = System.getProperty("user.dir");
            System.out.println("USING DEFAULT REPO DIR " + DEFAULT_DIR);
            this.dataEntryPoint = "db.json";
            this.fullRepoPath = DEFAULT_DIR + dataEntryPoint;
            this.fileObject = new File(this.fullRepoPath);
            this.init(DEFAULT_DIR, "db.json");
        }
    ```
- [FileRepoJson](): it has 2 overloading method 
    + First Method: Use to inherit from the super class without field inside.
    ```java
        public FileRepoJson() {
            super();
        }
    ```
    + Second Method: Use to inherit from the super class but include the entryField as the field to get the data from the input.
    ```java
        public FileRepoJson(String entryField) {
            super(entryField);
        }
    ```

### **Override Method**



# **Polymorphism**
Polymorphism refers to the ability of a single function, method, or operator to work with different types of data or objects.

```java
    public class PasswordField extends InputField {
    private String SpecialCases = "@#$%^&+=";
    private Integer minLen = 8;
    private Integer maxLen = 24;

        public PasswordField() {
            super("password");

            this.setFieldError(this.getFieldName() + " is invalid!");
        }

        public PasswordField(String passname) {
            super(passname);
            this.setFieldError(this.getFieldName() + " is invalid!");
        }

        @Override
        public boolean Validator() {
            boolean isValid = false;
            String inputValue = this.getValue();
            if (inputValue.length() < minLen) {
                this.setFieldError("Password must not be below" + minLen + " characters!");
                return false;
        ....... 
```
look more on this code: [PasswordField](https://github.com/lusamreth/simple-medical-record/blob/eb654a03874074caf60d2d23e8d470cc47a3e87e/app/src/main/java/simple/medical/record/validation/PasswordField.java)

This Validatior file use the method overriding is a specific type of polymorphism where a subclass provides a specific implementation for a method that is already defined in its superclass. It help our system promote the flexibility while it's been using for testing the password in the field. 


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
An anonymous inner class in Java is a class without a name that's defined and instantiated in a single expression.

```java 
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
```
This function provides a way to write the contents to a JSON file, using the repoWriter function to handle the writing process. This function benefit us to check the condition when import the data to the json files.

# **Static Method**
