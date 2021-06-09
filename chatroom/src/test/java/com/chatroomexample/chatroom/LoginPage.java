package com.chatroomexample.chatroom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id="submit-button")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void logIn(String username, String pass){
        inputUsername.sendKeys(username);
        password.sendKeys(pass);
        submitButton.click();
    }

}
