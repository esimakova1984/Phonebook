package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLoginRegistartionSuccess()){
            User user = new User().withEmail("esimakova1984@gmail.com").withPassword("Tcbvfrjdf1$");
            app.getHelperUser().login(user);
        }

    }

    @Test
    public void addNewContactSuccess(){
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Katya")
                .lastName("Sim"+index)
                .phone("12345678"+index)
                .email("a"+index+"@gmail.com")
                .address("Ashkelon")
                .description("friends")
                .build();

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().saveForm();
        Assert.assertTrue(app.getContact().isNewContactAddedSuccess());
    }
}
