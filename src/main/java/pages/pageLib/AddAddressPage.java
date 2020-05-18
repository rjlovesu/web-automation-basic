package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;

public class AddAddressPage extends BasePage {
  // Constructor
  public AddAddressPage(){
    
    addElement("country","input#mat-input-11");
    addElement("name","input#mat-input-12");
    addElement("mobileNumber","input#mat-input-13");
    addElement("zipCode","input#mat-input-14");
    addElement("adress","input#adress");
    addElement("city","input#mat-input-16");
    addElement("state","input#mat-input-17");
    addElement("submit","button#submitButton");
  }
  // Methods
  @Override
  public SelenideElement getMainElement() {
    return getElement("addAddress");//TODO
  }
  @Override
  public void navigate(String element) {
    switch (element) {
      case "submit": PageManager.setCurrentPage(PageManager.getSelectAddressPage()); break;
      default: super.navigate(element);
    }
  }
}
