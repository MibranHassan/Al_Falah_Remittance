package Utilities;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DOMMethods {

//    baseclassdriver sgp;
//    public WebDriver driver = sgp.getDriver();
    public WebDriver driver;

    public DOMMethods(WebDriver driver) {
        this.driver = driver;
    }
    public String getProjectlocation(){
        String directory = System.getProperty("user.dir");
        return directory;
    }
    public Properties getvaluesfromconfigfile() throws IOException {
        try{
            FileInputStream input = new FileInputStream("target\\config.properties");
            Properties obj = new Properties();
            obj.load(input);
            return obj;
        }catch (FileNotFoundException e){
            FileInputStream input = new FileInputStream("target\\config.properties");
            Properties obj = new Properties();
            obj.load(input);
            return obj;
        }
    }
    public void wait_toload_page() throws IOException{
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    public void click_Loginbtn(String loginbutton){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginbutton)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginbutton)));
        WebElement click_Login_btn = driver.findElement(By.xpath(loginbutton));
        try{
            click_Login_btn.click();
               }
        catch (NoSuchWindowException e){
            click_Login_btn.click();
              }
    }
    public void Is_Login(String userName, String password) throws IOException {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(userName)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password)));
        WebElement username_element = driver.findElement(By.id(userName));
        WebElement password_element = driver.findElement(By.id(password));
        try{
            username_element.sendKeys(getvaluesfromconfigfile().getProperty("username"));
            password_element.sendKeys(getvaluesfromconfigfile().getProperty("password"));
        }catch (NoSuchWindowException e){
            username_element.sendKeys(getvaluesfromconfigfile().getProperty("username"));
            password_element.sendKeys(getvaluesfromconfigfile().getProperty("password"));
        }
    }
    public void login_button(String btnlogin) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnlogin)));
            WebElement btnelement = driver.findElement(By.xpath(btnlogin));
        try{
            btnelement.click();
        }catch (NoSuchWindowException e){
            btnelement.click();
        }
    }
    public void Take_Login_screenshot(String file_path) throws IOException {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(file, new File(file_path));
        }catch (IOException | NoSuchElementException e){
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(file, new File(file_path));
        }
    }
    public void search_Initiate_screen(String Dashboard_SearchIcon, String Dashboard_SearchBox, String Search_Initiate_Remittance){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard_SearchIcon)));
        WebElement Search_Icon_LOV = driver.findElement(By.xpath(Dashboard_SearchIcon));
        Search_Icon_LOV.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard_SearchBox)));
        WebElement Search_Box_LOV = driver.findElement(By.xpath(Dashboard_SearchBox));
        Search_Box_LOV.click();
        WebElement Search_Box_item = driver.findElement(By.xpath(Search_Initiate_Remittance));
        try {
            List<WebElement> SearchBox_item_options = Search_Box_item.findElements(By.tagName("li"));
            for (WebElement SBoption : SearchBox_item_options) {
                if (SBoption.getText().equals(getvaluesfromconfigfile().getProperty("Search-Initiate-Screen"))) {
                    SBoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException | IOException e) {
        }
    }
    public void Ordering_Customer_Details(String Visible_First_Tab_All_Fields, String First_Tab_Next_Button) throws IOException {
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(50));
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Visible_First_Tab_All_Fields)));
        waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(Visible_First_Tab_All_Fields)));
                try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
            Thread.sleep(7000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebElement Visible_First_Fields = driver.findElement(By.xpath(Visible_First_Tab_All_Fields));
//        if (Visible_First_Fields.getText() != null){
//            //   Next Button First Tab
            waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(First_Tab_Next_Button)));
            WebElement Next_Button_First = driver.findElement(By.xpath(First_Tab_Next_Button));
            try {
                Next_Button_First.click();
            } catch (NoSuchWindowException e) {
            }
//        }


    }
    public void Beneficiary_Customer_Details(String Beneficiary_Account_Number, String Beneficiary_Account_Title, String Beneficiary_Address1, String Beneficiary_Address2, String Beneficiary_Address3, String Beneficiary_Identity_Document_Number, String Beneficiary_Bank_Swift_Code, String Beneficiary_Bank_Name, String Beneficiary_Bank_Country_Box, String Beneficiary_Bank_Country_Item, String Beneficiary_Branch_Address1, String Beneficiary_Branch_Address2, String Beneficiary_Branch_Address3, String Second_Tab_Next_Button) throws IOException {

        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(50));

