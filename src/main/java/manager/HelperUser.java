package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }


    public void fillLoginRegistartionForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }

    public void fillLoginRegistartionForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());

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


    public void alertWindow() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isErrorTextDisplayed() {
        Boolean errorText = new WebDriverWait(wd, 5)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.xpath("//*[text()='Registration failed with code 400']")), "Registration failed with code 400"));
        return errorText;
    }
}
