package app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.RatingPage;

public class RatingTest extends TestBase {
    private RatingPage ratingPage;

    @BeforeEach
    public void initializePage() {
        ratingPage = new RatingPage(driver);
        goToUrl(ratingPage.getUrl());
    }

    @Test
    public void shouldDisplayHateMessageWhenRatingOneStar() {
        ratingPage.selectOneStar();
        String displayedRatingMessage = ratingPage.getRatingMessage();
        assertTrue(displayedRatingMessage.contains("I just hate it"));
    }
}