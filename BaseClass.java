package com.initbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.initbanking.utilities.ReadConfig;

public class BaseClass {
	//Data Driven-> crate an object of ReadConfig
	ReadConfig readconfig= new ReadConfig();
	
	public String baseURL= readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	
	/*public String baseURL= "https://demo.guru99.com/v4/";
	public String username = "mngr565206";
	public String password= "EpypEtU";
	public static WebDriver driver;*/
	
	public static Logger logger;
	//Run Test cases on desired browser----take a parameter from XML file

	@Parameters("browser")
	@BeforeClass
	 public void setup(String br)
		{
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			 driver = new EdgeDriver();
		}
		driver.get(baseURL);
		//logger.info("URL is opened");
	}
	
	/*  public void setup()
	{
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		 logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4.properties");
	
	}*/
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
