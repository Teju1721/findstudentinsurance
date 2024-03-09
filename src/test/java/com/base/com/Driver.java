package com.base.com;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Driver {
	public Logger logger;
	public Properties p;

	public static WebDriver driver;

	@BeforeClass(groups = { "sanity" })
	public WebDriver setup() throws IOException {
		// loading properties file
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\config.properties");
		p = new Properties();
		p.load(file);
		

		logger = LogManager.getLogger(this.getClass());// Log4j

		driver = new ChromeDriver();
		
		  /*Scanner sc=new Scanner(System.in); 
		  System.out.println("Choose your Browser");
		  System.out.println("1. Chrome Browser");
		  System.out.println("2. Edge Browser");
		  System.out.print("Enter your choice : ");
		  String c=sc.nextLine(); 
		  sc.close();
		 if(c.equalsIgnoreCase("1")) {
		 
			 driver = new ChromeDriver();
		
		  } 
		 else { 
			 
			 driver=new EdgeDriver();
			 }
		 */
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

		return driver;
	}

	public static void CloseBrowser() {
		driver.close();
	}

}
