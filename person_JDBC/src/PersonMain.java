import java.util.ArrayList;
import java.util.Scanner;

// console : ���, �Է�

public class PersonMain {
	
	PersonDao dao = new PersonDao();
	Scanner sc = new Scanner(System.in);
	
	PersonMain(){
		System.out.println("PersonMain ������");
		init();
	}
	public void init(){
//		System.out.println("init");
		
		while(true) {
			System.out.println("\n===�޴� �����ϱ�===");
			System.out.println("1.��ü ���� ��ȸ");
			System.out.println("2.������ ��ȸ");
			System.out.println("3.���� ����");
			System.out.println("4.���� ����");
			System.out.println("5.���� �߰�");
			System.out.println("6.���α׷� ����");
			System.out.print(">> �޴� ��ȣ �Է� : ");
			
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1: 
					ArrayList<PersonBean> list = dao.getAllPerson();
					
//					String title = "��ȣ\t" + "�̸�\t"+ "����\t"+ "����\t"+ "�������\t";
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
					
				case 3: // ��������
					updateData();
					break;
				case 4: // �������� 
					
					deleteData();
					break;
				
				case 5: // �����߰�
					insertData();
					break;
					
				case 6: System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
						break;
				default : System.out.println("1~6������ ��ȣ�� �Է� ����");
			} // switch
			
		}// true
		
	} // init
	
	private void deleteData() {
		System.out.print("������ ��ȣ �Է�:");
		int num = sc.nextInt();
		
		int count = dao.deleteData(num);
		if(count > 0) {
			System.out.println("���� ����");
		}
		else if(count == 0) {
			System.out.println("���ǿ� �´� ���ڵ� ����");
		}
		else { // ����
			System.out.println("���� ����");
		}
	}
	
	public void updateData(){
		
		System.out.print("������ ��ȣ �Է�:");
		int num = sc.nextInt();
		
		System.out.print("������ �̸� �Է�:");
		String name = sc.next();
		
		System.out.print("������ ���� �Է�:");
		int age = sc.nextInt();
		
		System.out.print("������ ���� �Է�:");
		String gender = sc.next();
		
		System.out.print("������ ������� �Է�:");
		String birth = sc.next();
		
		
		PersonBean bean = new PersonBean(num,name,age,gender,birth);
		
		int count =  dao.updateData(bean);
		if(count > 0) {
			System.out.println("���� ����");
		}
		else if(count == 0) {
			System.out.println("���ǿ� �´� ���ڵ� ����");
		}
		else { // ����
			System.out.println("���� ����");
		}
		
		
	}//updateData
	
	public void insertData(){
		
		System.out.println("��ȣ�� �������� �Էµ˴ϴ�.(����)");
		System.out.print("�̸� �Է�:");
		String name = sc.next();
		
		System.out.print("���� �Է�:");
		int age = sc.nextInt();
		
		System.out.print("���� �Է�:");
		String gender = sc.next();
		
		System.out.print("������� �Է�:");
		String birth = sc.next();
		
		PersonBean bean = new PersonBean(0,name,age,gender,birth);
		//bean������ �ڷ���(type)�� �����ϱ��? PersonBean
		
		int count = dao.insertData(bean);
		System.out.println("count:" + count);
		
		if(count < 0) {
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� ����");
		}
		
		
	} // insertData
	
	
	public void getPersonByGender(){
		
		System.out.print("ã������ ���� �Է�:");
		String gender = sc.next();
		
		ArrayList<PersonBean> list = dao.getPersonByGender(gender);
		
		
		displayPerson(list);
		
	}//getPersonByGender()
	
	
	public void displayPerson(ArrayList<PersonBean> list){
		
		String title = "��ȣ\t" + "�̸�\t"+ "����\t"+ "����\t"+ "�������\t";
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
		
		new PersonMain(); // ��ü�� ����� �ڵ����� ȣ��Ǵ� �޼���� ����. �� �޼��带 �����ڶ�� �Ѵ�. 
	}

}

//������
//1. 
//2. 
//3. 






