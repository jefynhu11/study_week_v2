package br.com.dbserver.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Screenshot {

        public static MediaEntityModelProvider capture(WebDriver driver) {
        String base64image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        try {
            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64image).build();
        } catch (IOException e) {
            ExtentTestManager.getTest().log(Status.ERROR, "Não foi possivel gerar uma evidência!");
        }
        return null;
    }

}
