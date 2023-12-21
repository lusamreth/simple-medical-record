package simple.medical.record.validation;

public class EnumsField extends InputField {
    private String[] EnumValues;

    public EnumsField(String fieldName, String[] validValues) {
        super(fieldName);
        this.EnumValues = validValues;
        String warning = "";
        for (int i = 0; i < this.EnumValues.length; i++) {
            warning += this.EnumValues[i] + ",";
        }
        this.setFieldError(fieldName + " should only contain " + "[" + warning + "]");
    }

    @Override
    public boolean Validator() {
        boolean isValid = false;
        for (int i = 0; i < this.EnumValues.length; i++) {
            if (EnumValues[i].equalsIgnoreCase(this.getValue())) {
                return true;
            }
        }

        return isValid;
    }
}
