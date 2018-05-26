import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage { //створимо клас який буде описувати сторінку(як приклад тесту) сайту GITHUB
    private WebDriver driver;

    //Додамо конструктор за допомогою ALT+INSERT до нашого класу
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //опишемо методи і об'єкти які будуть використовуватися на сторінці

    //опишемо поля та кнопки
    private By signInButton = By.xpath("//a[text()='Sign in']"); //описали локатор для кнопки Sign in
    private By signUpButton = By.xpath("//a[text()='Sign up']"); //описали локатор для кнопки Sign up
    private By userNameField = By.xpath(".//*[@id=\"user[login]\"]"); //описали локатор для текстового поля User Name
    private By emailField = By.xpath(".//*[@id=\"user[email]\"]"); //описали локатор для текстового поля Email
    private By passwordField = By.xpath(".//*[@id=\"user[password]\"]"); //описали локатор для текстового поля Password
    private By signUpFormButton = By.xpath("//button[text()=\"Sign up for GitHub\"]"); //описали локатор для текстового кнопки Sign up for GitHub


    //опишемо методи взаємодії з кнопками (оскільки при кліку ми будемо переходити на інші сторінки то опишемо 2 дод. класи LoginPage та SignUpPage

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();//метод для кліку на кнопку Sign In
        //при кліку на кнопку Sign In ми будемо попадати на сторінку Log In page
        return new LoginPage(driver) // тому нам треба повертати (раніше створений клас-об'єкт)LoginPage і передати туди driver
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpButton).click();//метод для кліку на кнопку Sign Up
        //при кліку на кнопку Sign Up ми будемо попадати на сторінку LogUp page
        return new SignUpPage(driver); // тому нам треба повертати (раніше створений клас-об'єкт)SingUpPage і передати туди driver
    }

    public SignUpPage singUpFormButton() {
        driver.findElement(signUpFormButton).click();//метод для кліку на кнопку SignUpformButton
        //при кліку на кнопку Sign Up ми будемо попадати на сторінку Log In page
        return new SignUpPage(driver); // тому нам треба повертати (раніше створений клас-об'єкт)SingUpPage і передати туди driver
    }

    //опишемо методи для взаємодії з полями (оскільки ми не будемо переходити на інші сторінки сайту при заповненні полів, то дод. класи НЕ пишемо)

    public MainPage typeUserName(String username){//метод буде приймати стрінгове значення юзера яке ми повинні ввести
        driver.findElement(userNameField).sendKeys(username);//методом .sendKeys введемо поле з юзером
        return this;//повернемо дану сторінку
    }
    public MainPage typePassword(String password) {//метод буде приймати стрінгове значення пароля яке ми повинні ввести
        driver.findElement(passwordField).sendKeys(password);//методом .sendKeys введемо поле з паролем
        return this;//повернемо дану сторінку

    }
    public MainPage typeEmail(String email) {//метод буде приймати стрінгове значення емайлу яке ми повинні ввести
        driver.findElement(emailField).sendKeys(email);//методом .sendKeys введемо поле з емайлом
        return this;//повернемо дану сторінку

    }
    //напишемо метод для реєстрації
    public SignUpPage register (String username, String email, String password) {//метод буде приймати значення 3 полів

        //визвемо методи які описали раніше
        this.typeUserName(username);//використаємо готовий метод .typeUserName з нашого класу і передамо значення username з методу registr
        this.typeEmail(email); //по аналогії з вище
        this.typePassword(password);//по аналогії з вище
        this.clickSignUpFormButton();//клікнемо на кнопку Sign Up
        return new SignUpPage(driver);//і повернемо нову сторінкку(у нас новий клас SignUpPage) і передамо туди драйвер


    }


}

