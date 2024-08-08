package Utilities;

public class TradeFinance_Locators {
    public String tradefinance_item = "//a[@alt=\"Trade Finance\"]/descendant::span[@class=\"oj-navigationlist-item-label\"]";
    public String LC_item = "//a[@alt=\"Letter Of Credit / Contract\"]/descendant::span[@class=\"oj-navigationlist-item-label\"]";
    public String import_LC = "//a[@alt=\"Import Letter of Credit / Contract\"]/descendant::span[@class=\"oj-navigationlist-item-label\"]";
    public String Initiate_LC = "//a[@alt=\"Initiate Letter of Credit / Contract\"]/descendant::span[@class=\"oj-navigationlist-item-label\"]";
    public String create_LC = "//oj-button[@id=\"createButton\"]/descendant::span[@class=\"oj-button-text\"]";
    //Create LC - LC/Contract Details Tab
    public String Applicant_Account_forCharges = "//oj-select-one[@value=\"{{account}}\"]/descendant::span[@class=\"oj-select-chosen\"]";
    public String Applicant_Acc_Searchbox = "//div[@id=\"oj-listbox-drop\"]/descendant::input[@title=\"Search field\"]";
    public String Applicant_Acc_Searchbox_itemSearched = "//li[@class=\"oj-listbox-results-depth-1 oj-listbox-result oj-listbox-result-selectable\"]/descendant::div[@class=\"oj-listbox-result-label\"]";
    public String Applicant_Acc_searched_item = "//*[@id=\"oj-listbox-result-label-39\"]";
    public String Applicant_Acc_Select_Branch = "//*[@id=\"oj-select-choice-9\"]/a";
    public String Applicant_Acc_Search_Option_Enable = "//*[@id=\"oj-listbox-drop\"]";
    public String Applicant_Acc_Search_Branch = "//*[@id=\"oj-listbox-drop\"]/div[2]/div/input";
    public String Applicant_Acc_Select_Branch_item = "//*[@id=\"oj-listbox-results-9\"]/li[2]";
    public String Applicant_Div = "//div[@class=\"oj-listbox-result-label\"]/descendant::span[@data-bind=\"text:label\"]";
    public String Applicant_item = "//div[@class=\"oj-listbox-result-label\"]/descendant::span[@data-bind=\"text:label\"]";
    public String Applicant_Address1 = "//div[@class=\"oj-text-field-middle\"]/descendant::*[@id=\"applicantAddressline1|input\"]";
    public String Applicant_Address2 = "//div[@class=\"oj-text-field-middle\"]/descendant::*[@id=\"applicantAddressline2|input\"]";
    public String Applicant_Address3 = "//div[@class=\"oj-text-field-middle\"]/descendant::*[@id=\"applicantAddressline3|input\"]";
    public String Country_Lov = "//*[@id=\"ojChoiceId_applicantCountry_selected\"]";
    public String Country_Item = "//*[@id=\"oj-listbox-drop\"]/div/div/input";
    public String Country_Searched_Item = "//*[@id=\"oj-listbox-results-applicantCountry\"]/li[179]";
    public String Product_type = "//*[@id=\"SelectProduct485507|input\"]";
    public String Product = "//div[@class=\"oj-listbox-drop oj-listbox-drop-above\"]/descendant::ul[@class=\"oj-listbox-results\"]";
    public String selected_product_click = "//div[@id=\"oj-listbox-drop\"]";
//    public String Expiry_date = "//*[@id=\"DateofExpiry6957413|input\"]";
    public String Expiry_date = "//*[@id=\"DateofExpiry6957413\"]/div/span";
//    public String Expiry_date = "//div[@class=\"oj-inputdatetime-input-container oj-text-field-container\"]/descendant::div[@class=\"oj-text-field-middle\"]/descendant::input[@class=\"oj-inputdatetime-input oj-text-field-input oj-component-initnode\"]";
//    public String select_Expiry_date = "//table[@class=\"oj-datepicker-calendar oj-enabled oj-default \"]";
    public String select_Expiry_date = "//*[@id=\"92_oj-datepicker-div\"]";
    public String place_of_expiry = "PlaceofExpiry2128724|input";
    public String beneName = "//div[@class=\"oj-text-field-middle\"]/descendant::*[@id=\"BeneficiaryName6090582|input\"]";
    public String bene_Address1 = "//*[@id=\"Address296078|input\"]";
    public String bene_Address2 = "//*[@id=\"AddressLine25059124|input\"]";
    public String bene_Address3 = "//*[@id=\"AddressLine32484206|input\"]";
    public String bene_Country_Lov = "//*[@id=\"ojChoiceId_Country7808846_selected\"]";
    public String bene_Country_Item = "//*[@id=\"oj-listbox-drop\"]/div/div/input";
    public String bene_Country_Searched_Item = "//*[@id=\"oj-listbox-results-Country7808846\"]/li[179]";
    public String CA_bankAddress_details = "//*[@id=\"BankDetails3929745|input\"]";
}
