package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;

public class AddAddressPage extends BasePage {
  // Constructor
  public AddAddressPage(){
    addElement("country","input[placeholder='Please provide a country.']");
    addElement("name","input[placeholder='Please provide a name.']");
    addElement("mobileNumber","input[placeholder='Please provide a mobile number.']");
    addElement("zipCode","input[placeholder='Please provide a ZIP code.']");
    addElement("address","textarea#address");
    addElement("city","input[placeholder='Please provide a city.']");
    addElement("state","input[placeholder='Please provide a state.']");
    addElement("submit","button#submitButton");
  }
  // Methods
  @Override
  public SelenideElement getMainElement() {
    return getElement("submit");
  }
  @Override
  public void navigate(String element) {
    switch (element) {
      case "submit" : PageManager.setCurrentPage(PageManager.getSelectAddressPage()); break;
      default: super.navigate(element);
    }
  }
}
