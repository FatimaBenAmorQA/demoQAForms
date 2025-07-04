package com.e2etests.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtils extends BasePage {

	/** properties. */
	protected Properties properties;

	/** config fis. */
	protected FileInputStream configFis;

	/** driver. */
	private WebDriver driver;

	/**
	 * Instanciation de common utils.
	 */
	public SeleniumUtils()  {
	    super();
	    this.driver = Setup.getDriver();
	    }
	/**
	 * methode Locator value : to locate web element.
s	 * @param locatorTpye String locators
	 * @param value       the locator value
	 * @return byLocator
	 */
	public By locatorValue(String locatorTpye, String value) {
		By byLocator;
		final By obj = null;
		switch (locatorTpye) {
		case "id":
			byLocator = By.id(value);
			break;
		case "name":
			byLocator = By.name(value);
			break;
		case "xpath":
			byLocator = By.xpath(value);
			break;
		case "css":
			byLocator = By.cssSelector(value);
			break;
		case "linkText":
			byLocator = By.linkText(value);
			break;
		case "partialLinkText":
			byLocator = By.partialLinkText(value);
			break;
		default:
			byLocator = obj;
			break;
		}
		return byLocator;
	}

	/**
	 * method to open specified url.
	 *
	 * @param url to open
	 */
	public void get(String url) {
		driver.get(url);
	}
	
	
	
	/**
	 * method to get the current url.
	 *
	 * return current url
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * method to navigate to specified page.
	 *
	 * @param url navigation url
	 */
	public void navigate(String url) {
		driver.navigate().to(url);
	}

	/**
	 * method to click on an element with action class.
	 *
	 * @param element to be clicked
	 */
	public void clickOnElementUsingActions(By element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(Setup.getDriver().findElement(element));
		actions.click().perform();
	}
	
	/**
	 * method to double click on an element with action class.
	 *
	 * @param element to be clicked
	 */
	public void doubleclickOnElementUsingActions(By element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(Setup.getDriver().findElement(element));
		actions.doubleClick().perform();
	}

	/**
	 * method to click on an element using javascript.
	 *
	 * @param element to be clicked
	 */
	public void clickOnElementUsingJs(By element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement webElement = driver.findElement(element);
		jsExecutor.executeScript("arguments[0].click();", webElement);
	}

	/**
	 * Accesseur de l attribut title.
	 *
	 * @return title
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * Accesseur de l attribut page source.
	 *
	 * @return page source
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}

	/**
	 * method to find an element.
	 *
	 * @param locator element to be found
	 * @return WebElement if found else throws NoSuchElementException
	 */
	public WebElement findElement(By locator) {
		try {
			return Setup.getDriver().findElement(locator);
		} catch (NoSuchElementException e) {
			log.error(this.getClass().getName(), "findElement", "Element not found " + locator);
			String message = e.getMessage();
			log.warn(message);
			throw new NoSuchElementException(message);
		}
	}

	/**
	 * method to find all the elements of specific locator.
	 *
	 * @param locator element to be found
	 * @return return the list of elements if found else throws
	 *         NoSuchElementException
	 */
	public List<WebElement> findElements(By locator) {
		try {
			return Setup.getDriver().findElements(locator);
		} catch (NoSuchElementException e) {
			log.error(this.getClass().getName(), "findElements", "element not found" + locator);
			throw new NoSuchElementException(e.getMessage());
		}
	}

	/**
	 * method to accept alert, exception is thrown if no alert is present.
	 */
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	/**
	 * Accesseur de l attribut alert text.
	 *
	 * @return alert text
	 */
	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	/**
	 * methode Wait for element to be clickable.
	 *
	 * @param locator
	 */
	public void waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * method to clear field.
	 *
	 * @param element
	 */
	public void clearField(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			log.info(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}

	/**
	 * Methode click on element.
	 *
	 * @param elementAttr
	 */
	public void click(WebElement elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementToBeClickable(elementAttr);
			driver.findElement((By) elementAttr).click();
		} else {
			elementAttr.click();
		}
	}

	/**
	 * This method is used to click on button.
	 * 
	 * @param locatorType type of locators
	 * @param value       the locator value
	 */
	public void click(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			waitForElementToBeClickable(locator);
			element.click();
		} catch (NoSuchElementException e) {
			log.info("No Element Found to enter text", e);
		}
	}

	/**
	 * This method is used to enter the text by using sendkeys method.
	 * 
	 * @param locatorType that can be id / name / any other locator
	 * @param value       the locator value
	 * @param text        the data that you want to pass into the text field
	 */
	public void writeText(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			clearField(element);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			log.info("No Element Found to enter text", e);
		}
	}

	/**
	 * methode write text.
	 *
	 * @param elementAttr
	 * @param text
	 */
	public void writeText(WebElement elementAttr, String text) {
		if (elementAttr.getClass().getName().contains("By")) {
			clearField(elementAttr);
			driver.findElement((By) elementAttr).sendKeys(text);
		} else {
			clearField(elementAttr);
			elementAttr.sendKeys(text);
		}
	}

	/**
	 * methode read text.
	 *
	 * @param elementAttr
	 * @return string
	 */
	public String readText(WebElement elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			return driver.findElement((By) elementAttr).getText();
		} else {
			return elementAttr.getText();
		}
	}

	/**
	 * methode Auto suggest : Below is the code to select the Option based on the
	 * string passed in the Test. We are List as option can be more than one. By
	 * iterating the list we will select the required option.
	 *
	 * @param elementWeb
	 * @param writeText
	 * @param textToSelect
	 * @throws InterruptedException the interrupted exception
	 */
	public void autoSuggest(WebElement elementWeb, String writeText, String textToSelect) throws InterruptedException {
		// start input in input field
		elementWeb.sendKeys(writeText);
		Thread.sleep(3000);
		waitForElementToBeClickable(elementWeb);
		// get the list of suggestet inputs
		List<WebElement> options = driver.findElements(By.tagName("li"));
		// loop through list of inputs an click specific Text + break out the loop
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(textToSelect)) {
				option.click();
				break;
			}
		}
	}

	/**
	 * methode Switch to new window.
	 *
	 * @param driver
	 * @param iframeId
	 * @return web element
	 */
	public WebElement switchToNewWindow(WebDriver driver, String iframeId) {
		driver.switchTo().frame(iframeId);
		return driver.switchTo().activeElement();
	}

	/**
	 * methode Check radio.
	 *
	 * @param driver
	 * @param by
	 */
	public void checkRadio(WebDriver driver, By by) {
		WebElement inputElement = driver.findElement(by);
		inputElement.click();
	}

	/**
	 * methode Mouse hover.
	 *
	 * @param elementAttr
	 */
	public void mouseHover(WebElement elementAttr) {
		Actions actions = new Actions(driver);

		WebElement mouseHover = elementAttr;

		actions.moveToElement(mouseHover).perform();
	}

	/**
	 * this method is used to close browser.
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * methode Wait for element to be clickable
	 *
	 * @param locator
	 */
	public void waitForElementToBeClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * methode Column contains value.
	 *
	 * @param pathToFile
	 * @param columnIndex
	 * @param targetValue
	 * @return true, si c'est vrai
	 * @throws IOException Signal qu'une execption de type I/O s'est produite.
	 */
	public boolean columnContainsValue(String pathToFile, int columnIndex, String targetValue) throws IOException {

		Reader in = new FileReader(pathToFile);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

		for (CSVRecord record : records) {
			String rowValue = record.get(columnIndex);
			if (targetValue.equals(rowValue))
				return true;
		}
		return false;
	}

	/**
	 * methode Select option with text.
	 *
	 * @param textToSelect
	 * @param elementWeb
	 * @param locator
	 */
	public void selectOptionWithText(String textToSelect, WebElement elementWeb, By locator) {
		try {
			WebElement autoOptions = elementWeb;

			List<WebElement> optionsToSelect = autoOptions.findElements(locator);
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					log.info("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			log.info(e.getStackTrace());
		} catch (Exception e) {
			log.info(e.getStackTrace());
		}
	}

	/**
	 * methode Encoder string : Une méthode pour chiffrer les données.
	 *
	 * @param realStr
	 * @return string
	 */
	public static String encoderString(String realStr) {
		byte[] encodedStr = Base64.getEncoder().encode(realStr.getBytes());
		return (new String(encodedStr));
	}

	/**
	 * methode Decoder string :Une méthode pour déchiffrer les données.
	 *
	 * @param encodedStr
	 * @return string
	 */
	public static String decoderString(String encodedStr) {
		byte[] decoderString = Base64.getDecoder().decode(encodedStr.getBytes());
		return (new String(decoderString));
	}

	/**
	 * method to return to the default frame.
	 *
	 */
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * method to return to the parent frame.
	 *
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public JSONObject JsonData(int i) {

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("./src/test/resources/configs/waitConfig.json"));

			JSONArray array = (JSONArray) obj;
			JSONObject jsonObject = (JSONObject) array.get(i);

			return jsonObject;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
	public long getWait(String waitType) {
	    JSONParser parser = new JSONParser();

	    try {
	        Object obj = parser.parse(new FileReader("./src/test/resources/configs/waitConfig.json"));

	        JSONArray array = (JSONArray) obj;
	        JSONObject jsonObject = (JSONObject) array.get(0); // Supposons un seul objet JSON dans le tableau

	        String waitStr = (String) jsonObject.get(waitType);

	        if (waitStr != null) {
	            return Long.parseLong(waitStr);
	        } else {
	            // Si le type de délai n'est pas valide, vous pouvez renvoyer une valeur par défaut ici
	            return -1; // Ou toute autre valeur par défaut
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return -1; // Valeur par défaut en cas d'erreur
	    } catch (IOException e) {
	        e.printStackTrace();
	        return -1; // Valeur par défaut en cas d'erreur
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return -1; // Valeur par défaut en cas d'erreur
	    }
	}


	/**
	 * A list of methods for managing new tabs.
	 *
	 */
	public void switchToNextTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public void closeAndSwitchToNextTab() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public void closeTabAndReturn() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public void switchToPreviousTabAndClose() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
	}

	

	/**
	 * Switching Window.
	 *
	 */
	public static void switchToWindow(String targetTitle) {
		String origin = Setup.getDriver().getWindowHandle();
		for (String handle : Setup.getDriver().getWindowHandles()) {
			Setup.getDriver().switchTo().window(handle);
			if (Setup.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Setup.getDriver().switchTo().window(origin);
	}

	/**
	 * Return a list of string given a list of Web Element.
	 *
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	/**
	 * Returns the Text of the element given an element locator.
	 *
	 */
	public static List<String> getElementsText(By locator) {
		List<WebElement> elems = Setup.getDriver().findElements(locator);
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	public static void clickWithTimeOut(WebElement element, int timeout) {
		for (int i = 0; i < timeout; i++) {
			try {
				element.click();
				return;
			} catch (WebDriverException e) {
				waitFor(1);
			}
		}
	}
		public static void waitFor(int seconds) {
		    try {
		        Thread.sleep(seconds * 1000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		/**
		 * 
		 * c est pour selectionner une option radio
		 */
		public void clickRadioByLabelText(String labelText, List<WebElement> options) {
		    for (WebElement option : options) {
		        if (option.getText().equalsIgnoreCase(labelText.trim())) {
		            option.click();
		            log.info("Clicked on gender option: " + labelText);
		            break;
		        }
		    }
		}


		/**
		 * Méthode 1 : pour un <select> HTML natif (avec classe Select de Selenium)
		 */
		public void selectMonthByVisibleText(WebElement dropdownElement, String month) {
		    Select select = new Select(dropdownElement);
		    select.selectByVisibleText(month);
		}

		
	}
