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
        goToUrl(ratingPage.getPageUrl());
    }

    @Test
    public void shouldDisplayHateMessageWhenRatingOneStar() {
        ratingPage.selectOneStar();
        String displayedRatingMessage = ratingPage.getRatingMessage();
        assertTrue(displayedRatingMessage.contains("I just hate it"));
        String displayRatingNumber = ratingPage.getRatingNumber();
        assertTrue(displayRatingNumber.contains("1 out of 5"));
        
    }
    @Test
    public void eachStar() {
      ratingPage.eachStarClick();
    	  
    }
    
}