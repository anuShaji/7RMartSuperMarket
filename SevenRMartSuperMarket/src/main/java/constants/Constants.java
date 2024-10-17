package constants;

public class Constants {
	public static final String TESTDATAFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excelTestData.xlsx";
	public static final String ERRORMESSAGEFORLOGINPAGE = "Home page not loaded due to entering invalid credentials";
	public static final String UNABLETOADDERRORMSG = "Unable to add !!!";
	public static final String NOMATCHFOUND = "No match is found";
	public static final long EXPLICITWAIT = 25;
	public static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";
	public static final String EMAIL_ALREADY_REGISTERED = "This email is already registered. Please use a different email.";
	public static final String USER_ALREADY_EXISTS = "This user already exists in the database.";
	public static final String SEARCH_CRITERIA_MISSING = "Please enter search criteria.";
	public static final String SEARCH_TIMEOUT = "The search request timed out. Please try again.";
	public static final String UNEXPECTED_ERROR = "An unexpected error occurred. Please contact support.";
	public static final String FORM_SUBMISSION_FAILED = "Form submission failed. Please try again.";
	public static final String INCOMPLETE_PROFILE = "Your profile is incomplete. Please fill in all required fields.";
	public static final String SESSION_EXPIRED = "Your session has expired. Please log in again.";
	public static final String UNAUTHORIZED_ACCESS = "You do not have permission to access this page.";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
}
