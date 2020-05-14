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
		// Member ��ü ���� -> �÷��� ����
		// -> ��� �׼� �ۼ��� ����� ���� ��� ������ �� �ֵ��� �ִ��� �پ��� �ڷ� �غ�

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

	// ��ü �ڷ� ��ȯ �޼ҵ�
	// �����ڷ����� �ڷ� ����� �ڷ����� ��ġ
	// �Ű������� �ܺο��� ���޵Ǵ� �ڷ�(�˻� ���� ��)�� ���� �� ���
	public List<Member> memberList() {
		List<Member> result = null;

		// ��ü �ڷ� ��ȯ �׼� �߰�
		// ->����� ������ ���� �ٸ� �׼� �ʿ�
		result = this.members;

		// �޼ҵ��� �����ڷ����� void�� �ƴ϶�� return ���� �ʼ�
		return result;
	}

	// ȸ�� ���� ���� �޼ҵ�
	public void memberAdd(Member m) throws Exception {

		// ���޹��� Member ��ü�� ����ҿ� �����ϴ� �׼� ����
		// ->�ߺ��� ȸ���� ���(�̸� and ��ȭ��ȣ and �̸���)�� ��� ���� ó�� -> throw, throws
		if (this.memberCheck(m)) {
			this.members.add(m);

		} else {
			throw new Exception("�̹� �����ϴ� ȸ���Դϴ�. �̸� ��ȭ��ȣ �̸��� ��ġ");
		}

	}

	// �ߺ� ȸ�� �˻� private �޼ҵ�
	private boolean memberCheck(Member m) {
		boolean result = true; // �ʱⰪ�� true ����

		// ���� ȸ������ ������ ���޹��� Member ��ü�� ������ ���ϴ� ���� �߰�
		for (Member member : this.members) {
			if (member.getName().equals(m.getName()) && member.getPhone().equals(m.getPhone())
					&& member.getEmail().equals(m.getEmail())) {
				result = false;

			}
		}

		return result;
	}

	// �˻� ��� �ڷ� ��ȯ �޼ҵ�
	// �����ڷ����� �ڷ� ����� �ڷ����� ��ġ
	// �Ű������� �ܺο��� ���޵Ǵ� �ڷ�(�˻� ���� ��)�� ���� �� ���
	public List<Member> memberList(String key, String value) throws Exception {
		List<Member> result = new ArrayList<Member>();

		// ����)
		// �˻� ��� ��ȯ �׼� �߰�
		// ->����� ������ ���� �ٸ� �׼� �ʿ�
		// ->key(�˻� ����), value(�˻� ���)�� �м��ؼ� �˻� ����
		// ->�κ� �˻� ���� �����ϵ��� �׼� ���� -> equals() X -> contains() O

		for (Member m : this.members) {

			// �̸� ���� �˻�
			if (key.equals("name") && m.getName().equals(value)) {

				result.add(m);
				// ��ȭ��ȣ ����
			} else if (key.equals("phone") && m.getPhone().contains(value)) {

				result.add(m);
				// �̸��� ����
			} else if (key.equals("regDate") && m.getRegDate().contains(value)) {

				result.add(m);

			} else if (key.equals("regDate") && m.getRegDate().contains(value)) {

				result.add(m);

			}

		}

		// ���� ó�� �߰�
		// ->�˻� ����� ���� ���

		if (result.isEmpty())
			throw new Exception("�˻������ �����ϴ�.");

		// �޼ҵ��� �����ڷ����� void�� �ƴ϶�� return ���� �ʼ�
		return result;
	}

}
