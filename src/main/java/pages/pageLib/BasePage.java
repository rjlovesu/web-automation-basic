package pages.pageLib;

import com.codeborne.selenide.SelenideElement;
import general.Loading;
import general.Logger;
import io.cucumber.datatable.DataTable;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class BasePage {
  // Variables
  private final Integer defaultTimeout = 10;
  private final Logger logger = new Logger();
  private HashMap<String, String> elementCollection;
  // Constructor
  public BasePage() {
    elementCollection = new HashMap<String, String>();
  }
  // General methods
  public void click(String element) {
    String capElement = capitalizeSecond(element);
    getElement(capElement).click();
    info("Clicking " + capElement);
    navigate(capElement);
  }
  public void doAction(String action, DataTable dataTable) {
    throw new Error(action + " is undefined");
  }
  public void doAction(String action, String data) {
    throw new Error(action + " is undefined");
  }
  public void validatePage() {
    info("Validating page: " + this.getClass());
    assertThat(isDisplayed(getMainElement(), getTimeout())).isTrue();
  }
  public void clickText(String text) {
    getTextElement(text).click();
  }
  public Boolean isTextVisible(String text) {
    return getTextElement(text).isDisplayed();
  }
  public SelenideElement getTextElement(String text) {
    return $(byXpath("//*[contains(text(), '" + text + "')]"));
  }
  public void addElement(String key, String path){
    elementCollection.put(key, path);
  }
  public SelenideElement getElement(String element){
    
    info("Getting: " + element);
    String path = elementCollection.get(element);
    if(path == null){
      throw new Error("Element: " + element + " is undefined");
    }else {
      int count = 0;
      int maxTries = 3;
      while(true) {
        try {
          if(path.contains("//")){
            return $(byXpath(path));
          }else {
            return $(path);
          }
        } catch (Error e) {
          if (++count == maxTries) throw new Error("Failed to get " + element);
        }
      }
    }
  }
  public void validateFields(DataTable dataTable) {
    info("Validating fields: " + dataTable.asList());
    for(String element : dataTable.asList()){
      assertThat(isDisplayed(getElement(capitalizeSecond(element)), getTimeout()));
    }
  }
  public Integer getTimeout(){
    return defaultTimeout;
  }
  public void setValue(String element, String value){
    String capElement = capitalizeSecond(element);
    getElement(capElement).sendKeys(value);
    info("Setting value of " + capElement + " to " + value);
  }
  public void validateText(String text){
    info("Validating: " + text);
    assertThat(isDisplayed(getTextElement(text), 10)).isTrue();
  }
  // Overridable methods
  public void navigate(String element){}
  public SelenideElement getMainElement(){
    throw new Error("getMainElement is undefined for " + this.getClass());
  }
  // Helper methods
  public void info(String str){
    logger.info(str);
  }
  public void compare(List<String> expected, List<String> actual) {
    logger.compare(expected, actual);
  }
  public String capitalize(String words){
    words = words.toLowerCase().
            replaceAll("[^a-zA-Z0-9]", " ").
            replaceAll("\\s+"," ");
    StringBuilder capitalized = new StringBuilder();
    for(String word: words.split(" ")){
      capitalized.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
    }
    return capitalized.toString().replaceAll("\\s+","");
  }
  public String capitalizeSecond(String words){
    String str = capitalize(words);
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
  }
  public Boolean isDisplayed(SelenideElement element, Integer time){
    if (Loading.isDisplayed(element, time)){
      return true;
    } else {
      return false;
    }
  }
}