//        Scroll to Top so that it can find second tab selector
    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");

    // Beneficiary_Account_Number
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Account_Number)));
    WebElement Beneficiary_Account_Number_Item = driver.findElement(By.xpath(Beneficiary_Account_Number));
    try{
        Beneficiary_Account_Number_Item.click();
        Beneficiary_Account_Number_Item.clear();
        Beneficiary_Account_Number_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Account-Number"));
    }catch (NoSuchWindowException e){
        Beneficiary_Account_Number_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Account-Number"));
    }

    // Beneficiary_Account_Title
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Account_Title)));
    WebElement Beneficiary_Account_Title_Item = driver.findElement(By.xpath(Beneficiary_Account_Title));
    try{
        Beneficiary_Account_Title_Item.click();
        Beneficiary_Account_Title_Item.clear();
        Beneficiary_Account_Title_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Account-Title"));
    }catch (NoSuchWindowException e){
        Beneficiary_Account_Title_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Account-Title"));
    }

    // Beneficiary_Address1
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Address1)));
    WebElement Beneficiary_Address1_Item = driver.findElement(By.xpath(Beneficiary_Address1));
    try{
        Beneficiary_Address1_Item.click();
        Beneficiary_Address1_Item.clear();
        Beneficiary_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address1"));
    }catch (NoSuchWindowException e){
        Beneficiary_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address1"));
    }

    // Beneficiary_Address2
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Address2)));
    WebElement Beneficiary_Address2_Item = driver.findElement(By.xpath(Beneficiary_Address2));
    try{
        Beneficiary_Address2_Item.click();
        Beneficiary_Address2_Item.clear();
        Beneficiary_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
    }catch (NoSuchWindowException e){
        Beneficiary_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
    }

    // Beneficiary_Address3
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Address3)));
    WebElement Beneficiary_Address3_Item = driver.findElement(By.xpath(Beneficiary_Address3));
    try{
        Beneficiary_Address3_Item.click();
        Beneficiary_Address3_Item.clear();
        Beneficiary_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address3"));
    }catch (NoSuchWindowException e){
        Beneficiary_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address3"));
    }

    // Beneficiary_Identity_Document_Number
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Identity_Document_Number)));
    WebElement Beneficiary_Identity_Document_Number_Item = driver.findElement(By.xpath(Beneficiary_Identity_Document_Number));
    try{
        Beneficiary_Identity_Document_Number_Item.click();
        Beneficiary_Identity_Document_Number_Item.clear();
        Beneficiary_Identity_Document_Number_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Identity-Document-Number"));
    }catch (NoSuchWindowException e){
        Beneficiary_Identity_Document_Number_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Identity-Document-Number"));
    }

    // Beneficiary_Bank_Swift_Code
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Bank_Swift_Code)));
    WebElement Beneficiary_Bank_Swift_Code_Item = driver.findElement(By.xpath(Beneficiary_Bank_Swift_Code));
    try{
        Beneficiary_Bank_Swift_Code_Item.click();
        Beneficiary_Bank_Swift_Code_Item.clear();
        Beneficiary_Bank_Swift_Code_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Bank-Swift-Code"));
    }catch (NoSuchWindowException e){
        Beneficiary_Bank_Swift_Code_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Bank-Swift-Code"));
    }

    // Beneficiary_Bank_Name
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Bank_Name)));
    WebElement Beneficiary_Bank_Name_Item = driver.findElement(By.xpath(Beneficiary_Bank_Name));
    try{
        Beneficiary_Bank_Name_Item.click();
        Beneficiary_Bank_Name_Item.clear();
        Beneficiary_Bank_Name_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Bank-Name"));
    }catch (NoSuchWindowException e){
        Beneficiary_Bank_Name_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Bank-Name"));
    }


    //Beneficiary_Bank_Country_Box
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Bank_Country_Box)));
        waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(Beneficiary_Bank_Country_Box)));
        WebElement Beneficiary_Bank_Country_Box_Lov = driver.findElement(By.xpath(Beneficiary_Bank_Country_Box));
    Beneficiary_Bank_Country_Box_Lov.click();
        WebElement Beneficiary_Bank_Country_item = driver.findElement(By.xpath(Beneficiary_Bank_Country_Item));
        try {
            List<WebElement> BeneficiaryBankCountryoptions = Beneficiary_Bank_Country_item.findElements(By.tagName("li"));
            for (WebElement BBCoption : BeneficiaryBankCountryoptions)
            {
                if (BBCoption.getText().equals(getvaluesfromconfigfile().getProperty("Beneficiary-Bank-Country")))
                {
                    BBCoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

    // Beneficiary_Account_Number
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Branch_Address1)));
    WebElement Beneficiary_Branch_Address1_Item = driver.findElement(By.xpath(Beneficiary_Branch_Address1));
    try{
        Beneficiary_Branch_Address1_Item.click();
        Beneficiary_Branch_Address1_Item.clear();
        Beneficiary_Branch_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address1"));
    }catch (NoSuchWindowException e){
        Beneficiary_Branch_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address1"));
    }

    // Beneficiary_Account_Number
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Branch_Address2)));
    WebElement Beneficiary_Branch_Address2_Item = driver.findElement(By.xpath(Beneficiary_Branch_Address2));
    try{
        Beneficiary_Branch_Address2_Item.click();
        Beneficiary_Branch_Address2_Item.clear();
        Beneficiary_Branch_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address2"));
    }catch (NoSuchWindowException e){
        Beneficiary_Branch_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address2"));
    }

    // Beneficiary_Account_Number
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Beneficiary_Branch_Address3)));
    WebElement Beneficiary_Branch_Address3_Item = driver.findElement(By.xpath(Beneficiary_Branch_Address3));
    try{
        Beneficiary_Branch_Address3_Item.click();
        Beneficiary_Branch_Address3_Item.clear();
        Beneficiary_Branch_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address3"));
    }catch (NoSuchWindowException e){
        Beneficiary_Branch_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Branch-Address3"));
    }

    //   Next Button Second Tab
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Second_Tab_Next_Button)));
    WebElement Next_Button_Second = driver.findElement(By.xpath(Second_Tab_Next_Button));
    try {
        Next_Button_Second.click();
    } catch (NoSuchWindowException e) {
    }

    }
    public void Transaction_Information(String Purpose_of_Remittance, String Relationship_with_Beneficiary, String Charges_Details_Box, String Charges_Details_item, String Additional_Information, String Third_Tab_Next_Button) throws IOException {

        WebDriverWait waitThird = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Purpose_of_Remittance
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Purpose_of_Remittance)));
        WebElement Purpose_of_Remittance_Item = driver.findElement(By.xpath(Purpose_of_Remittance));
        try{
            Purpose_of_Remittance_Item.click();
            Purpose_of_Remittance_Item.clear();
            Purpose_of_Remittance_Item.sendKeys(getvaluesfromconfigfile().getProperty("Purpose-of-Remittance"));
        }catch (NoSuchWindowException e){
            Purpose_of_Remittance_Item.sendKeys(getvaluesfromconfigfile().getProperty("Purpose-of-Remittance"));
        }

        // Relationship_with_Beneficiary
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Relationship_with_Beneficiary)));
        WebElement Relationship_with_Beneficiary_Item = driver.findElement(By.xpath(Relationship_with_Beneficiary));
        try{
            Relationship_with_Beneficiary_Item.click();
            Relationship_with_Beneficiary_Item.clear();
            Relationship_with_Beneficiary_Item.sendKeys(getvaluesfromconfigfile().getProperty("Relationship-with-Beneficiary"));
        }catch (NoSuchWindowException e){
            Relationship_with_Beneficiary_Item.sendKeys(getvaluesfromconfigfile().getProperty("Relationship-with-Beneficiary"));
        }


        // Charges_Details
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Charges_Details_Box)));
        waitThird.until(ExpectedConditions.elementToBeClickable(By.xpath(Charges_Details_Box)));
        WebElement Charges_Details_Box_Lov = driver.findElement(By.xpath(Charges_Details_Box));
        Charges_Details_Box_Lov.click();
        WebElement Charges_Details_Item = driver.findElement(By.xpath(Charges_Details_item));
        try {
            List<WebElement> ChargesDetailsoptions = Charges_Details_Item.findElements(By.tagName("li"));
            for (WebElement CDoption : ChargesDetailsoptions)
            {
                if (CDoption.getText().equals(getvaluesfromconfigfile().getProperty("Charges-Details")))
                {
                    CDoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

        // Additional_Information
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Additional_Information)));
        WebElement Additional_Information_Item = driver.findElement(By.xpath(Additional_Information));
        try{
            Additional_Information_Item.click();
            Additional_Information_Item.clear();
            Additional_Information_Item.sendKeys(getvaluesfromconfigfile().getProperty("Additional-Information"));
        }catch (NoSuchWindowException e){
            Additional_Information_Item.sendKeys(getvaluesfromconfigfile().getProperty("Additional-Information"));
        }

