package pcCAFE1;

import java.time.*;
import java.util.*;




public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// SubMenu 클래스의 객체 생성

		// -> 반복문 밖에 코드 작성

		// -> SubMenu 클래스의 특정 메소드 호출 준비

		SubMenu sub = new SubMenu();

		// 메인 메뉴 액션 처리 추가 -> 무한 실행

		while (true) {

			// 메인 메뉴 출력

			System.out.println("---------------------------------------------");

			System.out.println("1. 회원 정보 입력  2. 회원 정보 전체출력  3.회원 정보 검색▶");

			System.out.print("선택(1~3, 0 quit)?");

			int menu = scan.nextInt();

			// break;

			if (menu == 0) {

				break;

			}

			// 메뉴별 액션 메소드 호출 -> switch 구문 사용

			switch (menu) {

			case 1:

				// 1. 회원 정보 입력 -> SubMenu 클래스의 특정 메소드 호출

				sub.method1(scan);

				break;

			case 2:

				// 2. 회원 정보 (전체)출력 -> SubMenu 클래스의 특정 메소드 호출

				sub.method2();

				break;

			case 3:

				// 3. 회원 정보 검색 -> SubMenu 클래스의 특정 메소드 호출

				sub.method3(scan);

				break;

			default:

				System.out.println("잘못된 선택입니다.");

				break;

			}

		}

		scan.close();

		System.out.println("프로그램 종료.");

	}

}
