package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }
    @Test
    public void registrationSuccess(){

        int index = (int) System.currentTimeMillis()/1000%3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm("esimakov" + index + "@gmail.com", "Tcbv123$");
        app.getHelperUser().submitRegistrtion();

        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }
    @Test
    public void registrationSuccessNew(){

        int index = (int) System.currentTimeMillis()/1000%3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistartionForm("esimakov" + index + "@gmail.com", "Tcbv123$");
        app.getHelperUser().submitRegistrtion();

        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }

    @AfterMethod
    public void postCondition(){
        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }
}
