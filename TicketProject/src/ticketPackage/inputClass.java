package ticketPackage;

import java.util.Scanner;

public class inputClass {
	OutputClass opc = new OutputClass();
	Scanner scanner = new Scanner(System.in);

	public int inputTicketSelect() {		
		int ticketSelect = 0;
		opc.PrintinputTicketSelect();
		while (true) {
			ticketSelect = scanner.nextInt();
			if (ticketSelect == 1 || ticketSelect == 2) {
				break;
			} else {
				opc.errorMessagePrint();
			}
		}
		return ticketSelect;
	}

	public long inputCustomerIDNumber() {
		long customerIDNumber = 0L;
		opc.PrintinputCustomerIDNumber();
		while (true) {
			customerIDNumber = scanner.nextLong();
			if ((customerIDNumber >= TicketConstValueClass.FULL_DIGIT_MIN
					&& customerIDNumber < TicketConstValueClass.FULL_DIGIT)) {
				break;
			} else {
				opc.errorMessagePrint();
			}
		}
		return customerIDNumber;
	}

	public int inputOrderCount() {
		int orderCount = 0;
		opc.PrintinputOrderCount();
		while (true) {
			orderCount = scanner.nextInt();
			if ((orderCount <= TicketConstValueClass.MAX_COUNT) && (orderCount >= TicketConstValueClass.MIN_COUNT)) {
				break;
			} else {
				opc.errorMessagePrint();
			}
		}
		return orderCount;
	}

	public int inputDiscountSelect() {
		int discountSelect = 0;
		opc.PrintinputDiscountSelect();
		while (true) {
			discountSelect = scanner.nextInt();
			if (discountSelect >= 1 && discountSelect <= 5) {
				break;
			} else {
				opc.errorMessagePrint();
			}
		}
		return discountSelect;
	}
	
	public int orderContinue() {
		int continueSelect;
		opc.PrintOrderContinue();
		while (true) {
			continueSelect = scanner.nextInt();
			if (continueSelect == 1 || continueSelect == 2) {
				break;
			} else {
				opc.errorMessagePrint();
			}
		}
		return continueSelect;
	}
}



