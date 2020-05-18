package pages.pageLib;

import com.codeborne.selenide.SelenideElement;

public class ChangePasswordPage extends BasePage {
  //Constructor
  public ChangePasswordPage() {
    addElement("title", "//h1[contains(., 'Change Password')]");
    addElement("currentPasswordField", "input#currentPassword");
  }
  @Override
  public SelenideElement getMainElement() {
    return getElement("title");
  }
}
