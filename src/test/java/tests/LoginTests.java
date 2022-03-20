package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void loginSuccess(){

        //step 1: open login-registration form, метод описан а HelperBase
        app.getHelperUser().openLoginRegistrationForm();

        //step 2: fill email, метод описан а HelperBase
        app.getHelperUser().fillLoginRegistartionForm("esimakova1984@gmail.com","Tcbvfrjdf1$");

        app.getHelperUser().submitLogin();


    }
    @Test
    public void loginSuccessNew(){

        //step 1: open login-registration form, метод описан а HelperBase
        app.getHelperUser().openLoginRegistrationForm();

        //step 2: fill email, метод описан а HelperBase
        app.getHelperUser().fillLoginRegistartionForm("esimakova1984@gmail.com","Tcbvfrjdf1$");

        app.getHelperUser().submitLogin();


    }
    @AfterMethod
    public void postCondition(){
        Assert.assertTrue(app.getHelperUser().isSignOutPresent());
    }


}