package database

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

import internal.GlobalVariable
import groovy.sql.Sql
import java.sql.*

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
//import com.kms.katalon.core.annotation.Keyword
import com.mysql.cj.jdbc.Driver

public class methods {
	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */
	//Establishing a connection to the DataBase
	@Keyword

	def connectDB(String url, String dbname, String port, String username, String password) {
		//Load driver class for your specific database type
		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname
		//Class.forName("org.sqlite.JDBC")
		//String connectionString = "jdbc:sqlite:" + dataFile
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */
	//Executing the constructed Query and Saving results in resultset
	@Keyword

	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	//execute update a SQL query on database
	@Keyword

	def executeUpdate(String queryString) {
		Statement stm = connection.createStatement()
		stm.executeUpdate(queryString)
	}

	@Keyword

	def updateRefNum(){
		executeUpdate("UPDATE tbl_rrn SET rrn = LAST_INSERT_ID(rrn+1) WHERE id = 1")
		ResultSet refnum = executeQuery("SELECT * FROM tbl_rrn WHERE id = 1")
		refnum.next()
		String updatedRefnum = refnum.getString('rrn')
		return updatedRefnum
	}


	//Closing the connection
	@Keyword

	def closeDatabaseConnection() {
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	@Keyword

	def execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}
}