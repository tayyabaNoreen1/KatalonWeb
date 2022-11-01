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


	
//Check Edit info option present
condition_editInfoPresent = WebUI.verifyElementVisible(button_editInfo, FailureHandling.OPTIONAL)
if(condition_editInfoPresent) {
	KeywordUtil.logInfo('Edit info button is present.')
	WebUI.click(button_editInfo)
}
else
	KeywordUtil.markFailedAndStop('Edit info button is missing.')
	
//Check Edit info page loaded
condition_editInfoPageLoad = WebUI.waitForElementVisible(header_editInfo, 10, FailureHandling.OPTIONAL)
if(condition_editInfoPageLoad)
	KeywordUtil.logInfo('Edit user info page loaded successfully.')
else
	KeywordUtil.markFailedAndStop('Edit user info page is not loading.')

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
	
//Check Continue button is present
condition_continueButtonPresent = WebUI.verifyElementVisible(button_continue, FailureHandling.OPTIONAL)
if(condition_continueButtonPresent) {
	KeywordUtil.logInfo('Continue button is present.')
	WebUI.click(button_continue)
}
else
	KeywordUtil.markFailedAndStop('Cannot save user info.')

//Check success message after update profile
condition_successMessageVisible = WebUI.waitForElementVisible(success_updateUser, 10, FailureHandling.OPTIONAL)
if(condition_successMessageVisible) {
	KeywordUtil.logInfo('Success message is displayed.')
	condition_successMessageText = WebUI.verifyElementText(success_updateUser, text_successUpdateUser, FailureHandling.OPTIONAL)
	if(condition_successMessageText) {
		KeywordUtil.logInfo('Success message text is correct.')
	}
	else
		KeywordUtil.markError('Success message text is incorrect.')
	
	if(condition_editInfoPresent) {
		KeywordUtil.logInfo('Edit info button is present.')
		WebUI.click(button_editInfo)
	}
	else
		KeywordUtil.markFailedAndStop('Edit info button is missing.')
	
	condition_firstNameMatch = WebUI.verifyElementAttributeValue(input_firstName, 'value', firstName, 0, FailureHandling.OPTIONAL)
	condition_lastNameMatch = WebUI.verifyElementAttributeValue(input_lastName, 'value', lastName, 0, FailureHandling.OPTIONAL)
	condition_telephoneMatch = WebUI.verifyElementAttributeValue(input_telephone, 'value', telephone, 0, FailureHandling.OPTIONAL)
	if(condition_firstNameMatch&&condition_lastNameMatch&&condition_telephoneMatch) {
		KeywordUtil.markPassed('User info is updated successfully.')
	}
	else if((!condition_firstNameMatch)&&condition_lastNameMatch&&condition_telephoneMatch) {
		KeywordUtil.markFailedAndStop('First name is not updated.')
	}
	else if(condition_firstNameMatch&&(!condition_lastNameMatch)&&condition_telephoneMatch) {
		KeywordUtil.markFailedAndStop('Last name is not updated.')
	}
	else if(condition_firstNameMatch&&condition_lastNameMatch&&(!condition_telephoneMatch)) {
		KeywordUtil.markFailedAndStop('Telephone is not updated.')
	}
}
else
	KeywordUtil.markWarning('Update profile success message is not displayed.')


