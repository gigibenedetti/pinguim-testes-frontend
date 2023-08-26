import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTeste {
	
	WebDriver driver;
	String[] modelos = { "Audi", "BMW", "Ford", "Porsche", "Mercedes Benz" };
	String[] numberSeats = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	String[] tipoCombustivel = { "Petrol", "Diesel", "Electric Power", "Gas", "Other" };
	String country = "Brazil";
	String occupation = "Employee";
	
	@BeforeClass
	public static void beforeClass(){
		WebDriverManager.chromedriver().setup();
	}
	
	@Before
	public void before(){
		ChromeOptions options = new ChromeOptions();// adicionando configurações adicionais pro chrome
		options.addArguments("--remote-allow-origins=*");// permitindo acessar qualquer origem
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}
	
	
	@Test
	public void CT02_CADASTRARVEICULO() {
		
		driver.findElement(By.xpath("//div[@class=\"main-navigation\"]//a[@id=\"nav_automobile\"]")).click();
		driver.findElement(By.id("make")).click();
		driver.findElement(By.xpath("//option[.='" + modelos[3] + "']")).click();
		driver.findElement(By.id("engineperformance")).sendKeys("500");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("12/30/1500");
		driver.findElement(By.xpath("//option[.='" + numberSeats[3] + "']")).click();
		driver.findElement(By.xpath("//option[.='" + tipoCombustivel[2] + "']")).click();
		driver.findElement(By.id("listprice")).sendKeys("1200");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("12032");
		driver.findElement(By.id("annualmileage")).sendKeys("50000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		driver.findElement(By.id("firstname")).sendKeys("Giovanna");
		driver.findElement(By.id("lastname")).sendKeys("Ferreira");
		driver.findElement(By.id("birthdate")).sendKeys("02/28/2002");
		driver.findElement(By.xpath("//option[.='" + country + "']")).click();
		driver.findElement(By.id("zipcode")).sendKeys("02349133");
		driver.findElement(By.xpath("//option[.='" + occupation + "']")).click();
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By.id("nextenterproductdata")).click();
		
		driver.findElement(By.id("startdate")).sendKeys("09/23/2030");
		driver.findElement(By.id("insurancesum")).click();
		driver.findElement(By.xpath("//option[.=' 3.000.000,00']")).click();
		driver.findElement(By.xpath("//option[.='Bonus 1']")).click();
		driver.findElement(By.xpath("//option[.='No Coverage']")).click();
		driver.findElement(By.xpath("//option[.=' No']")).click();
		
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By
				.id("nextselectpriceoption"))
				.click();
		
		driver.findElement(By.xpath("//th/label[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("nextsendquote")).click();
		driver.findElement(By.id("email")).sendKeys("asdasjd@hotmail.com");
		driver.findElement(By.id("username")).sendKeys("Giovanna");
		driver.findElement(By.id("password")).sendKeys("Abc1234");
		driver.findElement(By.id("confirmpassword")).sendKeys("Abc1234");
		driver.findElement(By.id("sendemail")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath("//h2")).getText();
		System.out.println(text);
		assertEquals("Sending e-mail success!", text);
	}
	
	@Test
	public void CT01_CADASTRARVEICULO() {
		
		driver.findElement(By.xpath("//div[@class=\"main-navigation\"]//a[@id=\"nav_automobile\"]")).click();
		driver.findElement(By.id("make")).click();
		driver.findElement(By.xpath("//option[.='" + modelos[3] + "']")).click();
		driver.findElement(By.id("engineperformance")).sendKeys("500");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("12/30/1500");
		driver.findElement(By.xpath("//option[.='" + numberSeats[3] + "']")).click();
		driver.findElement(By.xpath("//option[.='" + tipoCombustivel[2] + "']")).click();
		driver.findElement(By.id("listprice")).sendKeys("1200");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("12032");
		driver.findElement(By.id("annualmileage")).sendKeys("50000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		driver.findElement(By.id("firstname")).sendKeys("Giovanna");
		driver.findElement(By.id("lastname")).sendKeys("Ferreira");
		driver.findElement(By.id("birthdate")).sendKeys("02/28/2002");
		driver.findElement(By.xpath("//option[.='" + country + "']")).click();
		driver.findElement(By.id("zipcode")).sendKeys("02349133");
		driver.findElement(By.xpath("//option[.='" + occupation + "']")).click();
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By.id("nextenterproductdata")).click();
		
		driver.findElement(By.id("startdate")).sendKeys("09/23/2030");
		driver.findElement(By.id("insurancesum")).click();
		driver.findElement(By.xpath("//option[.=' 3.000.000,00']")).click();
		driver.findElement(By.xpath("//option[.='Bonus 1']")).click();
		driver.findElement(By.xpath("//option[.='No Coverage']")).click();
		driver.findElement(By.xpath("//option[.=' No']")).click();
		
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By
				.id("nextselectpriceoption"))
				.click();
		
		driver.findElement(By.xpath("//th/label[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("nextsendquote")).click();
		driver.findElement(By.id("email")).sendKeys("asdasjd@hotmail.com");
		driver.findElement(By.id("username")).sendKeys("Giovanna");
		driver.findElement(By.id("password")).sendKeys("Abc1234");
		driver.findElement(By.id("confirmpassword")).sendKeys("Abc1234");
		driver.findElement(By.id("sendemail")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath("//h2")).getText();
		System.out.println(text);
		assertEquals("Sending e-mail success!", text);
	}
	
	@Test
	public void CT03_COMPRADEROUPAAZUL() {
		
		driver.findElement(By.xpath("//div[@class=\"main-navigation\"]//a[@id=\"nav_automobile\"]")).click();
		driver.findElement(By.id("make")).click();
		driver.findElement(By.xpath("//option[.='" + modelos[3] + "']")).click();
		driver.findElement(By.id("engineperformance")).sendKeys("500");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("12/30/1500");
		driver.findElement(By.xpath("//option[.='" + numberSeats[3] + "']")).click();
		driver.findElement(By.xpath("//option[.='" + tipoCombustivel[2] + "']")).click();
		driver.findElement(By.id("listprice")).sendKeys("1200");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("12032");
		driver.findElement(By.id("annualmileage")).sendKeys("50000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		driver.findElement(By.id("firstname")).sendKeys("Giovanna");
		driver.findElement(By.id("lastname")).sendKeys("Ferreira");
		driver.findElement(By.id("birthdate")).sendKeys("02/28/2002");
		driver.findElement(By.xpath("//option[.='" + country + "']")).click();
		driver.findElement(By.id("zipcode")).sendKeys("02349133");
		driver.findElement(By.xpath("//option[.='" + occupation + "']")).click();
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By.id("nextenterproductdata")).click();
		
		driver.findElement(By.id("startdate")).sendKeys("09/23/2030");
		driver.findElement(By.id("insurancesum")).click();
		driver.findElement(By.xpath("//option[.=' 3.000.000,00']")).click();
		driver.findElement(By.xpath("//option[.='Bonus 1']")).click();
		driver.findElement(By.xpath("//option[.='No Coverage']")).click();
		driver.findElement(By.xpath("//option[.=' No']")).click();
		
		driver.findElement(By
				.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p[@class=\"group\"]/label[2]"))
				.click();
		driver.findElement(By
				.id("nextselectpriceoption"))
				.click();
		
		driver.findElement(By.xpath("//th/label[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("nextsendquote")).click();
		driver.findElement(By.id("email")).sendKeys("asdasjd@hotmail.com");
		driver.findElement(By.id("username")).sendKeys("Giovanna");
		driver.findElement(By.id("password")).sendKeys("Abc1234");
		driver.findElement(By.id("confirmpassword")).sendKeys("Abc1234");
		driver.findElement(By.id("sendemail")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath("//h2")).getText();
		System.out.println(text);
		assertEquals("Sending e-mail success!", text);
	}
	
	@After
	public void after(){
		driver.close();
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("ESTE É O MEU MÉTODO AfterClass");
	}
	
}
