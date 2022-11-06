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

//Check page login page is loading
WebUI.openBrowser('')
WebUI.deleteAllCookies()
WebUI.navigateToUrl(GlobalVariable.Url)
condition_pageLoad = WebUI.waitForElementVisible(header_loginPage, 10, FailureHandling.OPTIONAL)
if(condition_pageLoad)
	KeywordUtil.logInfo('Login page loaded successfully.')
else
	KeywordUtil.markFailedAndStop('Login page is not loading.')

//Check username field is present
condition_usernamePresent = WebUI.verifyElementVisible(input_email, FailureHandling.OPTIONAL)	
if(condition_usernamePresent) {
	KeywordUtil.logInfo('Username field is present.')
	WebUI.setText(input_email, username)
}
else
	KeywordUtil.markFailedAndStop('Username field is missing.')
	
//Check password field is present
condition_passwordPresent = WebUI.verifyElementVisible(input_password, FailureHandling.OPTIONAL)
if(condition_passwordPresent) {
	KeywordUtil.logInfo('Password field is present.')
	WebUI.setText(input_password, password)
}
else
	KeywordUtil.markFailedAndStop('Password field is missing.')
	
//Check Login button is present
condition_loginButtonPresent = WebUI.verifyElementVisible(button_login, FailureHandling.OPTIONAL)
if(condition_loginButtonPresent) {
	KeywordUtil.logInfo('Login button is present.')
	WebUI.click(button_login)
}
else
	KeywordUtil.markFailedAndStop('Login button is missing.')
	
//Check successfull login
condition_loginSuccess = WebUI.waitForElementVisible(header_myAccount, 10, FailureHandling.OPTIONAL)
if(condition_loginSuccess)
	KeywordUtil.markPassed('Login flow is working.')
else
	KeywordUtil.markFailedAndStop('Login is not working.')



