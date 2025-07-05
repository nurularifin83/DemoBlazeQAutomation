import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.logging.KeywordLogger

class CustomeListeners {
	
	def keywordLogger = new KeywordLogger()
	def dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
	
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		keywordLogger.logInfo("Starting Test Case: " + testCaseContext.getTestCaseId())
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		keywordLogger.logInfo("Finished Test Case: " + testCaseContext.getTestCaseId() + " - Status: " + testCaseContext.getTestCaseStatus())
		
		if(testCaseContext.getTestCaseStatus().equalsIgnoreCase("PASSED")) {
			println "Test case passed: " + testCaseContext.getTestCaseId()
		} else {
			println "Test case failed: " + testCaseContext.getTestCaseId()
		}
	}
	
	@AfterTestCase
	def afterTestCaseSkipped(TestCaseContext testCaseContext) {
		keywordLogger.logInfo("Test Case Skipped: " + testCaseContext.getTestCaseId())
		WebUI.closeBrowser()
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		keywordLogger.logInfo("Starting Test Suite: " + testSuiteContext.getTestSuiteId())
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		keywordLogger.logInfo("Finished Test Suite: " + testSuiteContext.getTestSuiteId())
	}
}