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
                                String Applicant_Account_forCharges, String Applicant_Acc_Searchbox,
                                String Applicant_Acc_Searchbox_itemSearched, String Applicant_Acc_Searched_item
            ,String Applicant_Acc_Select_Branch,
                                String Applicant_Acc_Search_Branch, String Applicant_Acc_Search_Option_Enable,
                                String Applicant_Acc_Select_Branch_item, String Applicant_item, String Applicant_Div,
                                 String Applicant_Address1, String Applicant_Address2, String Applicant_Address3,
                                String Country_Lov, String Country_Item, String Country_Searched_Lov, String Product_type,
                                String Product, String selected_product_click,String expiry_Date, String select_Expiry_date,
                                String Expiry_date_element, String place_of_expiry, String beneName,
                                String bene_Address1, String bene_Address2, String bene_Address3,
                                String bene_Country_Lov, String bene_Country_Item, String bene_Country_Searched_Item,String CA_bankAddress_details,
                                String Next_Button_First_Tab, String partialShipment_1, String partialShipment_2,
                                 String partialShipment_3, String partialShipment_4,String CreditAvailedBy_Box, String CreditAvailedBy_list) throws IOException {
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
            for (WebElement option : options)
            {
                if (option.getText().equals(getvaluesfromconfigfile().getProperty("LCBranch")))
                {
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
            for (WebElement Aoption : Applicantoptions)
            {
                if (Aoption.getText().equals(getvaluesfromconfigfile().getProperty("Applicant")))
                {
                    Aoption.click(); // click the desired option
                    break;
                }
            }
        } catch (NoSuchWindowException e) {
        }

        //   Address1
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address1)));
            WebElement address_element = driver.findElement(By.xpath(Applicant_Address1));
            try{
                address_element.click();
                address_element.clear();
                address_element.sendKeys(getvaluesfromconfigfile().getProperty("Address1"));
            }catch (NoSuchWindowException e){
                address_element.sendKeys(getvaluesfromconfigfile().getProperty("Address1"));
            }

        //   Address2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address2)));
        WebElement address_element2 = driver.findElement(By.xpath(Applicant_Address2));
        try{
            address_element2.click();
            address_element2.clear();
            address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Address2"));
        }catch (NoSuchWindowException e){
            address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Address2"));
        }

        //   Address3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Applicant_Address3)));
        WebElement address_element3 = driver.findElement(By.xpath(Applicant_Address3));
        try{
            address_element3.click();
            address_element3.clear();
            address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Address3"));
        }catch (NoSuchWindowException e){
            address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Address3"));
        }

        //Country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Country_Lov)));
        WebElement A_Country_Lov = driver.findElement(By.xpath(Country_Lov));
        A_Country_Lov.click();
        WebElement A_Country_Searched_Item = driver.findElement(By.xpath(Country_Searched_Lov));
        try {
            List<WebElement> Countryoptions = A_Country_Searched_Item.findElements(By.tagName("li"));
            for (WebElement Coption : Countryoptions)
            {
                if (Coption.getText().equals(getvaluesfromconfigfile().getProperty("Country")))
                {
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
            for (WebElement Poption : Productoptions)
            {
                if (Poption.getText().contains(getvaluesfromconfigfile().getProperty("Product")))
                {
                    Poption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Place of Expiry
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(place_of_expiry)));
        WebElement place_of_expiry_Element = driver.findElement(By.id(place_of_expiry));
        place_of_expiry_Element.click();
        try {
            place_of_expiry_Element.sendKeys(getvaluesfromconfigfile().getProperty("PlaceofExpiry"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Expiry Date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expiry_Date)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(expiry_Date)));
        WebElement expirydate_Element = driver.findElement(By.xpath(expiry_Date));
        expirydate_Element.click();
        expirydate_Element.sendKeys(getvaluesfromconfigfile().getProperty("Date-of-Expiry"));
        if (getvaluesfromconfigfile().getProperty("Beneficiary-Details").contains("New")){

        //   59 Bene Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(beneName)));
        WebElement beneName_element = driver.findElement(By.xpath(beneName));
        try{
            beneName_element.click();
            beneName_element.clear();
            beneName_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Name"));
        }catch (NoSuchWindowException e){
            beneName_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Name"));
        }

        //   Bene Address1
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address1)));
        WebElement bene_address_element = driver.findElement(By.xpath(bene_Address1));
        try{
            bene_address_element.click();
            bene_address_element.clear();
            bene_address_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address"));
        }catch (NoSuchWindowException e){
            bene_address_element.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address"));
        }

        //   Bene Address2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address2)));
        WebElement bene_address_element2 = driver.findElement(By.xpath(bene_Address2));
        try{
            bene_address_element2.click();
            bene_address_element2.clear();
            bene_address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
        }catch (NoSuchWindowException e){
            bene_address_element2.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address2"));
        }

        //   Bene Address3
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bene_Address3)));
        WebElement bene_address_element3 = driver.findElement(By.xpath(bene_Address3));
        try{
            bene_address_element3.click();
            bene_address_element3.clear();
            bene_address_element3.sendKeys(getvaluesfromconfigfile().getProperty("Beneficiary-Address3"));
        }catch (NoSuchWindowException e){
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
            for (WebElement BCoption : BeneCoptions)
            {
                if (BCoption.getText().equals(getvaluesfromconfigfile().getProperty("Beneficiary-Country")))
                {
                    BCoption.click(); // click the desired option
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }else {


        }

        // Credit Availed By
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreditAvailedBy_Box)));
        WebElement Credit_div = driver.findElement(By.xpath(CreditAvailedBy_Box));
        Credit_div.click();
        WebElement CreditAvailedBy_listElement = driver.findElement(By.xpath(CreditAvailedBy_list));
        try {
            List<WebElement> CreditAvailedoptions = CreditAvailedBy_listElement.findElements(By.tagName("li"));
            for (WebElement CAoption : CreditAvailedoptions)
            {
                if (CAoption.getText().contains(getvaluesfromconfigfile().getProperty("Credit-Available-By")))
                {
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
        try{
            CA_bankAddress.click();
            CA_bankAddress.clear();
            CA_bankAddress.sendKeys(getvaluesfromconfigfile().getProperty("Credit-Available-With-Bank-Address"));
        }catch (NoSuchWindowException e){
            CA_bankAddress.sendKeys(getvaluesfromconfigfile().getProperty("Credit-Available-With-Bank-Address"));
        }

        //   Next Button First Tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Next_Button_First_Tab)));
        WebElement Next_Button = driver.findElement(By.xpath(Next_Button_First_Tab));
        try{
            Next_Button.click();
              }catch (NoSuchWindowException e){
                  }


//        Second Tab
        //Partial Shipment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partialShipment_1)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(partialShipment_1)));
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