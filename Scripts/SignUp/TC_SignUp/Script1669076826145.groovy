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

CustomKeywords.'Utility.homePageLoad'(header_loginPage)

condition_pageLoad = WebUI.waitForElementVisible(link_registerPage, 10, FailureHandling.OPTIONAL)

if(condition_pageLoad) {
	WebUI.click(link_registerPage)
	condition_signUpPageLoad = WebUI.waitForElementVisible(header_signUpPage, 10, FailureHandling.OPTIONAL)
	if(condition_signUpPageLoad) {
		
		//Check first name field present
		condition_firstNamePresent = WebUI.verifyElementVisible(input_firstName, FailureHandling.OPTIONAL)
		if(condition_firstNamePresent) {
			KeywordUtil.logInfo('First name field is present.')
			WebUI.setText(input_firstName, firstName)
		}
		else
			KeywordUtil.markError('First name field is missing.')
			
		//Check last name field present
		condition_lastNamePresent = WebUI.verifyElementVisible(input_lastName, FailureHandling.OPTIONAL)
		if(condition_lastNamePresent) {
			KeywordUtil.logInfo('Last name field is present.')
			WebUI.setText(input_lastName, lastName)
		}
		else
			KeywordUtil.markError('Last name field is missing.')
			
		//Check email field is present
		condition_emailPresent = WebUI.verifyElementVisible(input_email, FailureHandling.OPTIONAL)
		if(condition_emailPresent) {
			KeywordUtil.logInfo('Email field is present.')
			WebUI.setText(input_email, email)
		}
		else
			KeywordUtil.markError('Email field is missing.')
			
		//Check telephone field present
		condition_telephonePresent = WebUI.verifyElementVisible(input_telephone, FailureHandling.OPTIONAL)
		if(condition_telephonePresent) {
			KeywordUtil.logInfo('Telephone field is present.')
			WebUI.setText(input_telephone, telephone)
		}
		else
			KeywordUtil.markError('Telephone field is missing.')
			
		//Check password field present
		condition_passwordPresent = WebUI.verifyElementVisible(input_password, FailureHandling.OPTIONAL)
		if(condition_passwordPresent) {
			KeywordUtil.logInfo('Password field is present.')
			WebUI.setText(input_password, password)
		}
		else
			KeywordUtil.markError('Password field is missing.')
			
		//Check confirm password field present
		condition_confirmPasswordPresent = WebUI.verifyElementVisible(input_confirmPassword, FailureHandling.OPTIONAL)
		if(condition_confirmPasswordPresent) {
			KeywordUtil.logInfo('Confirm password field is present.')
			WebUI.setText(input_confirmPassword, confirmPassword)
		}
		else
			KeywordUtil.markError('Confirm password field is missing.')
			
		//Check checkbox present
		condition_checkboxPresent = WebUI.verifyElementVisible(input_checkbox, FailureHandling.OPTIONAL)
		if(condition_checkboxPresent) {
			KeywordUtil.logInfo('Checkbox is present.')
			WebUI.scrollToElement(input_checkbox, 10, FailureHandling.OPTIONAL)
			WebUI.click(input_checkbox)
		}
		else
			KeywordUtil.markError('Checkbox is missing.')
			
			
		//Check submit button present
		condition_submitPresent = WebUI.verifyElementVisible(button_continue, FailureHandling.OPTIONAL)
		if(condition_submitPresent) {
			KeywordUtil.logInfo('Continue button is present.')
			WebUI.click(button_continue)
			condition_successRegister = WebUI.waitForElementVisible(success_signUp, 10, FailureHandling.OPTIONAL)
			if(condition_successRegister) {
				KeywordUtil.logInfo('Sign up success message is displayed.')
			}
		}
		else
			KeywordUtil.markFailedAndStop('Continue button is missing.')
	}
	else {
		KeywordUtil.markFailedAndStop('Register page is not loading.')
	}
}
else
	KeywordUtil.markFailedAndStop('Register link is not present.')