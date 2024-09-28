package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderDetail;
import model.Product;
import model.Order;
import model.OrderDetail;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {

	public ArrayList<OrderDetail> selectAll() {
		ArrayList<OrderDetail> res = new ArrayList<OrderDetail>();
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM OrderDetail";
			PreparedStatement st = con.prepareStatement(sql);

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String orderDetailId = rs.getString("orderDetailId");
				String orderId = rs.getString("orderId");
				String productId = rs.getString("productId");
				double quantity = rs.getDouble("quantity");
				double orgPrice = rs.getDouble("orgPrice");
				double salePercent = rs.getDouble("salePercent");
				float vat = rs.getFloat("vat");
				double amount = rs.getDouble("amount");

				Order ord = new Order(orderId);
				OrderDAO odDao = new OrderDAO();
				ord = odDao.selectById(ord);

				Product pro = new Product(productId);
				ProductDAO proDao = new ProductDAO();
				pro = proDao.selectById(pro);

				OrderDetail OrderDetail = new OrderDetail(orderDetailId, ord, pro, quantity, orgPrice, salePercent, vat,
						amount);
				res.add(OrderDetail);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public OrderDetail selectById(OrderDetail o) {
		OrderDetail res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM orderdetail WHERE orderDetailId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getOrderDetailId());

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String orderDetailId = rs.getString("orderDetailId");
				String orderId = rs.getString("orderId");
				String productId = rs.getString("productId");
				double quantity = rs.getDouble("quantity");
				double orgPrice = rs.getDouble("orgPrice");
				double salePercent = rs.getDouble("salePercent");
				float vat = rs.getFloat("vat");
				double amount = rs.getDouble("amount");

				Order ord = new Order(orderId);
				OrderDAO odDao = new OrderDAO();
				ord = odDao.selectById(ord);

				Product pro = new Product(productId);
				ProductDAO proDao = new ProductDAO();
				pro = proDao.selectById(pro);

				res = new OrderDetail(orderDetailId, ord, pro, quantity, orgPrice, salePercent, vat, amount);
				break;

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(OrderDetail OrderDetail) {
		int res = 0;

		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO OrderDetail(orderDetailId, orderId, productId, quantity, orgPrice, salePercent, vat, amount) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, OrderDetail.getOrderDetailId());
			st.setString(2, OrderDetail.getOrder().getOrderId()); // assuming ord is of type String
			st.setString(3, OrderDetail.getProduct().getProductId()); // assuming pro is of type String
			st.setDouble(4, OrderDetail.getQuantity()); // assuming quantity is of type int
			st.setDouble(5, OrderDetail.getOrgPrice()); // assuming orgPrice is of type BigDecimal
			st.setDouble(6, OrderDetail.getSalePercent()); // assuming salePercent is of type int
			st.setDouble(7, OrderDetail.getVat()); // assuming vat is of type BigDecimal
			st.setDouble(8, OrderDetail.getAmount());

			System.out.println(sql);

			res = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insertAll(ArrayList<OrderDetail> list) {
		int cnt = 0;
		for (OrderDetail OrderDetail : list) {
			cnt += this.insert(OrderDetail);

		}
		return cnt;
	}

	public int delete(OrderDetail OrderDetail) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from OrderDetail WHERE OrderDetailId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, OrderDetail.getOrderDetailId());
			res = st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<OrderDetail> list) {
		int cnt = 0;
		for (OrderDetail OrderDetail : list) {
			cnt += this.delete(OrderDetail);

		}
		return cnt;
	}

	public int update(OrderDetail o) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE OrderDetail SET orderId=?," + "productId = ?," + "quantity = ?," + "orgPrice = ?,"
					+ "salePercent = ?," + "VAT = ?," + "amount = ?" + " WHERE orderDetailId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getOrder().getOrderId());
			st.setString(2, o.getProduct().getProductId());
			st.setDouble(3, o.getQuantity());
			st.setDouble(4, o.getOrgPrice());
			st.setDouble(5, o.getSalePercent());
			st.setDouble(6, o.getVat());
			st.setDouble(7, o.getAmount());
			st.setString(8, o.getOrderDetailId());

			res = st.executeUpdate();
			System.out.println(res);

		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
		return res;
	}

}
