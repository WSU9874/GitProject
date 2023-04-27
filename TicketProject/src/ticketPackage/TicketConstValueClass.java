package ticketPackage;

import java.util.Locale;
import java.util.ResourceBundle;

public class TicketConstValueClass {

	public static final int BABY_PRICE = 0, ADULT_DAY_PRICE = 56000, ADULT_NIGHT_PRICE = 46000, 
			TEEN_DAY_PRICE = 47000, TEEN_NIGHT_PRICE = 46000, CHILD_DAY_PRICE = 44000, 
			CHILD_NIGHT_PRICE = 37000, OLD_DAY_PRICE = 44000, OLD_NIGHT_PRICE = 37000;
		
		public static final long FULL_DIGIT = 10000000000000L, FULL_DIGIT_MIN = 10000000000L,
								SEVEN_DIGIT = 1000000;
		
		public static final int TWO_DIGIT = 100,  ONE_DIGIT = 10, 
								OLD_GENERATION = 1900, NEW_GENERATION = 2000, 
								MALE_OLD = 1, FEMALE_OLD = 2, MALE_NEW = 3, FEMALE_NEW = 4,
								BEFORE_BIRTH = 2, AFTER_BIRTH = 1;

		public static final int MIN_BABY = 1, MIN_CHILD = 3, MIN_TEEN = 13, MIN_ADULT = 19,
								MAX_CHILD = 12, MAX_TEEN = 18, MAX_ADULT = 64;

		public static final int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
		
		public static final double DISABLE_DISCOUNT_RATE = 0.6, MERIT_DISCOUNT_RATE = 0.5,
									MULTICHILD_DISCOUNT_RATE = 0.8, 
									PREGNANT_DISCOUNT_RATE = 0.85;

		public static final int MAX_COUNT = 10, MIN_COUNT = 1;
		

		public static String language;
		public static String SELECT_TICKET_TYPE;
		public static String dayTicket;
		public static String nightTicket;
		public static String INPUT_ID;
		public static String HOW_MANY_TICKET_BUY;
		public static String CHOOSE_BENIFIT_NUMBER;
		public static String ENTER_AGAIN;
		public static String TOTAL_PRICE;
		public static String KEEP_BUY_TICKET;
		public static String KEEP_BUY_TICKET_GOING;
		public static String KEEP_BUY_TICKET_STOP;
		public static String EXIT_TICKET_PROGRAM;
		public static String EVERLAND;
		public static String SELECT_TICKET_TYPE_DAY;
		public static String SELECT_TICKET_TYPE_NIGHT;
		public static String baby;
		public static String kid;
		public static String teen;
		public static String adult;
		public static String oldman;
		public static String forNone;
		public static String forDisabled;
		public static String forMerities;
		public static String forMultiChild;
		public static String forPregnant;
		public static String PRINT_TOTAL_PRICE;
		public static String KEEP_ORDERING;
		
		public static void startLanguage() {
			Locale currentlocale = Locale.getDefault();
			//Locale currentlocale = new Locale("en", "US");
			//Locale currentlocale  = new Locale("ja", "JP");
			ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentlocale);

			SELECT_TICKET_TYPE = messages.getString("SELECT_TICKET_TYPE");
			dayTicket = messages.getString("dayTicket");
			nightTicket = messages.getString("nightTicket");
			INPUT_ID = messages.getString("INPUT_ID");
			HOW_MANY_TICKET_BUY = messages.getString("HOW_MANY_TICKET_BUY");
			CHOOSE_BENIFIT_NUMBER = messages.getString("CHOOSE_BENIFIT_NUMBER");
			ENTER_AGAIN = messages.getString("ENTER_AGAIN");
			TOTAL_PRICE = messages.getString("TOTAL_PRICE");
			KEEP_BUY_TICKET = messages.getString("KEEP_BUY_TICKET");
			KEEP_BUY_TICKET_GOING = messages.getString("KEEP_BUY_TICKET_GOING");
			KEEP_BUY_TICKET_STOP = messages.getString("KEEP_BUY_TICKET_STOP");
			EXIT_TICKET_PROGRAM = messages.getString("EXIT_TICKET_PROGRAM");
			EVERLAND = messages.getString("EVERLAND");
			SELECT_TICKET_TYPE_DAY = messages.getString("SELECT_TICKET_TYPE_DAY");
			SELECT_TICKET_TYPE_NIGHT = messages.getString("SELECT_TICKET_TYPE_NIGHT");
			baby = messages.getString("baby");
			kid = messages.getString("kid");
			teen = messages.getString("teen");
			adult = messages.getString("adult");
			oldman = messages.getString("oldman");
			forNone = messages.getString("forNone");
			forDisabled = messages.getString("forDisabled");
			forMerities = messages.getString("forMerities");
			forMultiChild = messages.getString("forMultiChild");
			forPregnant = messages.getString("forPregnant");
			PRINT_TOTAL_PRICE = messages.getString("PRINT_TOTAL_PRICE");
			KEEP_ORDERING = messages.getString("KEEP_ORDERING");
			
		}
}				