package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dosirak implements MenuOrder {
	private String[] DosirakName = { "�Ұ���ݵ��ö�", "��ġ���䵵�ö�", "������⵵�ö�", "���������ö�" };
	private String[] DosirakSize = { "�⺻", "���߰�" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < DosirakName.length; i++)
					System.out.println((i + 1) + "." + DosirakName[i]);
				System.out.println("������ ���ö��� ������ �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DosirakName.length);
			System.out.println(DosirakName[select - 1] + "�� �����Ͽ����ϴ�.\n");
			type = select;

			do {
				for (int i = 0; i < DosirakSize.length; i++)
					System.out.println((i + 1) + "." + DosirakSize[i]);
				System.out.println("������ ���ö��� ���� �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DosirakSize.length);
			System.out.println(DosirakSize[select - 1] + "�� �����Ͽ����ϴ�.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	public void print() {
		System.out.println("���ö�[����:" + DosirakName[type - 1] + "][��:" + DosirakSize[size - 1] + "]");
	}

}
