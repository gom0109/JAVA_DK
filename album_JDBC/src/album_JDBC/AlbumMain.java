package album_JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class AlbumMain {
	Scanner sc = new Scanner(System.in);
	AlbumDao dao = new AlbumDao();

	public AlbumMain() {
		init();
	}

	void init() {
		while (true) {
			System.out.println("======�޴� �����ϱ�======");
			System.out.println("1.��� ���� ��ȸ");
			System.out.println("2.���� �˻�");
			System.out.println("3.���� �������� �˻�(����:��������, ����:��������)");
			System.out.println("4.�ٹ� ����");
			System.out.println("5.�ٹ� ����");
			System.out.println("6.�ٹ� �߰�");
			System.out.println("7.����");
			System.out.println("8.���α׷� ����");
			System.out.print(">>>");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				ArrayList<AlbumBean> list = dao.selectAll();
				selectAllprint(list);

				break;
			case 2:
				selectSome();
				break;
			case 3:
				break;
			case 4:
				change4();

				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.out.println("����");
				System.exit(1);
				break;
			default:
				System.out.println("1~8������ ���ڸ� �Է����ּ���");
				break;
			}

		}

	}

	private void selectSome() {
		System.out.println("������ ��ȣ�� ������");
		int num = sc.nextInt();
		dao.selectSome(num);
		
	}

	private void change4() {
		System.out.println("������ �����͸� ����ּ���");
		System.out.print(">>>");
		int num = sc.nextInt();
		System.out.println("����");
		String song = sc.next();
		System.out.println("����");
		String singer = sc.next();
		System.out.println("ȸ��");
		String company = sc.next();
		System.out.println("����");
		int price = sc.nextInt();
		System.out.println("��¥");
		String date = sc.next();
		
		AlbumBean bean = new AlbumBean(num, song, singer, company, price, date);
		int count = dao.change4(bean);
		
	}

	private static void selectAllprint(ArrayList<AlbumBean> list) {
		for (int i = 0; i < list.size(); i++) {
			AlbumBean bean = list.get(i);
			int num = bean.getNum();
			String song = bean.getSong();
			String singer = bean.getSinger();
			String company = bean.getCompany();
			int price = bean.getPrice();
			String date = bean.getDate();

			System.out.println(num + "\t" + song + "\t" + singer + "\t" + company + "\t" + price + "\t" + date);
			
			
			
		}

	}

	public static void main(String[] args) {
		new AlbumMain();
		/*
		 * ======�޴� �����ϱ�====== 1.��� ���� ��ȸ 2.���� �˻� 3.���� �������� �˻�(����:��������, ����:��������) 4.�ٹ� ����
		 * 5.�ٹ� ���� 6.�ٹ� �߰� 7.���� 8.���α׷� ����
		 */

	}

}
