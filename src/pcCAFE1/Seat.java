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
			System.out.println("1.좌석 예약 2.좌석 선택 3.선택 취소4.전체좌석 조회");
			sel = Integer.parseInt(scan.nextLine());

			switch (sel) {
			case 1: // 좌석 조회
				System.out.println("1.좌석 예약");
				number = rightNum(inputNum());
				choice(seat, number);
				break;

			case 2: // 좌석 선택
				System.out.println("2.좌석 선택");
				number = rightNum(inputNum());
				cancel(seat, number);
				break;

			case 3: // 선택 취소
				System.out.println("3.선택 취소");
				number = rightNum(inputNum());
				check(seat, number);
				break;

			case 4: // 전체 좌석 조회
				System.out.println("4. 전체좌석 조회");
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
			state = "사용중";

		} else if (seat[seatNum - 1] == 0) {
			state = "선택가능";
		}
		// 출력
		System.out.println(seatNum + "번 좌석 : " + state);
	}

	public static void cancel(int[] seat, int seatNum) {
		if (seat[seatNum - 1] == 0) {
			System.out.println("취소할 자석 없음");

		} else {
			if (selYes() == 1) { // 취소 할때
				seat[seatNum - 1] = 0;
				System.out.println("취소!");
			} else if (selYes() == 2) { // 취소 안할때
				System.out.println("처음으로");
			} else { // 1,2 이외의 번호
				System.out.println("잘못입력함");

			}
		}
	}

	public static int selYes() {
		int yes = 0;

		System.out.println("예약 또는 취소 하시겠습니까? (1. yes 2. no) :");
		return yes = Integer.parseInt(scan.nextLine());
	}

	public static void choice(int[] seat, int seatNum) {
		if (seat[seatNum - 1] == 1) {
			System.out.println("선택 불가 / 사용중인 좌석입니다.");
		} else {
			if (selYes() == 1) {
				seat[seatNum - 1] = 1;
				System.out.println("선택되었습니다.");
			} else if (selYes() == 2) {
				System.out.println("이전단계로");
			} else {
				System.out.println("잘못입력되었습니다.");
			}
		}
	}

	public static int rightNum(int seatNum) {
		while (seatNum > 100 || seatNum < 1) {
			System.out.println("값 다시입력: ");
			seatNum = Integer.parseInt(scan.nextLine());
		}
		;
		return seatNum;
	}

	public static int inputNum() { // 좌석번호 입력 메소드
		System.out.println("좌석번호 입력 : ");
		int seatNum = Integer.parseInt(scan.nextLine());
		return seatNum;
	}

	private static int[] newArr() { // 배열초기화
		int[] seat = new int[100]; // 배열선언

		for (int i = 0; i < seat.length; i++) {
			seat[i] = 0;

		}
		return seat;

	}

}
