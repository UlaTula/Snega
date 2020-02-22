import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork02 {
    private final By ARTICLE_TITLES = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'd-print-none')]");
    private final By ARTICLE_COMMENT_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");

    @Test
    public void secondArticleTest() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

        List<WebElement> articles = driver.findElements(ARTICLE_TITLES);
        WebElement nextTitle = articles.get(1);
        String nextTitleText = nextTitle.getText();

        nextTitle.click();
        WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        String articleTitleText = articleTitle.getText();

        Assertions.assertEquals(nextTitleText, articleTitleText, "Wrong article page title!");

        WebElement commentCount = driver.findElement(ARTICLE_COMMENT_COUNT);
        commentCount.click();

        List<WebElement> articlesComment = driver.findElements(ARTICLE_COMMENT_TITLE);
        WebElement commentTitle = articlesComment.get(1);
        String commentTitleText = commentTitle.getText();

        Assertions.assertEquals(articleTitleText, commentTitleText, "Wrong comment page article title!");

        driver.close();
    }
}
