package ticketPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class OutputClass {
	Scanner scanner = new Scanner(System.in);
	
	public void RunTranslate() {
		TicketConstValueClass.startLanguage();
	}
	
	public void PrintinputTicketSelect() {
		RunTranslate();
		System.out.println(TicketConstValueClass.SELECT_TICKET_TYPE);
		System.out.println(TicketConstValueClass.dayTicket);
		System.out.println(TicketConstValueClass.nightTicket);
	}

	public void PrintinputCustomerIDNumber() {
		System.out.println(TicketConstValueClass.INPUT_ID);
	}

	public void PrintinputOrderCount() {
		System.out.println(TicketConstValueClass.HOW_MANY_TICKET_BUY);
	}

	public void PrintinputDiscountSelect() {
		System.out.println(TicketConstValueClass.CHOOSE_BENIFIT_NUMBER);
	}

	public void errorMessagePrint() {
		System.out.println(TicketConstValueClass.ENTER_AGAIN);
	}

	public void pricePrint(int priceResult) {
		System.out.printf(TicketConstValueClass.TOTAL_PRICE, priceResult);
	}

	public void PrintOrderContinue() {
		System.out.println(TicketConstValueClass.KEEP_BUY_TICKET);
		System.out.println(TicketConstValueClass.KEEP_BUY_TICKET_GOING);
		System.out.println(TicketConstValueClass.KEEP_BUY_TICKET_STOP);
	}

	public void orderPrint(int totalPrice1) {
		System.out.println(TicketConstValueClass.EXIT_TICKET_PROGRAM);
		System.out.printf("\n");
		System.out.println(TicketConstValueClass.EVERLAND);
		
		
		for (OrderList order : RunTicketClass.data) {
			if (order.getTicketSelect() == 1)
				System.out.print(TicketConstValueClass.SELECT_TICKET_TYPE_DAY);
			else
				System.out.print(TicketConstValueClass.SELECT_TICKET_TYPE_NIGHT);

			if (order.getAgegroup() == 1)
				System.out.println(TicketConstValueClass.baby);
			else if (order.getAgegroup() == 2)
				System.out.print(TicketConstValueClass.kid);
			else if (order.getAgegroup() == 3)
				System.out.print(TicketConstValueClass.teen);
			else if (order.getAgegroup() == 4)
				System.out.print(TicketConstValueClass.adult);
			else if (order.getAgegroup() == 5)
				System.out.print(TicketConstValueClass.oldman);

			System.out.printf("x %d\t\\%d  \t", order.getOrderCount(), order.getTotalPrice());

			switch (order.getDiscountSelect()) {
			case 1:
				System.out.println(TicketConstValueClass.forNone);
				break;
			case 2:
				System.out.println(TicketConstValueClass.forDisabled);
				break;
			case 3:
				System.out.println(TicketConstValueClass.forMerities);
				break;
			case 4:
				System.out.println(TicketConstValueClass.forMultiChild);
				break;
			case 5:
				System.out.println(TicketConstValueClass.forPregnant);
				break;
			default:

			}
			try {
				FileWriter fw = new FileWriter("C:\\Users\\w\\Desktop\\report.csv", true);
				LocalDateTime currentDateTime = LocalDateTime.now();
				fw.write(currentDateTime + "," + order.getTicketSelect() + "," + order.getAgegroup() + ","
						+ order.getOrderCount() + "," + order.getTotalPrice() + "," + order.getDiscountSelect() + "\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.printf("\n");
		System.out.printf(TicketConstValueClass.PRINT_TOTAL_PRICE, totalPrice1);
		System.out.printf("===================================================\n");
		System.out.printf("\n");

		// currentDateTime, 권종, 연령구분, 수량 , 가격, 우대사항

	}

}