package pcCAFE1;

import java.awt.List;
import java.util.ArrayList;

public class MemberDAO {
	private List<Member> members;

	public MemberDAO() {
		this.members = new ArrayList<Member>();
		this.init();
	}

	private void init() {	
		// Member 객체 생성 -> 컬렉션 저장
		// -> 출력 액션 작성시 경우의 수를 모두 가능할 수 있도록 최대한 다양한 자료 준비

		Member m1 = new Member();
		m1.setName("hong");
		m1.setPhone("010-1234-1234");
		m1.setEmail("hong@naver.com");
		m1.setRegDate("2017-04-28"); // yyyy-MM-dd
		this.members.add(m1);

		Member m2 = new Member();
		m2.setName("choi");
		m2.setPhone("010-5678-1234");
		m2.setEmail("choi@naver.com");
		m2.setRegDate("2017-05-01"); // yyyy-MM-dd
		this.members.add(m2);

		Member m3 = new Member();
		m3.setName("park");
		m3.setPhone("010-4321-4321");
		m3.setEmail("park@naver.com");
		m3.setRegDate("2017-05-10"); // yyyy-MM-dd
		this.members.add(m3);

	}

	// 전체 자료 반환 메소드
	// 리턴자료형은 자료 저장소 자료형과 일치
	// 매개변수는 외부에서 전달되는 자료(검색 조건 등)를 받을 때 사용
	public List<Member> memberList() {
		List<Member> result = null;

		// 전체 자료 반환 액션 추가
		// ->저장소 종류에 따라 다른 액션 필요
		result = this.members;

		// 메소드의 리턴자료형이 void가 아니라면 return 구문 필수
		return result;
	}

	// 회원 정보 저장 메소드
	public void memberAdd(Member m) throws Exception {

		// 전달받은 Member 객체를 저장소에 저장하는 액션 구현
		// ->중복된 회원인 경우(이름 and 전화번호 and 이메일)인 경우 예외 처리 -> throw, throws
		if (this.memberCheck(m)) {
			this.members.add(m);

		} else {
			throw new Exception("이미 존재하는 회원입니다. 이름 전화번호 이메일 일치");
		}

	}

	// 중복 회원 검사 private 메소드
	private boolean memberCheck(Member m) {
		boolean result = true; // 초기값은 true 지정

		// 기존 회원들의 정보와 전달받은 Member 객체의 정보를 비교하는 과정 추가
		for (Member member : this.members) {
			if (member.getName().equals(m.getName()) && member.getPhone().equals(m.getPhone())
					&& member.getEmail().equals(m.getEmail())) {
				result = false;

			}
		}

		return result;
	}

	// 검색 결과 자료 반환 메소드
	// 리턴자료형은 자료 저장소 자료형과 일치
	// 매개변수는 외부에서 전달되는 자료(검색 조건 등)를 받을 때 사용
	public List<Member> memberList(String key, String value) throws Exception {
		List<Member> result = new ArrayList<Member>();

		// 문제)
		// 검색 결과 반환 액션 추가
		// ->저장소 종류에 따라 다른 액션 필요
		// ->key(검색 기준), value(검색 대상)를 분석해서 검색 진행
		// ->부분 검색 진행 가능하도록 액션 구현 -> equals() X -> contains() O

		for (Member m : this.members) {

			// 이름 기준 검색
			if (key.equals("name") && m.getName().equals(value)) {

				result.add(m);
				// 전화번호 기준
			} else if (key.equals("phone") && m.getPhone().contains(value)) {

				result.add(m);
				// 이메일 기준
			} else if (key.equals("regDate") && m.getRegDate().contains(value)) {

				result.add(m);

			} else if (key.equals("regDate") && m.getRegDate().contains(value)) {

				result.add(m);

			}

		}

		// 예외 처리 추가
		// ->검색 결과가 없는 경우

		if (result.isEmpty())
			throw new Exception("검새결과가 없습니다.");

		// 메소드의 리턴자료형이 void가 아니라면 return 구문 필수
		return result;
	}

}
