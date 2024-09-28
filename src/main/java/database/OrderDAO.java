package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Order;
import model.Order;

public class OrderDAO implements DAOInterface<Order> {

	public ArrayList<Order> selectAll() {
		ArrayList<Order> res = new ArrayList<Order>();
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Order";
			PreparedStatement st = con.prepareStatement(sql);

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String orderId = rs.getString("orderId");
				String customerId = rs.getString("customerId");
				String ordAddress = rs.getString("ordAddress");
				String shipTo = rs.getString("shipTo");
				String status = rs.getString("status");
				String formOfPayment = rs.getString("formOfPayment");
				String statusOfPayment = rs.getString("statusOfPayment");
				double purchased = rs.getDouble("purchased");
				double remainingAmount = rs.getDouble("remainingAmount");
				Date ordDate = rs.getDate("ordDate");
				Date shipDate = rs.getDate("shipDate");

				CustomerDAO ctDao = new CustomerDAO();
				Customer para = ctDao.selectById(new Customer(customerId));

				Order Order = new Order(orderId, para, ordAddress, shipTo, status, formOfPayment, statusOfPayment,
						purchased, remainingAmount, ordDate, shipDate);
				res.add(Order);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public Order selectById(Order o) {
		Order res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Order WHERE OrderId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getOrderId());

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String orderId = rs.getString("orderId");
				String customerId = rs.getString("customerId");
				String ordAddress = rs.getString("ordAddress");
				String shipTo = rs.getString("shipTo");
				String status = rs.getString("status");
				String formOfPayment = rs.getString("formOfPayment");
				String statusOfPayment = rs.getString("statusOfPayment");
				double purchased = rs.getDouble("purchased");
				double remainingAmount = rs.getDouble("remainingAmount");
				Date ordDate = rs.getDate("ordDate");
				Date shipDate = rs.getDate("shipDate");

				CustomerDAO ctDao = new CustomerDAO();
				Customer para = ctDao.selectById(new Customer(customerId));

				res = new Order(orderId, para, ordAddress, shipTo, status, formOfPayment, statusOfPayment, purchased,
						remainingAmount, ordDate, shipDate);
				break;

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(Order o) {
		int res = 0;

		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO Order(orderId, customerId, ordAddress, shipTo, status, formOfPayment, statusOfPayment, purchased, remainingAmount, ordDate, shipDate)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);

			// Set the values for each parameter
			st.setString(1, o.getOrderId());
			st.setString(2, o.getCustomer().getCustomerId());
			st.setString(3, o.getOrdAddress());
			st.setString(4, o.getShipTo());
			st.setString(5, o.getStatus());
			st.setString(6, o.getFormOfPayment());
			st.setString(7, o.getStatusOfPayment());
			st.setDouble(8, o.getPurchased()); // Assuming 'purchased' is a monetary value (BigDecimal)
			st.setDouble(9, o.getRemainingAmount()); // Assuming 'remainingAmount' is a monetary value (BigDecimal)
			st.setDate(10, o.getOrdDate()); // Assuming 'ordDate' is a java.sql.Date
			st.setDate(11, o.getShipDate());

			System.out.println(sql);

			res = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insertAll(ArrayList<Order> list) {
		int cnt = 0;
		for (Order Order : list) {
			cnt += this.insert(Order);

		}
		return cnt;
	}

	public int delete(Order Order) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from Order WHERE OrderId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, Order.getOrderId());
			res = st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<Order> list) {
		int cnt = 0;
		for (Order Order : list) {
			cnt += this.delete(Order);

		}
		return cnt;
	}

	public int update(Order o) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Order SET customerId = ?," + "ordAddress = ?," + "shipTo = ?," + "status = ?,"
					+ "formOfPayment = ?," + "statusOfPayment = ?," + "purchased = ?," + "remainingAmount = ?,"
					+ "ordDate = ?," + "shipDate = ? " + "WHERE orderId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getCustomer().getCustomerId());
			st.setString(2, o.getOrdAddress());
			st.setString(3, o.getShipTo());
			st.setString(4, o.getStatus());
			st.setString(5, o.getFormOfPayment());
			st.setString(6, o.getStatusOfPayment());
			st.setDouble(7, o.getPurchased());
			st.setDouble(8, o.getRemainingAmount());
			st.setDate(9, o.getOrdDate());
			st.setDate(10, o.getShipDate());
			st.setString(11, o.getOrderId());
			System.out.println(sql);
			res = st.executeUpdate();
			System.out.println(res);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

}
