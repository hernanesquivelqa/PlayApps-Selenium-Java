package app;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.TestBase;
import pages.PageTagsInputBox;
public class TagsInputBoxTest extends TestBase {
	private PageTagsInputBox pageTagsInputBox;

	
	@BeforeEach
	public void setupUpPage() {
		pageTagsInputBox = new PageTagsInputBox(driver);
	    goToUrl(pageTagsInputBox.getUrl());
	}
	@Test
	public void testShouldGetNodeAndJavascriptTag() {
		List<String> expectedTags = pageTagsInputBox.getAllTagsText();
		assertEquals(expectedTags,pageTagsInputBox.getAllTagsText());
		
	}
	@Test
    public void testAddNewTag() {
      
        String newTag = "python";
        pageTagsInputBox.addNewTag(newTag);

        List<String> expectedTags = Arrays.asList("node", "javascript", newTag);

        List<String> actualTags = pageTagsInputBox.getAllTagsText();

        assertEquals(expectedTags, actualTags, 
            "La lista después de añadir '" + newTag + "' no coincide con la esperada");
    }
  

}
