package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;

public class SelectAddressPage extends BasePage {
  // Constructor
  public SelectAddressPage(){
    addElement("addAddress", "button[aria-label='Add a new address']");
    addElement("radioButton", "mat-radio-button[class*=mat-radio-button]");
    addElement("continue", "button[aria-label='Proceed to payment selection']");
    addElement("timTester", "//mat-row[contains(., 'Tim Tester')]//mat-radio-button");
  }
  // Methods
  @Override
  public SelenideElement getMainElement() {
    return getElement("addAddress");
  }
  @Override
  public void navigate(String element) {
    switch (element){
      case "continue" : PageManager.setCurrentPage(PageManager.getDeliveryPage()); break;
      case "addAdress": PageManager.setCurrentPage(PageManager.getAddAdressPage()); break;
      default         : super.navigate(element);
    }
  }
}
