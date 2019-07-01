package main.test;

import java.util.Random;

public class TestConstants {

	public static final class TestData  {
    //needed global fixed test data 
		
		public static String ENVIRONMENT = "";
		public static String BROWSER = "";
		public final static String PASSWORD = "test1234";
		public final static String Re_PASSWORD = "test43214";
		
		public final static String REGISTRATION_FIELDS_EMPTY_ERROR = "Please fill out this field.";
		public final static String REGISTRATION_FIELDS_4_LESS = "Please match the requested format.";

		public final static String RETYPE_PASSWORD = "Error: Passwords aren't equal!";


		public static String USERNAME = username();
		
		public static String username() {
			return "friend." + Math.abs(new Random().nextInt());
		}
		
public static String CATEGORY = category();
		
		public static String category() {
			return "Cactegory." + Math.abs(new Random().nextInt());
		}

		

	}
}
