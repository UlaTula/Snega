package pageObject;

import org.openqa.selenium.By;

public class CommentPage {
    private final By TITLE = By.xpath("(.//h1[contains(@class, 'article-title')])[2]");
    private final By ANONYM_COMMENTS = By.xpath("(.//span[contains(@class, 'type-cnt')])[1]");
    private final By REGISTER_COMMENTS = By.xpath("(.//span[contains(@class, 'type-cnt')])[2]");
    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.findElement(TITLE).getText();
    }

    public int getAnonymComment() {
        String anonymousComments = baseFunc.findElement(ANONYM_COMMENTS).getText();
        return Integer.parseInt(anonymousComments.substring(1, anonymousComments.length() - 1));
    }

    public int getRegisterComment() {
        String registerComments = baseFunc.findElement(REGISTER_COMMENTS).getText();
        return Integer.parseInt(registerComments.substring(1, registerComments.length() - 1));
    }
}
