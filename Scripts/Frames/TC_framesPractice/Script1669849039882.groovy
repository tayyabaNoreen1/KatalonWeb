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

WebUI.openBrowser('')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.Url)

condition_homPageLoad = WebUI.waitForElementVisible(title_home, 10, FailureHandling.OPTIONAL)

if (condition_homPageLoad) {
    KeywordUtil.logInfo('Home page with iframe is loaded.')

    condition_switchToFrame = WebUI.switchToFrame(frame, 10, FailureHandling.OPTIONAL)

    if (condition_switchToFrame) {
        KeywordUtil.logInfo('Succesfully switched to frame.')

        condition_dragBox = WebUI.verifyElementPresent(dragBox, 10, FailureHandling.OPTIONAL)

        if (condition_dragBox) {
            KeywordUtil.logInfo('Drag box is present.')

            condition_dropBox = WebUI.verifyElementPresent(dropBox, 10, FailureHandling.OPTIONAL)

            if (condition_dropBox) {
                KeywordUtil.logInfo('Drop box is present.')

                WebUI.dragAndDropToObject(dragBox, dropBox, FailureHandling.OPTIONAL)

                condition_textAfterDropping = WebUI.verifyElementText(dropBox, expectedText, FailureHandling.OPTIONAL)
				
				if(condition_textAfterDropping) {
					KeywordUtil.logInfo('Drag drop is completed.')
					condition_switchBackToDefault = WebUI.switchToDefaultContent(FailureHandling.OPTIONAL)
					condition_defaultTitle = WebUI.verifyElementText(title_home, 'Droppable', FailureHandling.OPTIONAL)
					if(condition_defaultTitle) {
						KeywordUtil.markPassed('Switching to iframe and back to default is working.')
					}
					else {
						KeywordUtil.markFailedAndStop('Swtiching back to default is not working.')
					}	
				}
				else {
                    KeywordUtil.markFailedAndStop('Drag drop cannot be completed.')
                }
            } else {
                KeywordUtil.markFailedAndStop('Drag drop cannot be done.')
            }
        } else {
            KeywordUtil.markFailedAndStop('Drag drop cannot be done.')
        }
    } else {
        KeywordUtil.markFailedAndStop('Not swtiched to iframe.')
    }
} else {
    KeywordUtil.markFailedAndStop('Test page not loaded.')
}

