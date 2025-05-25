package com.e2etests.automation.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class PracticeFormPage {

	/* @FindBy */

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'card') and contains(@class, 'mt-4') and contains(@class, 'top-card')][.//h5[text()='Book Store Application']]")
	public static WebElement bookStoreApplication;

	@FindBy(how = How.XPATH, using = "//img[@src='/images/Toolsqa.jpg']")
	public WebElement Toolsqa;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'header-text') and contains(text(), 'Forms')]")
	public static WebElement leftPannel;

	@FindBy(how = How.XPATH, using = "//ul[@class='menu-list']/li[@id='item-0']//span[text()='Practice Form']")
	public WebElement practiceFormSpan;

	@FindBy(how = How.XPATH, using = "//h1[text()='Practice Form']")
	public WebElement practiceFormTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='header-text' and contains(., 'Forms')]")
	public WebElement Forms;
	
	@FindBy(how = How.ID, using = "firstName")
	public WebElement firstname;
	
	@FindBy(how = How.ID, using = "lastName")
	public WebElement lastname;
	
	@FindBy(how = How.ID, using = "userEmail")
	public WebElement userEmail;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Male']")
	public WebElement OptionMale;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Female']")
	public WebElement OptionFemale;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Other']")
	public WebElement OptionOther;

	@FindBy(how = How.ID, using = "userNumber")
	public WebElement userNumber;
	
	@FindBy(how = How.ID, using = "dateOfBirthInput")
	public WebElement dateOfBirthInput;
	
	@FindBy(how = How.ID, using = "subjectsInput")
	public WebElement subjectsInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Sports']")
	public WebElement sports;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Reading']")
	public WebElement reading;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Music']")
	public WebElement music;
	
	@FindBy(how = How.ID, using = "uploadPicture")
	public WebElement uploadPicture;
	
	@FindBy(how = How.ID, using = "currentAddress")
	public WebElement currentAddress;
	
	@FindBy(how = How.ID, using = "submit")
	public WebElement submitbtn;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Select State']")
	public WebElement selectState;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Select City']")
	public WebElement selectCity;
	
	
	public PracticeFormPage() {
		PageFactory.initElements(Setup.driver, this);
	}

}
