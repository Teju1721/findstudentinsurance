package policyBazaar.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.base.com.Driver;
import com.base.com.Excel;

import base.object.Travel;
import base.object.Car;
import base.object.Health;

public class TravelInsuranceTest extends Driver {
   // public WebDriver driver;
    private Driver driverSetup;
    public Travel travelPage;
    public Car carPage;
    public Health healthPage;
    private ExtentReports extent;
    private ExtentTest test;
    public Excel data;

    public TravelInsuranceTest() {
	}
    
    public TravelInsuranceTest(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public void Check() throws IOException
    {
    	 driverSetup = new Driver();
         driver = driverSetup.setup();
    }

	@BeforeClass
    public void setUp() throws IOException {
//        
        travelPage = new Travel(driver);
        carPage= new Car(driver);
        healthPage= new Health(driver);
        data= new Excel();
        try {
            data.readData();
        } catch (IOException e) {
            e.printStackTrace();
        }


     // Initialize Extent report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\report\\extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Application", "PolicyBazaar");
        extent.setSystemInfo("TravelInsurance", "Tejasri");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt", "QA");
    }

    @Test(groups = {"sanity"}, priority = 1)
    public void testTravelInsuranceButtonClick() throws InterruptedException {
        test = extent.createTest("testTravelInsuranceButtonClick");
        test.log(Status.INFO, "Clicking on the insurance button");
        
        travelPage.clickTravelButton();

        // Add assert validation to verify that the button click action is successful
        Assert.assertTrue(travelPage.isTravelButtonClicked());
    }

    @Test(groups = {"sanity"}, priority = 2)
    public void testSwitchToChildWindow() throws InterruptedException {
        test = extent.createTest("testSwitchToChildWindow");
        test.log(Status.INFO, "Switching to the child window after clicking on the insurance button");

        // Get the window handles
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the child window
        String childWindowHandle = null;
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                childWindowHandle = windowHandle;
                driver.switchTo().window(childWindowHandle);
                break;
            }
        }

        // Add assert validation to verify that the child window is switched successfully
        Assert.assertNotEquals(childWindowHandle, parentWindowHandle, "Failed to switch to the child window");
    }
    
    @Test(groups = {"sanity"}, priority = 3)
    public void SelectDestination() throws InterruptedException, IOException {
        Excel data = new Excel();
        data.readData();
        String dest = data.Destination;
        test = extent.createTest("SelectDestination");
        test.log(Status.INFO, "Selecting destination");
        Thread.sleep(2000);
        travelPage.searchButton(dest);
        travelPage.searchCountry();
        travelPage.nextButton();

        // Validate if the expected page is reached
        String expectedPageTitle = "PolicyBazaar Travel Insurance"; // Replace with the actual expected page title
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The expected page is not reached");

        // Capture screenshot
        captureScreenshot("SelectDestination");
    }

    @Test(groups = {"sanity"}, priority = 4)
    public void testSelectDate() throws InterruptedException {
        test = extent.createTest("SelectDate");
        test.log(Status.INFO, "Selecting date");

        // Perform actions to select the date
        travelPage.clickDateButton();
        travelPage.selectStartDate();
        travelPage.selectEndDate();
        travelPage.clickProceedToTravellerButton();

        // Validate if the expected page is reached
        String expectedPageTitle = "PolicyBazaar Travel Insurance"; // Replace with the actual expected page title
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The expected page is not reached");

        // Capture screenshot
        captureScreenshot("SelectDate");
    }    
  @Test(groups = {"sanity"}, priority = 5)
  public void testSelectNumberOfTravellers() throws InterruptedException {
            test = extent.createTest("SelectNumberOfTravellers");
            test.log(Status.INFO, "Selecting number of travellers");

            // Perform actions to select the number of travellers
           // Create an instance of the Travel class
            travelPage.clickNumberOfTraveller();
            travelPage.selectDropDown1();
            travelPage.selectAge1();
            travelPage.selectDropDown2();
            travelPage.selectAge2();
            travelPage.NButton();

            // Assert that the number of travellers is selected correctly
            int expectedNumberOfTravellers = 2; 
            int actualNumberOfTravellers = travelPage.getSelectedTravellersCount();
            Assert.assertEquals(actualNumberOfTravellers, expectedNumberOfTravellers, "Number of travellers is not selected correctly");

            // Capture screenshot
            captureScreenshot("SelectNumberOfTravellers");
    }
  @Test(groups = {"sanity"},priority = 6)
  public void ViewPlan() throws InterruptedException {
	  //Thread.sleep(3000);
	  String Mobno=data.MobileNo;  		//Taking data from excel sheet
      test = extent.createTest("ViewPlan");
      test.log(Status.INFO, "Viewing plan");
      //Thread.sleep(3000);           
      // Perform actions to view the plan
      //travelPage.clickPreMedicalCondition();
      travelPage.enterMobileNumber(Mobno);
      travelPage.clickViewPlanButton();

      // Assert that the view plan button is clicked successfully
      Assert.assertTrue(travelPage.isPlanViewed(), "Failed to view the plan");

      // Capture screenshot
      captureScreenshot("ViewPlan");
  }


  @Test(groups = {"sanity"}, priority = 7)
  public void SelectingStudentTrip() throws InterruptedException {
      test = extent.createTest("SelectingStudentTrip");
      test.log(Status.INFO, "Selecting student trip");

      Thread.sleep(2000);

      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,150)", "");

      travelPage.clickStudentTrip();
      Thread.sleep(2000);
      travelPage.clickTraveller1();
      travelPage.clickTraveller2();
      travelPage.Days_no();

      travelPage.clickTripDurationApplyButton();
      Thread.sleep(2000);
      travelPage.clickFilterButton();
      travelPage.clickLowHighPrice();
      // Capture screenshot
      captureScreenshot("SelectingStudentTrip");
  }
