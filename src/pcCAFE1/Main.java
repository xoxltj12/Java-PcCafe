package pcCAFE1;

import java.time.*;
import java.util.*;




public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// SubMenu Ŭ������ ��ü ����

		// -> �ݺ��� �ۿ� �ڵ� �ۼ�

		// -> SubMenu Ŭ������ Ư�� �޼ҵ� ȣ�� �غ�

		SubMenu sub = new SubMenu();

		// ���� �޴� �׼� ó�� �߰� -> ���� ����

		while (true) {

			// ���� �޴� ���

			System.out.println("---------------------------------------------");

			System.out.println("1. ȸ�� ���� �Է�  2. ȸ�� ���� ��ü���  3.ȸ�� ���� �˻���");

			System.out.print("����(1~3, 0 quit)?");

			int menu = scan.nextInt();

			// break;

			if (menu == 0) {

				break;

			}

			// �޴��� �׼� �޼ҵ� ȣ�� -> switch ���� ���

			switch (menu) {

			case 1:

				// 1. ȸ�� ���� �Է� -> SubMenu Ŭ������ Ư�� �޼ҵ� ȣ��

				sub.method1(scan);

				break;

			case 2:

				// 2. ȸ�� ���� (��ü)��� -> SubMenu Ŭ������ Ư�� �޼ҵ� ȣ��

				sub.method2();

				break;

			case 3:

				// 3. ȸ�� ���� �˻� -> SubMenu Ŭ������ Ư�� �޼ҵ� ȣ��

				sub.method3(scan);

				break;

			default:

				System.out.println("�߸��� �����Դϴ�.");

				break;

			}

		}

		scan.close();

		System.out.println("���α׷� ����.");

	}

}
