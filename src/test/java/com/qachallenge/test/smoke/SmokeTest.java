/**
 * 
 */
package com.qachallenge.test.smoke;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qachallenge.DashboardDriver;
import com.qachallenge.page.Dashboard;

/**
 * @author kiran
 *
 */
public class SmokeTest extends DashboardDriver {
	static Logger log = Logger.getLogger(SmokeTest.class);
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
	//SEARCH BY DATE CREATED OR MODIFIED CREATED ---------------------------------------//
	@Test
	public void searchDateCreated_1() {
		log.info("Date Created Search - 07/17/2015");
		Dashboard.searchbyDate("07/17/2015");
	}
	@Test
	public void searchDateModified_1() {
		log.info("Date Modified Search - 10/02/2015");
		Dashboard.searchbyDate("10/02/2015");
	}
	//SEARCH BY NAME----- ---------------------------------------//
	@Test
	public void searchName_1() {
		log.info("Name Search - 1");
		Dashboard.searchbyName("Brown");
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
}
