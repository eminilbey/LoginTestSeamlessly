package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}//Constructor

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver;// A global instance/object outside the getDriver method, and its value is null
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();//new null object

    /*
    Create a re-usable utility method which will return same driver instance when we call it. Singleton pattern
     */
    public static WebDriver getDriver(){//A getter method

        if (driverPool.get() == null){

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");
            //The ConfigurationReader method takes the value of "browser" from 'Configuration.Properties' file
            // Assigns it to the browserType which is the argument of the below switch statement.


            /*
                Depending on the browserType that will return from configuration.properties file
                Switch statement will determine the case, and open the matching browser
            */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());//sets elements of the list as object of ChromeDriver
                    driverPool.get().manage().window().maximize();//driver = driverPool.get()
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }

        return driverPool.get();
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void quitDriver(){
        if (driverPool.get() != null){//For the test being run the driver is currently not null. So condition is ok and next line executes
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            //driverPool.set(null);//Just after quiting the session, this code makes the driver null again and
            //Singleton design pattern method (  Driver.getDriver() ) works again since that method investigates the driver at first if it is null or not
            driverPool.remove();//This also works and consequently, it is null as well
        }
    }
}
