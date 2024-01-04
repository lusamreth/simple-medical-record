
package simple.medical.record.utils;

public abstract class PasswordCypher {
    abstract public String hash(String password);

    abstract public Boolean compare(String input, String hash);
}
