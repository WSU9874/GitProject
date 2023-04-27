package ticketPackage;

import java.time.LocalDate;

public class AgeCalc {
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

		if ((type == TicketConstValueClass.MALE_NEW) || (type == TicketConstValueClass.FEMALE_NEW)) {
			customerYear += TicketConstValueClass.NEW_GENERATION;
		} else {
			customerYear += TicketConstValueClass.OLD_GENERATION;
		}

		LocalDate now = LocalDate.now();

		int todayYear = now.getYear();
		int todayMonth = now.getMonthValue();
		int todayDay = now.getDayOfMonth();

		koreanAge = todayYear - customerYear + 1;

		if ((customerMonth < todayMonth) || ((customerMonth == todayMonth) && (customerDay <= todayDay))) {
			age = (int) (koreanAge - TicketConstValueClass.AFTER_BIRTH);
		} else {
			age = (int) (koreanAge - TicketConstValueClass.BEFORE_BIRTH);
		}

		return age;
	}

	public int calcAgeGroup(int age) {
		int agegroup = 0;
		if (age < TicketConstValueClass.MIN_CHILD)
			agegroup = 1;
		else if ((age >= TicketConstValueClass.MIN_CHILD) && (age <= TicketConstValueClass.MAX_CHILD))
			agegroup = 2;
		else if ((age >= TicketConstValueClass.MIN_TEEN) && (age <= TicketConstValueClass.MAX_TEEN))
			agegroup = 3;
		else if ((age >= TicketConstValueClass.MIN_ADULT) && (age <= TicketConstValueClass.MAX_ADULT))
			agegroup = 4;
		else if (age > TicketConstValueClass.MAX_ADULT)
			agegroup = 5;

		return agegroup;

	}
}
