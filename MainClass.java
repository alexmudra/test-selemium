import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    static WebDriverWait wait;

    //WebDriverWait wait = (new WebDriverWait(driver, 5);// напишемо примусове/ЯВНЕ очікування

    //використовуємо вбудований клас WebDriverWait, створимо екземпляр класу з назвою wait, передамо туди наш драйвер і вкажимо очікування
    // вебелементу 5 секунд
    //static WebDriverWait wait = new WebDriverWait(driver, 5);//ми цей метод потім будемо використовувати всередині методів



    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// ук
        // азали путь к драйверу
        driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)
        /*методы для управления размером окна браузера*/
        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));


        //РОБОТА З ОЖИДАНИЯМИ (Implicity and Explicity whait) явним та неявними очікуваннями

        // Явне очікування explicityWait використовується для того щоб задати очікування для конеретної умови (очікування тільки один раз для умови)
        //Неявне очікування implicityWait для того щоб задати очікування для конкрентного елементу


        driver.get("https://pz.25h8.auction/tenders/index");//відкриваємо ресурс для тестування

        wait = new WebDriverWait(driver, 5);//об'єкт класу wait

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("///html/body/div[1]/div[3]/h1"]"))));
      //presenceOfAllElementsLocatedBy(By.xpath це умове при якій якщо елемент зявитьсня на сторінці то запуститься код далі


        selectOption("ДК 015:97", );
        selectOption();

    }
        public static void selectOption (String listName, String option){

            String listXpath = String.format("//*[@id=\"additional-classifications-select\"]", listName);
            String optionXpath = String.format("//*//*[@id=\"additional-classifications-select\"]/option[5]", option);

            driver.findElement(By.xpath(listXpath)).click();
            wait.until(ExpectedConditions.visibilityOf(By.xpath(listXpath)));// умов може буде дуже багато

            driver.findElement(By.xpath(optionXpath)).click();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(optionXpath)));// умов може буде дуже багато






            driver.quit();// обязательно указывать вконце теста даны й метод для завершения работы драйвера
        }
}

/* ДАНІ З УРОКУ ДЕ ВИСВІТЛЮЄТЬСЯ ТЕМА IMPLICITY AND EXPLICITY WAIT

 * import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath(".//*[@id='login_field']");
    private By passwordField = By.xpath(".//*[@id='password']");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By error = By.xpath(".//*[@id='js-flash-container']//div[@class='container']");
    private By createAccLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }




}

 *
 *
 *
 */
