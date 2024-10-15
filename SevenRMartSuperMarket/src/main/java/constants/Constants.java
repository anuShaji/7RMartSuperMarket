package constants;

public class Constants {
	public static final String TESTDATAFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excelTestData.xlsx";
	public static final String ERRORMESSAGEFORLOGINPAGE = "Home page not loaded due to entering invalid credentials";
	public static final String UNABLETOADDERRORMSG = "Unable to add !!!";
	public static final String NOMATCHFOUND = "No match is found";
	public static final long EXPLICITWAIT = 25;
	public static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";
	public static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact support.";
	public static final String PASSWORD_EXPIRED = "Your password has expired. Please reset it.";
	public static final String EMAIL_ALREADY_REGISTERED = "This email is already registered. Please use a different email.";
	public static final String PASSWORDS_DO_NOT_MATCH = "The passwords entered do not match. Please try again.";
	public static final String INVALID_EMAIL_FORMAT = "The email format is invalid. Please enter a valid email.";
	public static final String USER_ALREADY_EXISTS = "This user already exists in the database.";
	public static final String EMPTY_FIELD_ERROR = "Please fill out all required fields.";
	public static final String INVALID_DATA_FORMAT = "The data format is invalid. Please check your input.";
	public static final String SEARCH_CRITERIA_MISSING = "Please enter search criteria.";
	public static final String SEARCH_TIMEOUT = "The search request timed out. Please try again.";
	public static final String NETWORK_ERROR = "Network error occurred. Please check your internet connection.";
	public static final String SERVER_ERROR = "Server error occurred. Please try again later.";
	public static final String UNEXPECTED_ERROR = "An unexpected error occurred. Please contact support.";
	public static final String FORM_SUBMISSION_FAILED = "Form submission failed. Please try again.";
	public static final String INCOMPLETE_PROFILE = "Your profile is incomplete. Please fill in all required fields.";
	public static final String SESSION_EXPIRED = "Your session has expired. Please log in again.";
	public static final String UNAUTHORIZED_ACCESS = "You do not have permission to access this page.";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
}
