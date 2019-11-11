package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driverch = new ChromeDriver();
        driverch.get("https://www.i.ua/");
        driverch.manage().window().maximize();
        driverch.findElement(By.name("login")).sendKeys("ittest2");
        driverch.findElement(By.name("pass")).sendKeys("337774a");
        driverch.findElement(By.xpath("//input[@tabindex='5']  ")).click();
        String text = driverch.findElement(By.xpath("//li[@class='sn_menu_item']/span[@class='sn_menu_title']")).getText();
        Assert.assertEquals(text, "ittest2@i.ua");
        driverch.findElement(By.xpath("//p[@class='make_message']/a[@href]")).click();
        driverch.findElement(By.xpath("//textarea[@tabindex='2']")).sendKeys("ittest2@i.ua");
        driverch.findElement(By.xpath("//input[@tabindex='5']")).sendKeys("QAtestS");
        driverch.findElement(By.xpath("//textarea[@tabindex='10']")).sendKeys("Test text");
        driverch.findElement(By.xpath("//p[@class='send_container']/input[@type='submit']")).click();
        driverch.findElement(By.xpath("//li[@class='new']/a[@href]")).click();
        //driverch.findElement(By.xpath("//ul[@class='sn_menu']/li[4]/a")).click();
        String mailText = driverch.findElement(By.xpath("//div[@class='row new']/a/span[@class='sbj']/span")).getText();
        Assert.assertEquals(mailText,"QAtestS");
        driverch.findElement(By.xpath("//div[@class='row new']/a/span[@class='sbj']/span")).click();
        String textBody = driverch.findElement(By.xpath("//div[@class='message_container clear']/div/div[@class='message_body']/pre")).getText();
        Assert.assertEquals(textBody,"Test text");



    }
}