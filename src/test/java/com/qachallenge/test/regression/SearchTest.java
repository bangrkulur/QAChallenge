/**
 * 
 */
package com.qachallenge.test.regression;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qachallenge.DashboardDriver;
import com.qachallenge.page.Dashboard;

/**
 * @author kiran
 *
 */
public class SearchTest extends DashboardDriver {
	static Logger log = Logger.getLogger(SearchTest.class);
	//General Tests----------------------------------------------------//
	@Test
	public void searchDisplayed(){
		log.info("Search Test");
		Dashboard.isSearchDisplayed();
	}
	@Test
	public void controlDisplayed(){
		log.info("Control Test");
		Dashboard.isControlDisplayed();
	}
	@Test
	public void statisticsDisplayed(){
		log.info("Statistics Test");
		Dashboard.isStatisticsDisplayed();
	}
	//RECORD DIVISON TESTS-----------------------------------------------------//
	@Test
	public void searchRecordDivisions_1() {
		log.info("Record Divisions Search - Accounting");
		Dashboard.searchRecordsDivison("Accounting");
	}
	@Test
	public void searchRecordDivisions_2() {
		log.info("Record Divisions Search - Administration");
		Dashboard.searchRecordsDivison("Administration");
	}
	@Test
	public void searchRecordDivisions_3() {
		log.info("Record Divisions Search - Marketing");
		Dashboard.searchRecordsDivison("Marketing");
	}
	@Test
	public void searchRecordDivisions_4() {
		log.info("Record Divisions Search - Sales");
		Dashboard.searchRecordsDivison("Sales");
	}
	@Test
	public void searchRecordDivisions_5() {
		log.info("Record Divisions Search - Production");
		Dashboard.searchRecordsDivison("Production");
	}
	//RECORD STATUS TEST--------------------------------------------------------//
	@Test
	public void searchRecordStatus_1() {
		log.info("Record Status Search - New");
		Dashboard.searchRecordsStatus("new");
	}
	@Test
	public void searchRecordStatus_2() {
		log.info("Record Status Search - Archived");
		Dashboard.searchRecordsStatus("archived");
	}
	@Test
	public void searchRecordStatus_3() {
		log.info("Record Status Search - Working");
		Dashboard.searchRecordsStatus("working");
	}
	@Test
	public void searchRecordStatus_4() {
		log.info("Record Status Search - Delivered");
		Dashboard.searchRecordsStatus("delivered");
	}

	//SEARCH BY DATE CREATED OR MODIFIED CREATED ---------------------------------------//
	@Test
	public void searchDateCreated_1() {
		log.info("Date Created Search - 07/17/2015");
		Dashboard.searchbyDate("07/17/2015");
	}
	@Test
	public void searchDateCreated_2() {
		log.info("Date Created Search - 08/03/2015");
		Dashboard.searchbyDate("08/03/2015");
	}
	@Test
	public void searchDateModified_1() {
		log.info("Date Modified Search - 10/02/2015");
		Dashboard.searchbyDate("10/02/2015");
	}
	@Test
	public void searchDateModified_2() {
		log.info("Date Modified Search - 09/17/2015");
		Dashboard.searchbyDate("09/17/2015");
	}
	//SEARCH BY NAME----- ---------------------------------------//
	@Test
	public void searchName_1() {
		log.info("Name Search - 1");
		Dashboard.searchbyName("Brown");
	}
	@Test
	public void searchName_2() {
		log.info("Name Search - 2");
		Dashboard.searchbyName("Snyder");
	}
	@Test
	public void searchName_3() {
		log.info("Name Search - 3");
		Dashboard.searchbyName("Michelle Webb");
	}
	//NEGATIVE TESTS - INVALID INPUT--------------------------//
	@Test
	public void invalidRecordDivisions_1() {
		log.info("Invalid Record Divisions Search - Retired ");
		Dashboard.searchRecordsDivison("Retired");
	}
	@Test
	public void invalidRecordStatus_1() {
		log.info("Invalid Record Status Search - Delayed");
		Dashboard.searchRecordsStatus("delayed");
	}
	@Test
	public void invalidName_1() {
		log.info("Invalid Name Search - 1");
		Dashboard.searchbyName("Arjun");
	}
	public void invalidDateModified_1() {
		log.info("Invalid Date Modified Search - 09/17/1981");
		Dashboard.searchbyDate("09/17/1981");
	}
	@Test
	public void invalidDateCreated_1() {
		log.info("Invalid Date Created Search - 09/17/1980");
		Dashboard.searchbyDate("09/17/1980");
	}
}
