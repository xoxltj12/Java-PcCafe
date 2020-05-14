package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ramyon implements MenuOrder {
	private String[] RamyonName = { "신라면", "너구리", "오징어짬뽕", "짜파게티" };
	private String[] RamyonTopping = { "치즈", "계란", "공기밥" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < RamyonName.length; i++)
					System.out.println((i + 1) + "." + RamyonName[i]);
				System.out.println("구매할 라면의 종류를 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > RamyonName.length);
			System.out.println(RamyonName[select - 1] + "를 구매하였습니다.\n");
			type = select;

			do {
				for (int i = 0; i < RamyonTopping.length; i++)
					System.out.println((i + 1) + "." + RamyonTopping[i]);
				System.out.println("구매할 토핑을 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > RamyonTopping.length);
			System.out.println(RamyonTopping[select - 1] + "를 구매하였습니다.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	@Override
	public void print() {
		System.out.println("라면[종류:" + RamyonName[type - 1] + "][토핑:" + RamyonTopping[size - 1] + "]");

	}

}
