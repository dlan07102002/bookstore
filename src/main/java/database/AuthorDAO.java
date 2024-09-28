package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import model.Author;

public class AuthorDAO implements DAOInterface<Author> {
	
	public ArrayList<Author> selectAll() {
		ArrayList<Author> res = new ArrayList<Author>();
		try {
			//B1: Create connection
			Connection con = JDBCUtil.getConnection();
			
			//B2: Create preparedStatement
			String sql = "SELECT * FROM author";
			PreparedStatement st = con.prepareStatement(sql);
			
			//B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			//B4: Get data
			while(rs.next()) {
				String authorId = rs.getString("authorId");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birthDate");
				String biography = rs.getString("biography");
				
				Author author = new Author(authorId, name, birthDate, biography);
				res.add(author);
			
			}
			//B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public Author selectById(Author o) {
		Author res = null;
		try {
			//B1: Create connection
			Connection con = JDBCUtil.getConnection();
			
			//B2: Create preparedStatement
			String sql = "SELECT * FROM author WHERE authorId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getAuthorId());
			
			//B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			//B4: Get data
			while(rs.next()) {
				String authorId = rs.getString("authorId");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birthDate");
				String biography = rs.getString("biography");
				
				res = new Author(authorId, name, birthDate, biography);
				break;
			
			}
			//B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(Author author) {
		int res = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO author(authorId, name, birthDate, biography)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, author.getAuthorId());
			st.setString(2, author.getName());
			st.setDate(3, author.getBirthDate());
			st.setString(4, author.getBio());
			System.out.println(sql);
			
			res = st.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insertAll(ArrayList<Author> list) {
		int cnt = 0;
		for (Author author : list) {
			cnt += this.insert(author);

		}
		return cnt;
	}

	public int delete(Author author) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from author WHERE authorId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, author.getAuthorId());
			res = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<Author> list) {
		int cnt = 0;
		for (Author author : list) {
			cnt += this.delete(author);

		}
		return cnt;
	}

	public int update(Author author) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE author SET name = ?,"
					+ " birthDate = ?, biography = ?"
					+ " WHERE authorId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, author.getName());
			st.setDate(2, author.getBirthDate());
			st.setString(3, author.getBio());
			st.setString(4, author.getAuthorId());
			System.out.println(sql);
			
			res = st.executeUpdate();
			System.out.println(res);
			
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
		return res;
	}
	


}
