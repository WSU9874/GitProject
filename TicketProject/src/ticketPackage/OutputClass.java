package ticketPackage;

import java.util.Scanner;

public class OutputClass {
	Scanner scanner = new Scanner(System.in);

	public void PrintinputTicketSelect() {
		System.out.println("권종을 선택하세요.\n1. 주간권\n2. 야간권\n");
	}

	public void PrintinputCustomerIDNumber() {
		System.out.println("주민등록번호를 입력하세요.(13자리)\n");
	}

	public void PrintinputOrderCount() {
		System.out.println("몇개를 주문하시겠습니까(최대 10개)\n");
	}

	public void PrintinputDiscountSelect() {
		System.out.println("우대사항을 선택하세요.\n1. 없음\n2. " + "장애인\n3. 국가유공자\n4. 다자녀\n5. 임산부\n");
	}

	public void errorMessagePrint() {
		System.out.printf("잘못 입력하셨습니다.\n");
	}

	public void pricePrint(int priceResult) {
		System.out.printf("가격은 %d 원 입니다.\n", priceResult);
		System.out.printf("감사합니다.\n\n");
	}

	public void PrintOrderContinue() {

		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
	}

	public void orderPrint(int totalPrice1) {
		System.out.printf("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.printf("\n");
		System.out.printf("===============에버랜드===============\n");
		for (OrderList order : RunTicketClass.data) {
			if (order.getTicketSelect() == 1)
				System.out.print("주간권 ");
			else
				System.out.print("야간권 ");

			if (order.getAgegroup() == 1)
				System.out.println("유아   ");
			else if (order.getAgegroup() == 2)
				System.out.print("소인   ");
			else if (order.getAgegroup() == 3)
				System.out.print("청소년   ");
			else if (order.getAgegroup() == 4)
				System.out.print("대인   ");
			else if (order.getAgegroup() == 5)
				System.out.print("노인   ");

			System.out.printf("x %d\t%d원  \t", order.getOrderCount(), order.getTotalPrice());

			switch (order.getDiscountSelect()) {
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

			}
		}
		System.out.printf("\n");
		System.out.printf("입장료 총액은 %d원 입니다.\n", totalPrice1);
		System.out.printf("===================================================\n");
		System.out.printf("\n");

	}
}