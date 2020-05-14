package pcCAFE1;

import java.awt.List;
import java.util.Scanner;

import javax.rmi.CORBA.Util;

public class SubMenu {
	private MemberDAO dao;

	// 필드의 자료형이 클래스이고, 객체 생성을 필요로 하는 경우
	// 생성자에서 처리
	public SubMenu() {
		this.dao = new MemberDAO();
	}

	// 1. 회원 정보 입력
	public void method1(Scanner sc) {

		// 기능 상세 설명

		// 1. 외부 입력 -> 이름, 전화번호, 이메일
		// 2. 임시 Member 객체 생성 -> 자료 저장 -> setter
		// 3. 자료 저장시 등록일(시스템의 오늘 날짜) 추가
		// 4. Member 객체를 저장소에 저장하기 위해서 MemberDAO 클래스의 특정 메소드 호출
		// 주의) '시스템의 오늘 날짜' 같은 저장소 자료와 관련이 없는 일부 기능 구현은 Util.java에 static 메소드로
		// 등록해서 사용.

		System.out.println("이름은? ");
		String name = sc.next();
		System.out.println("전화번호는?");
		String phone = sc.next();
		System.out.println("이메일은?");
		String email = sc.next();

		// 시스템의 오늘 날짜를 얻는 사용자 정의 메소드
		String regDate = Util.toDayString("yyyy-mm-dd");

		try {
			Member m = new Member();
			m.setName(name);
			m.setPhone(phone);
			m.setEmail(email);
			m.setRegDate(regDate); // yyyy-M //yyyy-MM-dd
			dao.memberAdd(m); // 예외 발생 가능
			System.out.println("회원 1명이 추가되었습니다.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// 2. 회원 정보 (전체)출력
	public void method2() {

		// Test 클래스에서 테스트한 결과를 확인하고,
		// 소스 코드 작성
		List<Member> members = dao.memberList();
		this.memberPrint(members);

	}

	private void memberPrint(List<Member> members) {

		// 건수 출력
		System.out.printf("총: %s건%n", members.size());
		// 명단 출력
		System.out.println("--------------------------");
		for (Member m : members) {
			System.out.printf("%s %s %s %s%n", m.getName(), m.getPhone(), m.getEmail(), m.getRegDate());
		}
		System.out.println("--------------------------");
		System.out.println();

	}

	// 3. 회원 정보 검색
	public void method3(Scanner sc) {
		// 서브 메뉴 구성 -> 무한 실행

		while (true) {

			// 메인 메뉴 출력
			System.out.println("--------------------------------");
			System.out.println("3. 회원 정보 검색");
			System.out.println("--------------------------------");
			System.out.println("1. 이름 기준  2. 전화번호 기준 3.이메일 기준 4.등록월 기준");
			System.out.print("선택(1~4, 0 quit)?");
			int menu = sc.nextInt();

			// break;
			if (menu == 0) {
				break;
			}

			// 메뉴별 액션 메소드 호출 -> switch 구문 사용
			switch (menu) {
			case 1:
				// 1. 이름 기준 -> 자기 자신 클래스의 특정 private 메소드 호출
				this.subMethod3_1(sc);
				break;
			case 2:
				// 2. 전화번호 기준 -> 자기 자신 클래스의 특정 private 메소드 호출
				this.subMethod3_2(sc);
				break;
			case 3:
				// 3. 이메일 기준 -> 자기 자신 클래스의 특정 private 메소드 호출
				this.subMethod3_3(sc);
				break;
			case 4:
				this.subMethod3_4(sc);
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}

		}

	}

	private void subMethod3_1(Scanner sc) {
		// 검색할 이름을 외부 입력 받고, 검색 요청 및 검색 결과를 출력하는 액션 추가
		// -> 동명이인 검색기능
		// ->key는 name, value는 외부 입력된 자료
		System.out.println("검색할 이름? ");
		String name = sc.next();

		try {
			this.memberPrint(dao.memberList("name", name));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_2(Scanner sc) {
		// 검색할 전화번호를 외부 입력 받고, 검색 요청 및 검색 결과를 출력하는 액션 추가
		// ->부분 문자열 검색 기능
		// ->key는 phone, value는 외부 입력된 자료
		System.out.println("검색할 전화번호? ");
		String phone = sc.next();
		try {
			this.memberPrint(dao.memberList("phone", phone));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_3(Scanner sc) {
		// 검색할 이메일을 외부 입력 받고, 검색 요청 및 검색 결과를 출력하는 액션 추가
		// ->부분 문자열 검색 기능
		// ->key는 email, value는 외부 입력된 자료
		System.out.println("검색할 이메일? ");
		String email = sc.next();
		try {
			this.memberPrint(dao.memberList("email", email));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_4(Scanner sc) {

		System.out.println("검색할 등록월(yyyy-MM)? ");
		String regDate = sc.next();
		try {
			this.memberPrint(dao.memberList("regDate", regDate));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
