// 레코드 한줄 , 사용자 입력
public class PersonBean {
	// 멤버변수
	private int num;
	private String name;
	private int age;
	private String gender;
	private String birth;
	
	
	public PersonBean(int num, String name, int age, String gender, String birth) {
		super();
		int a; // 지역변수
		this.num = num;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birth = birth;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
