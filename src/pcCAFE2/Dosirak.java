package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dosirak implements MenuOrder {
	private String[] DosirakName = { "불고기백반도시락", "참치마요도시락", "돼지고기도시락", "돈가스도시락" };
	private String[] DosirakSize = { "기본", "양추가" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < DosirakName.length; i++)
					System.out.println((i + 1) + "." + DosirakName[i]);
				System.out.println("구매할 도시락의 종류를 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DosirakName.length);
			System.out.println(DosirakName[select - 1] + "를 구매하였습니다.\n");
			type = select;

			do {
				for (int i = 0; i < DosirakSize.length; i++)
					System.out.println((i + 1) + "." + DosirakSize[i]);
				System.out.println("구매할 도시락의 양을 입력하세요.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DosirakSize.length);
			System.out.println(DosirakSize[select - 1] + "를 구매하였습니다.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	public void print() {
		System.out.println("도시락[종류:" + DosirakName[type - 1] + "][양:" + DosirakSize[size - 1] + "]");
	}

}
