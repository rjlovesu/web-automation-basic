package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import pages.PageManager;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import static org.assertj.core.api.Assertions.assertThat;

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
    info("Validating Select Address menu with " + data);
    

    if(data.get("Name") != null){
      assertThat(isTextVisible(data.get("Name"))).isTrue();
    }

    if(data.get("Address") != null){
      assertThat(isTextVisible(data.get("Address"))).isTrue();
    }

    if(data.get("Country") != null){
      assertThat(isTextVisible(data.get("Country"))).isTrue();
    }
  }
}
