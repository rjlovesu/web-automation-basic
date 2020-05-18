package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;

public class ChangePasswordPage extends BasePage {
  //Constructor
  public ChangePasswordPage() {
    addElement("title", "//h1[contains(., 'Change Password')]");
    addElement("currentPasswordField", "input#currentPassword");
    addElement("newPasswordField", "input#newPassword");
    addElement("repeatNewPasswordField", "input#newPasswordRepeat");
    addElement("change", "button#changeButton");
    addElement("accountButton", "button[aria-label*='Show/hide account menu']");
    addElement("logout", "button[aria-label='Logout']");
  }
  @Override
  public SelenideElement getMainElement() {
    return getElement("title");
  }

  @Override
  public void navigate(String element){
    switch(element){
      case "logout":
        PageManager.setCurrentPage(PageManager.getHomePage());
        break;
    }
  }
}
