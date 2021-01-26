package album_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public AlbumDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	void getconn(){
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 2 num number primary key, 3 song varchar2(30) not null, 4 singer varchar2(30)
	 * not null, 5 company varchar2(20) not null, 6 price number default 0, 7
	 * pub_day date default sysdate 8 );
	 */

	public ArrayList<AlbumBean> selectAll() {
		getconn();
		ArrayList<AlbumBean> list =  new ArrayList<AlbumBean>();
		
		String sql = "select * from album";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String song = rs.getNString("song");
				String singer = rs.getNString("singer");
				String company = rs.getNString("company");
				int price = rs.getInt("price");
				String date = String.valueOf(rs.getDate("pub_day"));
				AlbumBean bean = new AlbumBean(num, song, singer, company, price, date);
				
				list.add(bean);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
	}

	public int change4(AlbumBean bean) {
		getconn();
		int count = -1;
		int num = bean.getNum();
		String song = bean.getSong();
		String singer = bean.getSinger();
		String company = bean.getCompany();
		int price = bean.getPrice();
		String date = bean.getDate();
		
		String sql = "update album set song='"+song +"',singer = '"+singer+"',company = '"+company+"',price = "+price+",pub_day = '"+date+"' where num = "+num;
		try {
			ps = conn.prepareStatement(sql);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
		
	}

	public void selectSome(int num) {

		getconn();
		String sql = "select * from album where num = "+num;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}





























