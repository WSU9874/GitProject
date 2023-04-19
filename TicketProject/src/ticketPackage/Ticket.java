package ticketPackage;

import java.util.Scanner;

public class Ticket {
	
	public static void main(String[] args) {
		inputClass ipc = new inputClass();
		RunTicketClass rtc = new RunTicketClass();
		OutputClass opc = new OutputClass();
		
		long customerIDNumber = 0;
		int ticketSelect = 0, orderCount = 0, discountSelect = 0;
		int age = 0;
		int continueSelect;
		int processIntegerationResult;
		int[][] orderList = new int[100][5];
		
//		ticketSelect = ipc.inputTicketSelect();
//		customerIDNumber = ipc.inputCustomerIDNumber();
//		orderCount = ipc.inputOrderCount();
//		discountSelect = ipc.inputDiscountSelect();
//		
//		age = rtc.calcAge(customerIDNumber);
//		int agegroup = rtc.calcAgeGroup(age);
//		int calcPrice = rtc.calcPriceProcess(age,ticketSelect);
//		int Discount = rtc.calcDiscount(age, ticketSelect, calcPrice, discountSelect);
//		priceResult = rtc.calcPriceResult(Discount, orderCount);
//		
//		System.out.println(priceResult);
		
		Scanner scanner = new Scanner(System.in);
		int cnt = 0;
		int totalPrice = 0;
		int isExit = 0;
		do {
			while (true) {
				

				ipc.inputData();
				customerIDNumber = inputClass.getCustomerIDNumber();
				ticketSelect = inputClass.getTicketSelect();
				discountSelect = inputClass.getDiscountSelect();
				orderCount = inputClass.getOrderCount();
				
				
				processIntegerationResult = rtc.processIntegration(customerIDNumber, 
																ticketSelect,
																discountSelect, orderCount,
																age);
				age = rtc.calcAge(customerIDNumber);
				
				
				opc.pricePrint(processIntegerationResult);
				
				totalPrice += processIntegerationResult;
				
				orderList = rtc.saveOrderList(ticketSelect, age, orderCount, processIntegerationResult, discountSelect,
									orderList, cnt);
				//System.out.println("==============="+orderList[0][4]);			

				continueSelect = opc.orderContinue();
				cnt++;

				if (continueSelect == 2) {
					
					break;	
				}
			}
			opc.orderPrint(totalPrice, orderList, totalPrice, cnt);

			System.out.printf("계속 진행(1: 새로운 주문, 2: 프로그램 종료): ");
			isExit = scanner.nextInt();
			totalPrice = 0;

		} while (isExit == 1);
	}
}