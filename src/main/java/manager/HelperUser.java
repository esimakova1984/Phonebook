package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }


    public void fillLoginRegistartionForm(String email, String password) {
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);

    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitRegistrtion() {
        click(By.xpath("//button[2]"));
    }

    public void signOut() {
        click(By.xpath("//*[text()='Sign Out']"));
    }
}
