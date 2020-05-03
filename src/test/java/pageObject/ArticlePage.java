package pageObject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_COMMENT_COUNT = By.xpath("(.//a[contains(@class, 'text-red-ribbon' )])[1]");
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.findElement(TITLE).getText();
    }

    public void goToCommentPage() {
        WebElement articleCommentTitle = baseFunc.findElement(ARTICLE_COMMENT_COUNT);
        baseFunc.click(articleCommentTitle);
    }

    public int getArticleCommentCount() {
        String articleCommentCount = baseFunc.findElement(ARTICLE_COMMENT_COUNT).getText();
        return Integer.parseInt(articleCommentCount.substring(1, articleCommentCount.length() - 1));
    }
}
