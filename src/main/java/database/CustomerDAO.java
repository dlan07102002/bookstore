package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.MessageInfo;

import model.Customer;
import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> res = new ArrayList<Customer>();
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Customer";
			PreparedStatement st = con.prepareStatement(sql);

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				boolean sex = rs.getBoolean("sex");
				String address = rs.getString("address");
				String ordAddress = rs.getString("ordAddress");
				String shipTo = rs.getString("shipTo");
				String email = rs.getString("email");
				Date birthDate = rs.getDate("birthDate");
				boolean isUseMsgService = rs.getBoolean("isUseMsgService");

				Customer Customer = new Customer(customerId, username, password, username, sex, address, ordAddress,
						shipTo, birthDate, shipTo, email, isUseMsgService);
				res.add(Customer);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public Customer selectById(Customer o) {
		Customer res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Customer WHERE customerId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getCustomerId());

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				boolean sex = rs.getBoolean("sex");
				String address = rs.getString("address");
				String ordAddress = rs.getString("ordAddress");
				String shipTo = rs.getString("shipTo");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				Date birthDate = rs.getDate("birthDate");
				boolean isUseMsgService = rs.getBoolean("isUseMsgService");

				res = new Customer(customerId, username, password, name, sex, address, ordAddress, shipTo, birthDate,
						phoneNumber, email, isUseMsgService);

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public Customer selectByUsernameAndPassword(Customer o) {
		Customer res = null;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Customer WHERE username=? AND password=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, o.getUsername()); // Set username
			st.setString(2, o.getPassword()); // Set password

			// B3: Execute sql
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				boolean sex = rs.getBoolean("sex");
				String address = rs.getString("address");
				String ordAddress = rs.getString("ordAddress");
				String shipTo = rs.getString("shipTo");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				Date birthDate = rs.getDate("birthDate");
				boolean isUseMsgService = rs.getBoolean("isUseMsgService");

				res = new Customer(customerId, username, password, name, sex, address, ordAddress, shipTo, birthDate, phoneNumber, email, isUseMsgService);
			}

			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace(); // Log error
		}
		return res;
	}

	public boolean checkUserName(String u) {
		boolean res = false;
		try {
			// B1: Create connection
			Connection con = JDBCUtil.getConnection();

			// B2: Create preparedStatement
			String sql = "SELECT * FROM Customer WHERE username=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u);

			// B3: Execute sql

			ResultSet rs = st.executeQuery();

			// B4: Get data
			while (rs.next()) {
				res = true;

			}
			// B5: close connection
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int insert(Customer c) {
		int res = 0;

		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO customer(customerId," + " username, password, name, sex, address,"
					+ " ordAddress," + "shipTo, birthDate, email, phoneNumber, " + "isUseMsgService)"
					+ "VALUES(?,?, ?, ?,?, ?,?,?, ?,?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCustomerId());
			st.setString(2, c.getUsername());
			st.setString(3, c.getPassword());
			st.setString(4, c.getName());
			st.setBoolean(5, c.getSex());

			st.setString(6, c.getAddress());
			st.setString(7, c.getOrdAddress());
			st.setString(8, c.getShipTo());
			st.setDate(9, c.getBirthDate());
			st.setString(10, c.getEmail());
			st.setString(11, c.getPhoneNumber());
			st.setBoolean(12, c.isUseMsgService());

			System.out.println(sql);

			res = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int insertAll(ArrayList<Customer> list) {
		int cnt = 0;
		for (Customer Customer : list) {
			cnt += this.insert(Customer);

		}
		return cnt;
	}

	public int delete(Customer Customer) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from Customer WHERE CustomerId=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(sql);
			st.setString(1, Customer.getCustomerId());
			res = st.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int deleteAll(ArrayList<Customer> list) {
		int cnt = 0;
		for (Customer Customer : list) {
			cnt += this.delete(Customer);

		}
		return cnt;
	}

	public int update(Customer c) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Customer SET "  + "username = ?," + "password = ?," + "name = ?,"
					+ "sex = ?," + "address = ?," + "ordAddress = ?," + "birthDate = ?," + "shipTo = ?," + "email = ?,"
					+"phoneNumber = ?,"+ "isUseMsgService = ? " + "WHERE CustomerId = ?";
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, c.getUsername());
			st.setString(2, c.getPassword());
			st.setString(3, c.getName());
			st.setBoolean(4, c.getSex());
			st.setString(5, c.getAddress());
			st.setString(6, c.getOrdAddress());
			st.setDate(7, c.getBirthDate());
			st.setString(8, c.getShipTo());
			st.setString(9, c.getEmail());
			st.setString(10, c.getPhoneNumber());
			st.setBoolean(11, c.isUseMsgService());
			st.setString(12, c.getCustomerId());

			System.out.println(sql);
			res = st.executeUpdate();
			 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean changePassword(Customer c) {
		boolean res = false;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Customer SET password = ? " + "WHERE CustomerId = ?";
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, c.getPassword());
			st.setString(2, c.getCustomerId());
			
			System.out.println(sql);
			st.executeUpdate();
			res = true;
			System.out.println(res);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	public int updateInfo(Customer c) {
		int res = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE Customer SET "  + "name = ?,"
					+ "sex = ?," + "address = ?," + "ordAddress = ?," + "birthDate = ?," + "shipTo = ?," + "email = ?,"
					+ "phoneNumber = ?,"+ "isUseMsgService = ? " + "WHERE CustomerId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, c.getName());
			st.setBoolean(2, c.getSex());
			st.setString(3, c.getAddress());
			st.setString(4, c.getOrdAddress());
			st.setDate(5, c.getBirthDate());
			st.setString(6, c.getShipTo());
			st.setString(7, c.getEmail());
			st.setString(8, c.getPhoneNumber());
			st.setBoolean(9, c.isUseMsgService());
			st.setString(10, c.getCustomerId());

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
