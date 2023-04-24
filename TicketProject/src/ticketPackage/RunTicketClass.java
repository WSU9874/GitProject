package ticketPackage;

import java.util.ArrayList;
import java.util.List;

public class RunTicketClass {
	inputClass ipc = new inputClass();
	static List<OrderList> data = new ArrayList<OrderList>();

	public int calcPriceProcess(int agegroup, int ticketSelect) {
		int calcPrice = 0;

		if (agegroup == TicketConstValueClass.BABY) {
			calcPrice = TicketConstValueClass.BABY_PRICE;
		} else if (agegroup == TicketConstValueClass.CHILD) {
			if (ticketSelect == 1) {
				calcPrice = TicketConstValueClass.CHILD_DAY_PRICE;
			} else if (ticketSelect == 2) {
				calcPrice = TicketConstValueClass.CHILD_NIGHT_PRICE;
			}
		} else if (agegroup == TicketConstValueClass.TEEN) {
			if (ticketSelect == 1) {
				calcPrice = TicketConstValueClass.TEEN_DAY_PRICE;
			} else if (ticketSelect == 2) {
				calcPrice = TicketConstValueClass.TEEN_NIGHT_PRICE;
			}
		} else if (agegroup == TicketConstValueClass.ADULT) {
			if (ticketSelect == 1) {
				calcPrice = TicketConstValueClass.ADULT_DAY_PRICE;
			} else if (ticketSelect == 2) {
				calcPrice = TicketConstValueClass.ADULT_NIGHT_PRICE;
			}
		} else {
			calcPrice = TicketConstValueClass.OLD_DAY_PRICE;
		}
		return calcPrice;
	}

	public int calcDiscount(int calcPrice, int discountSelect) {
		int Discount = 0;

		switch (discountSelect) {
		case 2:
			Discount = (int) (calcPrice * TicketConstValueClass.DISABLE_DISCOUNT_RATE);
			break;
		case 3:
			Discount = (int) (calcPrice * TicketConstValueClass.MERIT_DISCOUNT_RATE);
			break;
		case 4:
			Discount = (int) (calcPrice * TicketConstValueClass.MULTICHILD_DISCOUNT_RATE);
			break;
		case 5:
			Discount = (int) (calcPrice * TicketConstValueClass.PREGNANT_DISCOUNT_RATE);
			break;
		default:
			Discount = calcPrice;
			break;
		}
		return Discount;
	}

	public int calcPriceResult(int Discount, int orderCount) {
		int totalPrice = Discount * orderCount;
		return totalPrice;
	}

	public void inputData(int tickectSelect, long customerIDNumber, int orderCount, int discountSelect, int agegroup,
			int totalPrice) {
		OrderList order = new OrderList();
		order.setTicketSelect(tickectSelect);
		order.setCustomerIDNumber(customerIDNumber);
		order.setOrderCount(orderCount);
		order.setDiscountSelect(discountSelect);
		order.setAgegroup(agegroup);
		order.setTotalPrice(totalPrice);
		data.add(order);
	}

}