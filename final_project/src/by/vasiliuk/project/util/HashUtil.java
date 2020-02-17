package by.vasiliuk.project.util;


import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;


public class HashUtil {

    private static final int ITERATIONS = 100;
    private static final int SALT_LEN = 32;
    private static final int DESIRED_KEY_LEN = 50;

    public static String hash(String password) {
        byte[] salt;
        String hashByteString = new String();
        try {
            salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(SALT_LEN);
            hashByteString =  Base64.getEncoder().encodeToString((salt + "$" + hash(password, salt)).getBytes());
        } catch (NoSuchAlgorithmException e) {
            // log todo
            e.printStackTrace();
        }
        return hashByteString;
    }

    public static boolean check(String pass, String hash){
        String[] saltAndHash = hash.split("\\$");
        if (saltAndHash.length != 2) {
            throw new IllegalStateException(
                    "The stored password must have the form 'salt$hash'");
        }
        String hashOfInput = hash(pass, Base64.getDecoder().decode(saltAndHash[0]));
        boolean result = hashOfInput.equals(saltAndHash[1]);
        return result;
    }

    private static String hash(String password, byte[] salt) {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory keyFactory ;
        String hashString = new String();
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, DESIRED_KEY_LEN));
            hashString =  Base64.getEncoder().encodeToString(key.getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            // log todo
        }
        return hashString;
    }
}
