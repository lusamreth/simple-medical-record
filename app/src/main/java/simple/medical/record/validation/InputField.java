package simple.medical.record.validation;

// @FunctionalInterface
// interface Function {
// void apply();
// }

public abstract class InputField {
    private String fieldValue;
    private String fieldName;
    private String fieldErrMsg;

    public InputField(String fieldName) {
        this.fieldName = fieldName;
        this.fieldErrMsg = fieldName + " field has an unknown Exception";
    }

    public String getValue() {
        return this.fieldValue.trim();
    }

    public void setValue(String value) {
        this.fieldValue = value;
    }

    public void setFieldError(String error) {
        this.fieldErrMsg = error;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String verify() throws Exception {
        if (this.getValue() == "" || this.getValue() == null) {
            throw new Exception("Empty Value");
        }
        boolean res = this.Validator();

        if (!res) {
            throw new Exception(this.fieldErrMsg);
        } else {
            return this.getValue();
        }

    };

    public abstract boolean Validator();
}