@Test(groups = {"sanity"}, priority = 8)
public void InsuranceData() throws InterruptedException {
    test = extent.createTest("InsuranceData");
    test.log(Status.INFO, "Retrieving insurance data");
    Thread.sleep(2000);
    
    // Create a new workbook and sheet
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Insurance Data");
    
    // Create a header row
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Insurance Provider");
    headerRow.createCell(1).setCellValue("Plan Name");
    headerRow.createCell(2).setCellValue("Amount");
    
    // Retrieve and print the insurance data
List<WebElement> planList = driver.findElements(By.xpath("//*[@class='quotesCardWrapper ']"));

 // Create a new workbook and sheet
 Workbook workbook1 = new XSSFWorkbook();
 Sheet sheet1 = workbook1.createSheet("Insurance Data");

 // Create a header row
 Row headerRow1 = sheet1.createRow(0);
 headerRow1.createCell(0).setCellValue("Insurance Provider");
 headerRow1.createCell(1).setCellValue("Plan Name");
 headerRow1.createCell(2).setCellValue("Amount");

 int rowCount = 1;
 for (int i = 0; i <= 2 && i < planList.size(); i++) {
     WebElement plan = planList.get(i);
     String itemText = plan.getText();
     String[] lines = itemText.split("\\n");

     String provider;
     String planName;
     String amount;

     if (i == 0) {
         provider = lines[i == 0 ? 0 : i + 0];
         planName = lines[i == 0 ? 1 : i + 1];
         amount = lines[i == 0 ? 4 : i + 4];
     } else if (i == 1) {
         provider = lines[i == 0 ? 0 : i + 0];
         planName = lines[i == 0 ? 1 : i + 1];
         amount = lines[i == 0 ? 4 : i + 4];
     } else {
         provider = lines[i == 0 ? 0 : i - 1];
         planName = lines[i == 0 ? 1 : i + 0];
         amount = lines[i == 0 ? 4 : i + 3];
     }

     System.out.println("Insurance Provider: " + provider);
     System.out.println("Plan Name: " + planName);
     System.out.println("Amount: " + amount);
     System.out.println("----------------------");

     // Write the insurance data to the Excel sheet
     Row dataRow = sheet1.createRow(rowCount++);
     dataRow.createCell(0).setCellValue(provider);
     dataRow.createCell(1).setCellValue(planName);
     dataRow.createCell(2).setCellValue(amount);
 }

 // Auto-size the columns
 for (int i = 0; i < 3; i++) {
     sheet1.autoSizeColumn(i);
 }

 // Specify the file path
 String filePath = System.getProperty("user.dir") + "\\Excel\\InsuranceData.xlsx";

 // Save the workbook to the specified file path
 try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
     workbook1.write(outputStream);
 } catch (IOException e) {
     e.printStackTrace();
 }

 // Capture screenshot
 captureScreenshot("InsuranceData");

 travelPage.clickHomeButton(); // navigate back to the home page

}
    
