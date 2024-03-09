package stepDefination;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.base.com.Driver;

import base.object.Car;
import base.object.Health;
import base.object.Travel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import policyBazaar.test.TravelInsuranceTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TravelInsuranceStepDefinitions extends Driver {
    public TravelInsuranceTest test;
    public Travel tr;
    public Car cr;
    public Health hl;
    public ExtentReports extent;
    public ExtentTest extentTest;

    public void initializeTest() throws IOException {
       test = new TravelInsuranceTest(driver);
        tr = new Travel(driver);
        cr= new Car(driver);
        hl= new Health(driver);
        test.setUp();
    }

    public void setupExtentReports() {
        // Initialize the extent reports object
        extent = new ExtentReports();
        // Other setup code for extent reports
    }

    @Given("I am on the travel insurance website")
    public void i_am_on_the_travel_insurance_website() throws IOException, InterruptedException {
        Driver driversetup = new Driver();
        driversetup.setup();
        initializeTest();
    }

    @When("I click for travel insurance plan for students")
    public void searchForStudentTravelInsurance() throws IOException, InterruptedException {
        initializeTest(); 
        // Initialize the test object
        test.testTravelInsuranceButtonClick();
        test.testSwitchToChildWindow();
       test.SelectDestination();
        test.testSelectDate();
    }

    @When("I select the option for {int} student people \\(Age {int}, {int}) traveling to any European country")
    public void i_select_the_option_for_student_people_age_traveling_to_any_european_country(Integer int1, Integer int2, Integer int3) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	test.testSelectNumberOfTravellers();
      
    }

    @When("I fill in further dummy details")
    public void fillInDummyDetails() throws InterruptedException {
        // Implementation for filling in dummy details
    	test.ViewPlan();
    }

    @Then("I should see the three lowest international travel insurance plans with their amounts and insurance provider companies")
    public void verifyLowestInsurancePlans() throws InterruptedException {
        // Implementation for verifying lowest insurance plans
    	test.SelectingStudentTrip();
    	test.InsuranceData();
    	test.SwitchChild();
    }

    @Given("I am on the car insurance section of the website")
    public void iAmOnCarInsuranceSection() throws InterruptedException, IOException {
        // Implementation for navigating to the car insurance section
    	initializeTest(); 
    	test.CarInsurance();
    	
    }

    @When("I proceed without entering the car number")
    public void proceedWithoutCarNumber() {
        // Implementation for proceeding without entering car number
    }

    @When("I fill in the required details")
    public void fillInRequiredDetails() throws InterruptedException {
        // Implementation for filling in required details
    	test.fillingForm();
    	
    }

    @When("I provide an invalid email or phone number")
    public void provideInvalidContactDetails() {
        // Implementation for providing invalid contact details
    }

    @Then("I should capture the error message displayed")
    public void captureErrorMessage() {
    	test.HealthInsurance();
    }

    @Given("I am on the health insurance section of the website")
    public void iAmOnHealthInsuranceSection() throws IOException {
    	
    }

    @When("I retrieve all the health insurance menu items")
    public void retrieveHealthInsuranceMenuItems() throws IOException {
        // Implementation for retrieving health insurance menu items
    	
    }

    @Then("I should display the retrieved menu items")
    public void displayRetrievedMenuItems() throws IOException {
        // Implementation for displaying retrieved menu items
    	initializeTest(); 
    	test.tearDown();
    }
}
