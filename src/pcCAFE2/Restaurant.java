package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private static int menu;

	public static void main(String[] args) {
		List<MenuOrder> orderList = new ArrayList<MenuOrder>();
		MenuOrder order = null;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int memu = 0;
		int option = 0;

		try {
			do {
				System.out.println("1.�޴� �ֹ�");
				System.out.println("2.�ֹ� Ȯ��");
				System.out.println("3.�ֹ� ó��");
				System.out.println("0.��       ��");
				System.out.println("��� ����");

				menu = Integer.parseInt(in.readLine());

				switch (memu) {
				case 1:
					do {
						System.out.println("1.���");
						System.out.println("2.����");
						System.out.println("3.�н�");
						System.out.println("4.���ö�");
						System.out.println("0.�� ��");
						System.out.println("�޴��� �����ϼ���.");
						option = Integer.parseInt(in.readLine());

						switch (option) {
						case 1:
							order = new Ramyon();
							break;
						case 2:
							order = new Drink();
							break;
						case 3:
							order = new Bunsik();
							break;
						case 4:
							order = new Dosirak();
							break;
						case 0:
							break;
						default:
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
							continue;
						}
						if (order == null) {
							order.order();
							orderList.add(order);
						}
						order = null;
					} while (option < 1 || option > 5);
					break;

				case 2:
					for (MenuOrder mo : orderList)
						mo.print();
					break;
				case 3:
					if (orderList.size() > 0)
						orderList.remove(1);
					else
						System.out.println("�� �̻� ó���� �ֹ��� �����ϴ�.");
					break;
				default:
					System.out.println("�߸� �� �Է��Դϴ�. �ٽ��Է��� �ֽʽÿ�.");
				}
			} while (menu != 0);
		} catch (IOException e) {

		}
	}

}
