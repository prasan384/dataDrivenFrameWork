package KeyWords;

public class ValidationKeywords extends GenericKeyWords {

	public void validateTitle() {
		log("validating title");

	}

	public void validateText() {

	}

	public void validateElementPresent(String Locator) {
		boolean result= isElementPresent(Locator);
		reportFailure("Element not found " + Locator,true);
		
	

	}

	public void validatelogin() {

	}
}
