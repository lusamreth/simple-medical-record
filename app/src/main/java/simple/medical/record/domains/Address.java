package simple.medical.record.domains;

public class Address {
    private String street;
    private String village;
    private String district;
    private String province;

    public Address(String street, String village, String district, String province) {
        this.street = street;
        this.village = village;
        this.district = district;
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String toString() {
        return this.getStreet() + ", " + this.getVillage() + ", " + this.getDistrict() + ", " + this.getProvince();
    }
}
