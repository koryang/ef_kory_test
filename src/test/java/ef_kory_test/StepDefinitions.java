package ef_kory_test;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.hostProperties;
import properties.userProperties;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    public static WebDriver driver = new ChromeDriver();
    String temp;

    @Given("user has login as youtube user")
    public void userHasLoginAsYoutubeUser() {
        driver.get(hostProperties.host);

        driver.findElement(By.linkText("SIGN IN")).click();
        driver.findElement(By.id("identifierId")).sendKeys(userProperties.username);

        WebElement nextButtonElement = driver.findElement(By.id("identifierNext"));
        // check visibility with isDisplayed()
        try {
            if (nextButtonElement.isDisplayed()) {
                driver.findElement(By.id("identifierNext")).click();
            }
        } catch (Exception e) {
            System.out.println("Next button element is not visible");
        }

        driver.findElement(By.name("Passwd")).sendKeys(userProperties.password);
        driver.findElement(By.id("identifierNext")).click();

    }

    @And("user visit Youtube Music home page")
    public void userVisitYoutubeMusicHomePage() {
        driver.get(hostProperties.host);
    }

    @When("user click the play icon on the first song in the carousel")
    public void userClickThePlayIconOnTheFirstSongInTheCarousel() {
        driver.findElement(By.id("play-button")).click();
    }

    @Then("user should hear the music playing")
    public void userShouldHearTheMusicPlaying() {
        WebElement music = driver.findElement(By.id("progress-bar"));
        assertTrue(music.isEnabled());
    }

    @And("user should see the player bar appeared")
    public void userShouldSeeThePlayerBarAppeared() {
        WebElement playerbar = driver.findElement(By.id("player-bar-background"));
        assertTrue(playerbar.isDisplayed());
    }

    @When("user click the pause icon")
    public void userClickThePauseIcon() {
        Helper.waitForElementIdUntilVisible("play-pause-button");
        driver.findElement(By.id("play-pause-button")).click();
    }

    @Then("user should not hear any music playing")
    public void userShouldNotHearAnyMusicPlaying() {
    }

    @And("user should see the pause icon disapeared")
    public void userShouldSeeThePauseIconDisapeared() {
//        WebElement playButton = driver.findElement(By.xpath("//tp-yt-paper-icon-button[@id=\"play-pause-button\" and @title=\"Pause\"]"));
//        assertFalse(playButton.isDisplayed());
    }

    @And("user should see the play icon appeared")
    public void userShouldSeeThePlayIconAppeared() {
        WebElement playButton = driver.findElement(By.xpath("//tp-yt-paper-icon-button[@id=\"play-pause-button\" and @title=\"Play\"]"));
        assertTrue(playButton.isDisplayed());
    }

    @When("user click the play back icon")
    public void userClickThePlayBackIcon() {
        driver.findElement(By.className("previous-button")).click();
    }

    @And("user should see the music playing from the begining")
    public void userShouldSeeTheMusicPlayingFromTheBegining() {
        WebElement begin = driver.findElement(By.xpath("//span[@class=\"time-info style-scope ytmusic-player-bar\" and contains(text(),'0:0')]"));
        assertTrue(begin.isDisplayed());
    }

    @When("user click the play next icon")
    public void userClickThePlayNextIcon() {
//        temp = driver.findElement(By.className("byline style-scope ytmusic-player-bar complex-string")).getAttribute("title");
        Helper.waitForElementClassUntilVisible("next-button");
        driver.findElement(By.className("next-button")).click();
    }

    @And("user should see next music is playing")
    public void userShouldSeeNextMusicIsPlaying() {
//        try {
//            wait(5);
//            String music = driver.findElement(By.className("subtitle style-scope ytmusic-player-bar")).getAttribute("title");
//            assertNotEquals(temp, music);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @When("user click the repeat icon")
    public void userClickTheRepeatIcon() {
        driver.findElement(By.className("repeat style-scope ytmusic-player-bar")).click();
    }

    @Then("user should hear the music repeated icon is active")
    public void userShouldHearTheMusicRepeatedIconIsActive() {
        WebElement repeat = driver.findElement(By.xpath("//tp-yt-paper-icon-button[@class='repeat' and title='Repeat off']"));
        assertTrue(repeat.isDisplayed());
    }

    @When("user click the reshuffle icon")
    public void userClickTheReshuffleIcon() {
    }

    @Then("user should hear the music reshuffle icon is active")
    public void userShouldHearTheMusicReshuffleIconIsActive() {
    }

    @When("user click the mute icon")
    public void userClickTheMuteIcon() {
    }

    @Then("user should hear the music mute icon is active")
    public void userShouldHearTheMusicMuteIconIsActive() {
    }

    @After()
    public void closeBrowser(){
        driver.quit();
    }
}
