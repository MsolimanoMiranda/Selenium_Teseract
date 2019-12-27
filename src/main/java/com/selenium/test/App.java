package com.selenium.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App 
{
		private static String userName = "10473421602" ;
	    private static String password = "12345678" ;
		
	
	    public static void main(String[] args) throws IOException, InterruptedException, TesseractException{
	    {
    	
    	
    	 String chromeDriverPath = "/usr/local/bin/chromedriver" ;
         System.setProperty("webdriver.chrome.driver", chromeDriverPath);
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
         WebDriver driver = new ChromeDriver(options);
         String TESS4J_FOLDER_PATH = "/usr/local/Cellar/tesseract/4.1.0/share/tessdata/";
        // Get the login page
//        driver.get("http://www.sunat.gob.pe/cl-ti-itmrconsruc/FrameCriterioBusquedaMovil.jsp");
//        WebElement  element = driver.findElement(By.xpath("//img[@id='imgCodigo']"));
//        driver.findElement(By.xpath("//input[@id='txtRuc']")).sendKeys(userName);

//
////         
////         String logoSRC = element.getAttribute("src");
////         
////         URL imageURL = new URL(logoSRC);
////         BufferedImage saveImage = ImageIO.read(imageURL);
////         DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
////         Date date= new Date();
////      	 String datexx= dateFormat.format(date)+".png";
////      	
////         ImageIO.write(saveImage, "png", new File(datexx));
////        
//         
//         
//        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        int imgwidth=element.getSize().getWidth();
//        int imgheight=element.getSize().getHeight();
//        Point point=element.getLocation();
//        int cordx=point.getX();
//        int codry=point.getY();
//        BufferedImage img=ImageIO.read(screen);
//       // BufferedImage dest=img.getSubimage(1470, 500, 200, 120);
//        BufferedImage dest=img.getSubimage(cordx*2, codry*2, imgwidth*2, imgheight*2);
//        System.out.println(cordx+"-"+codry+"-"+imgwidth+"-"+imgheight);
//        ImageIO.write(dest,"png",screen);
//        DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
//        Date date= new Date();
//        String date1= dateFormat.format(date);
//        FileUtils.copyFile(screen, new File(date1+".png"));
//     
//         
//         
//         
//         
//        Tesseract instace= new Tesseract();
//         instace.setDatapath(TESS4J_FOLDER_PATH);
//        instace.setLanguage("eng");
////         File imageFile = new File(datexx); 
//         try {  
//         String result = instace.doOCR(screen); 
//         Thread.sleep(5000);
//         System.out.println(result.toUpperCase());
//         driver.findElement(By.xpath("//input[@id='txtCodigo']")).sendKeys(result.toUpperCase().trim());
//
//		     } catch (TesseractException e) {  
//		         System.err.println(e.getMessage());  
//		        
//		     }   
//
//          // Locate the login button and click on it
//          driver.findElement(By.xpath("//button[@id='btnAceptar']")).click();
//         // String msj = driver.switchTo().alert().getText();
//        //  if(msj){
//         // Ingrese el código que se muestra en la imagen
//          File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//          FileUtils.copyFile(screenshot, new File("ultimateImg.png"));
////          String msj = driver.findElement(By.className("error")) != null?driver.findElement(By.className("error")).getText():"Vacia";
////          
////          	System.out.println(msj);
//          
//          
         driver.get("https://www.sat.gob.pe/VirtualSAT/principal.aspx?mysession=0JrSgKPZx1vb65%2b0O8Sa6Xyk4JGpN8O2zOeY0VNNOU8%3d");
          
         driver.switchTo().frame(0);
         WebElement x=driver.findElement(By.xpath("//select[@id='tipoBusInfraConductor']"));
         
         Select selectOI = new Select(x);
         selectOI.selectByValue("busqLicencia");
          driver.findElement(By.xpath("//input[@id='ctl00_cplPrincipal_ibtnRefresh']")).click();
          File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(screenshot, new File("ultimateImg.png"));
         
         File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

         WebElement  element = driver.findElement(By.xpath("//img[@class='captcha_class']"));
         int imgwidth=element.getSize().getWidth();
         int imgheight=element.getSize().getHeight();
         Point point=element.getLocation();
         int cordx=point.getX();
         int codry=point.getY();
         BufferedImage img=ImageIO.read(screen);
        // BufferedImage dest=img.getSubimage(1470, 500, 200, 120);
         BufferedImage dest=img.getSubimage(cordx*2, codry*2, imgwidth*2, imgheight*2);
         System.out.println(cordx+"-"+codry+"-"+imgwidth+"-"+imgheight);
         ImageIO.write(dest,"png",screen);
         DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
         Date date= new Date();
         String date1= dateFormat.format(date);
         FileUtils.copyFile(screen, new File(date1+".png"));
      
          
        
          
         Tesseract instace= new Tesseract();
          instace.setDatapath(TESS4J_FOLDER_PATH);
         instace.setLanguage("eng");
//           File imageFile = new File(datexx); 
          try {  
          String result = instace.doOCR(screen); 
          Thread.sleep(5000);
          System.out.println(result.toUpperCase());
          //driver.findElement(By.xpath("//input[@id='txtCodigo']")).sendKeys(result.toUpperCase().trim());
          driver.findElement(By.xpath("//input[@id='ctl00_cplPrincipal_txtCaptcha']")).sendKeys(result.toUpperCase().trim());
   		     } catch (TesseractException e) {  
   		         System.err.println(e.getMessage());  
   		        
   		     }   

           // Locate the login button and click on it

          // String msj = driver.switchTo().alert().getText();
         //  if(msj){
          // Ingrese el código que se muestra en la imagen
//           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//           FileUtils.copyFile(screenshot, new File("ultimateImg.png"));
//            String msj = driver.findElement(By.className("error")) != null?driver.findElement(By.className("error")).getText():"Vacia";
//            
//            	System.out.println(msj);
           
            
          
         

       	driver.quit();
       	System.exit(1);
          
          

     }
    }
	    
  
	    
}
