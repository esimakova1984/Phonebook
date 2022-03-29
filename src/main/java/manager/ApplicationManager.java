package manager;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    ContactHelper contact;

    public void init(){
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/olegnarushevich/QA_32_automation/lessons/Phonebook/chromedriver");
        wd.manage().window();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//ожидание Силениеум по посторению странице в браузере после DOM
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperUser = new HelperUser(wd);
        contact = new ContactHelper(wd);
    }


    public void stop(){
        //wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public ContactHelper getContact() {
        return contact;
    }
}
