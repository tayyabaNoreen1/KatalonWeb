import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

public class Utility {

	@Keyword
	public void homePageLoad(TestObject header_loginPage) {
		WebUI.openBrowser('')
		WebUI.deleteAllCookies()
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.Url)
		boolean condition_pageLoad = WebUI.waitForElementVisible(header_loginPage, 10, FailureHandling.OPTIONAL)
		if(condition_pageLoad) {
			GlobalVariable.homeLoaded = true
			KeywordUtil.logInfo('Home page loaded successfully.')
		}
		else
			KeywordUtil.markFailedAndStop('Home page is not loading.')
	}

	@Keyword
	public void editProfile(TestObject button_editInfo) {
		boolean condition_editInfoPresent = WebUI.verifyElementVisible(button_editInfo, FailureHandling.OPTIONAL)
		if(condition_editInfoPresent) {
			KeywordUtil.logInfo('Edit info button is present.')
			WebUI.click(button_editInfo)
		}
		else
			KeywordUtil.markFailedAndStop('Edit info button is missing.')
	}
}