//   Next Button Third Tab
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Third_Tab_Next_Button)));
        WebElement Next_Button_Third = driver.findElement(By.xpath(Third_Tab_Next_Button));
        try {
            Next_Button_Third.click();
        } catch (NoSuchWindowException e) {
        }

        try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Intermediary_Institution_Details(String Identifier, String Bank_swift_code,String Bank_Name, String Bank_Address1, String Bank_Address2, String Bank_Address3, String Fourth_Tab_Next_Button) throws IOException {

        WebDriverWait waitFourth = new WebDriverWait(driver, Duration.ofSeconds(50));

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");


        //   Identifier
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Identifier)));
        WebElement Identifier_Item = driver.findElement(By.xpath(Identifier));
        try{
            Identifier_Item.click();
            Identifier_Item.clear();
            Identifier_Item.sendKeys(getvaluesfromconfigfile().getProperty("Identifier"));
        }catch (NoSuchWindowException e){
            Identifier_Item.sendKeys(getvaluesfromconfigfile().getProperty("Identifier"));
        }

        //   Bank_swift_code
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bank_swift_code)));
        WebElement Bank_swift_code_Item = driver.findElement(By.xpath(Bank_swift_code));
        try{
            Bank_swift_code_Item.click();
            Bank_swift_code_Item.clear();
            Bank_swift_code_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-swift-code"));
        }catch (NoSuchWindowException e){
            Bank_swift_code_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-swift-code"));
        }

        //   Bank_Name
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bank_Name)));
        WebElement Bank_Name_Item = driver.findElement(By.xpath(Bank_Name));
        try{
            Bank_Name_Item.click();
            Bank_Name_Item.clear();
            Bank_Name_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Name"));
        }catch (NoSuchWindowException e){
            Bank_Name_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Name"));
        }

        //   Bank_Address1
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bank_Address1)));
        WebElement Bank_Address1_Item = driver.findElement(By.xpath(Bank_Address1));
        try{
            Bank_Address1_Item.click();
            Bank_Address1_Item.clear();
            Bank_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address1"));
        }catch (NoSuchWindowException e){
            Bank_Address1_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address1"));
        }

        //   Bank_Address2
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bank_Address2)));
        WebElement Bank_Address2_Item = driver.findElement(By.xpath(Bank_Address2));
        try{
            Bank_Address2_Item.click();
            Bank_Address2_Item.clear();
            Bank_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address2"));
        }catch (NoSuchWindowException e){
            Bank_Address2_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address2"));
        }

        //   Bank_Address3
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bank_Address3)));
        WebElement Bank_Address3_Item = driver.findElement(By.xpath(Bank_Address3));
        try{
            Bank_Address3_Item.click();
            Bank_Address3_Item.clear();
            Bank_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address3"));
        }catch (NoSuchWindowException e){
            Bank_Address3_Item.sendKeys(getvaluesfromconfigfile().getProperty("Bank-Address3"));
        }

        //   Next Button Fourth Tab
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Fourth_Tab_Next_Button)));
        WebElement Next_Button_Fourth = driver.findElement(By.xpath(Fourth_Tab_Next_Button));
        try {
            Next_Button_Fourth.click();
        } catch (NoSuchWindowException e) {
        }

    }
    public void Remitting_Amount_Details(String Remitting_Amount, String PS_ID, String CPR, String SRB_Sales_Tax_Required_Box, String SRB_Sales_Tax_Required_list, String Customer_Comments, String Fifth_Tab_Next_Button) throws IOException {

        WebDriverWait waitFifth = new WebDriverWait(driver, Duration.ofSeconds(50));

    //   Remitting_Amount
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Remitting_Amount)));
        WebElement Remitting_Amount_Item = driver.findElement(By.xpath(Remitting_Amount));
        try{
            Remitting_Amount_Item.click();
            Remitting_Amount_Item.clear();
            Remitting_Amount_Item.sendKeys(getvaluesfromconfigfile().getProperty("Remitting-Amount"));
        }catch (NoSuchWindowException | IOException e){
            Remitting_Amount_Item.sendKeys(getvaluesfromconfigfile().getProperty("Remitting-Amount"));
        }

        //   PS_ID
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PS_ID)));
        WebElement PS_ID_Item = driver.findElement(By.xpath(PS_ID));
        try{
            PS_ID_Item.click();
            PS_ID_Item.clear();
            PS_ID_Item.sendKeys(getvaluesfromconfigfile().getProperty("PS-ID"));
        }catch (NoSuchWindowException e){
            PS_ID_Item.sendKeys(getvaluesfromconfigfile().getProperty("PS-ID"));
        }

        //   Bank_Address3
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CPR)));
        WebElement CPR_Item = driver.findElement(By.xpath(CPR));
        try{
            CPR_Item.click();
            CPR_Item.clear();
            CPR_Item.sendKeys(getvaluesfromconfigfile().getProperty("CPR"));
        }catch (NoSuchWindowException e){
            CPR_Item.sendKeys(getvaluesfromconfigfile().getProperty("CPR"));
        }

        // Charges_Details
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SRB_Sales_Tax_Required_Box)));
        waitFifth.until(ExpectedConditions.elementToBeClickable(By.xpath(SRB_Sales_Tax_Required_Box)));
        WebElement SRB_Sales_Tax_Required_Box_LOV = driver.findElement(By.xpath(SRB_Sales_Tax_Required_Box));
        SRB_Sales_Tax_Required_Box_LOV.click();
        WebElement SRB_Sales_Tax_Required_list_Item = driver.findElement(By.xpath(SRB_Sales_Tax_Required_list));
        try {
            List<WebElement> SalesTaxRequiredoptions = SRB_Sales_Tax_Required_list_Item.findElements(By.tagName("li"));
            for (WebElement SToption : SalesTaxRequiredoptions)
            {
                if (SToption.getText().equals(getvaluesfromconfigfile().getProperty("SRB-Sales-Tax-Required")))
                {
                    SToption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

        //   Bank_Address3
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Customer_Comments)));
        WebElement Customer_Comments_Item = driver.findElement(By.xpath(Customer_Comments));
        try{
            Customer_Comments_Item.click();
            Customer_Comments_Item.clear();
            Customer_Comments_Item.sendKeys(getvaluesfromconfigfile().getProperty("Customer-Comments"));
        }catch (NoSuchWindowException e){
            Customer_Comments_Item.sendKeys(getvaluesfromconfigfile().getProperty("Customer-Comments"));
        }

        //   Next Button Fourth Tab
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Fifth_Tab_Next_Button)));
        WebElement Next_Button_Fifth = driver.findElement(By.xpath(Fifth_Tab_Next_Button));
        try {
            Next_Button_Fifth.click();
        } catch (NoSuchWindowException e) {
        }
    }
    public void Attachments(String Sixth_Tab_TermsAndConditions, String Sixth_Tab_Submit_Button, String Review_Screen_Submit_Button){

        WebDriverWait waitSixth = new WebDriverWait(driver, Duration.ofSeconds(50));

        //   Terms And Conditions
        waitSixth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Sixth_Tab_TermsAndConditions)));
        WebElement Term_Condition_check = driver.findElement(By.xpath(Sixth_Tab_TermsAndConditions));
        try {
            Term_Condition_check.click();
        } catch (NoSuchWindowException e) {
        }

        //   Submit LC
        waitSixth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Sixth_Tab_Submit_Button)));
        WebElement Submit_btn = driver.findElement(By.xpath(Sixth_Tab_Submit_Button));
        try {
            Submit_btn.click();
        } catch (NoSuchWindowException e) {
        }

        //   Review Screen Submit Button
        waitSixth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Review_Screen_Submit_Button)));
        WebElement Review_Screen_Submit_btn = driver.findElement(By.xpath(Review_Screen_Submit_Button));
        try {
            Review_Screen_Submit_btn.click();
        } catch (NoSuchWindowException e) {
        }
    }

    //Cross Browser
    @BeforeTest
    @Parameters("browser")
    public void cross_browser(String browser) throws Exception {

        if (browser.equalsIgnoreCase("chrome")) {
            FileInputStream input = null;
            try {
                input = new FileInputStream("target\\config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Properties obj = new Properties();
            try {
                obj.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            String url = obj.getProperty("Env");
            driver.manage().window().maximize();
            driver.get(url);
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            FileInputStream input = null;
            try {
                input = new FileInputStream("target\\config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Properties obj = new Properties();
            try {
                obj.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            driver = new EdgeDriver();
            String url = obj.getProperty("Env");
            driver.manage().window().maximize();
            driver.get(url);
        }
        else {
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void Quit_browser(){
        if (driver != null) {
            // Perform a wait before closing the browser
            try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
                Thread.sleep(4000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}