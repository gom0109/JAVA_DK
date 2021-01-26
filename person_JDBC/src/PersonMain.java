import java.util.ArrayList;
import java.util.Scanner;

// console : 출력, 입력

public class PersonMain {
	
	PersonDao dao = new PersonDao();
	Scanner sc = new Scanner(System.in);
	
	PersonMain(){
		System.out.println("PersonMain 생성자");
		init();
	}
	public void init(){
//		System.out.println("init");
		
		while(true) {
			System.out.println("\n===메뉴 선택하기===");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1: 
					ArrayList<PersonBean> list = dao.getAllPerson();
					
//					String title = "번호\t" + "이름\t"+ "나이\t"+ "성별\t"+ "생년월일\t";
//					System.out.println(title);
//					
//					for(int i=0;i<list.size();i++) {
//						PersonBean bean = list.get(i);
//						String result = bean.getNum()+"\t" +
//										bean.getName() +"\t" +
//										bean.getAge() +"\t" +
//										bean.getGender()+"\t" +
//										bean.getBirth();
//						
//						System.out.println(result);
//					}
					
					displayPerson(list);
				
					break;
					
				case 2: 
					getPersonByGender();
					break;
					
				case 3: // 정보수정
					updateData();
					break;
				case 4: // 정보삭제 
					
					deleteData();
					break;
				
				case 5: // 정보추가
					insertData();
					break;
					
				case 6: System.out.println("프로그램을 종료합니다.");
						System.exit(0);
						break;
				default : System.out.println("1~6사이의 번호만 입력 가능");
			} // switch
			
		}// true
		
	} // init
	
	private void deleteData() {
		System.out.print("삭제할 번호 입력:");
		int num = sc.nextInt();
		
		int count = dao.deleteData(num);
		if(count > 0) {
			System.out.println("삭제 성공");
		}
		else if(count == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else { // 음수
			System.out.println("삭제 실패");
		}
	}
	
	public void updateData(){
		
		System.out.print("수정할 번호 입력:");
		int num = sc.nextInt();
		
		System.out.print("수정할 이름 입력:");
		String name = sc.next();
		
		System.out.print("수정할 나이 입력:");
		int age = sc.nextInt();
		
		System.out.print("수정할 성별 입력:");
		String gender = sc.next();
		
		System.out.print("수정할 생년월일 입력:");
		String birth = sc.next();
		
		
		PersonBean bean = new PersonBean(num,name,age,gender,birth);
		
		int count =  dao.updateData(bean);
		if(count > 0) {
			System.out.println("수정 성공");
		}
		else if(count == 0) {
			System.out.println("조건에 맞는 레코드 없음");
		}
		else { // 음수
			System.out.println("수정 실패");
		}
		
		
	}//updateData
	
	public void insertData(){
		
		System.out.println("번호는 시퀀스로 입력됩니다.(생략)");
		System.out.print("이름 입력:");
		String name = sc.next();
		
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		
		System.out.print("성별 입력:");
		String gender = sc.next();
		
		System.out.print("생년월일 입력:");
		String birth = sc.next();
		
		PersonBean bean = new PersonBean(0,name,age,gender,birth);
		//bean변수의 자료형(type)은 무엇일까요? PersonBean
		
		int count = dao.insertData(bean);
		System.out.println("count:" + count);
		
		if(count < 0) {
			System.out.println("삽입 실패");
		}
		else {
			System.out.println("삽입 성공");
		}
		
		
	} // insertData
	
	
	public void getPersonByGender(){
		
		System.out.print("찾으려는 성별 입력:");
		String gender = sc.next();
		
		ArrayList<PersonBean> list = dao.getPersonByGender(gender);
		
		
		displayPerson(list);
		
	}//getPersonByGender()
	
	
	public void displayPerson(ArrayList<PersonBean> list){
		
		String title = "번호\t" + "이름\t"+ "나이\t"+ "성별\t"+ "생년월일\t";
		System.out.println(title);
		
		for(int i=0;i<list.size();i++) {
			PersonBean bean = list.get(i);
			String result = bean.getNum()+"\t" +
							bean.getName() +"\t" +
							bean.getAge() +"\t" +
							bean.getGender()+"\t" +
							bean.getBirth();
			
			System.out.println(result);
		} // for
		
	} // displayPerson()
	
	
	
	public static void main(String[] args) {
		
		new PersonMain(); // 객체를 만들면 자동으로 호출되는 메서드로 간다. 그 메서드를 생성자라고 한다. 
	}

}

//생성자
//1. 
//2. 
//3. 






