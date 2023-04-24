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

		do {
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

			System.out.println("계속 진행(1: 새로운 주문, 2: 프로그램 종료): ");
			isExit = scanner.nextInt();

		} while (isExit == 1);
	}
}
