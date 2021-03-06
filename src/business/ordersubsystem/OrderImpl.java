package business.ordersubsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import business.externalinterfaces.Address;
import business.externalinterfaces.CreditCard;
import business.externalinterfaces.Order;
import business.externalinterfaces.OrderItem;

public class OrderImpl implements Order {
	private List<OrderItem> orderItems;
	private int orderId;
	private LocalDate date;
	private double totalPrice;
	
	private Address shippingAddress;
	private Address billingAddress;
	private CreditCard cc;
	
	public OrderImpl() {
	}

	public void addOrderItem(OrderItem orderItem){
		if(orderItems==null) 
			orderItems = new ArrayList<OrderItem>();
		orderItems.add(orderItem);
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public double getTotalPrice() {
		if(orderItems == null) {
			return 0.0;
		} else {
			 DoubleSummaryStatistics summary 
			    = orderItems.stream().collect(
				    Collectors.summarizingDouble(
					   (OrderItem item) -> item.getUnitPrice() * item.getQuantity()));
			 return summary.getSum();
		}
	}
	
	public LocalDate getOrderDate() {
		//note that LocalDates are immutable
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public Address getShipAddress() {

		return shippingAddress;
	}

	@Override
	public Address getBillAddress() {

		return billingAddress;
	}

	@Override
	public CreditCard getPaymentInfo() {

		return cc;
	}

	@Override
	public void setShipAddress(Address add) {

		this.shippingAddress = add;
	}

	@Override
	public void setBillAddress(Address add) {

		this.billingAddress = add;
	}

	@Override
	public void setPaymentInfo(CreditCard cc) {

		this.cc = cc;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderImpl [orderItems=" + orderItems + ", orderId=" + orderId + ", date=" + date + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + ", cc=" + cc + "]";
	}
	
	
}
