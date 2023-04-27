package ticketPackage;

public class OrderList {

	private int ticketSelect;
	private int agegroup;
	private int orderCount;
	private int discountSelect;
	private long customerIDNumber;
	private int totalPrice;

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getCustomerIDNumber() {
		return customerIDNumber;
	}

	public void setCustomerIDNumber(long customerIDNumber) {
		this.customerIDNumber = customerIDNumber;
	}

	public int getTicketSelect() {
		return ticketSelect;
	}

	public void setTicketSelect(int ticketSelect) {
		this.ticketSelect = ticketSelect;
	}

	public int getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getDiscountSelect() {
		return discountSelect;
	}

	public void setDiscountSelect(int discountSelect) {
		this.discountSelect = discountSelect;
	}
}