
package simple.medical.record.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Cypher extends PasswordCypher {
    public String hash(String password) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return bcryptHashString;
    }

    public Boolean compare(String input, String hash) {
        System.out.println("Input: " + input + " Hash: " + hash);
        return BCrypt.verifyer()
                .verify(input.toCharArray(), hash).verified;

    }
}
