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
        Contact contact = Contact.builder()
                .name("Katya")
                .lastName("Sim")
                .phone("12345678")
                .email("a@gmail.com")
                .address("Ashkelon")
                .description("friends")
                .build();

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
    }
}
