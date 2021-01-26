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
			System.out.println("======메뉴 선택하기======");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.가격 범위조건 검색(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.정렬");
			System.out.println("8.프로그램 종료");
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
				System.out.println("종료");
				System.exit(1);
				break;
			default:
				System.out.println("1~8사이의 숫자를 입력해주세요");
				break;
			}

		}

	}

	private void selectSome() {
		System.out.println("선택할 번호를 고르세요");
		int num = sc.nextInt();
		dao.selectSome(num);
		
	}

	private void change4() {
		System.out.println("수정할 데이터를 골라주세요");
		System.out.print(">>>");
		int num = sc.nextInt();
		System.out.println("제목");
		String song = sc.next();
		System.out.println("가수");
		String singer = sc.next();
		System.out.println("회사");
		String company = sc.next();
		System.out.println("가격");
		int price = sc.nextInt();
		System.out.println("날짜");
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
		 * ======메뉴 선택하기====== 1.모든 정보 조회 2.조건 검색 3.가격 범위조건 검색(가격:내림차순, 가수:오름차순) 4.앨범 수정
		 * 5.앨범 삭제 6.앨범 추가 7.정렬 8.프로그램 종료
		 */

	}

}
