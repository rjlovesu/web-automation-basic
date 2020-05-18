package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;

public class DeliveryPage extends SelectAddressPage {
  // Constructor
  public DeliveryPage(){
    addElement("expectedDelivery", "mat-header-cell[translate='LABEL_EXPECTED_DELIVERY']");
    addElement("oneDayDelivery", "//mat-row[contains(., 'One Day Delivery')]//mat-radio-button");
    addElement("standardDelivery", "//mat-row[contains(., 'Standard Delivery')]//mat-radio-button");
    addElement("continue", "button[aria-label='Proceed to delivery method selection']");
  }
  // Methods
  @Override
  public SelenideElement getMainElement() {
    return getElement("expectedDelivery");
  }
  @Override
  public void navigate(String element) {
    switch (element){
      case "continue": PageManager.setCurrentPage(PageManager.getPaymentOptionsPage()); break;
      default        : super.navigate(element); break;
    }
  }
}
