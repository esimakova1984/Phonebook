package tests;

import models.User;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isSignOutPresent()) {
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void registrationSuccess() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm("esimakov" + index + "@gmail.com", "Tcbv123$");
        app.getHelperUser().submitRegistrtion();

        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }

    @Test
    public void registrationSuccessModel() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("esimakov" + index + "@gmail.com").withPassword("Tcbv123$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(user);
        app.getHelperUser().submitRegistrtion();
        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }

    @Test
    public void registrationWrongPasswordModel() {
        User user = new User().withEmail("esimakov@gmail.com").withPassword("123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm(user);
        app.getHelperUser().submitRegistrtion();
        app.getHelperUser().alertWindow();
        Assert.assertTrue(app.getHelperUser().isErrorTextDisplayed());

    }


    @Test
    public void registrationSuccessNew() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm("esimakov" + index + "@gmail.com", "Tcbv123$");
        app.getHelperUser().submitRegistrtion();

        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }


}
