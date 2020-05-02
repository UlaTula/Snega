import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeWork0202b {
    private final Logger LOGGER = LogManager.getLogger(HomeWork0202b.class);

    private final By FULL_TITLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By FULL_TITLE_ARTICLE = By.xpath(".//div[contains(@class, 'article-title')]");
    private final By COMMENT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_PAGE_COMMENT = By.xpath(".//a[contains(@class, 'd-print')]");
    private final By ANONYM_COMMENTS = By.xpath("(.//span[contains(@class, 'type-cnt')])[1]");
    private final By REGISTER_COMMENTS = By.xpath("(.//span[contains(@class, 'type-cnt')])[2]");

    private WebDriver driver;

    @Test
    public void commentTest() {
        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");

        LOGGER.info("Opening browser");
        driver = new ChromeDriver();

        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();

        LOGGER.info("Open delfi page in russian");
        driver.get("http://rus.delfi.lv");

        LOGGER.info("Get all articles with comments and save second one");
        List<WebElement> articles = driver.findElements(FULL_TITLE);
        WebElement articleTitle = articles.get(1);

        LOGGER.info("Comment count from second article main page");
        String commentCount = articleTitle.findElement(COMMENT).getText();
        int commentCountInt = Integer.parseInt(commentCount.substring(1, commentCount.length() - 1));

        LOGGER.info("Click to the article page");
        articles.get(1).findElement(TITLE).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FULL_TITLE_ARTICLE));

        LOGGER.info("Get from article page comment count");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_COMMENT).getText();
        int articleCommentInt = Integer.parseInt(articlePageTitle.substring(1, articlePageTitle.length() - 1));

        LOGGER.info("Compare comment counts");
        Assertions.assertEquals(commentCountInt, articleCommentInt);

        LOGGER.info("Click to the comment page");
        driver.findElement(ARTICLE_PAGE_COMMENT).click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ANONYM_COMMENTS));

        LOGGER.info("Pick up anonymous comments count");
        WebElement anonymousComments = driver.findElement(ANONYM_COMMENTS);
        String anonymousCommentsText = anonymousComments.getText();
        int anonymousCommentsInt = Integer.parseInt(anonymousCommentsText.substring(1, anonymousCommentsText.length() - 1));

        LOGGER.info("Pick up registered comments count");
        WebElement registeredComments = driver.findElement(REGISTER_COMMENTS);
        String registeredCommentsText = registeredComments.getText();
        int registeredCommentsInt = Integer.parseInt(registeredCommentsText.substring(1, registeredCommentsText.length() - 1));

        LOGGER.info("All comments count");
        int allCommentsCount = anonymousCommentsInt + registeredCommentsInt;

        LOGGER.info("Compare comment counts");
        Assertions.assertEquals(articleCommentInt, allCommentsCount);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
