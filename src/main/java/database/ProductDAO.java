package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Category;
import model.Order;
import model.Product;
import model.Product;

public class ProductDAO implements DAOInterface<Product> {
	public ArrayList<Product> selectAll() {
		ArrayList<Product> res = new ArrayList<Product>();
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Product";
			PreparedStatement st = con.prepareStatement(sql);

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String authorId = rs.getString("authorId");
				int publishYear = rs.getInt("publishYear");
				double impPrice = rs.getDouble("impPrice");
				double orgPrice = rs.getDouble("orgPrice");
				double sellPrice = rs.getDouble("sellPrice");
				int quantity = rs.getInt("quantity");
				String categoryId = rs.getString("categoryId");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new Author(authorId);
				AuthorDAO atDao = new AuthorDAO();
				author = atDao.selectById(author);

				CategoryDAO ctDao = new CategoryDAO();
				Category category = new Category(categoryId);
				category = ctDao.selectById(category);

				Product product = new Product(productId, productName, author, publishYear, impPrice, sellPrice,
						orgPrice, quantity, category, language, description);
				res.add(product);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public Product selectById(Product o) {
		Product res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Product WHERE ProductId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getProductId());

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String productId = rs.getString("productId");
				String productName = rs.getString("productName");
				String authorId = rs.getString("authorId");
				int publishYear = rs.getInt("publishYear");
				double impPrice = rs.getDouble("impPrice");
				double orgPrice = rs.getDouble("orgPrice");
				double sellPrice = rs.getDouble("sellPrice");
				int quantity = rs.getInt("quantity");
				String categoryId = rs.getString("categoryId");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new Author(authorId);
				AuthorDAO atDao = new AuthorDAO();
				author = atDao.selectById(author);

				CategoryDAO ctDao = new CategoryDAO();
				Category category = new Category(categoryId);
				category = ctDao.selectById(category);

				res = new Product(productId, productName, author, publishYear, impPrice, sellPrice, orgPrice, quantity,
						category, language, description);
				break;

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(Product Product) {
		int res = 0;

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO Product(productId, productName, authorId, publishYear, impPrice, sellPrice, orgPrice, quantity, categoryId, language, description) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Product.getProductId());
			st.setString(2, Product.getProductName());
			st.setString(3, Product.getAuthor().getAuthorId());
			st.setInt(4, Product.getpublishYear()); // Assuming publishYear is an integer
			st.setDouble(5, Product.getImpPrice()); // Assuming impPrice is a double/float
			st.setDouble(6, Product.getSellPrice()); // Assuming sellPrice is a double/float
			st.setDouble(7, Product.getOrgPrice()); // Assuming orgPrice is a double/float
			st.setInt(8, Product.getQuantity()); // Assuming quantity is an integer
			st.setString(9, Product.getCategory().getCategoryId());
			st.setString(10, Product.getLanguage());
			st.setString(11, Product.getDescription());

			System.out.println(sql);

			res = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insertAll(ArrayList<Product> list) {
		int cnt = 0;
		for (Product Product : list) {
			cnt += this.insert(Product);

		}
		return cnt;
	}

	public int delete(Product Product) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from Product WHERE ProductId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, Product.getProductId());
			res = st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<Product> list) {
		int cnt = 0;
		for (Product Product : list) {
			cnt += this.delete(Product);

		}
		return cnt;
	}

	public int update(Product o) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Product SET productName = ?, authorId = ?, publishYear = ?, impPrice = ?, "
					+ "orgPrice = ?, sellPrice = ?, quantity = ?, categoryId = ?, language = ?, description = ? "
					+ "WHERE productId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getProductName());
			st.setString(2, o.getAuthor().getAuthorId());
			st.setInt(3, o.getpublishYear());
			st.setDouble(4, o.getImpPrice());
			st.setDouble(5, o.getOrgPrice());
			st.setDouble(6, o.getSellPrice());
			st.setInt(7, o.getQuantity());
			st.setString(8, o.getCategory().getCategoryId());
			st.setString(9, o.getLanguage());
			st.setString(10, o.getDescription());
			st.setString(11, o.getProductId());

			res = st.executeUpdate();
			System.out.println(res);

		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
		return res;
	}
	
	

}
