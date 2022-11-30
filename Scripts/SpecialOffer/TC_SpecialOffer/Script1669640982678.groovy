import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


WebDriver driver = DriverFactory.getWebDriver()

Actions act = new Actions(driver)

condition_menuOption = WebUI.waitForElementVisible(menu_special, 10, FailureHandling.OPTIONAL)

if(condition_menuOption) {
	WebUI.click(menu_special)
	condition_pageLoaded = WebUI.waitForElementVisible(title_SpecialOffer, 10, FailureHandling.OPTIONAL)
	if(condition_pageLoaded) {
		KeywordUtil.logInfo('Special offer page is loaded.')
		List<WebElement> itemThumbnails = WebUiCommonHelper.findWebElements(items, 30)
		List<WebElement> cartIcons = WebUiCommonHelper.findWebElements(button_cart, 30)
		List<WebElement> claims = WebUiCommonHelper.findWebElements(claim, 30)
		List<WebElement> itemTitles = WebUiCommonHelper.findWebElements(titles_items, 30)
		List<String> itemsText = []
		int claimIndex = 0
		for(int i=0; i<itemThumbnails.size(); i++) {
			itemsText.add(itemTitles.get(i).getText())
			if(itemThumbnails.get(i).findElements(By.className('claimed')).size()!=0){
				KeywordUtil.logInfo("Claim is present for ${itemsText[i]}.")
				String percentageText = claims[claimIndex].getText().split('%')[0]
				int percentageValue = Integer.parseInt(percentageText)
				if(percentageValue > 40) {
					KeywordUtil.logInfo("${itemsText[i]} is added to list.")
					act.moveToElement(itemThumbnails.get(i)).build().perform()
					WebUI.delay(3)
					act.click(cartIcons.get(i)).build().perform()
					WebUI.delay(3)
				}
				claimIndex += 1
			}
			else {
				KeywordUtil.logInfo("Claim not present for ${itemsText[i]}.")
			}
			
		}
		condition_cartPageButton = WebUI.waitForElementVisible(button_cartPage, 10, FailureHandling.OPTIONAL)
		if(condition_cartPageButton) {
			WebUI.click(button_cartPage)
			condition_cartDrawer = WebUI.waitForElementVisible(cartDrawer, 10, FailureHandling.OPTIONAL)
			if(condition_cartDrawer) {
				KeywordUtil.logInfo('Cart drawer opened.')
				if(WebUI.verifyElementVisible(button_editCart, FailureHandling.OPTIONAL)) {
					WebUI.click(button_editCart)
					if(WebUI.waitForElementVisible(breadcrumb_cartPage, 10, FailureHandling.OPTIONAL)) {
						List<WebElement> tableCartItems = WebUiCommonHelper.findWebElements(items_cartTable, 30)
						for(int j=0; j<tableCartItems.size(); j++) {
							String text = tableCartItems.get(j).getText()
							if (itemsText.contains(text)) {
								KeywordUtil.logInfo("${text} is present in cart.")
							}
							else {
								KeywordUtil.markFailedAndStop('Item is missing from cart')
							}
						}
						KeywordUtil.markPassed('Items with claim more than 40% are present in cart.')
					}
				}
			}
			else {
				KeywordUtil.markFailed('Cart drawer is not opened.')
			}
		}
		
		else {
			KeywordUtil.markFailed('Cart page button is missing.')
		}
		
	}
	else {
		KeywordUtil.markFailedAndStop('Special offer page is not loading.')
	}
}
else {
	KeywordUtil.markFailedAndStop('Special offer option is not present in menu.')
}

