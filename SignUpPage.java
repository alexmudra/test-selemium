

//СТВОРИМО КЛАС ДЛЯ СТОРІНКИ SING UP PAGE

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//ОПИШЕМ КЛАС SING UP ДЛЯ ГІТХАБУ

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class=\"setup-wrapper\"]//h1");//локатор для надпису в хедері
    private By userEmail = By.xpath("//input[@class=\"form-control\"]");//локатор для поля емайл
    private By singUpButton = By.xpath("//button[@class=\"btn btn-primary\"]\n");//локатор для кнопки







}
