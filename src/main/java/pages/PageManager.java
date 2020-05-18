package pages;

import pages.pageLib.*;

public class PageManager {
  // Variables
  private static BasePage currentPage = null;
  private static HomePage HOME_PAGE = new HomePage();
  private static HomePageLoggedIn HOME_PAGE_LOGGED_IN = new HomePageLoggedIn();
  private static SearchResultsPage SEARCH_RESULTS_PAGE = new SearchResultsPage();
  private static LoginPage LOGIN_PAGE = new LoginPage();
  private static RegistrationPage registrationPage = new RegistrationPage();
  private static BasketPage basketPage = new BasketPage();
  private static SelectAddressPage selectAddressPage = new SelectAddressPage();
  private static DeliveryPage deliveryPage = new DeliveryPage();
  private static PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage();
  private static OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
  private static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
  private static AddAddressPage addAddressPage = new AddAddressPage();
  // Methods
  public static void setCurrentPage(BasePage page){
    currentPage = page;
    PageManager.getCurrentPage().validatePage();
  }
  public static BasePage getCurrentPage(){
    return currentPage;
  }
  // Getters & setters
  public static HomePage getHomePage() {
    return HOME_PAGE;
  }
  public static HomePageLoggedIn getHomePageLoggedIn() {
    return HOME_PAGE_LOGGED_IN;
  }
  public static SearchResultsPage getSearchResultsPage() {
    return SEARCH_RESULTS_PAGE;
  }
  public static LoginPage getLoginPage() {
    return LOGIN_PAGE;
  }
  public static RegistrationPage getRegistrationPage() {
    return registrationPage;
  }
  public static BasketPage getBasketPage() {
    return basketPage;
  }
  public static SelectAddressPage getSelectAddressPage() {
    return selectAddressPage;
  }
  public static DeliveryPage getDeliveryPage() {
    return deliveryPage;
  }
  public static PaymentOptionsPage getPaymentOptionsPage() {
    return paymentOptionsPage;
  }
  public static OrderSummaryPage getOrderSummaryPage() {
    return orderSummaryPage;
  }
  public static ChangePasswordPage getChangePasswordPage(){
    return changePasswordPage;
  }
  public static AddAddressPage getAddAddressPage(){
    return addAddressPage;
  }
}
