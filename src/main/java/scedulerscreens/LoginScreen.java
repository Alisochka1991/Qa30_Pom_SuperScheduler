package scedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginScreen extends BaseScreen{

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//*[@resource-id = 'com.example.svetlana.scheduler:id/log_email_input']")
    AndroidElement emailEditText;
    @FindBy(how = How.XPATH,using="//*[@resource-id = 'com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(how = How.XPATH,using ="//*[@resource-id = 'com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;


    public LoginScreen fillEmail(String email)
    {
        should(emailEditText,20 );
        type(emailEditText,email);
        return this;
    }

    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;
    }

    public WizardScreen clickLoginBtn()
    {
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }


    public WizardScreen loginComplex(Auth auth)
    {
        should(emailEditText,20);
        type(emailEditText,auth.getEmail());
        type(passwordEditText,auth.getPassword());
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);

    }



}

