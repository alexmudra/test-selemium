import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Allert {

    public static WebDriver driver;
    public WebElement allert;

    public Allert(WebDriver driver, WebElement allert){
        this.driver = driver;
    }

    public static void main(String[]args) {
        driver.get("//a[text()=\"jdk-8u171-docs-all.zip\"]");
    }



}
