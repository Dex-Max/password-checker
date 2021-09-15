import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides methods for a password checker program
 * @author Randall Kim
 */
public class PasswordCheckerUtility {
    /**
     * Checks if a given is password is valid.
     * @param passwordString Password to be checked for validity.
     * @return True if the password meets all criteria.
     * @throws LengthException if password is less than 6 characters long.
     * @throws NoDigitException if password does not contain a digit.
     * @throws NoUpperAlphaException if password does not contain an uppercase letter.
     * @throws NoLowerAlphaException if password does not contain a lowercase letter.
     * @throws InvalidSequenceException if password contains more than two of the same character in a row.
     */
    public static boolean isValidPassword(String passwordString) throws LengthException,
            NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException
    {
        if(!isValidLength(passwordString, 6)) {
            throw new LengthException();
        } else if (!hasUpperCase(passwordString)) {
            throw new NoUpperAlphaException();
        } else if (!hasLowerCase(passwordString)) {
            throw new NoLowerAlphaException();
        } else if (!hasNumber(passwordString)) {
            throw new NoDigitException();
        } else if (!hasSpecialChar(passwordString)) {
            throw new NoSpecialCharacterException();
        } else if (isInvalidSequence(passwordString)) {
            throw new InvalidSequenceException();
        }

        return true;
    }

    /**
     * Checks if a valid password is weak.
     * @param passwordString Password to be checked for weakness.
     * @return True if the password is considered weak.
     */
    public static boolean isWeakPassword(String passwordString) {
        int passwordLength = passwordString.length();

        if(passwordLength >= 6 && passwordLength <= 9){
            return true;
        }

        return false;
    }

    /**
     * Checks a list of passwords and returns only the invalid ones.
     * @param passwordList ArrayList of passwords to be checked.
     * @return ArrayList of invalid passwords and the corresponding error message.
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwordList) {
        ArrayList<String> invalids = new ArrayList<String>();

        for(String password : passwordList){
            try {
                isValidPassword(password);
            } catch (Exception e){
                invalids.add(password + " - " + e.getMessage());
            }
        }

        return invalids;
    }

    /**
     * Checks password for length.
     * @param password Password to be checked for valid length.
     * @param minimumLength Minimum length that a password must have.
     * @return True if the password length is at least the minimum length.
     */
    private static boolean isValidLength(String password, int minimumLength) {
        return !(password.length() < minimumLength);
    }

    /**
     * Checks password for uppercase letters.
     * @param password Password to be checked for uppercase letters.
     * @return True if the password contains an uppercase letter.
     */
    private static boolean hasUpperCase(String password) {
        return !(password.equals(password.toLowerCase()));
    }

    /**
     * Checks password for lowercase letters.
     * @param password Password to be checked for lowercase letters.
     * @return True if the password contains a lowercase letter.
     */
    private static boolean hasLowerCase(String password) {
        return !(password.equals(password.toUpperCase()));
    }

    /**
     * Checks password for a number.
     * @param password Password to be checked for a digit.
     * @return True if the password contains a digit.
     */
    private static boolean hasNumber(String password) {
        boolean hasNumber = false;

        for(int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                hasNumber = true;
                break;
            }
        }

        return hasNumber;
    }

    /**
     * Checks password for a special character.
     * @param password Password to be checked for a special character.
     * @return True if the password contains a special character.
     */
    private static boolean hasSpecialChar(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);

        return !matcher.matches();
    }

    /**
     * Checks password for a sequence of 3 or more of the same character in a row.
     * @param password Password to be checked for valid sequence.
     * @return True if the password contains at most 2 of the same character in a row.
     */
    private static boolean isInvalidSequence(String password) {
        int consecutiveCount = 1;
        char currentChar = password.charAt(0);

        for(int i = 1; i < password.length(); i++){
            if(password.charAt(i) != currentChar){
                consecutiveCount = 1;
                currentChar = password.charAt(i);
            } else {
                consecutiveCount ++;
            }

            if(consecutiveCount > 2) {
                return true;
            }
        }

        return false;
    }
}
