package com.grantbroadwater.util;

/**
 * Log keeping for the application.
 * <br><br>
 * Prints out logs from throughout the program just like System.out.print(),
 * however, the logs are also saved into a list, that can then be retrieved or
 * saved. Logs can also be explicitly declared as errors that were caught in 
 * execution of the program. To use, simply create a new instance of Log.
 * <pre>
 * Examples:
 * 
 *    		new Log("Hello, World!");
 *    
 *    		new Log("An error occurred on this line!", true);
 * </pre>
 * Non-Error logs are displayed as:
 * <br>ClassName.methodName()[lineNumber] :: log<br>
 * Error logs are displayed as:
 * <br>ERROR: ClassName.methodName()[lineNumber] :: log<br>
 * 
 * @author GrantBroadwater
 * @since January 9, 2015
 * @version 1.0.2
 */
public class Log {

	private static boolean printNorm = true;
	private static boolean printErr = true;
	
	private static java.util.List<String> logs = new java.util.ArrayList<String>();
	private static java.util.List<String> norm = new java.util.ArrayList<String>();
	private static java.util.List<String> err = new java.util.ArrayList<String>();

	
	/**
	 * Creates a new, non error, log for the program.
	 * 
	 * <br><br>
	 * 
	 * Creates a new log in the form of a String to be printed and added to the appropriate 
	 * list. Logs created with only the String parameter are assumed to be non-error logs.
	 * To log an error, use {@link com.broadwater.util.Log#Log(String, boolean) Log(String, boolean)}.
	 * All logs are automatically added to its appropriate list. Non-Error logs are displayed as:
	 * ClassName.methodName()[lineNumber] :: log
	 * 
	 * @param log The String to be displayed and added to the list. The log will only be displayed
	 * 				if {@link com.broadwater.util.Log#displayNonErrorLogs(boolean) displayNonErrorLogs()}
	 * 				is set to true. All logs are displayed by default. All logs are added to the 
	 * 				appropriate list, regardless of any conditions or settings.
	 */
	public Log(String log) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.substring(className.lastIndexOf('.') + 1);
		
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		String debugInfo = (className + "." + methodName+"()["+lineNumber+"] :: ");
		
		Log.logs.add(debugInfo + log);
		Log.norm.add(debugInfo + log);
		
		if(printNorm){
			System.out.println(debugInfo);
			System.out.println("\t"+log);
		}
	}
	
	/**
	 * Creates a new log for the program.
	 * 
	 * <br><br>
	 * 
	 * Creates a new log in the form of a String to be printed and added to the appropriate
	 * list. The log will be considered a non-error log unless the error parameter is set to true.
	 * If the parameter is set to true, then there will be a String ("ERROR:") displayed in the
	 * console before the given debug information. Non-Error logs are displayed as:
	 * <br>ClassName.methodName()[lineNumber] :: log<br>
	 * Error logs are displayed as:
	 * <br>ERROR: ClassName.methodName()[lineNumber] :: log<br>
	 * 
	 * @param log The String to be displayed and added to the list. The log will only be 
	 * 					displayed to the screen if
	 * 					{@link com.broadwater.util.Log#displayNonErrorLogs(boolean) displayNonErrorLogs()} or 
	 *					{@link com.broadwater.util.Log#displayErrorLogs(boolean) displayErrorLogs()} 
	 *					is set to true. All logs are displayed by default. All logs are added to 
	 *					the appropriate list, regardless of any conditions or settings.
	 * @param error Indicates if the log is an error. Error logs are preceded with a String ("ERROR:")
	 * 					to be clearly indicated, and are added to the ErrorLogs list, this list can be 
	 * 					retrieved from {@link com.broadwater.util.Log#getErrorList() getErrorList()}.
	 */
	public Log(String log, boolean error){
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.substring(className.lastIndexOf('.') + 1);
		
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		String debugInfo = (className + "." + methodName+"()["+lineNumber+"] :: ");
		
		Log.logs.add(debugInfo + log);
		if(error){
			Log.err.add("ERROR: "+debugInfo + log);
			if(printErr)
				displayInConsole("ERROR: "+debugInfo, log);
		}else{
			Log.norm.add(debugInfo + log);
			if(printNorm)
				displayInConsole(debugInfo, log);
		}
			
		
	}
	
	private static void displayInConsole(String debugInfo, String str){
		System.out.println(debugInfo);
		System.out.println("\t"+str);
	}
	
	/**
	 * Dictates if non error logs should be displayed in the console. Non error logs are displayed by default.
	 * If the non error logs should be added to the list but not displayed then set to false. If the non error
	 * log should be displayed but not added to the list, then use System.out.println();
	 * 
	 * @param doesDisplay Indicates if non error logs should be displayed. If it is not required for non error 
	 * 						logs to be displayed, then set to false. Otherwise, set to true.
	 */
	public static void displayNonErrorLogs(boolean doesDisplay){
		Log.printNorm = doesDisplay;
	}
	
	/**
	 * Checks if non error logs are being displayed to the console. If false, all non error logs have been added
	 * to the non error logs list, but have not been printed to the console. If you wish to see the non error log list
	 * use {@link com.broadwater.util.Log#getNonErrorList() getNonErrorList()}.
	 * 
	 * @return boolean data type indicating if non error logs are being displayed.
	 */
	public static boolean displayNonErrorLogs(){
		return Log.printNorm;
	}
	
	/**
	 * Dictates if error logs should be displayed in the console. Error logs are displayed by default.
	 * If the error logs should be added to the list but not displayed then set to false. If the error
	 * log should be displayed but not added to the list, then use System.out.println();
	 * 
	 * @param doesDisplay Indicates if error logs should be displayed. If it is not required for error 
	 * 						logs to be displayed, then set to false. Otherwise, set to true.
	 */
	public static void displayErrorLogs(boolean doesDisplay){
		Log.printErr = doesDisplay;
	}
	
	/**
	 * Checks if error logs are being displayed to the console. If false, all error logs have been added
	 * to the error logs list, but have not been printed to the console. If you wish to see the error log list,
	 * use {@link com.broadwater.util.Log#getNonErrorList() getNonErrorList()}.
	 * 
	 * @return boolean data type indicating if error logs are being displayed.
	 */
	public static boolean displayErrorLogs(){
		return Log.printErr;
	}
	
	/**
	 * All non error logs in a java.util.List<String>. To retrieve a list of all logs use
	 * {@link com.broadwater.util.Log#getAllLogs() getAllLogs()}.
	 * 
	 * @return java.util.List<String> containing all non error logs from the entire execution of this program.
	 */
	public static java.util.List<String> getNonErrorList(){
		return Log.err;
	}
	
	/**
	 * All error logs in a java.util.List<String>. To retrieve a list of all logs use
	 * {@link com.broadwater.util.Log#getAllLogs() getAllLogs()}.
	 * 
	 * @return java.util.List<String> containing non error logs from the entire execution of this program.
	 */
	public static java.util.List<String> getErrorList(){
		return Log.err;
	}
	
	/**
	 * All logs in a java.util.List<String>. Logs are added to this list regardless on if they were declared as an error.
	 * 
	 * @return java.util.List<String> containing all logs from the entire execution of this program.
	 */
	public static java.util.List<String> getAllLogs(){
		return Log.logs;
	}
	
}