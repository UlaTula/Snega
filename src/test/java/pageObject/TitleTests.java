package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TitleTests {
    private final Logger LOGGER = LogManager.getLogger(TitleTests.class);
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titleCheck() {
        LOGGER.info("Open browser with delfi home page");
        baseFunc.openHomePage();

        LOGGER.info("Get second title from home page");
        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(2);

        LOGGER.info("Move to second article page");
        homePage.goToTitleById(2);

        LOGGER.info("Get title from article page");
        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();

        LOGGER.info("Compare first page and article page titles");
        Assertions.assertEquals(homePageTitle, articlePageTitle, "Incorrect title");

        LOGGER.info("Move to comment page");
        articlePage.goToCommentPage();

        LOGGER.info("Get title from Comment page");
        CommentPage commentPage = new CommentPage(baseFunc);
        String commentPageTitle = commentPage.getTitle();

        LOGGER.info("Compare article and comment page titles");
        Assertions.assertEquals(articlePageTitle, commentPageTitle, "Incorrect title");

        LOGGER.info("Clean up");
        baseFunc.closeBrowser();
    }

    @Test
    public void commentCountCheck() {
        LOGGER.info("Open browser with delfi home page");
        baseFunc.openHomePage();

        LOGGER.info("Get second title and comment count from home page");
        HomePage homePage = new HomePage(baseFunc);
        int commentCountInt = homePage.getCommentCount();

        LOGGER.info("Move to second article page");
        homePage.goToTitleById(2);

        LOGGER.info("Get article page title and comment count");
        ArticlePage articlePage = new ArticlePage(baseFunc);
        int articleCommentCountInt = articlePage.getArticleCommentCount();

        LOGGER.info("Compare first page and article page comments");
        Assertions.assertEquals(commentCountInt, articleCommentCountInt, "Different comment count");

        LOGGER.info("Move to comment page");
        articlePage.goToCommentPage();

        LOGGER.info("Get comment page comment count");
        CommentPage commentPage = new CommentPage(baseFunc);
        int anonymousCommentsInt = commentPage.getAnonymComment();
        int registerCommentsInt = commentPage.getRegisterComment();
        int allCommentInt = anonymousCommentsInt + registerCommentsInt;

        LOGGER.info("Compare article page and comment page comments");
        Assertions.assertEquals(articleCommentCountInt, allCommentInt, "Different comment count");

        LOGGER.info("Clean up");
        baseFunc.closeBrowser();
    }

}
