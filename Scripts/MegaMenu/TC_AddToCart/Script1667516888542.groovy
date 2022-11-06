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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.maximizeWindow()

WebDriver driver = DriverFactory.getWebDriver()

String[] itemNeeded = ['iPod Shuffle', 'MacBook']

Actions act = new Actions(driver)

WebUI.mouseOver(menu_MegaMenu, FailureHandling.STOP_ON_FAILURE)

condition_menuApple = WebUI.waitForElementVisible(menuOption_Apple, 10, FailureHandling.OPTIONAL)

if (condition_menuApple) {
	KeywordUtil.logInfo('Apple option is present in Menu.')
	WebUI.click(menuOption_Apple, FailureHandling.STOP_ON_FAILURE)
	condition_pageApple = WebUI.waitForElementVisible(page_Apple, 10, FailureHandling.OPTIONAL)
	if (condition_pageApple) {
		KeywordUtil.logInfo('Apple product page opened successfully.')
		
				List<WebElement> menuElementsText = WebUiCommonHelper.findWebElements(items_AppleTitle, 30)
				List<WebElement> menuElementsThumbnail = WebUiCommonHelper.findWebElements(items_AppleThumbnail, 30)
				List<WebElement> cartIcons = WebUiCommonHelper.findWebElements(carts, 30)
				
				for (int i = 0; i < menuElementsText.size(); i++) {
					if (itemNeeded.contains(menuElementsText.get(i).getText())) {
						KeywordUtil.logInfo('Required item found.')
						act.moveToElement(menuElementsThumbnail.get(i)).build().perform()
						WebUI.delay(3)
						act.click(cartIcons.get(i)).build().perform()
						String text = WebUI.getText(text_cartCount)
						if(itemNeeded.size()==Integer.valueOf(text)) {
							KeywordUtil.markPassed('All items added to cart')
							break;
						}
					}}
	}
	else {
	KeywordUtil.markFailedAndStop('Apple product page is not loaded.')
	}
}

