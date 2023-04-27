package ticketPackage;

import java.util.Locale;

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
		
		public static void startLanguage(String language) {
			// language="US";

			if (language.equals("KR")) {

				SELECT_TICKET_TYPE = "권종을 선택하세요.";
				dayTicket = "1. 주간권";
				nightTicket = "2. 야간권";
				INPUT_ID = "주민등록번호를 입력하세요.(13자리)";
				HOW_MANY_TICKET_BUY = "몇개를 주문하시겠습니까(최대 10개)";
				CHOOSE_BENIFIT_NUMBER = "우대사항을 선택하세요.\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 다자녀\n5. 임산부";
				ENTER_AGAIN = "잘못 입력하셨습니다.";
				TOTAL_PRICE = "가격은 %d 원 입니다.\n감사합니다\n\n";
				KEEP_BUY_TICKET = "계속 발권 하시겠습니까?";
				KEEP_BUY_TICKET_GOING = "1. 티켓 발권";
				KEEP_BUY_TICKET_STOP = "2. 종료";
				EXIT_TICKET_PROGRAM = "티켓 발권을 종료합니다. 감사합니다.";
				EVERLAND = "========================에버랜드========================";
				SELECT_TICKET_TYPE_DAY = "주간권 ";
				SELECT_TICKET_TYPE_NIGHT = "야간권 ";
				baby = "유아   ";
				kid = "소인   ";
				teen = "청소년   ";
				adult = "대인   ";
				oldman = "노인   ";
				forNone = "*우대적용 없음";
				forDisabled = "*장애인 우대적용";
				forMerities = "*국가유공자 우대적용";
				forMultiChild = "*다자녀 우대적용";
				forPregnant = "*임산부 우대적용";
				PRINT_TOTAL_PRICE = "입장료 총액은 %d원 입니다.\n";
				KEEP_ORDERING = "계속 진행(1. 새로운 주문, 2.: 프로그램 종료): ";
			} else if(language.equals("US")){
				SELECT_TICKET_TYPE = "Please select a ticket type.";
				dayTicket = "1. Day ticket";
				nightTicket = "2. Night ticket";
				INPUT_ID = "Please enter the 13 digits of your resident registration number.";
				HOW_MANY_TICKET_BUY = "You can purchase a minimum of 1 and a maximum of 10.";
				CHOOSE_BENIFIT_NUMBER = "Please select a preference.\n1. None\n2. Disabled\n3. National merit\n4. Multiple children\n5. Pregnant woman";
				ENTER_AGAIN = "You entered it incorrectly.";
				TOTAL_PRICE = "Price is %d Won.";
				KEEP_BUY_TICKET = "Would you like to proceed with ticketing?";
				KEEP_BUY_TICKET_GOING = "1. Get tickets";
				KEEP_BUY_TICKET_STOP = "2. Exit";
				EXIT_TICKET_PROGRAM = "End ticket issuance. thank you.";
				EVERLAND = "========================EVERLAND========================";
				SELECT_TICKET_TYPE_DAY = "Dayt ticket ";
				SELECT_TICKET_TYPE_NIGHT = "Night ticket ";
				baby = "baby   ";
				kid = "kid   ";
				teen = "teen   ";
				adult = "adult   ";
				oldman = "oldman   ";
				forNone = "*No preferential treatment";
				forDisabled = "*Preferential treatment for the disabled";
				forMerities = "*Preferential treatment for the national merit";
				forMultiChild = "*Preferential treatment for the Multi child.";
				forPregnant = "*Preferential treatment for the pregnant";
				PRINT_TOTAL_PRICE = "Enterance fee is %dwon.\n";
				KEEP_ORDERING = "Continue (1. New order, 2.: Program terminated): ";
			} else if(language.equals("JP")){
				SELECT_TICKET_TYPE = "入場券を選択してください.";
				dayTicket = "1. 週刊権";
				nightTicket = "2. 夜間券";
				INPUT_ID = "住民登録番号を入力してください。（13桁）";
				HOW_MANY_TICKET_BUY = "いくつご注文なさいますか。（最大10個）";
				CHOOSE_BENIFIT_NUMBER = "優待事項を選択してください。\n1. なし\n2.障害者\n3.国家有功者\n4.多子女\\n5.妊婦";
				ENTER_AGAIN = "誤入力しました.";
				TOTAL_PRICE = "価格は%dウォンです。\nありがとうございます\n\n";
				KEEP_BUY_TICKET = "発券し続けますか？";
				KEEP_BUY_TICKET_GOING = "1. チケット発券";
				KEEP_BUY_TICKET_STOP = "2. 終了, 結了, 納め.";
				EXIT_TICKET_PROGRAM = "チケットの発券を終了します。 ありがとうございます。.";
				EVERLAND = "========================エバーランド========================";
				SELECT_TICKET_TYPE_DAY = "週刊権 ";
				SELECT_TICKET_TYPE_NIGHT = "夜間券 ";
				baby = "乳児.   ";
				kid = "小人.   ";
				teen = "青少年.   ";
				adult = "大人.   ";
				oldman = "老人   ";
				forNone = "*優待適用なし";
				forDisabled = "*障害者優待適用";
				forMerities = "*国家有功者優待適用";
				forMultiChild = "*多子女優待適用";
				forPregnant = "*妊婦優待適用";
				PRINT_TOTAL_PRICE = "入場料総額は%dウォンです.\n";
				KEEP_ORDERING = "継続進行(1.新しい注文、2.:プログラム終了): ";
			}
		}
	}
