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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement



WebUI.mouseOver(menu_MegaMenu, FailureHandling.STOP_ON_FAILURE)


List<WebElement> menuElements = WebUiCommonHelper.findWebElements(list_MegaMenu, 30)

for(int i=0; i<menuElements.size();i++) {
	
	WebUI.mouseOver(menu_MegaMenu, FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(7)
	String option = menuElements[i].getAttribute('title')
	String expected = menuElements[i].getAttribute('href')
	//System.out.println(menuElements.get(i))
	menuElements.get(i).click()
	WebUI.delay(5)
	String current = WebUI.getUrl()
	if(current == expected)
		KeywordUtil.logInfo("Link for ${option} is correct")
	String currentListHeader = list_pageHeaders[i]
	if(WebUI.verifyElementText(page_header, currentListHeader, FailureHandling.OPTIONAL)) {
		KeywordUtil.logInfo("Correct page ${currentListHeader} for ${option} is opened.")
	}
	WebUI.delay(5)
//	WebUI.refresh()
//	WebUI.delay(5)
//	WebUI.mouseOver(menu_MegaMenu, FailureHandling.STOP_ON_FAILURE)
//	WebUI.delay(2)
	menuElements = WebUiCommonHelper.findWebElements(list_MegaMenu, 30) 
	 //I get error if I dont do this step
	//error is: 'Stale element reference: element is not attached to the page document.'
}


