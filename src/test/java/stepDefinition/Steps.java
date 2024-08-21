package stepDefinition;

import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class Steps {
    public WebDriver driver;
    DOMMethods domMethods = new DOMMethods(driver);
    Dashboard_Locators D_locator = new Dashboard_Locators();
    InitiateRemittance_Locators T_locator = new InitiateRemittance_Locators();
    Login_Locators locator = new Login_Locators();

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
    @When("click on Searchbar")
    public void click_on_Searchbar() {
        domMethods.search_Initiate_screen(D_locator.Dashboard_SearchIcon, D_locator.Dashboard_SearchBox,D_locator.Search_Initiate_Remittance);
    }
      @And("Fill Remittance Details")
    public void fill_lc_details() throws IOException {
        domMethods.Ordering_Customer_Details(T_locator.First_Tab_Next_Button);

        domMethods.Beneficiary_Customer_Details(T_locator.Beneficiary_Account_Number, T_locator.Beneficiary_Account_Title,T_locator.Beneficiary_Address1, T_locator.Beneficiary_Address2, T_locator.Beneficiary_Address3, T_locator.Beneficiary_Identity_Document_Number, T_locator.Beneficiary_Bank_Swift_Code, T_locator.Beneficiary_Bank_Name, T_locator.Beneficiary_Bank_Country_Box, T_locator.Beneficiary_Bank_Country_Item, T_locator.Beneficiary_Branch_Address1, T_locator.Beneficiary_Branch_Address2, T_locator.Beneficiary_Branch_Address3,T_locator.Second_Tab_Next_Button);

        domMethods.Transaction_Information(T_locator.Purpose_of_Remittance, T_locator.Relationship_with_Beneficiary, T_locator.Charges_Details_Box, T_locator.Charges_Details_item, T_locator.Additional_Information, T_locator.Third_Tab_Next_Button);

        domMethods.Intermediary_Institution_Details(T_locator.Identifier,T_locator.Bank_swift_code,T_locator.Bank_Name,T_locator.Bank_Address1, T_locator.Bank_Address2, T_locator.Bank_Address3, T_locator.Fourth_Tab_Next_Button);

        domMethods.Remitting_Amount_Details(T_locator.Remitting_Amount, T_locator.PS_ID, T_locator.CPR, T_locator.SRB_Sales_Tax_Required_Box, T_locator.SRB_Sales_Tax_Required_list, T_locator.Customer_Comments, T_locator.Fifth_Tab_Next_Button);
        domMethods.Attachments(T_locator.Sixth_Tab_TermsAndConditions, T_locator.Sixth_Tab_Submit_Button, T_locator.Review_Screen_Submit_Button);
    } 

    @And("take screenshot of Review Screen for Initiate LC")
    public void take_screenshot_of_Review_Screen_for_Initiate_LC() throws IOException {
        String CreateLC_base_path = domMethods.getProjectlocation();
        String CreateLCScreenshotPath = domMethods.getvaluesfromconfigfile().getProperty("Trade_LC_Import_Initiate_CreateLC_screenshot_path");
        System.out.println(CreateLC_base_path+CreateLCScreenshotPath);
        domMethods.Take_Login_screenshot(CreateLC_base_path+CreateLCScreenshotPath);
    }
}
