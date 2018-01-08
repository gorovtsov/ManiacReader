package by.htp.library.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static final Validator instance = new Validator();
	
	public static Validator getInstance() {
		return instance;
	}
	
	private final Pattern VALID_PASSWORD_REGEX = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}");
	
	private final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	public boolean validatePassword(String passwordStr) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordStr);
		return matcher.find();
	}
}
