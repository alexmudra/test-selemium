import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//СТВОРИМО КЛАС ДЛЯ СТОРІНКИ LOG IN PAGE В ГІТХАБ
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //ОПИШЕМО ЛОКАТОРИ ТА МЕТОДИ РОБОТИ З СТОРІНКОЮ LOGIN

    private By loginField = By.xpath("//input[@id=\"login_field\"]");//поле логін
    private By passwordField = By.xpath("//input[@id=\"password\"]");//поле пароль
    private By signInButton = By.xpath("//input[@type=\"submit\"]"); //батон сабміт
    private By heading = By.xpath("//div[contains(@class,\"auth-form-header p-0\")]/h1");//локатор, щоб пізніше написати тест для перевірки тексту в елементі
    private By error = By.xpath(".//*[@id=\"js-flash-container\"]//div[@class='container']");// локатор елементу з текстом який буде показуватись при неправ.вводі
    private By createAccLing = By.xpath("//a[text()='Create an account']"); //локатор для лінку Create an account


    //метод для взаємодії з філдом юрезнейм і повертає наявну сторінку
    public LoginPage typeUserName(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }
    //метод для взаємодії з філдом password і повертає наявну сторінку
    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    //Напишемо метод для перевірки вводу НЕправильного паролю

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUserName(username); //вводимо юзернейм за допомогою раніше написаного методу
        this.typePassword(password); //аналогічно
        driver.findElement(signInButton).click();//нажмем на кнопку для логіна
        return new LoginPage(driver);//метод поверне об'єкт даної (вже з новим станом) сторінки і передамо туди драйвер
    }

    //напишемо метод який буде перевіряти текст заголову і буде робити скріни
    public String getHeadingText(){
        return driver.findElement(heading).getText(); //метод поверне текст з елементу який ми перевіряємо
    }

    //метод який буде отримувати текс помилки при неправильному вводі в поля
    public String getErrorText(){
        return driver.findElement(error).getText(); //метод поверне текст з елементу який ми перевіряємо

    }
    //метод Create Account який буде повертати клас SignUpPage (бо при клікові на неї ми перейдемо на сторінку SingUp)
    public SignUpPage createAccount (){
        driver.findElement(createAccLing).click();//знайшли лінк і клікнули на нього
        return new SignUpPage(driver);


    }





}
