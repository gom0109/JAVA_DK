import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DB 
public class PersonDao {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	PersonDao(){
		System.out.println("PersonDao 생성자");
		//0.jar포함 

		try {
			//1. 드라이버 로드 
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //

	public void getConn(){

		//2.계정에 접속
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("접속 오류");
		}
	} // 

	public ArrayList<PersonBean> getAllPerson(){
		//2
		getConn();

		ArrayList<PersonBean> list=new ArrayList<PersonBean>();

		String sql = "select * from person order by num";

		try {
			//3.sql문 분석
			ps = conn.prepareStatement(sql);

			//4.sql문 실행
			rs = ps.executeQuery();
			//		     NUM NAME              AGE GENDER BIRTH
			//		     ---------- ---------- ---------- ------ --------
			//		       1 보라               23 여     92/03/04
			//		       2 슬기               34 여     77/11/09
			//		       3 찬열               17 남     04/12/29
			//		       4 백현               57 남     65/02/06
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				//String birth = rs.getString("birth");
				String birth = String.valueOf(rs.getDate("birth"));

				//Integer.parseInt("123"); // "123"=>123
				//String.valueOf(123); // 123=>"123"

				//System.out.println(num +"," + name+"," + age+"," + gender+"," + birth);

				PersonBean bean = new PersonBean(num,name,age,gender,birth);

				list.add(bean);

			}//while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			//5.
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally

		System.out.println("list 갯수:" + list.size());
		return list;

	}

	public ArrayList<PersonBean> getPersonByGender(String gender) {

		ArrayList<PersonBean> list = new ArrayList<PersonBean>();
		//2.
		getConn();

		//3.
		String sql = "select * from person where gender='" + gender + "'";
		try {
			ps = conn.prepareStatement(sql);

			// 4
			rs = ps.executeQuery();

			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender2 = rs.getString("gender");
				String birth = String.valueOf(rs.getDate("birth"));

				PersonBean bean = new PersonBean(num, name, age, gender2, birth);
				list.add(bean);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			//5.
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally

		System.out.println(gender + ":" + list.size());
		return list;
	}//

	public int insertData(PersonBean bean){

		//		System.out.println(bean.getNum());
		//		System.out.println(bean.getName());
		//		System.out.println(bean.getAge());
		//		System.out.println(bean.getGender());
		//		System.out.println(bean.getBirth());		

		//2
		getConn();
		int count = 0;

		String sql = "insert into person " +  
					" values(perseq.nextval,?,?,?,?)";  
		try {
			//3.sql문 분석
			ps = conn.prepareStatement(sql);
			ps.setString(1,bean.getName()); 
			ps.setInt(2, bean.getAge());
			ps.setString(3,bean.getGender());
			ps.setString(4, bean.getBirth());		


			// 4.실행
			count = ps.executeUpdate(); // 성공적으로 실행된 갯수


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally

		return count; 


	}

	public int updateData(PersonBean bean) {
		
//		System.out.println(bean.getNum());
//		System.out.println(bean.getName());
//		System.out.println(bean.getAge());
//		System.out.println(bean.getGender());
//		System.out.println(bean.getBirth());
		
		int count = -1;
		
		//2
		getConn();
		
		//3
		String sql = "update person set name=?,age=?,gender=?,birth=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,bean.getName());
			ps.setInt(2, bean.getAge());
			ps.setString(3, bean.getGender());
			ps.setString(4,bean.getBirth());
			ps.setInt(5, bean.getNum());
			
			//4
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // finally
		
		return count;
		
	}

	public int deleteData(int num) {
		
		getConn();
		int count = -1;
		
		String sql = "delete from person where num="+num;
		
		try {
			ps = conn.prepareStatement(sql);
			
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // finally
		
		return count;
	}

}




