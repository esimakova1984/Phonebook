package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }



    public void openContactForm(){
        click(By.xpath("//*[text()='ADD']"));
    }

    public void fillContactForm(Contact contact){
        type(By.xpath("//*[@placeholder='Name']"), contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"), contact.getDescription());
    }


    public void saveForm() {
        click(By.cssSelector("div[class='add_form__2rsm2'] button"));
    }

    public boolean isNewContactAddedSuccess() {
        return isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke"));
    }
}
