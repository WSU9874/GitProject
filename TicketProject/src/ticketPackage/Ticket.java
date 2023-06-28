package ticketPackage;

import java.util.Scanner;

public class Ticket {

	public static void main(String[] args) {
		inputClass ipc = new inputClass();
		RunTicketClass rtc = new RunTicketClass();
		OutputClass opc = new OutputClass();
		AgeCalc age = new AgeCalc();
		Scanner scanner = new Scanner(System.in);

		long customerIDNumber = 0;
		int ticketSelect = 0, orderCount = 0, discountSelect = 0, agegroup, totalPrice = 0, calcPrice, Discount;
		int continueSelect, totalResultPrice = 0, isExit = 0;

		while (true) {
			do {
				ticketSelect = ipc.inputTicketSelect();
				customerIDNumber = ipc.inputCustomerIDNumber();
				orderCount = ipc.inputOrderCount();
				discountSelect = ipc.inputDiscountSelect();

				agegroup = age.calcAgeGroup(age.calcAge(customerIDNumber));
				calcPrice = rtc.calcPriceProcess(agegroup, ticketSelect);
				Discount = rtc.calcDiscount(calcPrice, discountSelect);
				totalPrice = rtc.calcPriceResult(Discount, orderCount);
				rtc.inputData(ticketSelect, customerIDNumber, orderCount, discountSelect, agegroup, totalPrice);
				continueSelect = ipc.orderContinue();
				totalResultPrice += totalPrice;
			} while (continueSelect == 1);
			opc.orderPrint(totalResultPrice);
			opc.RunTranslate();
			System.out.println(TicketConstValueClass.KEEP_ORDERING);

			do {
				isExit = scanner.nextInt();
				if (isExit != 1 && isExit != 2) {
					System.out.println(TicketConstValueClass.ENTER_AGAIN);
				}
			} while (isExit != 1 && isExit != 2);

			if (isExit == 1) {
				continue;
			} else if (isExit == 2) {
				break;	
			}
		}
	}
}
