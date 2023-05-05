package loginpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginautov1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream"); // use fake camera and microphone
        options.addArguments("use-fake-ui-for-media-stream"); // use fake UI for camera and microphone
		WebDriver driver = new ChromeDriver(options);
		
		String csvFile = "E:/data-cat.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String email = data[0];
            String password = data[1];
            
            // open the login page
            driver.get("https://pmb.arkatama.id/cat/");

            // find the email and password fields and enter values
            WebElement emailField = driver.findElement(By.id("user_email"));
            WebElement passwordField = driver.findElement(By.id("user_password"));
            emailField.sendKeys(email);
            passwordField.sendKeys(password);

            // click the login button
            String beforeUrl = driver.getCurrentUrl();
            WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit' and (text() = 'Login' or . = 'Login')]"));
            loginButton.click();
            Thread.sleep(2500);
            String afterUrl = driver.getCurrentUrl();

            if (beforeUrl.equals(afterUrl)) {
            	System.out.println("Login test FAILED for user: " + email);
                Thread.sleep(1000);
                    
                driver.manage().deleteAllCookies();
                driver.navigate().refresh();
            } else {
            	  System.out.println("Login test passed for user: " + email);
                  Thread.sleep(1000);
                      
                  driver.manage().deleteAllCookies();
                  driver.navigate().refresh();
                  
            }
            
        }
        
        driver.quit();
        
        System.out.println("");
        System.out.println("Made by : Kevin & Juve");
        System.out.println("If there any error or problems please report to us!!");
        System.out.println("Thank You!");

	}

}
