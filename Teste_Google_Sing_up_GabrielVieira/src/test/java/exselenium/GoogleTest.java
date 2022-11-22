package exselenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

    protected WebDriver driver;

    
    @BeforeEach
    public void openPage() {
    	System.setProperty("webdriver.chrome.driver", "/home/aluno/Downloads/chromedriver_linux64/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup");

        Dimension newDimension = new Dimension(1600, 900);
        driver.manage().window().setSize(newDimension);
    }
    
    @Test
    public void teste_short_email() {
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Gabriel");
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vieira");
        
        WebElement Passwd = driver.findElement(By.name("Passwd"));
        Passwd.sendKeys("q1w2e3r4@");
        
        WebElement confirmPasswd = driver.findElement(By.name("ConfirmPasswd"));
        confirmPasswd.sendKeys("q1w2e3r4@");
        
        WebElement Email = driver.findElement(By.id("username"));
        Email.sendKeys("abcd");
        
        WebElement next = driver.findElement(By.xpath("//span[contains(.,'Próxima')]"));
        next.click();
        
        try{
        	Thread.sleep(1500);
            WebElement shortMessage = driver.findElement(By.xpath("//div[contains(.,'O seu nome de usuário deve ter entre 6 e 30 caracteres.')]"));
            assertTrue(shortMessage.getText().contains("O seu nome de usuário deve ter entre 6 e 30 caracteres."));
        }catch (Exception e) {
        	fail();
		}
        
        driver.quit();
    }

    @Test
    public void test_special_character() {
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Gabriel");
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vieira");
        
        WebElement Passwd = driver.findElement(By.name("Passwd"));
        Passwd.sendKeys("q1w2e3r4@");
        
        WebElement confirmPasswd = driver.findElement(By.name("ConfirmPasswd"));
        confirmPasswd.sendKeys("q1w2e3r4@");
        
        WebElement Email = driver.findElement(By.id("username"));
        Email.sendKeys("abcd****");
        
        WebElement next = driver.findElement(By.xpath("//span[contains(.,'Próxima')]"));
        next.click();
        
        try{
        	Thread.sleep(1500);
            WebElement specialCharacter = driver.findElement(By.xpath("//div[contains(.,'Somente letras (a - z), números (0 - 9) e pontos (.) são permitidos.')]"));
            assertTrue(specialCharacter.getText().contains("Somente letras (a - z), números (0 - 9) e pontos (.) são permitidos."));
        }catch (Exception e) {
        	fail();
		}
        
        driver.quit();
    }
    
    @Test
    public void test_email_exist() {
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Gabriel");
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Vieira");
        
        WebElement Passwd = driver.findElement(By.name("Passwd"));
        Passwd.sendKeys("q1w2e3r4@");
        
        WebElement confirmPasswd = driver.findElement(By.name("ConfirmPasswd"));
        confirmPasswd.sendKeys("q1w2e3r4@");
        
        WebElement Email = driver.findElement(By.id("username"));
        Email.sendKeys("existe");
        
        WebElement next = driver.findElement(By.xpath("//span[contains(.,'Próxima')]"));
        next.click();
        
        try{
        	Thread.sleep(1500);
            WebElement exists = driver.findElement(By.xpath("//div[contains(.,'Este nome de usuário já está em uso. Tente outro.')]"));
            assertTrue(exists.getText().contains("Este nome de usuário já está em uso. Tente outro."));
        }catch (Exception e) {
        	fail();
		}
        
        driver.quit();
    }

}
