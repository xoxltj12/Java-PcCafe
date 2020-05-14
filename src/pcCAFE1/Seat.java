package pcCAFE1;

import java.util.Scanner;

public class Seat {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean eof = false;
		int sel = 0;
		int number = 0;
		int[] seat = newArr();

		while (!eof) {
			System.out.println("==========menu=========");
			System.out.println("1.�¼� ���� 2.�¼� ���� 3.���� ���4.��ü�¼� ��ȸ");
			sel = Integer.parseInt(scan.nextLine());

			switch (sel) {
			case 1: // �¼� ��ȸ
				System.out.println("1.�¼� ����");
				number = rightNum(inputNum());
				choice(seat, number);
				break;

			case 2: // �¼� ����
				System.out.println("2.�¼� ����");
				number = rightNum(inputNum());
				cancel(seat, number);
				break;

			case 3: // ���� ���
				System.out.println("3.���� ���");
				number = rightNum(inputNum());
				check(seat, number);
				break;

			case 4: // ��ü �¼� ��ȸ
				System.out.println("4. ��ü�¼� ��ȸ");
				total(seat);
			}// end of switch
		} // end of while
	}

	private static void total(int[] seat) {
		for (int i = 1; i < seat.length; i++) {
			check(seat, i);
		}

	}

	public static void check(int[] seat, int seatNum) {

		String state = "";

		if (seat[seatNum - 1] == 1) {
			state = "�����";

		} else if (seat[seatNum - 1] == 0) {
			state = "���ð���";
		}
		// ���
		System.out.println(seatNum + "�� �¼� : " + state);
	}

	public static void cancel(int[] seat, int seatNum) {
		if (seat[seatNum - 1] == 0) {
			System.out.println("����� �ڼ� ����");

		} else {
			if (selYes() == 1) { // ��� �Ҷ�
				seat[seatNum - 1] = 0;
				System.out.println("���!");
			} else if (selYes() == 2) { // ��� ���Ҷ�
				System.out.println("ó������");
			} else { // 1,2 �̿��� ��ȣ
				System.out.println("�߸��Է���");

			}
		}
	}

	public static int selYes() {
		int yes = 0;

		System.out.println("���� �Ǵ� ��� �Ͻðڽ��ϱ�? (1. yes 2. no) :");
		return yes = Integer.parseInt(scan.nextLine());
	}

	public static void choice(int[] seat, int seatNum) {
		if (seat[seatNum - 1] == 1) {
			System.out.println("���� �Ұ� / ������� �¼��Դϴ�.");
		} else {
			if (selYes() == 1) {
				seat[seatNum - 1] = 1;
				System.out.println("���õǾ����ϴ�.");
			} else if (selYes() == 2) {
				System.out.println("�����ܰ��");
			} else {
				System.out.println("�߸��ԷµǾ����ϴ�.");
			}
		}
	}

	public static int rightNum(int seatNum) {
		while (seatNum > 100 || seatNum < 1) {
			System.out.println("�� �ٽ��Է�: ");
			seatNum = Integer.parseInt(scan.nextLine());
		}
		;
		return seatNum;
	}

	public static int inputNum() { // �¼���ȣ �Է� �޼ҵ�
		System.out.println("�¼���ȣ �Է� : ");
		int seatNum = Integer.parseInt(scan.nextLine());
		return seatNum;
	}

	private static int[] newArr() { // �迭�ʱ�ȭ
		int[] seat = new int[100]; // �迭����

		for (int i = 0; i < seat.length; i++) {
			seat[i] = 0;

		}
		return seat;

	}

}
