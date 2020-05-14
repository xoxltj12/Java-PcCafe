package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drink implements MenuOrder {
	private String[] DrinkName = { "콜라", "사이다", "커피" };
	private String[] DrinkSize = { "레귤러", "라지", "엑스라지" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < DrinkName.length; i++)
					System.out.println((i + 1) + "." + DrinkName[i]);
				System.out.println("구매할 음료의 종류를 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DrinkName.length);
			System.out.println(DrinkName[select - 1] + "를 구매하였습니다.\n");
			type = select;

			do {
				for (int i = 0; i < DrinkSize.length; i++)
					System.out.println((i + 1) + "." + DrinkSize[i]);
				System.out.println("구매할 음료의 양을 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DrinkSize.length);
			System.out.println(DrinkSize[select - 1] + "를 구매하였습니다.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	public void print() {
		System.out.println("음료[종류:" + DrinkName[type - 1] + "][양:" + DrinkSize[size - 1] + "]");
	}

}
