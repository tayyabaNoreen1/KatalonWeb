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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//Check logout flow
//condition_logoutPresent = WebUI.verifyElementPresent(option_logout, 0, FailureHandling.OPTIONAL)
condition_myAccountPresent = WebUI.verifyElementPresent(menu_myAccount, 5, FailureHandling.STOP_ON_FAILURE)
condition_logoutPresent = WebUI.verifyElementPresent(menuOption_logout, 5, FailureHandling.OPTIONAL)

if(condition_myAccountPresent) {
	WebUI.mouseOver(menu_myAccount, FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(5)
	if(condition_logoutPresent) {
		KeywordUtil.logInfo('Logout option is present.')
		WebUI.delay(5)
		WebUI.click(menuOption_logout)
	}
	WebUI.delay(5)
	condition_logoutSuccess = WebUI.waitForElementVisible(success_logout, 10, FailureHandling.OPTIONAL)
	if(condition_logoutSuccess)
		KeywordUtil.markPassed('User is logged out successfully.')
	else
		KeywordUtil.markFailedAndStop('Logout failed.')
}
else
	KeywordUtil.markFailedAndStop('Logout option is not present.')

