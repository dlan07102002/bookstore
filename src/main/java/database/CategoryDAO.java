package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;

public class CategoryDAO implements DAOInterface<Category> {

	public ArrayList<Category> selectAll() {
		ArrayList<Category> res = new ArrayList<Category>();
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Category";
			PreparedStatement st = con.prepareStatement(sql);

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String CategoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");

				Category Category = new Category(CategoryId, categoryName);
				res.add(Category);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public Category selectById(Category o) {
		Category res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Category WHERE categoryId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getCategoryId());

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String CategoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");

				res = new Category(CategoryId, categoryName);
				break;

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(Category Category) {
		int res = 0;

		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO Category(categoryId, categoryName)" + "VALUES(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Category.getCategoryId());
			st.setString(2, Category.getCategoryName());

			System.out.println(sql);

			res = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insertAll(ArrayList<Category> list) {
		int cnt = 0;
		for (Category Category : list) {
			cnt += this.insert(Category);

		}
		return cnt;
	}

	public int delete(Category Category) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from category WHERE categoryId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, Category.getCategoryId());
			res = st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<Category> list) {
		int cnt = 0;
		for (Category Category : list) {
			cnt += this.delete(Category);

		}
		return cnt;
	}

	public int update(Category Category) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE category SET categoryName = ?" + "WHERE categoryId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2, Category.getCategoryId());
			st.setString(1, Category.getCategoryName());

			System.out.println(sql);
			res = st.executeUpdate();
			System.out.println(res);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) {
		CategoryDAO a = new CategoryDAO();

		Category b = new Category("CT");
		System.out.println(a.selectById(b));
	}

}
