import com.bridgelabz.junit.UserRegistration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegistrationTest {

    private UserRegistration userRegistration;
    private String arg;
    private boolean expectedValidation;


    public UserRegistrationTest(String arg, boolean expectedValidation) {
        this.arg = arg;
        this.expectedValidation = expectedValidation;
    }

    @Before
    public void  initialize(){
        userRegistration = new UserRegistration();
    }

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("Ajju");
        System.out.println(result);
        Assert.assertTrue(result);
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldMinimumThreeChar_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldMinimumThreeChar_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("Up"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldNotNumeric_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("Up123124"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldSpace_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("Upe ndra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldNotAnySpecialSymbol_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("Upe@ndra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldNotSpace_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldFirstCharCapital_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldFirstCharCapital_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("upendra"));
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        boolean result = userRegistration.validateLastName("Lastname");
        Assert.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenProper_ShouldMinimumThreeChar_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateLastName("Upendra"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldMinimumThreeChar_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateLastName("Up"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldNotNumeric_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateLastName("Up123124"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldSpace_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateLastName("Upe ndra"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldNotAnySpecialSymbol_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateLastName("Upe@ndra"));
    }

    @Test
    public void givenLastName_WhenProper_ShouldNotSpace_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateLastName("Upendra"));
    }

    @Test
    public void givenLastName_WhenProper_ShouldFirstCharCapital_ReturnTrue() {
        Assert.assertTrue(userRegistration.validateLastName("Upendra"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldFirstCharCapital_ReturnFalse() {
        Assert.assertFalse(userRegistration.validateLastName("upendra"));
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Parameterized.Parameters
    public static Collection<Object[]> data()
    {
        Object[][] data = new Object[][] {
                { "abc@yahoo.com" , true },
                {"abc.100@yahoo.com",true},
                {"abc.100@abc.com.au",true},
                {"abc+100@gmail.com",true},
                {"abc.abc@gmail.co.in",true},
                {"abc100@gmail.com",true},
                {"abc@1.com",true},
                {"abc+100",false},
                {"abc",false},
                {"abc@.com.my",false},
                {"abc123@gmail.a",false},
                {".abc@abc.com",false},
                {"abc()*@gmail.com",false},
                {"abc@%.com",false},
                {"abc..2002@gmail.com",false},
                {"abc.@g.com",false},
                {"abc@abc@gmail.com",false},
                {"abc@a.com.21a",false},
                {"abc@g.cim.au.au",false}};

        return Arrays.asList(data);
    }

    @Test
    public void Test()
    {
        Boolean res = userRegistration.validateEmail(this.arg);
        Assert.assertEquals(this.expectedValidation,res);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void givenPassword_Whenproper_ShouldMinimumEightChar_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePassWord("Aj@1hfdfhAdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldMinimumEightChar_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePassWord("Aj@1"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldAtLeastOneCapitalChar_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePassWord("Aj@1hfdfhAdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldAtLeastOneCapitalChar_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePassWord("j@1hfdfhdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldAtLeastOneNumeric_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePassWord("j@1hfaAdfhdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldAtLeastOneNumeric_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePassWord("j@hfaAdfhdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldExactOneSpecialSymbol_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePassWord("j@hfa1Adfhdsk"));
    }

    @Test
    public void givenPassword_Whenproper_ShouldExactOneSpecialSymbol_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePassWord("jhfa1Adfhdsk"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void givenPhoneNumber_Whenproper_ShouldTenDigitNumberWithTwoDigitCountryCode_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePhoneNumber("919021547869"));
    }

    @Test
    public void givenPhoneNumber_Whenproper_ShouldOneSpaceAfterCountryCode_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePhoneNumber("91 9021547869"));
    }

    @Test
    public void givenPhoneNumber_Whenproper_ShouldCountryCodeTwoDigitNumber_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePhoneNumber("91 9021547869"));
    }

    @Test
    public void givenPhoneNumber_WhenImproper_ShouldCountryCodeTwoDigitNumber_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePhoneNumber("919 9021547869"));
    }

    @Test
    public void givenPhoneNumber_Whenproper_ShouldOnlyNumericValue_ReturnTrue() {
        Assert.assertTrue(userRegistration.validatePhoneNumber("919021547869"));
    }

    @Test
    public void givenPhoneNumber_WhenImproper_ShouldOnlyNumericValue_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePhoneNumber("9190215478df"));
    }

    @Test
    public void givenPhoneNumber_WhenImproper_ShouldSpecialSymbol_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePhoneNumber("91902154@78"));
    }

    @Test
    public void givenPhoneNumber_WhenImproper_ShouldNoSpaceInPhoneNumber_ReturnFalse() {
        Assert.assertFalse(userRegistration.validatePhoneNumber("91902154 78"));
    }

}
