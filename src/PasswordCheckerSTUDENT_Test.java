import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Randall Kim
 */
public class PasswordCheckerSTUDENT_Test {
    ArrayList<String> passwordList;

    @Before
    public void setUp() throws Exception {
        String[] passwords = {"abc", "12ABab%", "aB1%", "CDDDDEEEf1%", "abcd123%", "abcdEFG12!", "ABCD123#", "abCD12345", "abCD!@#$"};
        passwordList = new ArrayList<>();
        passwordList.addAll(Arrays.asList(passwords));
    }

    @After
    public void tearDown() throws Exception {
        passwordList = null;
    }

    /**
     * Test if the password is less than 8 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testIsValidPasswordTooShort()
    {
        String validPassword = "AbCd12345%";
        String shortPassword = "Ab1%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
            PasswordCheckerUtility.isValidPassword(shortPassword);
        } catch (LengthException e){
            assertTrue("Successfully threw a lengthExcepetion",true);
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha()
    {
        String validPassword = "AbCd12345%";
        String noUpperPassword = "abcd12345%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
            PasswordCheckerUtility.isValidPassword(noUpperPassword);
        } catch (NoUpperAlphaException e){
            assertTrue(true);
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha()
    {
        String validPassword = "AbCd12345%";
        String noLowerPassword = "ABCD12345%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
            PasswordCheckerUtility.isValidPassword(noLowerPassword);
        } catch (NoLowerAlphaException e){
            assertTrue(true);
        }
    }
    /**
     * Test if the password is valid but is between 6-9 characters
     */
    @Test
    public void testIsWeakPassword()
    {
        String weakPassword = "Ab1234%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(weakPassword));
            assertTrue(PasswordCheckerUtility.isWeakPassword(weakPassword));
        } catch (Exception e){
            fail("Threw an exception");
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence()
    {
        String validPassword = "AbCd12345%";
        String invalidSequencePassword = "Aaaa12345%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
            PasswordCheckerUtility.isValidPassword(invalidSequencePassword);
        } catch (InvalidSequenceException e){
            assertTrue(true);
        }
    }

    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit()
    {
        String validPassword = "AbCd12345%";
        String invalidSequencePassword = "ABCDefghj%";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
            PasswordCheckerUtility.isValidPassword(invalidSequencePassword);
        } catch (NoDigitException e){
            assertTrue(true);
        }
    }

    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful()
    {
        String validPassword1 = "AbCd12345%";
        String validPassword2 = "12345ABCdef!@#";

        try {
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword1));
            assertTrue(PasswordCheckerUtility.isValidPassword(validPassword2));
        } catch (Exception e){
            fail("Threw an exception");
        }
    }

    /**
     * Test the invalidPasswords method
     * Check the results of the ArrayList of Strings returned by the validPasswords method
     */
    @Test
    public void testInvalidPasswords() {
        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwordList);

        String invalid1 = invalidPasswords.get(0);
        assertTrue(invalid1.contains("abc"));
        assertTrue(invalid1.contains("long"));

        String invalid2 = invalidPasswords.get(1);
        assertTrue(invalid2.contains("aB1%"));
        assertTrue(invalid2.contains("long"));

        String invalid3 = invalidPasswords.get(2);
        assertTrue(invalid3.contains("CDDDDEEEf1%"));
        assertTrue(invalid3.contains("sequence"));

        String invalid4 = invalidPasswords.get(3);
        assertTrue(invalid4.contains("abcd123%"));
        assertTrue(invalid4.contains("uppercase"));

        String invalid5 = invalidPasswords.get(4);
        assertTrue(invalid5.contains("ABCD123#"));
        assertTrue(invalid5.contains("lowercase"));

        String invalid6 = invalidPasswords.get(5);
        assertTrue(invalid6.contains("abCD12345"));
        assertTrue(invalid6.contains("special"));

        String invalid7 = invalidPasswords.get(6);
        assertTrue(invalid7.contains("abCD!@#$"));
        assertTrue(invalid7.contains("digit"));
    }
}