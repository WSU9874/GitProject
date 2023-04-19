package ticketPackage;

import java.util.Scanner;

public class inputClass {
	Scanner scanner = new Scanner(System.in);
	private static int ticketSelect;
	public static int getTicketSelect() {
		return ticketSelect;
		
	}

	public static void setTicketSelect(int ticketSelect) {
		inputClass.ticketSelect = ticketSelect;
	}

	public static long getCustomerIDNumber() {
		return customerIDNumber;
	}

	public static void setCustomerIDNumber(long customerIDNumber) {
		inputClass.customerIDNumber = customerIDNumber;
	}

	public static int getOrderCount() {
		return orderCount;
	}

	public static void setOrderCount(int orderCount) {
		inputClass.orderCount = orderCount;
	}

	public static int getDiscountSelect() {
		return discountSelect;
	}

	public static void setDiscountSelect(int discountSelect) {
		inputClass.discountSelect = discountSelect;
	}

	private static long customerIDNumber;
	private static int orderCount;
	private static int discountSelect;
	

	public int inputTicketSelect() {		
		int ticketSelect = 0;
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권\n");
		while (true) {
			ticketSelect = scanner.nextInt();
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				OutputClass.errorMessagePrint();
			}
		}
		return ticketSelect;
	}

	public long inputCustomerIDNumber() {
		long customerIDNumber = 0L;
		System.out.println("주민등록번호를 입력하세요.\n");
		while (true) {
			customerIDNumber = scanner.nextLong();
			if ((customerIDNumber >= TicketConstValueClass.FULL_DIGIT_MIN
					&& customerIDNumber < TicketConstValueClass.FULL_DIGIT)) {
				break;
			} else {
				OutputClass.errorMessagePrint();
			}
		}
		return customerIDNumber;
	}

	public int inputOrderCount() {
		int orderCount = 0;

		System.out.println("몇개를 주문하시겠습니까(최대 10개)\n");
		while (true) {
			orderCount = scanner.nextInt();
			if ((orderCount <= TicketConstValueClass.MAX_COUNT) && (orderCount >= TicketConstValueClass.MIN_COUNT)) {
				break;
			} else {
				OutputClass.errorMessagePrint();
			}
		}
		return orderCount;
	}

	public int inputDiscountSelect() {
		int discountSelect = 0;
		System.out.println("우대사항을 선택하세요.\n1. 없음\n2. 장애인\n3. 국가유공자\n4. 다자녀\n5. 임산부\n");
		while (true) {
			discountSelect = scanner.nextInt();
			if (discountSelect >= 1 && discountSelect <= 5) {
				break;
			} else {
				OutputClass.errorMessagePrint();
			}
		}
		return discountSelect;
	}

	public void inputData() {
		ticketSelect = inputTicketSelect();
		customerIDNumber = inputCustomerIDNumber();
		orderCount = inputOrderCount();
		discountSelect = inputDiscountSelect();
	}

}
