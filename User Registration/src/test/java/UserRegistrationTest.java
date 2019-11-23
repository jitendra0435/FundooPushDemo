import com.bridgelabz.junit.UserRegistration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class UserRegistrationTest {

    UserRegistration userRegistration;

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
    public void givenFirstName_WhenImproper_ShouldMinimumThreeChar_ReturnFail() {
        Assert.assertFalse(userRegistration.validateFirstName("Up"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldNotNumeric_ReturnFail() {
        Assert.assertFalse(userRegistration.validateFirstName("Up123124"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldSpace_ReturnFail() {
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
    public void givenLastName_WhenImproper_ShouldMinimumThreeChar_ReturnFail() {
        Assert.assertFalse(userRegistration.validateLastName("Up"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldNotNumeric_ReturnFail() {
        Assert.assertFalse(userRegistration.validateLastName("Up123124"));
    }

    @Test
    public void givenLastName_WhenImproper_ShouldSpace_ReturnFail() {
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
}
