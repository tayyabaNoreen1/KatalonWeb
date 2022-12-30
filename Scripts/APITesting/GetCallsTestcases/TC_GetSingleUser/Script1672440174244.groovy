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


response = WS.sendRequest(findTestObject('Object Repository/APITesting/GetCalls/GetSingleUser'), FailureHandling.OPTIONAL)

//Check Status code
conditionStatusCode =WS.verifyResponseStatusCode(response, 200, FailureHandling.OPTIONAL)

if (conditionStatusCode) {
	KeywordUtil.markPassed('Status code is correct.')
}
else {
	KeywordUtil.markFailedAndStop('Status code is incorrect')
}

//Check Schema
conditionSchema = WS.validateJsonAgainstSchema(response, 'Resources/APITesting/GetSingleUser.txt', FailureHandling.OPTIONAL)

if(conditionSchema) {
	KeywordUtil.markPassed('Response schema is correct.')
}
else {
	KeywordUtil.markFailedAndStop('Response schema is incorrect.')
}

//Check Result count
conditionResultCount = WS.verifyElementsCount(response, 'data', 5, FailureHandling.OPTIONAL)

if(conditionResultCount) {
	KeywordUtil.markPassed('Results count is correct.')
}
else {
	KeywordUtil.markError('Result count is incorrect.')
}

//Check Response params
conditionResponseID = WS.verifyElementPropertyValue(response, 'data.id', '2', FailureHandling.OPTIONAL)

if(conditionResponseID) {
	KeywordUtil.markPassed('User ID is correct.')
}
else {
	KeywordUtil.markWarning('User ID is incorrect')
}

conditionResponseEmail = WS.verifyElementPropertyValue(response, 'data.email', 'janet.weaver@reqres.in', FailureHandling.OPTIONAL)

if(conditionResponseEmail) {
	KeywordUtil.markPassed('User Email is correct.')
}
else {
	KeywordUtil.markWarning('User Email is incorrect')
}


conditionResponseFirstName = WS.verifyElementPropertyValue(response, 'data.first_name', 'Janet', FailureHandling.OPTIONAL)

if(conditionResponseFirstName) {
	KeywordUtil.markPassed('User First name is correct.')
}
else {
	KeywordUtil.markWarning('User First name is incorrect')
}

conditionResponseLastName = WS.verifyElementPropertyValue(response, 'data.last_name', 'Weaver', FailureHandling.OPTIONAL)

if(conditionResponseLastName) {
	KeywordUtil.markPassed('User Last name is correct.')
}
else {
	KeywordUtil.markWarning('User Last name is incorrect')
}

conditionResponseAvatar = WS.verifyElementPropertyValue(response, 'data.avatar', 'https://reqres.in/img/faces/2-image.jpg', FailureHandling.OPTIONAL)

if(conditionResponseAvatar) {
	KeywordUtil.markPassed('All user detail is correct.')
}
else {
	KeywordUtil.markWarning('User avatar link is incorrect')
}