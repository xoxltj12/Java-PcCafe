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
				System.out.println("1.메뉴 주문");
				System.out.println("2.주문 확인");
				System.out.println("3.주문 처리");
				System.out.println("0.종       료");
				System.out.println("기능 선택");

				menu = Integer.parseInt(in.readLine());

				switch (memu) {
				case 1:
					do {
						System.out.println("1.라면");
						System.out.println("2.음료");
						System.out.println("3.분식");
						System.out.println("4.도시락");
						System.out.println("0.종 료");
						System.out.println("메뉴를 선택하세요.");
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
							System.out.println("잘못 입력하셨습니다.");
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
						System.out.println("더 이상 처리할 주문이 없습니다.");
					break;
				default:
					System.out.println("잘못 된 입력입니다. 다시입력해 주십시오.");
				}
			} while (menu != 0);
		} catch (IOException e) {

		}
	}

}
