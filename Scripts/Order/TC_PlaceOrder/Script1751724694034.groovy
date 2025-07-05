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

WebUI.callTestCase(findTestCase('Common/TC_Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Pages/Login/input_username'), 'nurularifin')

WebUI.sendKeys(findTestObject('Pages/Login/input_password'), 'nurularifin')

WebUI.click(findTestObject('Pages/Login/button_login'))

WebUI.delay(4)

WebUI.click(findTestObject('Pages/Products/a_product'))

WebUI.click(findTestObject('Pages/Cart/a_add_to_Cart'))

WebUI.waitForAlert(2)

WebUI.verifyAlertPresent(2)

WebUI.acceptAlert()

WebUI.click(findTestObject('Pages/Cart/a_cart_menu'))

WebUI.click(findTestObject('Pages/Order/button_place_order'))

WebUI.sendKeys(findTestObject('Pages/Order/input_name'), 'Nurul Arifin')

WebUI.sendKeys(findTestObject('Pages/Order/input_country'), 'Indonesia')

WebUI.sendKeys(findTestObject('Pages/Order/input_city'), 'Jakarta')

WebUI.sendKeys(findTestObject('Pages/Order/input_credit_card'), '0942734327')

WebUI.sendKeys(findTestObject('Pages/Order/input_month'), '07')

WebUI.sendKeys(findTestObject('Pages/Order/input_year'), '2025')

WebUI.click(findTestObject('Pages/Order/button_purchase'))

WebUI.click(findTestObject('Pages/Order/button_ok'))

WebUI.delay(3)

WebUI.verifyTextPresent('CATEGORIES', false)

