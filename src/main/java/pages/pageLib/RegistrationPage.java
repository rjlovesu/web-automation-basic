package pages.pageLib;

import com.codeborne.selenide.SelenideElement;

public class RegistrationPage extends BasePage {
  // Constructor
  public RegistrationPage(){
    addElement("emailField", "input[aria-label='Email address field']");
    addElement("passwordField", "input[aria-label='Field for the password']");
    addElement("passwordRepeatField", "input[aria-label='Field to confirm the password']");
    addElement("securityQuestion", "mat-select[aria-label='Selection list for the security question']");
    addElement("securityAnswer", "input[aria-label='Field for the answer to the security question']");
    addElement("registrationButton", "button[aria-label='Button to complete the registration']");
    
  
  }
  // Methods
  @Override
  public SelenideElement getMainElement() {
    return getElement("emailField");
  }
}
