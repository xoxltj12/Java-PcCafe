package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drink implements MenuOrder {
	private String[] DrinkName = { "�ݶ�", "���̴�", "Ŀ��" };
	private String[] DrinkSize = { "���ַ�", "����", "��������" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < DrinkName.length; i++)
					System.out.println((i + 1) + "." + DrinkName[i]);
				System.out.println("������ ������ ������ �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DrinkName.length);
			System.out.println(DrinkName[select - 1] + "�� �����Ͽ����ϴ�.\n");
			type = select;

			do {
				for (int i = 0; i < DrinkSize.length; i++)
					System.out.println((i + 1) + "." + DrinkSize[i]);
				System.out.println("������ ������ ���� �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > DrinkSize.length);
			System.out.println(DrinkSize[select - 1] + "�� �����Ͽ����ϴ�.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	public void print() {
		System.out.println("����[����:" + DrinkName[type - 1] + "][��:" + DrinkSize[size - 1] + "]");
	}

}
