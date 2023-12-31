package simple.medical.record.validation;

import simple.medical.record.utils.Cypher;
import simple.medical.record.utils.PasswordCypher;

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
        }

        if (inputValue.length() > maxLen) {
            this.setFieldError("Password must not exceed " + maxLen + " characters!");
            return false;
        }

        for (int j = 0; j < inputValue.length(); j++) {
            char charValue = inputValue.charAt(j);
            for (int i = 0; i < this.SpecialCases.length(); i++) {
                if (this.SpecialCases.charAt(i) == charValue) {
                    isValid = true;
                    break;
                }
            }
        }

        if (!isValid) {
            this.setFieldError("Password must contain at least one special character!");
        }

        return isValid;
    }
}
