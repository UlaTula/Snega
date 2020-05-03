package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By FULL_TITLE = By.tagName("article");
    private final By COMMENT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleById(int id) {
        List<WebElement> titles = baseFunc.findElements(TITLE);
        return titles.get(id - 1).getText();
    }

    public void goToTitleById(int id) {
        List<WebElement> titles = baseFunc.findElements(TITLE);
        baseFunc.click(titles.get(id - 1));
    }

    public int getCommentCount() {
        List<WebElement> articles = baseFunc.findElements(FULL_TITLE);
        WebElement articleTitle = articles.get(1);
        String commentCount = articleTitle.findElement(COMMENT).getText();
        return Integer.parseInt(commentCount.substring(1, commentCount.length() - 1));
    }
}
