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
    public void Check_Title() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),getvaluesfromconfigfile().getProperty("search_hotel_page_title"));
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
    public void click_on_Hamburger_icon(String hem_icon){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(hem_icon)));
        WebElement btn_hem_icon = driver.findElement(By.className(hem_icon));
        try{
            btn_hem_icon.click();
        }catch (NoSuchWindowException e){
            btn_hem_icon.click();
        }
    }
    public void click_on_TradeFinance_item(String trade_finance_item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(trade_finance_item)));
        WebElement btn_trade_item = driver.findElement(By.xpath(trade_finance_item));
        try{
            btn_trade_item.click();
        }catch (NoSuchWindowException e){
            btn_trade_item.click();
        }
    }
    public void click_on_LC_item(String LC_item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LC_item)));
        WebElement btn_LC_item = driver.findElement(By.xpath(LC_item));
        try{
            btn_LC_item.click();
        }catch (NoSuchWindowException e){
            btn_LC_item.click();
        }
    }
    public void click_on_ImportLC_item(String ImportLC_item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ImportLC_item)));
        WebElement btn_importLC_item = driver.findElement(By.xpath(ImportLC_item));
        try{
            btn_importLC_item.click();
        }catch (NoSuchWindowException e){
            btn_importLC_item.click();
        }
    }
    public void click_on_InitiateLC_item(String InitiateLC_item){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitiateLC_item)));
        WebElement btn_initiateLC_item = driver.findElement(By.xpath(InitiateLC_item));
        try{
            btn_initiateLC_item.click();
        }catch (NoSuchWindowException e){
            btn_initiateLC_item.click();
        }
    }
    public void click_on_CreateLC_button(String CreateLC_btn){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreateLC_btn)));
        WebElement btn_createLC = driver.findElement(By.xpath(CreateLC_btn));
        try{
            btn_createLC.click();
        }catch (NoSuchWindowException e){
            btn_createLC.click();
        }
    }
    public void Fill_LC_Details(
                                String Applicant_Account_forCharges,String Applicant_Acc_Searched_item,String Applicant_Acc_Select_Branch,
                                String Applicant_Acc_Select_Branch_item, String Applicant_item, String Applicant_Div,
                                 String Applicant_Address1, String Applicant_Address2, String Applicant_Address3,
                                String Country_Lov, String Country_Searched_Lov, String Product_type,
                                String selected_product_click,String expiry_Date, String place_of_expiry, String beneName,
                                String bene_Address1, String bene_Address2, String bene_Address3,
                                String bene_Country_Lov, String bene_Country_Searched_Item,String CA_bankAddress_details,
                                String Next_Button_First_Tab,String CreditAvailedBy_Box, String CreditAvailedBy_list,
    String Bene_Detail_Existing_button, String Bene_Detail_Existing_BeneName, String Bene_Detail_Existing_BeneLov) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Applicant Account For Charges
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Account_forCharges)));
        WebElement Account_forCharges = driver.findElement(By.xpath(Applicant_Account_forCharges));
        Account_forCharges.click();
        WebElement innerOptions = driver.findElement(By.xpath(Applicant_Acc_Searched_item));
        innerOptions.click();

        //Please Select for Branch
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Acc_Select_Branch)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Applicant_Acc_Select_Branch)));
        WebElement BranchLOV = driver.findElement(By.xpath(Applicant_Acc_Select_Branch));
        BranchLOV.click();
        WebElement Branch_item = driver.findElement(By.id(Applicant_Acc_Select_Branch_item));
        try {
            List<WebElement> options = Branch_item.findElements(By.tagName("li"));
            for (WebElement option : options) {
                if (option.getText().equals(getvaluesfromconfigfile().getProperty("LCBranch"))) {
                    option.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

//        Applicant
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Div)));
        WebElement ApplicantLOV = driver.findElement(By.xpath(Applicant_Div));
        ApplicantLOV.click();
        WebElement Applicant_itemm = driver.findElement(By.xpath(Applicant_item));
        try {
            List<WebElement> Applicantoptions = Applicant_itemm.findElements(By.tagName("li"));
            for (WebElement Aoption : Applicantoptions) {
                if (Aoption.getText().equals(getvaluesfromconfigfile().getProperty("Applicant"))) {
                    Aoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

        //   Address1
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address1)));
        WebElement address_element = driver.findElement(By.xpath(Applicant_Address1));
        try {
            address_element.click();
            address_element.clear();
            address_element.sendKeys(getvaluesfromconfigfile().getProperty("Address1"));
        } catch (NoSuchWindowException e) {
            address_element.sendKeys(getvaluesfromconfigfile().getProperty("Address1"));
        }

        //   Address2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address2)));
        WebElement address_element2 = driver.findElement(By.xpath(Applicant_Address2));
        try {
            address_element2.click();
            address_element2.clear();
            address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Address2"));
        } catch (NoSuchWindowException e) {
            address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Address2"));
        }

        //   Address3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address3)));
        WebElement address_element3 = driver.findElement(By.xpath(Applicant_Address3));
        try {
            address_element3.click();
            address_element3.clear();
            address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Address3"));
        } catch (NoSuchWindowException e) {
            address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Address3"));
        }

        //Country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Country_Lov)));
        WebElement A_Country_Lov = driver.findElement(By.xpath(Country_Lov));
        A_Country_Lov.click();
        WebElement A_Country_Searched_Item = driver.findElement(By.xpath(Country_Searched_Lov));
        try {
            List<WebElement> Countryoptions = A_Country_Searched_Item.findElements(By.tagName("li"));
            for (WebElement Coption : Countryoptions) {
                if (Coption.getText().equals(getvaluesfromconfigfile().getProperty("Country"))) {
                    Coption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Product_type)));
        WebElement Product_typing = driver.findElement(By.xpath(Product_type));
        Product_typing.click();
        WebElement Product_Searched_Item_selected = driver.findElement(By.xpath(selected_product_click));
        try {
            List<WebElement> Productoptions = Product_Searched_Item_selected.findElements(By.tagName("li"));
            for (WebElement Poption : Productoptions) {
                if (Poption.getText().contains(getvaluesfromconfigfile().getProperty("Product"))) {
                    Poption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Expiry Date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expiry_Date)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(expiry_Date)));
        WebElement expirydate_Element = driver.findElement(By.xpath(expiry_Date));
        expirydate_Element.click();
        expirydate_Element.sendKeys(getvaluesfromconfigfile().getProperty("Date-of-Expiry"));

        //Place of Expiry
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(place_of_expiry)));
        WebElement place_of_expiry_Element = driver.findElement(By.id(place_of_expiry));
        place_of_expiry_Element.click();
        try {
            place_of_expiry_Element.sendKeys(getvaluesfromconfigfile().getProperty("PlaceofExpiry"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Bene Details Condition of New and Existing
        if (getvaluesfromconfigfile().getProperty("Beneficiary-Details").contains("New")) {

            //   59 Bene Name
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beneName)));
            WebElement beneName_element = driver.findElement(By.xpath(beneName));
            try {
                beneName_element.click();
                beneName_element.clear();
                beneName_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Name"));
            } catch (NoSuchWindowException e) {
                beneName_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Name"));
            }

            //   Bene Address1
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address1)));
            WebElement bene_address_element = driver.findElement(By.xpath(bene_Address1));
            try {
                bene_address_element.click();
                bene_address_element.clear();
                bene_address_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address"));
            } catch (NoSuchWindowException e) {
                bene_address_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address"));
            }

            //   Bene Address2
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address2)));
            WebElement bene_address_element2 = driver.findElement(By.xpath(bene_Address2));
            try {
                bene_address_element2.click();
                bene_address_element2.clear();
                bene_address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
            } catch (NoSuchWindowException e) {
                bene_address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
            }

            //   Bene Address3
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address3)));
            WebElement bene_address_element3 = driver.findElement(By.xpath(bene_Address3));
            try {
                bene_address_element3.click();
                bene_address_element3.clear();
                bene_address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address3"));
            } catch (NoSuchWindowException e) {
                address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address3"));
            }

            //  Bene Country
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Country_Lov)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bene_Country_Lov)));
            WebElement bene_A_Country_Lov = driver.findElement(By.xpath(bene_Country_Lov));
            bene_A_Country_Lov.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bene_Country_Searched_Item)));
            WebElement bene_A_Country_Searched_Item = driver.findElement(By.xpath(bene_Country_Searched_Item));
            try {
                List<WebElement> BeneCoptions = bene_A_Country_Searched_Item.findElements(By.tagName("li"));
                for (WebElement BCoption : BeneCoptions) {
                    if (BCoption.getText().equals(getvaluesfromconfigfile().getProperty("Beneficiary-Country"))) {
                        BCoption.click(); // click the desired option
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//        Beneficiary Details Existing
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bene_Detail_Existing_button)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Bene_Detail_Existing_button)));
            WebElement Existing_button = driver.findElement(By.xpath(Bene_Detail_Existing_button));
            Existing_button.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Bene_Detail_Existing_BeneName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Bene_Detail_Existing_BeneName)));
            WebElement Existing_BeneName = driver.findElement(By.xpath(Bene_Detail_Existing_BeneName));
            Existing_BeneName.click();
            WebElement Existing_BeneLov = driver.findElement(By.xpath(Bene_Detail_Existing_BeneLov));
            try {
                List<WebElement> BDExistingoptions = Existing_BeneLov.findElements(By.tagName("li"));
                for (WebElement BDEoption : BDExistingoptions) {
                    if (BDEoption.getText().equals(getvaluesfromconfigfile().getProperty("Existing-Beneficiary-Name-Lov"))) {
                        BDEoption.click(); // click the desired option
                        break;
                    }
                }
            } catch (NoSuchWindowException e) {
            }

        }
        //End of Bene. Details Else(Existing) Part
        try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Credit Availed By
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditAvailedBy_Box)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CreditAvailedBy_Box)));
        WebElement Credit_div = driver.findElement(By.xpath(CreditAvailedBy_Box));
        Credit_div.click();
        WebElement CreditAvailedBy_listElement = driver.findElement(By.xpath(CreditAvailedBy_list));
        try {
            List<WebElement> CreditAvailedoptions = CreditAvailedBy_listElement.findElements(By.tagName("li"));
            for (WebElement CAoption : CreditAvailedoptions) {
                if (CAoption.getText().contains(getvaluesfromconfigfile().getProperty("Credit-Available-By"))) {
                    CAoption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //   Credit Available With Bank Address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CA_bankAddress_details)));
        WebElement CA_bankAddress = driver.findElement(By.xpath(CA_bankAddress_details));
        try {
            CA_bankAddress.click();
            CA_bankAddress.clear();
            CA_bankAddress.sendKeys(getvaluesfromconfigfile().getProperty("Credit-Available-With-Bank-Address"));
        } catch (NoSuchWindowException e) {
            CA_bankAddress.sendKeys(getvaluesfromconfigfile().getProperty("Credit-Available-With-Bank-Address"));
        }

        //   Next Button First Tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Next_Button_First_Tab)));
        WebElement Next_Button = driver.findElement(By.xpath(Next_Button_First_Tab));
        try {
            Next_Button.click();
        } catch (NoSuchWindowException e) {
        }

        try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



//        Second Tab
public void Fill_LC_Secondtab_Details(
        String partialShipment_1, String partialShipment_4,String Airport_of_Departure, String Trans_shipment_Box,
        String Trans_shipment_Lov, String Dispatch_from, String Airport_of_Destination,
        String For_Transpotation, String shipment_Date, String Country_Origin,
        String Country_Origin_Lov, String Next_Button_Second_tab) throws IOException {

        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(50));

//        Scroll to Top so that it can find second tab selector
    ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");


    //Partial Shipment
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partialShipment_1)));
        waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(partialShipment_1)));
        WebElement partialShipment_LOV = driver.findElement(By.xpath(partialShipment_1));
        partialShipment_LOV.click();
        WebElement partialShipment_item = driver.findElement(By.xpath(partialShipment_4));
        try {
            List<WebElement> partialShipmentoptions = partialShipment_item.findElements(By.tagName("li"));
            for (WebElement PSoption : partialShipmentoptions)
            {
                if (PSoption.getText().contains(getvaluesfromconfigfile().getProperty("Partial-shipment")))
                {
                    PSoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

    //Trans-shipment
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Trans_shipment_Box)));
    waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(Trans_shipment_Box)));
    WebElement Trans_shipment_Box_Ele = driver.findElement(By.xpath(Trans_shipment_Box));
    Trans_shipment_Box_Ele.click();
    WebElement Trans_shipment_Lov_Item = driver.findElement(By.xpath(Trans_shipment_Lov));
    try {
        List<WebElement> Trans_shipment_options = Trans_shipment_Lov_Item.findElements(By.tagName("li"));
        for (WebElement TSoption : Trans_shipment_options)
        {
            if (TSoption.getText().contains(getvaluesfromconfigfile().getProperty("Partial-shipment")))
            {
                TSoption.click(); // click the desired option
                break;
            }
        }
    } catch (NoSuchWindowException e) {
    }

        //   Dispatch From
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dispatch_from)));
        WebElement Dispatch_from_Item = driver.findElement(By.xpath(Dispatch_from));
        try{
            Dispatch_from_Item.click();
            Dispatch_from_Item.clear();
            Dispatch_from_Item.sendKeys(getvaluesfromconfigfile().getProperty("Dispatch-From"));
        }catch (NoSuchWindowException e){
            Dispatch_from_Item.sendKeys(getvaluesfromconfigfile().getProperty("Dispatch-From"));
        }

    //   Airport Of Departure
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Airport_of_Departure)));
    WebElement Airport_Departure = driver.findElement(By.xpath(Airport_of_Departure));
    try{
        Airport_Departure.click();
        Airport_Departure.clear();
        Airport_Departure.sendKeys(getvaluesfromconfigfile().getProperty("Port-of-loading"));
    }catch (NoSuchWindowException e){
        Airport_Departure.sendKeys(getvaluesfromconfigfile().getProperty("Port-of-loading"));
    }

    //   Airport Of Destination
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Airport_of_Destination)));
    WebElement Airport_of_Destination_Item = driver.findElement(By.xpath(Airport_of_Destination));
    try{
        Airport_of_Destination_Item.click();
        Airport_of_Destination_Item.clear();
        Airport_of_Destination_Item.sendKeys(getvaluesfromconfigfile().getProperty("Airport-of-destination"));
    }catch (NoSuchWindowException e){
        Airport_of_Destination_Item.sendKeys(getvaluesfromconfigfile().getProperty("Airport-of-destination"));
    }

    //   For Transpotation
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(For_Transpotation)));
    WebElement For_Transpotation_Item = driver.findElement(By.xpath(For_Transpotation));
    try{
        For_Transpotation_Item.click();
        For_Transpotation_Item.clear();
        For_Transpotation_Item.sendKeys(getvaluesfromconfigfile().getProperty("Place-of-final-destination"));
    }catch (NoSuchWindowException e){
        For_Transpotation_Item.sendKeys(getvaluesfromconfigfile().getProperty("Place-of-final-destination"));
    }

    //Shipment Date
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shipment_Date)));
    waiting.until(ExpectedConditions.elementToBeClickable(By.xpath(shipment_Date)));
    WebElement shipment_Date_Element = driver.findElement(By.xpath(shipment_Date));
    shipment_Date_Element.click();
    shipment_Date_Element.sendKeys(getvaluesfromconfigfile().getProperty("shipment-Date"));

    //Country
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Country_Origin)));
    WebElement Country_Lov_Item = driver.findElement(By.xpath(Country_Origin));
    Country_Lov_Item.click();
    WebElement Country_Origin_Lov_Item = driver.findElement(By.xpath(Country_Origin_Lov));
    try {
        List<WebElement> CountryOriginoptions = Country_Origin_Lov_Item.findElements(By.tagName("li"));
        for (WebElement COoption : CountryOriginoptions) {
            if (COoption.getText().equals(getvaluesfromconfigfile().getProperty("Country-of-Origin"))) {
                COoption.click(); // click the desired option
                break;
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

//   Next Button Second Tab
    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Next_Button_Second_tab)));
    WebElement Next_Button_Second = driver.findElement(By.xpath(Next_Button_Second_tab));
    try {
        Next_Button_Second.click();
    } catch (NoSuchWindowException e) {
    }
    }

    public void Fill_LC_Thirdtab_Details(
            String Goods_description, String Documents_description, String Additional_Conditions,
            String Documents_Submit_date, String IncoTerms_Box, String IncoTerms_Lov, String Next_Button_Third_tab) throws IOException {

        WebDriverWait waitThird = new WebDriverWait(driver, Duration.ofSeconds(50));

        //   Goods Description
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Goods_description)));
        WebElement Goods_description_Item = driver.findElement(By.xpath(Goods_description));
        try{
            Goods_description_Item.click();
            Goods_description_Item.clear();
            Goods_description_Item.sendKeys(getvaluesfromconfigfile().getProperty("Goods-Description"));
        }catch (NoSuchWindowException e){
            Goods_description_Item.sendKeys(getvaluesfromconfigfile().getProperty("Goods-Description"));
        }

        //   Documents Description
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Documents_description)));
        WebElement Documents_description_Item = driver.findElement(By.xpath(Documents_description));
        try{
            Documents_description_Item.click();
            Documents_description_Item.clear();
            Documents_description_Item.sendKeys(getvaluesfromconfigfile().getProperty("Documents-Description"));
        }catch (NoSuchWindowException e){
            Documents_description_Item.sendKeys(getvaluesfromconfigfile().getProperty("Documents-Description"));
        }

        //   Additional Conditions
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Additional_Conditions)));
        WebElement Additional_Conditions_Item = driver.findElement(By.xpath(Additional_Conditions));
        try{
            Additional_Conditions_Item.click();
            Additional_Conditions_Item.clear();
            Additional_Conditions_Item.sendKeys(getvaluesfromconfigfile().getProperty("Additional-Condition"));
        }catch (NoSuchWindowException e){
            Additional_Conditions_Item.sendKeys(getvaluesfromconfigfile().getProperty("Additional-Condition"));
        }

        //   Documents tobe presents within after shipment date
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Documents_Submit_date)));
        WebElement Documents_Submit_date_Item = driver.findElement(By.xpath(Documents_Submit_date));
        try{
            Documents_Submit_date_Item.click();
            Documents_Submit_date_Item.clear();
            Documents_Submit_date_Item.sendKeys(getvaluesfromconfigfile().getProperty("Documents-tobe-present-within"));
        }catch (NoSuchWindowException e){
            Documents_Submit_date_Item.sendKeys(getvaluesfromconfigfile().getProperty("Documents-tobe-present-within"));
        }

        // Inco Terms
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IncoTerms_Box)));
        WebElement IncoTerms_Box_Item = driver.findElement(By.xpath(IncoTerms_Box));
        IncoTerms_Box_Item.click();
        WebElement IncoTerms_Lov_Item = driver.findElement(By.xpath(IncoTerms_Lov));
        try {
            List<WebElement> IncoTermsoptions = IncoTerms_Lov_Item.findElements(By.tagName("li"));
            for (WebElement IToption : IncoTermsoptions) {
                if (IToption.getText().equals(getvaluesfromconfigfile().getProperty("Incoterms"))) {
                    IToption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//   Next Button Third Tab
        waitThird.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Next_Button_Third_tab)));
        WebElement Next_Button_Third = driver.findElement(By.xpath(Next_Button_Third_tab));
        try {
            Next_Button_Third.click();
        } catch (NoSuchWindowException e) {
        }

        try {
//                TimeUnit.SECONDS.sleep(5); // Adjust the delay as needed
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void Fill_LC_Fourthtab_Details(String Advising_Bank_Swift, String Advising_Bank_Swift_Verify,String Advising_Bank_NameAdd_Button,
            String SpecialPay_For_Bene, String SpecialPay_For_Bank, String Confirmation_Instruction_Confirm_btn,
            String Confirmation_Instruction_MayConfirm_btn, String Confirmation_Instruction_Without_btn, String Confirmation_Instruction_Request_Confirmation_Box,
            String Confirmation_Instruction_Request_Confirmation_Lov, String Sender_to_receiver_Info, String Charges, String Next_Button_Fourth_tab) throws IOException {

        WebDriverWait waitFourth = new WebDriverWait(driver, Duration.ofSeconds(50));

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");

//        Advising Bank Swift Code
        if (getvaluesfromconfigfile().getProperty("Advising-Bank").contains("Swift Code")) {
            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Advising_Bank_Swift)));
            WebElement Advising_Bank_Swift_Item = driver.findElement(By.xpath(Advising_Bank_Swift));
            WebElement Advising_Bank_Swift_Verify_Item = driver.findElement(By.xpath(Advising_Bank_Swift_Verify));
            try{
                Advising_Bank_Swift_Item.click();
                Advising_Bank_Swift_Item.clear();
                Advising_Bank_Swift_Item.sendKeys(getvaluesfromconfigfile().getProperty("Instructions-AdvisingBank-SwiftCode"));
                Advising_Bank_Swift_Verify_Item.click();
            }catch (NoSuchWindowException e){
                Advising_Bank_Swift_Item.sendKeys(getvaluesfromconfigfile().getProperty("Instructions-AdvisingBank-SwiftCode"));
                Advising_Bank_Swift_Verify_Item.click();
            }
        }else {
            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Advising_Bank_NameAdd_Button)));
            WebElement Advising_Bank_NameAdd_Button_Item = driver.findElement(By.xpath(Advising_Bank_NameAdd_Button));
            try{
                Advising_Bank_NameAdd_Button_Item.click();

            }catch (NoSuchWindowException e){

            }
        }


        //   Additional Conditions
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SpecialPay_For_Bene)));
        WebElement SpecialPay_For_Bene_Item = driver.findElement(By.xpath(SpecialPay_For_Bene));
        try{
            SpecialPay_For_Bene_Item.click();
            SpecialPay_For_Bene_Item.clear();
            SpecialPay_For_Bene_Item.sendKeys(getvaluesfromconfigfile().getProperty("Special-payment-condition"));
        }catch (NoSuchWindowException e){
            SpecialPay_For_Bene_Item.sendKeys(getvaluesfromconfigfile().getProperty("Special-payment-condition"));
        }

        //   Additional Conditions
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SpecialPay_For_Bank)));
        WebElement SpecialPay_For_Bank_Item = driver.findElement(By.xpath(SpecialPay_For_Bank));
        try{
            SpecialPay_For_Bank_Item.click();
            SpecialPay_For_Bank_Item.clear();
            SpecialPay_For_Bank_Item.sendKeys(getvaluesfromconfigfile().getProperty("Special-payment-condition-For-Bank"));
        }catch (NoSuchWindowException e){
            SpecialPay_For_Bank_Item.sendKeys(getvaluesfromconfigfile().getProperty("Special-payment-condition-For-Bank"));
        }

        //        Confirmation Instruction
        if (getvaluesfromconfigfile().getProperty("Confirm-Instruction").contains("Confirm")) {
            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirmation_Instruction_Confirm_btn)));
            waitFourth.until(ExpectedConditions.elementToBeClickable(By.xpath(Confirmation_Instruction_Confirm_btn)));
            WebElement Confirm_btn = driver.findElement(By.xpath(Confirmation_Instruction_Confirm_btn));
            Confirm_btn.click();

            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirmation_Instruction_Request_Confirmation_Box)));
            waitFourth.until(ExpectedConditions.elementToBeClickable(By.xpath(Confirmation_Instruction_Request_Confirmation_Box)));
            WebElement Confirmation_Box = driver.findElement(By.xpath(Confirmation_Instruction_Request_Confirmation_Box));
            Confirmation_Box.click();
            WebElement Confirmation_Lov = driver.findElement(By.xpath(Confirmation_Instruction_Request_Confirmation_Lov));
            try {
                List<WebElement> Confirmationoptions = Confirmation_Lov.findElements(By.tagName("li"));
                for (WebElement CIoption : Confirmationoptions) {
                    if (CIoption.getText().equals(getvaluesfromconfigfile().getProperty("Requested-Confirmation-party"))) {
                        CIoption.click(); // click the desired option
                        break;
                    }
                }
            } catch (NoSuchWindowException e) {
            }
        } else if (getvaluesfromconfigfile().getProperty("Confirm-Instruction").contains("May Confirm")) {
            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirmation_Instruction_MayConfirm_btn)));
            waitFourth.until(ExpectedConditions.elementToBeClickable(By.xpath(Confirmation_Instruction_MayConfirm_btn)));
            WebElement MayConfirm_btn = driver.findElement(By.xpath(Confirmation_Instruction_MayConfirm_btn));
            MayConfirm_btn.click();

            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirmation_Instruction_Request_Confirmation_Box)));
            waitFourth.until(ExpectedConditions.elementToBeClickable(By.xpath(Confirmation_Instruction_Request_Confirmation_Box)));
            WebElement Confirmation_Box = driver.findElement(By.xpath(Confirmation_Instruction_Request_Confirmation_Box));
            Confirmation_Box.click();
            WebElement Confirmation_Lov = driver.findElement(By.xpath(Confirmation_Instruction_Request_Confirmation_Lov));
            try {
                List<WebElement> Confirmationoptions = Confirmation_Lov.findElements(By.tagName("li"));
                for (WebElement CIoption : Confirmationoptions) {
                    if (CIoption.getText().equals(getvaluesfromconfigfile().getProperty("Requested-Confirmation-party"))) {
                        CIoption.click(); // click the desired option
                        break;
                    }
                }
            } catch (NoSuchWindowException e) {
            }
        }else {
            waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Confirmation_Instruction_Without_btn)));
            waitFourth.until(ExpectedConditions.elementToBeClickable(By.xpath(Confirmation_Instruction_Without_btn)));
            WebElement Without_btn = driver.findElement(By.xpath(Confirmation_Instruction_Without_btn));
            Without_btn.click();
        }

        //   Send to receiver Information
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Sender_to_receiver_Info)));
        WebElement Sender_to_receiver_Info_Item = driver.findElement(By.xpath(Sender_to_receiver_Info));
        try{
            Sender_to_receiver_Info_Item.click();
            Sender_to_receiver_Info_Item.clear();
            Sender_to_receiver_Info_Item.sendKeys(getvaluesfromconfigfile().getProperty("Sender-to-Receiver-Information"));
        }catch (NoSuchWindowException e){
            Sender_to_receiver_Info_Item.sendKeys(getvaluesfromconfigfile().getProperty("Sender-to-Receiver-Information"));
        }

        //   Charges
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Charges)));
        WebElement Charges_Item = driver.findElement(By.xpath(Charges));
        try{
            Charges_Item.click();
            Charges_Item.clear();
            Charges_Item.sendKeys(getvaluesfromconfigfile().getProperty("Charges"));
        }catch (NoSuchWindowException e){
            Charges_Item.sendKeys(getvaluesfromconfigfile().getProperty("Charges"));
        }

        //   Next Button Fourth Tab
        waitFourth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Next_Button_Fourth_tab)));
        WebElement Next_Button_Fourth = driver.findElement(By.xpath(Next_Button_Fourth_tab));
        try {
            Next_Button_Fourth.click();
        } catch (NoSuchWindowException e) {
        }

    }

    public void Fill_LC_Fifthtab_Details(String Term_Condition, String Submit, String Review_Screen_Submit){

        WebDriverWait waitFifth = new WebDriverWait(driver, Duration.ofSeconds(50));

        //   Terms And Conditions
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Term_Condition)));
        WebElement Term_Condition_check = driver.findElement(By.xpath(Term_Condition));
        try {
            Term_Condition_check.click();
        } catch (NoSuchWindowException e) {
        }

        //   Submit LC
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Submit)));
        WebElement Submit_btn = driver.findElement(By.xpath(Submit));
        try {
            Submit_btn.click();
        } catch (NoSuchWindowException e) {
        }

        //   Review Screen Submit Button
        waitFifth.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Review_Screen_Submit)));
        WebElement Review_Screen_Submit_btn = driver.findElement(By.xpath(Review_Screen_Submit));
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