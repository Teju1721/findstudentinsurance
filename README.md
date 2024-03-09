
# Travel Insurance Plan for Students

This document provides an overview of the features and scenarios covered in the "Travel Insurance Plan for Students" feature.


# Scenario 1: Find and Display Three Lowest International Travel Insurance Plans

# Scenario 2: Get a Car Insurance Quote and Capture Error Message

# Scenario 3: Retrieve and Display Health Insurance Menu Items


## Tech Stack

- Java (MAVEN project)
- SELENIUM 4.17.0
- TestNG 7.4.0
- Eclipse 2023-12 (4.30.0)
- Extent Reports 5.1.1


## Folder Structure

```bash
 - src/test/java
 Package 1 : base.objects
   Class 1 : Car.java
   Class 2 : Health.java
   Class 3 : Travel.java
   
 Package 2 : com.base.com
   Class 1 : Driver.java
   Class 2 : Excel.java

 
  Package 3 : policyBazaar.test
    Class 1 :CucumberTestRunner.java
    Class 2 : TravelinsuranceTest.java
 Package  4 : stepDefination
    Class 1 : TravelinsuranceStepDefinitions.java
    
```bash
- src/test/resources/Features
    feature file : Policy.feature
    
- src/test/resources/Testdata
	config.properties
	log4j2.properties
	logj2.xml
	Traveldata.xlxs	

- Student_insurance_Project_cucumber/Excel
	CarData.xlsx
	HealthInsuranceData.xlsx
	InsuranceData.xlsx
	
## Test Cases

There are total 4 Test Cases

```bash
  Test Case 1 : Find and Display Three Lowest International Travel Insurance Plans
```
```bash
  Test Case 2 : Get a Car Insurance Quote and Capture Error Message 
```
```bash
  Test Case 3 : Retrieve and Display Health Insurance Menu Items
```
```bash
  Test Case 4 : Closing all the instances of the webDriver and closing the Website
```

## Report and Screenshots

- Extent Report ( \report\extent-report.html)
- Screenshots

## Author

- Tejasri (2303781)