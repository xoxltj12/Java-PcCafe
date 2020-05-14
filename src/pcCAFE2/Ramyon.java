package pcCAFE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ramyon implements MenuOrder {
	private String[] RamyonName = { "�Ŷ��", "�ʱ���", "��¡��«��", "¥�İ�Ƽ" };
	private String[] RamyonTopping = { "ġ��", "���", "�����" };

	private int type = 0;
	private int size = 0;

	public void order() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int select = 0;
			do {
				for (int i = 0; i < RamyonName.length; i++)
					System.out.println((i + 1) + "." + RamyonName[i]);
				System.out.println("������ ����� ������ �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > RamyonName.length);
			System.out.println(RamyonName[select - 1] + "�� �����Ͽ����ϴ�.\n");
			type = select;

			do {
				for (int i = 0; i < RamyonTopping.length; i++)
					System.out.println((i + 1) + "." + RamyonTopping[i]);
				System.out.println("������ ������ �Է��ϼ���.");
				select = Integer.parseInt(in.readLine());
			} while (select < 1 || select > RamyonTopping.length);
			System.out.println(RamyonTopping[select - 1] + "�� �����Ͽ����ϴ�.\n");
			size = select;
		} catch (IOException e) {
			System.out.println("Ramyon order error:" + e);
		}
	}

	@Override
	public void print() {
		System.out.println("���[����:" + RamyonName[type - 1] + "][����:" + RamyonTopping[size - 1] + "]");

	}

}
