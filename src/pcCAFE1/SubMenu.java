package pcCAFE1;

import java.awt.List;
import java.util.Scanner;

import javax.rmi.CORBA.Util;

public class SubMenu {
	private MemberDAO dao;

	// �ʵ��� �ڷ����� Ŭ�����̰�, ��ü ������ �ʿ�� �ϴ� ���
	// �����ڿ��� ó��
	public SubMenu() {
		this.dao = new MemberDAO();
	}

	// 1. ȸ�� ���� �Է�
	public void method1(Scanner sc) {

		// ��� �� ����

		// 1. �ܺ� �Է� -> �̸�, ��ȭ��ȣ, �̸���
		// 2. �ӽ� Member ��ü ���� -> �ڷ� ���� -> setter
		// 3. �ڷ� ����� �����(�ý����� ���� ��¥) �߰�
		// 4. Member ��ü�� ����ҿ� �����ϱ� ���ؼ� MemberDAO Ŭ������ Ư�� �޼ҵ� ȣ��
		// ����) '�ý����� ���� ��¥' ���� ����� �ڷ�� ������ ���� �Ϻ� ��� ������ Util.java�� static �޼ҵ��
		// ����ؼ� ���.

		System.out.println("�̸���? ");
		String name = sc.next();
		System.out.println("��ȭ��ȣ��?");
		String phone = sc.next();
		System.out.println("�̸�����?");
		String email = sc.next();

		// �ý����� ���� ��¥�� ��� ����� ���� �޼ҵ�
		String regDate = Util.toDayString("yyyy-mm-dd");

		try {
			Member m = new Member();
			m.setName(name);
			m.setPhone(phone);
			m.setEmail(email);
			m.setRegDate(regDate); // yyyy-M //yyyy-MM-dd
			dao.memberAdd(m); // ���� �߻� ����
			System.out.println("ȸ�� 1���� �߰��Ǿ����ϴ�.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// 2. ȸ�� ���� (��ü)���
	public void method2() {

		// Test Ŭ�������� �׽�Ʈ�� ����� Ȯ���ϰ�,
		// �ҽ� �ڵ� �ۼ�
		List<Member> members = dao.memberList();
		this.memberPrint(members);

	}

	private void memberPrint(List<Member> members) {

		// �Ǽ� ���
		System.out.printf("��: %s��%n", members.size());
		// ��� ���
		System.out.println("--------------------------");
		for (Member m : members) {
			System.out.printf("%s %s %s %s%n", m.getName(), m.getPhone(), m.getEmail(), m.getRegDate());
		}
		System.out.println("--------------------------");
		System.out.println();

	}

	// 3. ȸ�� ���� �˻�
	public void method3(Scanner sc) {
		// ���� �޴� ���� -> ���� ����

		while (true) {

			// ���� �޴� ���
			System.out.println("--------------------------------");
			System.out.println("3. ȸ�� ���� �˻�");
			System.out.println("--------------------------------");
			System.out.println("1. �̸� ����  2. ��ȭ��ȣ ���� 3.�̸��� ���� 4.��Ͽ� ����");
			System.out.print("����(1~4, 0 quit)?");
			int menu = sc.nextInt();

			// break;
			if (menu == 0) {
				break;
			}

			// �޴��� �׼� �޼ҵ� ȣ�� -> switch ���� ���
			switch (menu) {
			case 1:
				// 1. �̸� ���� -> �ڱ� �ڽ� Ŭ������ Ư�� private �޼ҵ� ȣ��
				this.subMethod3_1(sc);
				break;
			case 2:
				// 2. ��ȭ��ȣ ���� -> �ڱ� �ڽ� Ŭ������ Ư�� private �޼ҵ� ȣ��
				this.subMethod3_2(sc);
				break;
			case 3:
				// 3. �̸��� ���� -> �ڱ� �ڽ� Ŭ������ Ư�� private �޼ҵ� ȣ��
				this.subMethod3_3(sc);
				break;
			case 4:
				this.subMethod3_4(sc);
				break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
				break;
			}

		}

	}

	private void subMethod3_1(Scanner sc) {
		// �˻��� �̸��� �ܺ� �Է� �ް�, �˻� ��û �� �˻� ����� ����ϴ� �׼� �߰�
		// -> �������� �˻����
		// ->key�� name, value�� �ܺ� �Էµ� �ڷ�
		System.out.println("�˻��� �̸�? ");
		String name = sc.next();

		try {
			this.memberPrint(dao.memberList("name", name));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_2(Scanner sc) {
		// �˻��� ��ȭ��ȣ�� �ܺ� �Է� �ް�, �˻� ��û �� �˻� ����� ����ϴ� �׼� �߰�
		// ->�κ� ���ڿ� �˻� ���
		// ->key�� phone, value�� �ܺ� �Էµ� �ڷ�
		System.out.println("�˻��� ��ȭ��ȣ? ");
		String phone = sc.next();
		try {
			this.memberPrint(dao.memberList("phone", phone));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_3(Scanner sc) {
		// �˻��� �̸����� �ܺ� �Է� �ް�, �˻� ��û �� �˻� ����� ����ϴ� �׼� �߰�
		// ->�κ� ���ڿ� �˻� ���
		// ->key�� email, value�� �ܺ� �Էµ� �ڷ�
		System.out.println("�˻��� �̸���? ");
		String email = sc.next();
		try {
			this.memberPrint(dao.memberList("email", email));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void subMethod3_4(Scanner sc) {

		System.out.println("�˻��� ��Ͽ�(yyyy-MM)? ");
		String regDate = sc.next();
		try {
			this.memberPrint(dao.memberList("regDate", regDate));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
