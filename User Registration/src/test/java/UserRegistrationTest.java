import com.bridgelabz.junit.UserRegistration;
import org.junit.Assert;
import org.junit.Test;



public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateFirstName("Ajju");
        System.out.println(result);
        Assert.assertTrue(result);
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldMinimumThreeCharTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldMinimumThreeCharFail() {
        Assert.assertFalse(userRegistration.validateFirstName("Up"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldNotNumericFail() {
        Assert.assertFalse(userRegistration.validateFirstName("Up123124"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldSpaceFail() {
        Assert.assertFalse(userRegistration.validateFirstName("Upe ndra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldNotAnySpecialSymbolFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("Upe@ndra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldNotSpaceTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenProper_ShouldFirstCharCapitalTrue() {
        Assert.assertTrue(userRegistration.validateFirstName("Upendra"));
    }

    @Test
    public void givenFirstName_WhenImproper_ShouldFirstCharCapitalFalse() {
        Assert.assertFalse(userRegistration.validateFirstName("upendra"));
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
      //  UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateLastName("Lastame");
        Assert.assertTrue(result);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
}
