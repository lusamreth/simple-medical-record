package Medical_Record;

public class Hospital_Class {
    private String name;
    private Address_Class address;
    
    public Hospital_Class(String name, Address_Class address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address_Class getAddress() {
        return address;
    }

    public void setAddress(Address_Class address) {
        this.address = address;
    }

    

    

    
}
