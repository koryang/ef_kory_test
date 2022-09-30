package ef_kory_test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    public static void waitForElementIdUntilVisible(String element){
        WebDriverWait wait = new WebDriverWait(StepDefinitions.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
    }

    public static void waitForElementClassUntilVisible(String element){
        WebDriverWait wait = new WebDriverWait(StepDefinitions.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
    }

    public static void waitForElementXpathUntilVisible(String element){
        WebDriverWait wait = new WebDriverWait(StepDefinitions.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }
}
