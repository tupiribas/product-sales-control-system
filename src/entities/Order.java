package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;

	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat SDF2 = new SimpleDateFormat("dd/MM/yyyy");
	private List<OrderItem> listOrderItem = new ArrayList<>();

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		listOrderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		listOrderItem.remove(item);
	}

	public Double total() {
		double som = 0;
		for (OrderItem oI : listOrderItem) {
			som += oI.subTotal();
		}
		return som;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: " + SDF.format(this.getMoment()) + "\n");
		sb.append("Order status: " + this.getStatus() + "\n");
		sb.append("Client: " + this.getClient().getName() + " ");
		sb.append(SDF2.format(this.getClient().getBirthDate()) + " - " + this.getClient().getEmail() + "\n");
		sb.append("Order itens: \n");
		for (OrderItem oI : listOrderItem) {
			sb.append(oI.getProduct().getNome() + ", $" + String.format("%.2f", oI.getPrice()) + ", Quantity: "
					+ oI.getQuantity() + ", Subtotal: $" + String.format("%.2f", oI.subTotal()) + "\n");
		}
		sb.append("\nTotal price: " + String.format("%.2f", this.total()));

		return sb.toString();
	}

}