@Test(groups = {"sanity"}, priority = 9)

    public void SwitchChild()
    {
    	 // Get the window handles
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the child window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    
@Test(groups = {"sanity"},priority = 10)

    public 	void CarInsurance() throws InterruptedException
    {
    	test = extent.createTest("testCarInsurance");
        test.log(Status.INFO, "Testing car insurance");
        carPage.Website(driver);
        carPage.clickWithoutCarNumber();
        carPage.clickSearchButton();
        carPage.clickRtoButton();
        carPage.clickCarBrandButton();
        carPage.clickCarSearchButton();
        carPage.clickCarSelectButton();
        carPage.clickCarFuelType();
        carPage.clickCarVariant();
      
        // Capture screenshot
        captureScreenshot("testCarInsurance");
    }
@Test(groups = {"sanity"}, priority = 11)
public void fillingForm() throws InterruptedException {
    String name = data.Name;
    String mail = data.Email;
    String mobileno = data.Mobileno2;
    carPage.enterName(name);
    carPage.enterEmail(mail);
    carPage.clickCaptureEmail_Error();
    String Error_message = carPage.CaptureEmail_Error.getText();
    System.out.println(Error_message);
    carPage.clickFillingDetails_MobileNumber(mobileno);
    carPage.clickApplyButton();
    carPage.clickNavigateBackTo_HomePage();

    // Create a new workbook and sheet
    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Form Data");

        // Create a header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Error Message");

        // Write the error message to the Excel sheet
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(Error_message);

        // Auto-size the columns
        sheet.autoSizeColumn(0);

        // Specify the file path
        String filePath = System.getProperty("user.dir") + "\\Excel\\CarData.xlsx";

        // Save the workbook to the specified file path
        try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Capture screenshot
        captureScreenshot("FormData");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

	
@Test(groups = {"sanity"}, priority = 12)
public void HealthInsurance() {
    healthPage.clickMenuButton();
    List<WebElement> healthInsuranceList = Health.HealthMenuList;

    // Extract the text values into a separate list
    List<String> textValues = new ArrayList<>();
    for (WebElement health_insurance : healthInsuranceList) {
        textValues.add(health_insurance.getText());
    }

    // Sort the text values
    Collections.sort(textValues);
    System.out.println("-------------HEALTH INSURANCE MENU LIST--------------- ");
    for (String textValue : textValues) {
        System.out.println(textValue);
        System.out.println();
    }

    // Create a new workbook and sheet
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Health Insurance");

    // Create a header row
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Insurance Data");

    // Write the text values to the Excel sheet
    int rowCount = 1;
    for (String textValue : textValues) {
        Row dataRow = sheet.createRow(rowCount++);
        dataRow.createCell(0).setCellValue(textValue);
    }

    // Auto-size the columns
    sheet.autoSizeColumn(0);

    // Specify the file path
    String filePath = System.getProperty("user.dir") + "\\Excel\\HealthInsuranceData.xlsx";

    // Save the workbook to the specified file path
    try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
        workbook.write(outputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Capture screenshot
    captureScreenshot("HealthInsuranceData");
}

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());
            // Capture screenshot for failed test case
            captureScreenshot(result.getName() + "_failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
            // Capture screenshot for passed test case
            captureScreenshot(result.getName() + "_passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
       Driver.CloseBrowser();

        // Generate the Extent report
        extent.flush();
    }

    private void captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "screenshots/" + screenshotName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
            test.addScreenCaptureFromPath(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
