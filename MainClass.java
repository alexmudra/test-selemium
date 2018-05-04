import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //static WebDriverWait wait;

    //WebDriverWait wait = (new WebDriverWait(driver, 5);// напишемо примусове/ЯВНЕ очікування

    //використовуємо вбудований клас WebDriverWait, створимо екземпляр класу з назвою wait, передамо туди наш драйвер і вкажимо очікування
    // вебелементу 5 секунд
    //static WebDriverWait wait = new WebDriverWait(driver, 5);//ми цей метод потім будемо використовувати всередині методів

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        //driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));

//РОБОТА З СКЛАДНИМИ ОПЕРАЦІЯМИ та методами маніпуляцій на сайті
// . МЕТОД ACTIONS (працюємо з драйвером для браузеру Хром, бо на ФФ можуть бути проблеми)

        driver.get("https://www.ebay.com/");//відкриваємо ресурс EBAY для тестування

        WebElement link = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[text()=\"Electronics\"]"));//створилои перемінну link
        WebElement element = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[text()=\"Electronics\"]"));//створили перемінну element


        //Нам потрібно відтворити наведення мишкою на елемент (складна поведінка). Скористаємося класом Actions

        Actions actions = new Actions(driver); //створили перемінну типу Actions, створили об'єкт класу,
        // передали туди як аргумент наш клас driver

        //метод moveToElement дозволяє навести курсор на елемент сайту
        //метод build будує дію (завжди пишеться після ланцюжка всіх методів перед .perform
        //метод .perform виконує дію (це кінцевий елемент для запуску всього ланцюжка методів)
        actions.moveToElement(link).build().perform();

        //Робота з методом .dragAndDrop
        //в цей метод потрібно передати атрибути Source(що будемо переміщувати?) і Target (куди будемо переміщувати?)
        actions.dragAndDrop(element, link).build().perform();//тобто гіпотетично ми перемістили елемент element в link

        //Робота з методом .clockAndhold (тобто клікнути на елемент і не відпускати клавішу миші)
        //метод .moveToElement - тягнемо мишкою елемент
        //метод .release - відпускаємо клавішу миші
        actions.clickAndHold(element).moveToElement(link).release().build().perform();
        
        //Робота з методом .doubleClick - подвійний клік по елементу
        actions.doubleClick(link);

        //Робота з методом .contextClick - дозволяє імітувати клік правою кнопкою миші на елементі
        actions.contextClick(element);

        //ЛАНЦЮЖКИ МЕТОДІВ МОЖУТЬ БУТИ ДОВГИМИ І ЗАВЖДИ ВКІНЦІ СТАВИТИ МЕТОД .BUILD && .PERFORM


        //driver.quit();// обязательно указывать вконце теста даны й метод для завершения работы драйвера
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
 */
