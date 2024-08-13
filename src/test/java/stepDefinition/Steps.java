package stepDefinition;

import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class Steps {
//    baseclassdriver sgp;
//    public WebDriver driver = sgp.getDriver();
    public WebDriver driver;
    DOMMethods domMethods = new DOMMethods(driver);
    Dashboard_Locators D_locator = new Dashboard_Locators();
    TradeFinance_Locators T_locator = new TradeFinance_Locators();
    Login_Locators locator = new Login_Locators();
//    private String browser;

    //goto Login Page
    @Given("User Launch {string} Browser")
    public void userLaunchBrowser(String arg0) throws Exception {
        domMethods.cross_browser(arg0);
    }

    @When("user wait to load page")
    public void user_wait_to_load_page() throws IOException {
        domMethods.wait_toload_page();
    }

    @Then("user click on login button so it should reflect to Login page")
    public void user_click_on_login_button_so_it_should_reflect_to_Login_page() {
        domMethods.click_Loginbtn(locator.main_login_button);
        domMethods.Quit_browser();

    }

    //Login Page
    @Given("user launch {string} Browser Again")
    public void userLaunchBrowserAgain(String browser) throws Exception {
        domMethods.cross_browser(browser);
        domMethods.click_Loginbtn(locator.main_login_button);
    }

    @When("user enter correct email & password")
    public void user_enter_correct_email_password() throws IOException {
       domMethods.Is_Login(locator.user_name_loc, locator.login_password_loc);
    }

    @And("take screenshot")
    public void take_screenshot() throws IOException {
        String login_base_path = domMethods.getProjectlocation();
        String loginScreenshotPath = domMethods.getvaluesfromconfigfile().getProperty("Login_screenshot_path");
        System.out.println(login_base_path+loginScreenshotPath);
        domMethods.Take_Login_screenshot(login_base_path+loginScreenshotPath);
    }

    @Then("click on Signin button so user will reflect to dashboard page")
    public void click_on_Signin_button_so_user_will_reflect_to_dashboard_page() {
        domMethods.login_button(locator.login_btn_loc);
    }

    //Dashboard
//Hamburger
    @Given("User Launch {string} Browser and login then it should lands on dashboard")
    public void user_launch_browser_and_login_then_it_should_lands_on_dashboard(String browser) throws Exception {
    domMethods.cross_browser(browser);
    domMethods.click_Loginbtn(locator.main_login_button);
    domMethods.Is_Login(locator.user_name_loc, locator.login_password_loc);
    domMethods.login_button(locator.login_btn_loc);
}
    @When("user click on Hamburger Icon")
    public void user_click_on_hamburger_icon() {
        domMethods.click_on_Hamburger_icon(D_locator.hem_icon);
    }
    @Then("Slider should get Open")
    public void slider_should_get_open() {
        domMethods.Quit_browser();
    }

    //Hamburger Items
    //Trade Finance -> LC -> Import -> Initiate -> Create LC
    @Given("user launch {string} Browser for Initiate LC")
    public void user_launch_browser_for_initiate_lc(String browser) throws Exception {
        domMethods.cross_browser(browser);

    }
    @And("perform login")
    public void perform_login() throws IOException {
        domMethods.click_Loginbtn(locator.main_login_button);
        domMethods.Is_Login(locator.user_name_loc, locator.login_password_loc);
        domMethods.login_button(locator.login_btn_loc);
    }
    @When("click on hamburger")
    public void click_on_hamburger() {
        domMethods.click_on_Hamburger_icon(D_locator.hem_icon);
    }
    @And("user click on trade finance")
    public void user_click_on_trade_finance() {
        domMethods.click_on_TradeFinance_item(T_locator.tradefinance_item);
    }
    @And("click on Letter of credit")
    public void click_on_letter_of_credit() {
        domMethods.click_on_LC_item(T_locator.LC_item);
    }
    @And("click on Import LC")
    public void click_on_import_lc() {
        domMethods.click_on_ImportLC_item(T_locator.import_LC);
    }
    @And("click on Initiate LC")
    public void click_on_initiate_lc() {
        domMethods.click_on_InitiateLC_item(T_locator.Initiate_LC);
    }
    @And("click on create LC button")
    public void click_on_create_lc_button() {
        domMethods.click_on_CreateLC_button(T_locator.create_LC);
    }
    @And("Fill LC Details")
    public void fill_lc_details() throws IOException {
        domMethods.Fill_LC_Details(T_locator.Applicant_Account_forCharges,T_locator.Applicant_Acc_searched_item,
                T_locator.Applicant_Acc_Select_Branch,T_locator.Applicant_Acc_Select_Branch_item,
                T_locator.Applicant_item, T_locator.Applicant_Div,
                T_locator.Applicant_Address1,T_locator.Applicant_Address2,T_locator.Applicant_Address3,
                T_locator.Country_Lov, T_locator.Country_Searched_Item,
                T_locator.Product_type,T_locator.selected_product_click,T_locator.Expiry_date,
                 T_locator.place_of_expiry, T_locator.beneName, T_locator.bene_Address1,T_locator.bene_Address2,T_locator.bene_Address3,
                T_locator.bene_Country_Lov, T_locator.bene_Country_Searched_Item,
                T_locator.CA_bankAddress_details, T_locator.Next_Button, T_locator.CreditAvailedBy_Box,T_locator.CreditAvailedBy_list,
                T_locator.Bene_Detail_Existing_button, T_locator.Bene_Detail_Existing_BeneName,T_locator.Bene_Detail_Existing_BeneLov);

        domMethods.Fill_LC_Secondtab_Details(T_locator.partialShipment_1,T_locator.partialShipment_4,T_locator.Airport_of_Departure, T_locator.Trans_shipment_Box,
                T_locator.Trans_shipment_Lov, T_locator.Dispatch_from, T_locator.Airport_of_Destination, T_locator.For_Transpotation,
                T_locator.shipment_Date, T_locator.Country_Origin, T_locator.Country_Origin_Lov, T_locator.Next_Button_Second_tab);

        domMethods.Fill_LC_Thirdtab_Details(T_locator.Goods_description, T_locator.Documents_description, T_locator.Additional_Conditions,
                T_locator.Documents_Submit_date, T_locator.IncoTerms_Box, T_locator.IncoTerms_Lov, T_locator.Next_Button_Third_tab);

        domMethods.Fill_LC_Fourthtab_Details(T_locator.SpecialPay_For_Bene, T_locator.SpecialPay_For_Bank, T_locator.Confirmation_Instruction_Confirm_btn,
                T_locator.Confirmation_Instruction_MayConfirm_btn, T_locator.Confirmation_Instruction_Without_btn, T_locator.Confirmation_Instruction_Request_Confirmation_Box,
                T_locator.Confirmation_Instruction_Request_Confirmation_Lov, T_locator.Sender_to_receiver_Info, T_locator.Charges, T_locator.Next_Button_Fourth_tab);

        domMethods.Fill_LC_Fifthtab_Details(T_locator.Term_Condition, T_locator.Submit, T_locator.Review_Screen_Submit);
    }
    @And("Fill Goods and Shipment Details")
    public void fill_goods_and_shipment_details() {

    }
    @And("Fill Documents and Conditions")
    public void fill_documents_and_conditions() {

    }
    @And("Fill Instructions")
    public void fill_instructions() {

    }
    @And("Upload attachment and click on submit")
    public void upload_attachment_and_click_on_submit() {

    }
    @And("take screenshot of Review Screen for Initiate LC")
    public void take_screenshot_of_Review_Screen_for_Initiate_LC() throws IOException {
        String CreateLC_base_path = domMethods.getProjectlocation();
        String CreateLCScreenshotPath = domMethods.getvaluesfromconfigfile().getProperty("Trade_LC_Import_Initiate_CreateLC_screenshot_path");
        System.out.println(CreateLC_base_path+CreateLCScreenshotPath);
        domMethods.Take_Login_screenshot(CreateLC_base_path+CreateLCScreenshotPath);
    }

    @Then("complete all the details and click on submit button")
    public void complete_all_the_details_and_click_on_submit_button() {
    }


}
