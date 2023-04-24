package ticketPackage;

import java.util.Scanner;

public class OutputClass {
	inputClass ipc = new inputClass();
	RunTicketClass rtc = new RunTicketClass();
	Scanner scanner = new Scanner(System.in);

	public void pricePrint(int priceResult) {
		System.out.printf("가격은 %d 원 입니다.\n", priceResult);
		System.out.printf("감사합니다.\n\n");
	}
	
	public void orderPrint(int priceResult, int[][] orderList, int totalPrice, int cnt) {
		System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("\n");
		System.out.printf("===============에버랜드===============\n");
		
		for (int i = 0; i < cnt; i++) {
			switch (orderList[i][0]) {
			case 1:
				System.out.printf("주간권  ");
				break;
			case 2:
				System.out.printf("야간권  ");
				break;
			default:
				break;
			}

			if (rtc.calcAgeGroup(orderList[i][1]) == TicketConstValueClass.BABY) {
				System.out.printf("유아 ");
			} else if (rtc.calcAgeGroup(orderList[i][1]) == TicketConstValueClass.CHILD) {
				System.out.printf("어린이 ");
			} else if (rtc.calcAgeGroup(orderList[i][1]) == TicketConstValueClass.TEEN) {
				System.out.printf("청소년 ");
			} else if (rtc.calcAgeGroup(orderList[i][1]) == TicketConstValueClass.ADULT) {
				System.out.printf("어른 ");
			} else {
				System.out.printf("노인 ");
			}
			System.out.printf("X %3d", orderList[i][2]);
			System.out.printf("%8d원    ", orderList[i][3]);

			switch (orderList[i][4]) {
			case 1:
				System.out.printf("*우대적용 없음\n");
				break;
			case 2:
				System.out.printf("*장애인 우대적용\n");
				break;
			case 3:
				System.out.printf("*국가유공자 우대적용\n");
				break;
			case 4:
				System.out.printf("*다자녀 우대적용\n");
				break;
			case 5:
				System.out.printf("*임산부 우대적용\n");
				break;
			default:
				break;
			}
		}
		
		System.out.printf("\n");
		System.out.printf("입장료 총액은 %d원 입니다.\n", totalPrice);
		System.out.printf("===================================================\n");
		System.out.printf("\n");
}
	
	public int orderContinue() {

		int continueSelect = 0;
		
		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
		while (true) {
			continueSelect = scanner.nextInt();
			if (continueSelect == 1 || continueSelect == 2) {
				break;
			}
			else {
				errorMessagePrint();
			}
		}
		return continueSelect;
	}

	public static void errorMessagePrint() {
		System.out.printf("잘못 입력하셨습니다.\n");
	}

}
