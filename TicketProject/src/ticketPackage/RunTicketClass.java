package ticketPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RunTicketClass {
	inputClass ipc = new inputClass();
	
	public int calcAge(long customerIDNumber) {
		long calcIDNumber;
		long customerYear, customerMonth, customerDay;
		long type;
		long koreanAge;
		int age;
		
		customerIDNumber += TicketConstValueClass.FULL_DIGIT;
		calcIDNumber = customerIDNumber / TicketConstValueClass.SEVEN_DIGIT;
		type = calcIDNumber % 10;
		calcIDNumber /= TicketConstValueClass.ONE_DIGIT;
		customerDay = calcIDNumber % TicketConstValueClass.TWO_DIGIT;
		calcIDNumber /= TicketConstValueClass.TWO_DIGIT;
		customerMonth = calcIDNumber % TicketConstValueClass.TWO_DIGIT;
		calcIDNumber /= TicketConstValueClass.TWO_DIGIT;
		customerYear = calcIDNumber % TicketConstValueClass.TWO_DIGIT;
		
		if((type == TicketConstValueClass.MALE_NEW) || (type == TicketConstValueClass.FEMALE_NEW)) {
			customerYear += TicketConstValueClass.NEW_GENERATION;
		} else {
			customerYear += TicketConstValueClass.OLD_GENERATION;
		}
		
		LocalDate now = LocalDate.now();
		
		int todayYear = now.getYear();
		int todayMonth = now.getMonthValue();
		int todayDay = now.getDayOfMonth();
		
		koreanAge = todayYear - customerYear +1;
		
		if((customerMonth < todayMonth) || ((customerMonth == todayMonth) && (customerDay <= todayDay))) {
			age = (int) (koreanAge - TicketConstValueClass.AFTER_BIRTH);
		} else {
			age = (int) (koreanAge - TicketConstValueClass.BEFORE_BIRTH);
		}

		return age;
	}

	public int calcAgeGroup(int age) {
		int agegroup;
		if (age < TicketConstValueClass.MIN_CHILD) {
			agegroup = 1;
			return agegroup;
		} else if ((age >= TicketConstValueClass.MIN_CHILD) && (age <= TicketConstValueClass.MAX_CHILD)) {
			agegroup = 2;
			return agegroup;
		} else if ((age >= TicketConstValueClass.MIN_TEEN) && (age <= TicketConstValueClass.MAX_TEEN)) {
			agegroup = 3;
			return agegroup;
		} else if ((age >= TicketConstValueClass.MIN_ADULT) && (age <= TicketConstValueClass.MAX_ADULT)) {
			agegroup = 4;
			return agegroup;
		} else if (age > TicketConstValueClass.MAX_ADULT) {
			agegroup = 5;
			return agegroup;
		}
		return 0;


	}

	public int calcPriceProcess(int age, int ticketSelect) {
		int calcPrice = 0;
		int agegroup = calcAgeGroup(age);
		
		if(agegroup == TicketConstValueClass.BABY) {
			calcPrice = TicketConstValueClass.BABY_PRICE;
		}else if(agegroup == TicketConstValueClass.CHILD) {
			if(ticketSelect == 1) {
				calcPrice = TicketConstValueClass.CHILD_DAY_PRICE;
			}else if(ticketSelect ==2) {
				calcPrice = TicketConstValueClass.CHILD_NIGHT_PRICE;
			}
		}else if(agegroup == TicketConstValueClass.TEEN) {
			if(ticketSelect == 1) {
				calcPrice = TicketConstValueClass.TEEN_DAY_PRICE;
			}else if(ticketSelect ==2) {
				calcPrice = TicketConstValueClass.TEEN_NIGHT_PRICE;
			}
		}else if(agegroup == TicketConstValueClass.ADULT) {
			if(ticketSelect == 1) {
				calcPrice = TicketConstValueClass.ADULT_DAY_PRICE;
			}else if(ticketSelect ==2) {
				calcPrice = TicketConstValueClass.ADULT_NIGHT_PRICE;
			}
		}else {
			calcPrice = TicketConstValueClass.OLD_DAY_PRICE;
		}
		return calcPrice;
	}
	
	public int calcDiscount(int age, int ticketSelect, int calcPrice, int discountSelect) {
		int Discount = 0;
		
		calcPrice = calcPriceProcess(age, ticketSelect); 
		
		switch(discountSelect) {
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
		return Discount * orderCount;
	}
	
	public int processIntegration(long customerIDNumber, int ticketSelect, int discountSelect,
									int orderCount, int age) {
		int calcPrice;
		int priceResult;
		
		age = calcAge(customerIDNumber);
		calcPrice = calcPriceProcess(age, ticketSelect);
		int Discount = calcDiscount(age, ticketSelect, calcPrice, discountSelect);
		priceResult = calcPriceResult(Discount, orderCount);
		
		return priceResult;
	}
	
	public int[][] saveOrderList(int ticketSelect, int age, int orderCount, int priceResult,
								int discountSelect, int[][] orderList, int cnt) {
		

		orderList[cnt][0] = ticketSelect;
		orderList[cnt][1] = age;
		orderList[cnt][2] = orderCount;
		orderList[cnt][3] = priceResult;
		orderList[cnt][4] = discountSelect;
		

	return orderList;
		
	}

//	public List<Integer> saveOrderList(int ticketSelect, int age, int orderCount, int priceResult, int discountSelect,
//			List<Integer> orderList , int cnt) {
//		
//
//		OrderList order = new OrderList();
//		
//		
//		orderList.add(ticketSelect);
//		orderList.add(age);
//		orderList.add(orderCount);
//		orderList.add(priceResult);
//		orderList.add(discountSelect);
//
//		return orderList;
//	}

}


