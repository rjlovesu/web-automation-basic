package pages.pageLib;

import com.codeborne.selenide.SelenideElement;

public class ChangePasswordPage extends BasePage {
  //Constructor
  public ChangePasswordPage() {
    addElement("title", "//h1[contains(., 'Change Password')]");
    addElement("currentPasswordField", "input#currentPassword");
    addElement("newPasswordField", "input#newPassword");
    addElement("repeatNewPasswordField", "input#newPasswordRepeat");
    addElement("change", "button#changeButton");
  
  }
  @Override
  public SelenideElement getMainElement() {
    return getElement("title");
  }
}
