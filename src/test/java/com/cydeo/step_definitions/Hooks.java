package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
- In the class we will be able to  pass    pre- & post-    conditions to
each scenario and each step
- The below methods are run by the sake of the "glue" path provided in the runner.
  So, the glue checks all the methods in this Hooks class, which is in the glue path (step_definitions),
  and passes it to the runner.
  It runs along with the scenarios.
 */
public class Hooks {
    //import from io.cucumber.java to be able to use it with features files, scenarios etc
    //but not import it from junit because in this case it would act like TestNG

    //@Before(order = 1)
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");
    }

    //@Before(value = "@login", order = 2)//This will only apply to scenarios with @login tag
    public void setupScenarioForLogins() {
        System.out.println("====This will only apply to scenarios with @login tag");
    }

    //@Before(value = "@db", order = 0)//runs before all (-1)
    public void setupForDataBaseScenarios() {
        System.out.println("====This will only apply to scenarios with @db tag");
    }

    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            //All the pixels of the screen is in an array of byte
            scenario.attach(screenShot, "image/png", scenario.getName());
        }


        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");

        //BrowserUtils.sleep(5);
        Driver.quitDriver();
    }

    //@BeforeStep
    public void setupStep() {
        System.out.println("--------->applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep() {
        System.out.println("---------->applying tearDown using @afterStep");
    }
    /*
====Setting up browser using cucumber @Before
--------->applying setup using @BeforeStep
User is already on the library login page
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters librarian username
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters librarian password
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User should see the dashboard
---------->applying tearDown using @afterStep
====Closing browser using cucumber @After
====Scenario ended/ Take screenshot if failed!


====Setting up browser using cucumber @Before
--------->applying setup using @BeforeStep
User is already on the library login page
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters student username
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters student password
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User should see the dashboard
---------->applying tearDown using @afterStep
====Closing browser using cucumber @After
====Scenario ended/ Take screenshot if failed!


====Setting up browser using cucumber @Before
--------->applying setup using @BeforeStep
User is already on the library login page
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters admin username
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User enters admin password
---------->applying tearDown using @afterStep
--------->applying setup using @BeforeStep
User should see the dashboard
---------->applying tearDown using @afterStep
====Closing browser using cucumber @After
====Scenario ended/ Take screenshot if failed!
     */
}
