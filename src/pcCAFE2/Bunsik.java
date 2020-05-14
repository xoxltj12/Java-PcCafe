package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bunsik implements MenuOrder {
	private String[] BunsikName = { "������", "����", "����", "���" };
	private String[] BunsikSize = { "�⺻", "���߰�" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < BunsikName.length; i++)
					System.out.println((i + 1) + "." + BunsikName[i]);
				System.out.println("������ ������ ������ �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > BunsikName.length);
			System.out.println(BunsikName[select - 1] + "�� �����Ͽ����ϴ�.\n");
			type = select;

			do {
				for (int i = 0; i < BunsikSize.length; i++)
					System.out.println((i + 1) + "." + BunsikSize[i]);
				System.out.println("������ ������ ���� �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > BunsikSize.length);
			System.out.println(BunsikSize[select - 1] + "�� �����Ͽ����ϴ�.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	public void print() {
		System.out.println("����[����:" + BunsikName[type - 1] + "][��:" + BunsikSize[size - 1] + "]");
	}

}
