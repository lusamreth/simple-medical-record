package simple.medical.record.validation;

public class StringField extends InputField {

    public StringField(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean Validator() {
        // check none empty !!
        if (this.getValue() == "") {
            return false;
        }
        return true;
    }

}
