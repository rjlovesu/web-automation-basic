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
      case "addAddress": PageManager.setCurrentPage(PageManager.getAddAddressPage()); break;
      default         : super.navigate(element);
    }
  }
  @Override
  public void doAction(String action, DataTable dataTable) {
    switch(capitalizeSecond(action)){
      case "validateAddress": validateAddress(dataTable); break;
      default: super.doAction(action, dataTable);
    }
  }

  public void validateAddress(DataTable dataTable){
    Map<String,String> data = dataTable.transpose().asMaps().get(0);
    info("Validating Account menu: " + data);
    

    if(data.get("Name") != null){
      addElement("nameText", "button[aria-label='Add a new address']");
      assertThat(getElement("nameText").text().contains(data.get("Name"))).isTrue();
    }

    if(data.get("Address") != null){
      assertThat(getElement("privacySecurityButton").text().contains(data.get("Address"))).isTrue();
    }

    if(data.get("Country") != null){
      assertThat(getElement("logoutButton").text().contains(data.get("Country"))).isTrue();
    }
  }
}
