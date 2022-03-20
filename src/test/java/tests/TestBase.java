package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();//статические переменные и методы отрабатываются первыми

    @BeforeSuite//этот метод отработает раньше чем метод с аннотацией ТЕСТ
    public void setUp() {
        app.init();
    }


    @AfterSuite
    public void tearDown(){
        app.stop();
    }


}
