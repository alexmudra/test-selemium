

//СТВОРИМО КЛАС ДЛЯ СТОРІНКИ SING UP PAGE

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//ОПИШЕМ КЛАС SING UP ДЛЯ ГІТХАБУ

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //Опишем локатори до деяких полів SignUp form

    private By heading = By.xpath("//div[@class=\"setup-wrapper\"]//h1");//локатор для надпису в хедері
    private By userEmail = By.xpath("//input[@class=\"form-control\"]");//локатор для поля емайл
    private By userPassword = By.xpath("//input[@id=\"user_password\"]");//локатор для поля з паролем
    private By userName = By.xpath("//*[@id=\"user_login\"]");//локатор для юзернейм
    private By mainNameError = By.xpath("//*[@id=\"signup-form\"]/div");//локатор над формою
    private By userNameError = By.xpath("//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]");//локатор помилки під полем username
    private By emailError = By.xpath("//*//*[@id=\"signup-form\"]/auto-check[2]/dl/dd[2]");//локатор помилки над полем username
    private By passwordError = By.xpath("//*[@id=\"signup-form\"]/auto-check[3]/dl/dd[2]");
    private By singUpButton = By.xpath("//button[@class=\"btn btn-primary\"]\n");//локатор для кнопки

    //Опишем методи які будуть заповнювати поля

    public SignUpPage typeUserName(String username) {//метод буде приймати стрінгове значення юзера яке ми повинні ввести
        driver.findElement(userName).sendKeys(username);//методом .sendKeys введемо поле з юзером
        return this;//повернемо дану сторінку
    }

    public SignUpPage typePassword(String password) {//метод буде приймати стрінгове значення пароля яке ми повинні ввести
        driver.findElement(userPassword).sendKeys(password);//методом .sendKeys введемо поле з паролем
        return this;//повернемо дану сторінку

    }

    public SignUpPage typeEmail(String email) {//метод буде приймати стрінгове значення емайлу яке ми повинні ввести
        driver.findElement(userEmail).sendKeys(email);//методом .sendKeys введемо поле з емайлом
        return this;//повернемо дану сторінку

    }

    //створимо метод для заповнення форми неправильними даними

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(singUpButton).click();//клікнемо на кнопку signup
        return new SignUpPage(driver);

    }

    //Напишемо методи які отримують текст помилок та заголовків

    public String getHeadingText(){
        return driver.findElement(heading).getText();//метод отримає текс заголовку із Heading
    }
    public String getMainErrorText(){
        return driver.findElement(mainNameError).getText();//метод отримає текс головної помилки із незаповненоно поля
    }
    public String getUserNameErrorText(){
        return driver.findElement(userNameError).getText();//метод отримає текс помилки із незаповненоно поля name
    }
    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();//метод отримає текс помилки із незаповненоно поля email
    }
    public String getPasswordErrorText(){
        return driver.findElement(passwordError).getText();//метод отримає текс помилки із незаповненоно поля password
    }
}
