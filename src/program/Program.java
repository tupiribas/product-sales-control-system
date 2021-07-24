package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: \n");
		System.out.print("Name ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/AAAA): ");
		String brithDate = sc.next();

		Client client = new Client(name, email, sdf.parse(brithDate));

		System.out.println("Enter order date: \n");
		System.out.print("Status: ");
		String status = sc.next().toUpperCase();
		System.out.print("How many itens to this order? ");
		int quantOrder = sc.nextInt();

		Order order = new Order(new Date(System.currentTimeMillis()), OrderStatus.valueOf(status), client);

		int i = 1;
		while (i <= quantOrder) {
			System.out.println("Enter " + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String name_P = sc.nextLine();
			System.out.print("Product price: ");
			double price_P = sc.nextDouble();
			System.out.print("Quantity: ");
			int quant_P = sc.nextInt();

			OrderItem orderItem = new OrderItem(quant_P, price_P, new Product(name_P, price_P));
			order.addItem(orderItem);
			// order.removeItem(orderItem);
			i++;
		}

		System.out.println("ORDER SUMARY: \n");
		System.out.println(order);

		sc.close();
	}

}
